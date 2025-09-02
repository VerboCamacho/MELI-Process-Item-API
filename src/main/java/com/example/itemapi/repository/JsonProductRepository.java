package com.example.itemapi.repository;

import com.example.itemapi.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * {@code JsonProductRepository} es una implementación de {@link ProductRepository}
 * que carga los productos desde un archivo JSON ubicado en el classpath de la aplicación.
 * <p>
 * Esta clase utiliza la librería {@link ObjectMapper} de Jackson para deserializar
 * el archivo JSON en una lista inmutable de objetos {@link Product}.
 * </p>
 *
 * <p><b>Responsabilidades principales:</b></p>
 * <ul>
 *   <li>Cargar y mantener en memoria una lista de productos desde {@code products.json}.</li>
 *   <li>Ofrecer métodos para consultar todos los productos o buscar uno por su ID.</li>
 * </ul>
 *
 * <p><b>Uso dentro de Spring:</b></p>
 * <p>
 * Está anotada con {@link Repository}, lo que la hace detectable como componente
 * dentro del contexto de Spring y permite la inyección de dependencias donde se necesite
 * un {@link ProductRepository}.
 * </p>
 */
@Repository
public class JsonProductRepository implements ProductRepository {

    /**
     * Lista inmutable de productos cargados desde el archivo JSON.
     */
    private List<Product> products;

    /**
     * Constructor que inicializa la lista de productos
     * cargándolos automáticamente desde el archivo {@code products.json}.
     */
    public JsonProductRepository() {
        loadProducts();
    }

    /**
     * Carga los productos desde el archivo {@code products.json}
     * ubicado en el classpath. Si el archivo no existe o ocurre
     * un error en la deserialización, se lanza una excepción en tiempo de ejecución.
     *
     * <p>La lista resultante se envuelve en una colección inmutable
     * mediante {@link Collections#unmodifiableList(List)}.</p>
     */
    private void loadProducts() {
        try (InputStream inputStream = getClass().getResourceAsStream("/products.json")) {
            if (inputStream == null) {
                throw new RuntimeException("Recurso /products.json no encontrado en el classpath");
            }
            ObjectMapper mapper = new ObjectMapper();
            List<Product> loaded = mapper.readValue(inputStream, new TypeReference<List<Product>>() {});
            this.products = Collections.unmodifiableList(loaded);
        } catch (Exception e) {
            throw new RuntimeException("Error cargando products.json", e);
        }
    }

    /**
     * Devuelve todos los productos cargados en memoria.
     *
     * @return lista inmutable de {@link Product}.
     */
    @Override
    public List<Product> findAll() {
        return products;
    }

    /**
     * Busca un producto en la lista por su identificador único.
     *
     * @param id identificador del producto a buscar.
     * @return el {@link Product} correspondiente al ID,
     *         o {@code null} si no existe en la lista.
     */
    @Override
    public Product findById(String id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
