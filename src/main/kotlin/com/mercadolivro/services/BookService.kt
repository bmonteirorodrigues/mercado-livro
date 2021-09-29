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

    fun getById(id: Int): BookModel {
        return booksRepository.findById(id).orElseThrow()
    }

    fun deleteById(id: Int){
        if(!booksRepository.existsById(id)) throw Exception()
        val book = booksRepository.findById(id).orElseThrow()
            book.status = BookStatus.CANCELADO
        booksRepository.save(book)
    }

    fun updateById(id: Int, book: BookModel){}

}
