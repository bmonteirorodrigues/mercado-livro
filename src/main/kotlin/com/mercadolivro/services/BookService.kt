package com.mercadolivro.services

import com.mercadolivro.domain.BookModel
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.repository.BooksRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class BookService(
    val booksRepository: BooksRepository
) {
    fun create(bookModel: BookModel) {
        booksRepository.save(bookModel)
    }

    fun getAllBooks(pageable: Pageable): Page<BookModel> {
        return booksRepository.findAll(pageable)
    }

    fun getByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>{
        return booksRepository.findByStatus(status, pageable)
    }

    fun getById(id: Int): BookModel {
        return booksRepository.findById(id).orElseThrow()
    }

    fun deleteById(id: Int){
        if(!booksRepository.existsById(id)) throw Exception()
        val book = booksRepository.findById(id).orElseThrow()
            book.status = BookStatus.CANCELADO
        booksRepository.save(book)
    }

    fun updateById(id: Int, book: BookModel){
        if(!booksRepository.existsById(id))
            throw Exception()

        if(!BookModel.statusChangeAllowed(booksRepository.findById(id).get().status!!)) {
            throw Exception("Nao e possivel atualizar um livro com o status ${booksRepository.findById(book.id!!).get().status!!}")
        }

        booksRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = booksRepository.findByCustomer(customer)
        for(book in books){
            book.status = BookStatus.DELETADO
        }
        booksRepository.saveAll(books)
    }
}
