package com.example.productservice.Services;

import com.example.productservice.DTO.FakseStoreProductDto;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repository.CategoryRepo;
import com.example.productservice.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductServcie{

    private RestTemplate restTemplate;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

//    public ProductServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @Override
    public Product getProductById(Long id) {

        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product createProduct(FakseStoreProductDto productDto) {
        Product product = from(productDto);
        // For create flow, rely on DB auto-generated id from BaseModel.
        product.setId(null);
        return productRepo.save(product);

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Product from(FakseStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());

        // Resolve existing category by title or create/persist it once.
        Category category = categoryRepo.findByTitle(fakeStoreProductDto.getCategory())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setTitle(fakeStoreProductDto.getTitle());
                    newCategory.setDescription(fakeStoreProductDto.getDescription());
                    newCategory.setCreatedAt(new Date());
                    newCategory.setUpdatedAt(new Date());
                    return categoryRepo.save(newCategory);
                });
        product.setCategory(category);

        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setQty(fakeStoreProductDto.getQty());
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());

        return product;
    }
}
