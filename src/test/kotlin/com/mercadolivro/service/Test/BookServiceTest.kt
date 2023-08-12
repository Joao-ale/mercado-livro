package com.mercadolivro.service.Test

import com.mercadolivro.model.BookModel
import com.mercadolivro.repository.BookRepository
import org.junit.jupiter.api.Test
import org.mockito.Mock


class BookServiceTest {
    @Mock
    private lateinit var bookRepository: BookRepository


    //TERMINAR TESTES
    @Test
    fun findAll(){
        val bookModel:BookModel
         whenever(bookRepository.findAll()).thenReturn(bookModel)
    }
}