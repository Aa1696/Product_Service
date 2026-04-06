package com.example.productservice.Services;

import com.example.productservice.DTO.FakseStoreProductDto;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repository.CategoryRepo;
import com.example.productservice.Repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplSimulationTest {

    @Mock
    private ProductRepo productRepo;

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void simulateGivenPostPayloadWithoutId_thenCreateSucceeds() {
        FakseStoreProductDto dto = new FakseStoreProductDto();
        dto.setTitle("iPhone");
        dto.setDescription("It is the latest version , it is iPhone16");
        dto.setPrice(100000.98);
        dto.setCategory("Premium");
        dto.setImage("image.com");
        dto.setQty(2);

        Category category = new Category();
        category.setId(10L);
        category.setTitle("Premium");
        when(categoryRepo.findByTitle("Premium")).thenReturn(Optional.of(category));

        Product saved = new Product();
        saved.setId(1L);
        saved.setTitle(dto.getTitle());
        saved.setDescription(dto.getDescription());
        saved.setPrice(dto.getPrice());
        saved.setImageUrl(dto.getImage());
        saved.setQty(dto.getQty());
        when(productRepo.save(any(Product.class))).thenReturn(saved);

        Product result = productService.createProduct(dto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("iPhone", result.getTitle());
        assertNull(dto.getId());
    }
}

