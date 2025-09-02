package com.example.itemapi.service;

import com.example.itemapi.model.Product;
import com.example.itemapi.repository.JsonProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private JsonProductRepository repository;

    @InjectMocks
    private ProductServiceImpl service;

    @Test
    void listProducts_shouldReturnRepositoryResult() {
        Product p1 = buildProduct("w-001", "Apple Watch Series 9", 399.99);
        Product p2 = buildProduct("w-002", "Samsung Galaxy Watch 6", 299.99);
        Mockito.when(repository.findAll()).thenReturn(List.of(p1, p2));

        List<Product> result = service.listProducts();

        assertNotNull(result, "El servicio no debe retornar null");
        assertEquals(2, result.size());
        assertEquals("w-001", result.get(0).getId());
        verify(repository, times(1)).findAll();
    }

    @Test
    void listProducts_whenEmpty_shouldThrow204() {
        // 🔹 Simular que el repositorio devuelve una lista vacía
        Mockito.when(repository.findAll()).thenReturn(List.of());

        // 🔹 Verificar que el servicio lanza una excepción 204 No Content
        ResponseStatusException ex = assertThrows(
            ResponseStatusException.class,
            () -> service.listProducts()
        );

        assertEquals(204, ex.getStatusCode().value(), "Debe lanzar 204 cuando no hay productos");
        assertTrue(ex.getReason().contains("No hay productos disponibles"));
        verify(repository, times(1)).findAll();
    }

    @Test
    void getProductById_whenExists_shouldReturnProduct() {
        Product p = buildProduct("w-001", "Apple Watch Series 9", 399.99);
        Mockito.when(repository.findById("w-001")).thenReturn(p);

        Product result = service.getProductById("w-001");

        assertNotNull(result);
        assertEquals("w-001", result.getId());
        verify(repository, times(1)).findById(eq("w-001"));
    }

    @Test
    void getProductById_whenNotExists_shouldThrow404() {
        Mockito.when(repository.findById("nope")).thenReturn(null);

        ResponseStatusException ex = assertThrows(
            ResponseStatusException.class,
            () -> service.getProductById("nope")
        );

        assertEquals(404, ex.getStatusCode().value(), "Debe lanzar 404 cuando no existe");
        assertTrue(ex.getReason().contains("Producto no encontrado: nope"));
        verify(repository, times(1)).findById(eq("nope"));
    }

    // Helper para crear productos de prueba
    private Product buildProduct(String id, String name, double price) {
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        return p;
    }
}
