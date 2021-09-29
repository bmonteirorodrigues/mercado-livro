package com.mercadolivro.repository

import com.mercadolivro.domain.BookModel
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.enums.BookStatus
import org.springframework.data.repository.CrudRepository

interface BooksRepository : CrudRepository<BookModel, Int>{

    fun findByStatus(status: BookStatus): List<BookModel>
}