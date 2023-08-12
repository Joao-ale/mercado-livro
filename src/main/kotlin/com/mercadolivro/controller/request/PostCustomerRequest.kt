package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "nome deve ser informado")
    var name: String,

    @field:Email(message = "Email deve ser válido")
    var email: String
)