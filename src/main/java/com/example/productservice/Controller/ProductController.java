package com.example.productservice.Controller;

import com.example.productservice.DTO.FakseStoreProductDto;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductServcie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServcie productServcie;

    public ProductController(ProductServcie productServcie) {
        this.productServcie = productServcie;
    }

    @GetMapping("/{id}")
    public Product getPRoductById(@PathVariable String id) {

        return null;
        
    }

    @GetMapping()
    public List<Product> getProducts() {
        return null;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable String id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        return ;
    }

    @PostMapping
    public Product createProduct(@RequestBody FakseStoreProductDto product) {

        return productServcie.createProduct(product);

    }

    //In future we will add the bulk update controller
    
}
