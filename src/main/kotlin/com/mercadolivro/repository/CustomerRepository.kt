package com.mercadolivro.repository

import com.mercadolivro.domain.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int>{
}