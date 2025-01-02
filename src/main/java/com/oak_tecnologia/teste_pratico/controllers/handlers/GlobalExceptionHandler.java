package com.oak_tecnologia.teste_pratico.controllers.handlers;

import com.oak_tecnologia.teste_pratico.dto.error.ErrorFieldsDTO;
import com.oak_tecnologia.teste_pratico.dto.error.ErrorMessageDTO;
import com.oak_tecnologia.teste_pratico.dto.error.ErrorMessageFieldsDTO;
import com.oak_tecnologia.teste_pratico.services.exceptions.OpcaoInvalidaException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OpcaoInvalidaException.class)
    public ResponseEntity<ErrorMessageDTO> opcaoInvalida(OpcaoInvalidaException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDTO errorMessageDto = new ErrorMessageDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessageDTO> httpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageDTO errorMessageDto = new ErrorMessageDTO(Instant.now(), status.value(), "Corpo da requisição inválido.", request.getRequestURI());
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageDTO> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessageFieldsDTO errorMessageDto = new ErrorMessageFieldsDTO(Instant.now(), status.value(), "Erro no processamento de dados.", request.getRequestURI());
        for (FieldError error : e.getFieldErrors()){
            String field = error.getField(); // Atributo da classe Motorista que apresentou inconformidade
            String message = error.getDefaultMessage(); // message definida nas annotations de validação
            ErrorFieldsDTO errorFieldsDto = new ErrorFieldsDTO(field, message);
            errorMessageDto.getErrors().add(errorFieldsDto);
        }
        return ResponseEntity.status(status.value()).body(errorMessageDto);
    }

}
