package com.barvegas.backend.handler;

import com.barvegas.backend.exception.BadRequestException;
import com.barvegas.backend.exception.ExceptionDetails;
import com.barvegas.backend.exception.ServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequest(BadRequestException bre) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Olhe a documentação")
                        .details(bre.getMessage())
                        .devMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<ExceptionDetails> handlerAnyRequest(ServerErrorException see) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .title("Internal Server Error, Olhe a documentação")
                        .details(see.getMessage())
                        .devMessage(see.getClass().getName())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionDetails> handlerAnyRequest(Exception e) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .title("Internal Server Error, Olhe a documentação")
                        .details("Erro de requisição")
                        .devMessage("Olhar documentação")
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}