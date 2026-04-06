package com.example.productservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel{

    private String title;
    private String description;

}
