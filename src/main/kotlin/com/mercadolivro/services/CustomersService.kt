package com.mercadolivro.services

import com.mercadolivro.controllers.requests.PostCustomerRequest
import com.mercadolivro.controllers.requests.PutCustomerRequest
import com.mercadolivro.domain.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomersService {
    var customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter{it.name.contains(name, true)}
        }
        return customers
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.first { it.id == id }
    }

    fun updateCustomer(customer: CustomerModel){
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: String){
        customers.removeIf{ it.id == id }
    }

    fun createCustomer(postCustomerRequest: CustomerModel){
        val id: Int = if(customers.isNullOrEmpty()) 1 else (customers.last().id!!.toInt() + 1)
        customers.add(CustomerModel(id.toString(),postCustomerRequest.name, postCustomerRequest.email))
    }

}