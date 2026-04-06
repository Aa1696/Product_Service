package com.example.productservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductNotFoundExceptionDto {

    private String message;
    private Long productId;

}
