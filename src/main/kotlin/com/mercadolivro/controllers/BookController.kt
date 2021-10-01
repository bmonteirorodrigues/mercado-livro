package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostBookRequest
import com.mercadolivro.controllers.requests.PutBookRequest
import com.mercadolivro.controllers.responses.BookResponse
import com.mercadolivro.domain.BookModel
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.extensions.toResponse
import com.mercadolivro.services.CustomersService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import com.mercadolivro.services.BookService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault

@RestController
@RequestMapping("books")
class BookController(
    var customersService: CustomersService,
    var bookService: BookService
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody postBookRequest: PostBookRequest){
        val customer = customersService.getById(postBookRequest.customerId)
        bookService.create(postBookRequest.toBookModel(customer))
    }

    @GetMapping
    fun getAllBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> =
        bookService.getAllBooks(pageable).map { it.toResponse() }


    @GetMapping("actives")
    fun getAllActiveBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> =
        bookService.getByStatus(BookStatus.ATIVO, pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): BookModel =
        bookService.getById(id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Int) =
        bookService.deleteById(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateById(@PathVariable id: Int, @RequestBody putBookRequest: PutBookRequest) =
        bookService.updateById(id, putBookRequest.toBookModel(bookService.getById(id)))

}
