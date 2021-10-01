package com.mercadolivro.domain

import com.mercadolivro.enums.CustomerStatus
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
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus? = null,

    var cpf: String? = null
    ){


}