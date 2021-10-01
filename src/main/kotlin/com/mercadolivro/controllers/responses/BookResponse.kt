package com.mercadolivro.controllers.responses

import com.mercadolivro.domain.CustomerModel
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus
import java.math.BigDecimal
import javax.persistence.*

data class BookResponse(
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: BookStatus? = null
)
