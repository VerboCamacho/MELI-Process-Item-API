package com.example.itemapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Representa un producto disponible en la tienda.
 *
 * <p>
 * Es la entidad principal del dominio y contiene toda la información
 * relevante para la visualización y comercialización del producto.
 * Incluye datos generales, inventario, imágenes, categoría,
 * marca, así como características técnicas y reseñas de clientes.
 * </p>
 *
 * <p>
 * Un {@code Product} está compuesto por varias clases auxiliares
 * como {@link GeneralInfo}, {@link Characteristics} y {@link Reviews},
 * que permiten estructurar la información de manera modular.
 * </p>
 *
 * @see GeneralInfo
 * @see Characteristics
 * @see Reviews
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidad principal que representa un producto dentro de la tienda.")
public class Product {

    /**
     * Identificador único del producto.
     */
    @Schema(description = "Identificador único del producto", example = "PRD-12345")
    private String id;

    /**
     * Nombre del producto.
     */
    @Schema(description = "Nombre del producto", example = "Reloj Omega Seamaster")
    private String name;

    /**
     * Descripción detallada del producto.
     */
    @Schema(description = "Descripción detallada del producto", example = "Reloj de lujo resistente al agua hasta 300 metros.")
    private String description;

    /**
     * Precio actual del producto.
     */
    @Schema(description = "Precio actual del producto", example = "4500.00")
    private Double price;

    /**
     * Moneda en la que está expresado el precio.
     */
    @Schema(description = "Moneda en la que está expresado el precio", example = "USD")
    private String currency;

    /**
     * Cantidad disponible en el inventario.
     */
    @Schema(description = "Cantidad disponible en inventario", example = "20")
    private Integer availableQuantity;

    /**
     * Lista de URLs con las imágenes del producto.
     */
    @Schema(
        description = "Lista de URLs de imágenes del producto",
        example = "[\"https://example.com/image1.jpg\", \"https://example.com/image2.jpg\"]"
    )
    private List<String> images;

    /**
     * Categoría a la que pertenece el producto.
     */
    @Schema(description = "Categoría a la que pertenece el producto", example = "Relojes de lujo")
    private String category;

    /**
     * Marca del producto.
     */
    @Schema(description = "Marca del producto", example = "Omega")
    private String brand;

    /**
     * Información adicional sobre el vendedor o distribución.
     */
    @Schema(description = "Descripción del vendedor o información adicional", example = "Distribuidor autorizado con garantía internacional.")
    private String sellerDescription;

    /**
     * Información general del producto como precios, cuotas y envío.
     */
    @Schema(description = "Información general del producto como precios, cuotas y envío")
    private GeneralInfo generalInfo;

    /**
     * Características físicas y técnicas del producto.
     */
    @Schema(description = "Características físicas y técnicas del producto")
    private Characteristics characteristics;

    /**
     * Reseñas y calificaciones otorgadas por los clientes.
     */
    @Schema(description = "Reseñas de clientes y calificaciones del producto")
    private Reviews reviews;
}
