package com.example.productservice.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakseStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
    private int qty;

}
