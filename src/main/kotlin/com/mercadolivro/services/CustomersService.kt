package com.mercadolivro.services

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomersService(
   val customerRepository: CustomerRepository
) {
    var customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let { return customerRepository.findByNameContaining(name) }
        return customerRepository.findAll().toList()
    }

    fun getById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun updateCustomer(customer: CustomerModel){
        if(!customerRepository.existsById(customer.id!!)) throw Exception()
        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int){
        if(!customerRepository.existsById(id)) throw Exception()
        customerRepository.deleteById(id)
    }

    fun createCustomer(customerModel: CustomerModel){
        customerRepository.save(customerModel)
    }
}