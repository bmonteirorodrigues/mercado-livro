package com.mercadolivro.repository

import com.mercadolivro.domain.BookModel
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BooksRepository : JpaRepository<BookModel, Int>{

    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}