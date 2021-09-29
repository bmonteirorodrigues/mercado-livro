package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostBookRequest
import com.mercadolivro.domain.BookModel
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.extensions.toBookModel
import com.mercadolivro.services.CustomersService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import com.mercadolivro.services.BookService

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
    fun getAllBooks(): List<BookModel> =
        bookService.getAllBooks().toList()


    @GetMapping("actives")
    fun getAllActiveBooks(): List<BookModel> =
        bookService.getByStatus(BookStatus.ATIVO)

}