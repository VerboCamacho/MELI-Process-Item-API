package com.example.itemapi.repository;

import com.example.itemapi.model.Product;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

@Test
void shouldLoadProductsFromJson() {
JsonProductRepository repo = new JsonProductRepository();
List<Product> all = repo.findAll();
assertNotNull(all);
assertFalse(all.isEmpty(), "La lista de productos no debe estar vacía");
}

@Test
void shouldFindByIdWhenExists() {
JsonProductRepository repo = new JsonProductRepository();
Product p = repo.findById("1001"); 
assertNotNull(p);
assertEquals("1001", p.getId());
}

@Test
void shouldReturnNullWhenIdNotExists() {
JsonProductRepository repo = new JsonProductRepository();
Product p = repo.findById("NO_EXISTE");
assertNull(p);
}
}