package com.mercadolivro.extensions

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.domain.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel{
    return CustomerModel(id = null, name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel{
    return CustomerModel(id = id, name = this.name, email = this.email)
}