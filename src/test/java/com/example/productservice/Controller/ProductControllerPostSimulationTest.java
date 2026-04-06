package com.example.productservice.Controller;

import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductServcie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerPostSimulationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServcie productServcie;

    @Test
    void postMacPayload_bindsAndReturnsCreatedProduct() throws Exception {
        Product saved = new Product();
        saved.setId(2L);
        saved.setTitle("MAC");
        saved.setDescription("It is the latest version , it is the latest MacBokPro");
        saved.setPrice(250000.98);
        saved.setImageUrl("image.com");
        saved.setQty(5);

        when(productServcie.createProduct(any())).thenReturn(saved);

        String requestBody = """
                {
                  \"title\": \"MAC\",
                  \"description\": \"It is the latest version , it is the latest MacBokPro\",
                  \"price\": 250000.98,
                  \"category\": \"Premium\",
                  \"image\": \"image.com\",
                  \"qty\": 5
                }
                """;

        mockMvc.perform(post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.title").value("MAC"))
                .andExpect(jsonPath("$.qty").value(5));
    }
}

