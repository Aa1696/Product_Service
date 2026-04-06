package com.example.productservice.Services;

import com.example.productservice.DTO.FakseStoreProductDto;
import com.example.productservice.Models.Product;

import java.util.List;

public interface ProductServcie {

    public Product getProductById(Long id);

    public List<Product> getAllProduct();

    public Product createProduct(FakseStoreProductDto product);

    public Product updateProduct(Long id, Product product);

    public void deleteProduct(Long id);

}
