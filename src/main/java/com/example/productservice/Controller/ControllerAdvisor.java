package com.example.productservice.Controller;

import com.example.productservice.DTO.ProductNotFoundExceptionDto;
import com.example.productservice.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> productNotFound(ProductNotFoundException ex) {

        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage(ex.getMessage());
        dto.setProductId(ex.getProductId());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String>cachingRunTimeException(RuntimeException ex) {
        RuntimeException runtimeException = new RuntimeException();
        runtimeException.setStackTrace(ex.getStackTrace());
        return new ResponseEntity<>(runtimeException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);  }

}
