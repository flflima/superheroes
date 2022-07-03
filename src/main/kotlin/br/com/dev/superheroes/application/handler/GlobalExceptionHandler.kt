package br.com.dev.superheroes.application.handler

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.stream.Collectors

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException
    ): MyResponseDTO {
        val errors = ex.bindingResult
            .fieldErrors
            .stream()
            .map { obj: FieldError -> obj.defaultMessage }
            .collect(Collectors.toList())
        return MyResponseDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            message = "Error",
            error = errors as List<String>
        )

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MissingKotlinParameterException::class)
    fun missingKotlinParameterException(ex: MissingKotlinParameterException): MyResponseDTO? {
        return MyResponseDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            message = "Error",
            error = listOf(ex.path.fold("") { result, segment ->
                if (segment.fieldName != null && result.isEmpty()) segment.fieldName
                else if (segment.fieldName != null) "$result.${segment.fieldName}"
                else "$result[${segment.index}]"
            } + " is required"
            )
        )
    }
}

data class MyResponseDTO(val status: Int, val message: String?, val error: List<String>)