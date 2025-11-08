package br.edu.utfpr.pb.ecommerce.server_ecommerce.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleException(Exception exception,
                                    HttpServletRequest request) {

        return new ApiError(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getServletPath());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleExceptionArguments(MethodArgumentNotValidException exception,
                                             HttpServletRequest request) {

        BindingResult result = exception.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : result.getFieldErrors()) {
            errors.put( fieldError.getField(),
                    fieldError.getDefaultMessage());
        }

        return new ApiError(
                "Fields not valid",
                HttpStatus.BAD_REQUEST.value(),
                request.getServletPath(),
                errors);
    }
}
