package com.mercadolivro.extensions

import com.mercadolivro.controllers.requests.PostBookRequest
import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutBookRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.domain.BookModel
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.enums.BookStatus

fun PostCustomerRequest.toCustomerModel(): CustomerModel{
    return CustomerModel(name = this.name,
                         email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel{
    return CustomerModel(id = id,
                         name = this.name,
                         email = this.email)
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel{
    return BookModel(name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        id = previousValue.id,
        customer = previousValue.customer)
}


fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel{
    return BookModel(name = this.name,
                     price = this.price,
                     status = BookStatus.ATIVO,
                     customer = customer)
}


