package com.example.itemapi.service;

import com.example.itemapi.model.Product;
import java.util.List;

/**
 * Servicio de negocio para la gestión de {@link Product}.
 *
 * <p>
 * Define operaciones relacionadas con la consulta de productos,
 * como obtener la lista completa o recuperar un producto específico
 * mediante su identificador único.
 * </p>
 *
 * <p>
 * Esta interfaz abstrae la lógica de negocio de los controladores
 * y delega la implementación a una clase concreta.
 * </p>
 *
 * @see Product
 */
public interface ProductService {

    /**
     * Devuelve todos los productos disponibles en el sistema.
     *
     * <p>
     * El resultado nunca es {@code null}. En caso de no existir productos,
     * se retorna una lista vacía.
     * </p>
     *
     * @return lista de productos registrados
     */
    List<Product> listProducts();

    /**
     * Recupera un {@link Product} a partir de su identificador único.
     *
     * <p>
     * Si no existe un producto con el id especificado,
     * se retorna {@code null}. En implementaciones más robustas,
     * puede considerarse el uso de {@code Optional}.
     * </p>
     *
     * @param id identificador único del producto (no puede ser {@code null})
     * @return producto correspondiente o {@code null} si no se encuentra
     */
    Product getProductById(String id);
}
