package com.mercadolivro.domain

import org.springframework.context.annotation.Primary
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity(name = "customers")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String
    )