package com.mercadolivro.enums

enum class Errors(val code:String, val message: String) {

    //Request
    ML001("ML-001", "Invalid request"),

    //Book 100 - 199
    ML101("ML-101", "Book [%s] not exists"),
    ML102("ML-102", "Cannot update book with status [%s]"),

    //Customer 200 - 299
    ML201("ML-201", "Customer [%s] not exists")
}