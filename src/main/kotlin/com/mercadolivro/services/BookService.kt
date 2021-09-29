package com.mercadolivro.services

import com.mercadolivro.domain.BookModel
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.repository.BooksRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val booksRepository: BooksRepository
) {
    fun create(bookModel: BookModel) {
        booksRepository.save(bookModel)
    }

    fun getAllBooks(): List<BookModel> {
        return booksRepository.findAll().toList()
    }

    fun getByStatus(status: BookStatus): List<BookModel>{
        return booksRepository.findByStatus(status)
    }
}
