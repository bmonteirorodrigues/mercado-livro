package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.domain.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController {

    var customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAll(): MutableList<CustomerModel> {
        return customers
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.first { it.id == id }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody postCustomerRequest: PostCustomerRequest){
        customers.add(CustomerModel("1",postCustomerRequest.name, postCustomerRequest.email))
    }
}