package com.example.itemapi.service;

import com.example.itemapi.model.Product;
import com.example.itemapi.repository.JsonProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Implementación de {@link ProductService} que obtiene los productos
 * desde un repositorio basado en archivo JSON ({@link JsonProductRepository}).
 *
 * <p>
 * Esta clase se encarga de la lógica de negocio relacionada con la
 * validación de parámetros y el control de errores, mapeando los
 * fallos a códigos HTTP mediante {@link ResponseStatusException}.
 * </p>
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final JsonProductRepository repository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param repository repositorio que provee los productos desde un archivo JSON
     */
    public ProductServiceImpl(JsonProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Recupera todos los productos disponibles en el repositorio.
     *
     * <p>
     * - Retorna {@link HttpStatus#NO_CONTENT} si no hay productos.<br>
     * - Retorna {@link HttpStatus#INTERNAL_SERVER_ERROR} en caso de error inesperado.
     * </p>
     *
     * @return lista de productos disponibles
     * @throws ResponseStatusException si ocurre un error o no hay productos
     */
    @Override
    public List<Product> listProducts() {
        try {
            List<Product> products = repository.findAll();
            if (products == null || products.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No hay productos disponibles");
            }
            return products;
        } catch (ResponseStatusException e) {
            throw e; // Se re-lanza para mantener el status original
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener productos", e);
        }
    }

    /**
     * Recupera un {@link Product} a partir de su identificador único.
     *
     * <p>
     * - Retorna {@link HttpStatus#BAD_REQUEST} si el id es nulo o vacío.<br>
     * - Retorna {@link HttpStatus#NOT_FOUND} si no existe el producto.<br>
     * - Retorna {@link HttpStatus#INTERNAL_SERVER_ERROR} en caso de error inesperado.
     * </p>
     *
     * @param id identificador único del producto (no puede ser nulo o vacío)
     * @return el producto encontrado
     * @throws ResponseStatusException si ocurre un error de validación o de búsqueda
     */
    @Override
    public Product getProductById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del producto no puede ser nulo o vacío");
        }

        try {
            Product producto = repository.findById(id);
            if (producto == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + id);
            }
            return producto;
        } catch (ResponseStatusException e) {
            throw e; // Se re-lanza para mantener el status original
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al buscar producto: " + id, e);
        }
    }
}
