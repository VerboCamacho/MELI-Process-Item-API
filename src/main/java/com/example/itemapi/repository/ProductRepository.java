package com.example.itemapi.repository;

import com.example.itemapi.model.Product;

import java.util.List;

/**
 * {@code ProductRepository} define el contrato de acceso a los productos
 * dentro del sistema. 
 * <p>
 * Esta interfaz abstrae la lógica de obtención de productos, permitiendo
 * que existan distintas implementaciones (por ejemplo, en memoria desde JSON,
 * desde una base de datos, o desde un servicio externo).
 * </p>
 *
 * <p><b>Responsabilidades principales:</b></p>
 * <ul>
 *   <li>Proveer acceso a la lista completa de productos.</li>
 *   <li>Permitir la búsqueda de un producto por su identificador único.</li>
 * </ul>
 *
 * <p><b>Ventajas de usar la interfaz:</b></p>
 * <ul>
 *   <li>Favorece la inyección de dependencias en Spring.</li>
 *   <li>Permite intercambiar fácilmente la fuente de datos sin cambiar el código cliente.</li>
 *   <li>Facilita pruebas unitarias mediante mocks o stubs.</li>
 * </ul>
 */
public interface ProductRepository {

    /**
     * Devuelve la lista completa de productos disponibles en el repositorio.
     *
     * @return lista de objetos {@link Product}; nunca {@code null}.
     */
    List<Product> findAll();

    /**
     * Busca un producto por su identificador único.
     *
     * @param id identificador del producto (no debe ser {@code null}).
     * @return el {@link Product} correspondiente al ID,
     *         o {@code null} si no existe en el repositorio.
     */
    Product findById(String id);
}
