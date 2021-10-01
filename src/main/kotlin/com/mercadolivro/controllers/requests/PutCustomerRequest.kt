package com.mercadolivro.controllers.requests

import com.mercadolivro.enums.CustomerStatus

data class PutCustomerRequest(var name: String,
                              var email: String
                              )