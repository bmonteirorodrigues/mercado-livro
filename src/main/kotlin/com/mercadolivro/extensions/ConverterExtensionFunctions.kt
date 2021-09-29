package com.mercadolivro.extensions

import com.mercadolivro.controllers.requests.PostBookRequest
import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.domain.BookModel
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.enums.BookStatus

fun PostCustomerRequest.toCustomerModel(): CustomerModel{
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel{
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer : CustomerModel): BookModel{
    return BookModel(name = this.name, price = this.price, status = BookStatus.ATIVO, customerModel = customer)
}

