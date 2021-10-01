package com.mercadolivro.controllers.responses

import com.mercadolivro.enums.CustomerStatus
import javax.persistence.Column
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class CustomerResponse(
    var id: Int?,
    var name: String,
    var email: String,
    var status: CustomerStatus? = null
)
