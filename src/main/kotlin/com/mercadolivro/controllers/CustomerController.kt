package com.mercadolivro.controllers

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.services.CustomersService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt
import com.mercadolivro.extensions.*

@RestController
@RequestMapping("customers")
class CustomerController(
    var customersService: CustomersService
){

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customersService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customersService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String, @RequestBody customer: PutCustomerRequest){
        customersService.updateCustomer(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String){
        customersService.deleteCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody postCustomerRequest: PostCustomerRequest){
        customersService.createCustomer(postCustomerRequest.toCustomerModel())
    }
}