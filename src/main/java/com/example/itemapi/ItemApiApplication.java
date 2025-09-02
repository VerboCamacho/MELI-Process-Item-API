package com.example.itemapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la aplicación Spring Boot.
 *
 * <p>
 * Esta clase sirve como punto de entrada de la API de productos,
 * inicializando el contexto de Spring y exponiendo los servicios REST.
 * </p>
 *
 * <p>
 * Se ejecuta mediante el método {@link #main(String[])} que delega
 * en {@link SpringApplication#run(Class, String...)}.
 * </p>
 */
@SpringBootApplication
public class ItemApiApplication {

    /**
     * Método principal de ejecución.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(ItemApiApplication.class, args);
    }
}
