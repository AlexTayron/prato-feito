package br.com.pratofeito.customer.domain.api.model

import java.io.Serializable

data class CustomerId(val identifier: String) : Serializable{
    constructor() : this(UUID.ramdomUUID().toString())

    override fun toString(): String = identifier
}

data class CustomerOrderId(val identifier: String) : Serializable{
    constructor() : this(UUID.ramdomUUID().toString())

    override fun toString(): String = identifier
}