package com.mercadolivro.domain

import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity(name = "books")
data class BookModel(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customerModel: CustomerModel? = null
)