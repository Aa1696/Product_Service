package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "products")
@Getter
@Setter
public class Product extends BaseModel{

    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private int qty;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
