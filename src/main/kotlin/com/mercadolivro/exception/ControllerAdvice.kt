package com.mercadolivro.exception

import com.mercadolivro.controller.response.ErrorResponse
import com.mercadolivro.controller.response.FieldErrorResponse
import com.mercadolivro.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(NotFoundException::class)
    fun handlerException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse>{
        val error = ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.message,
                ex.errorCode,
                null)

        return ResponseEntity(error,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handlerException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse>{
        val error = ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.message,
                ex.errorCode,
                null)

        return ResponseEntity(error,HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest):ResponseEntity<ErrorResponse>{
        val error = ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                Errors.ML001.message,
                Errors.ML001.code,
                ex.bindingResult.fieldErrors.map { FieldErrorResponse(it.defaultMessage ?: "invalid", it.field)})

        return ResponseEntity(error,HttpStatus.UNPROCESSABLE_ENTITY)
    }
}