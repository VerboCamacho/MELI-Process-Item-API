package com.example.itemapi.controller;

import com.example.itemapi.model.Product;
import com.example.itemapi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllProducts_shouldReturn200AndJsonArray() throws Exception {
        Product p1 = buildProduct("w-001", "Apple Watch Series 9", 399.99);
        Product p2 = buildProduct("w-002", "Samsung Galaxy Watch 6", 299.99);
        Mockito.when(service.listProducts()).thenReturn(List.of(p1, p2));

        mockMvc.perform(get("/v1/products").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value("w-001"))
            .andExpect(jsonPath("$[0].name").value("Apple Watch Series 9"))
            .andExpect(jsonPath("$[0].price").value(399.99))
            .andExpect(jsonPath("$[1].id").value("w-002"))
            .andExpect(jsonPath("$[1].name").value("Samsung Galaxy Watch 6"))
            .andExpect(jsonPath("$[1].price").value(299.99));

        verify(service, times(1)).listProducts();
    }

    @Test
    void getAllProducts_whenEmpty_shouldReturn204() throws Exception {
        Mockito.when(service.listProducts()).thenReturn(List.of());

        mockMvc.perform(get("/v1/products").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        verify(service, times(1)).listProducts();
    }

    @Test
    void getProductById_whenFound_shouldReturn200AndProduct() throws Exception {
        Product p = buildProduct("w-001", "Apple Watch Series 9", 399.99);
        Mockito.when(service.getProductById("w-001")).thenReturn(p);

        mockMvc.perform(get("/v1/products/w-001").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value("w-001"))
            .andExpect(jsonPath("$.name").value("Apple Watch Series 9"))
            .andExpect(jsonPath("$.price").value(399.99));

        verify(service, times(1)).getProductById("w-001");
    }

    @Test
    void getProductById_whenNotFound_shouldReturn404() throws Exception {
        Mockito.when(service.getProductById(anyString())).thenReturn(null);

        mockMvc.perform(get("/v1/products/no-such-id").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());

        verify(service, times(1)).getProductById("no-such-id");
    }

    // Helper
    private Product buildProduct(String id, String name, double price) {
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        return p;
    }
}
