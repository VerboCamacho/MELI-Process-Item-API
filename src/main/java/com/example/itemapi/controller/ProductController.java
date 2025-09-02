package com.example.itemapi.controller;

import com.example.itemapi.model.Product;
import com.example.itemapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Controlador REST encargado de exponer los endpoints relacionados con productos.
 * <p>
 * Define operaciones para listar todos los productos y consultar el detalle de un
 * producto específico. Utiliza {@link ProductService} para acceder a la lógica
 * de negocio y a la capa de repositorio.
 * </p>
 */
@RestController
@RequestMapping("/v1/products")
@Tag(name = "Productos", description = "API para consulta de productos")
public class ProductController {

    private final ProductService service;

    /**
     * Crea una nueva instancia del controlador de productos.
     *
     * @param service servicio de productos utilizado para acceder a la lógica de negocio.
     */
    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * Obtiene la lista completa de productos disponibles.
     * <p>
     * Si no existen productos en el sistema, devuelve un {@code 204 No Content}.
     * </p>
     *
     * @return una respuesta HTTP con la lista de productos ({@code 200 OK})
     *         o {@code 204 No Content} si no existen productos.
     */
    @Operation(
            summary = "Listar productos",
            description = "Devuelve la lista completa de productos disponibles"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de productos",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Product.class)),
                    examples = @ExampleObject(
                            value = "[{\"id\":\"w-001\",\"name\":\"Apple Watch Series 9\",\"price\":399.99}," +
                                    "{\"id\":\"w-002\",\"name\":\"Samsung Galaxy Watch 6\",\"price\":299.99}]"
                    )
            )
    )
    @ApiResponse(
            responseCode = "204",
            description = "No hay productos disponibles"
    )
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.listProducts();
        if (products == null || products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    /**
     * Obtiene un producto específico a partir de su identificador único.
     * <p>
     * Si el producto no existe, se lanza una excepción con estado
     * {@code 404 Not Found}.
     * </p>
     *
     * @param id identificador único del producto a consultar. No debe ser {@code null}.
     * @return una respuesta HTTP con el producto encontrado ({@code 200 OK}).
     * @throws ResponseStatusException si el producto no existe en el sistema.
     */
    @Operation(
            summary = "Obtener un producto por ID",
            description = "Devuelve el detalle de un producto específico"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Producto encontrado",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Product.class),
                    examples = @ExampleObject(
                            value = "{\"id\":\"w-001\",\"name\":\"Apple Watch Series 9\",\"price\":399.99}"
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Producto no encontrado",
            content = @Content
    )
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = service.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
        return ResponseEntity.ok(product);
    }
}
