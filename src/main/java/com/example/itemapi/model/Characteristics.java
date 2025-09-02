package com.example.itemapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las características físicas y técnicas de un producto.
 *
 * <p>
 * Incluye información relacionada con el diseño, los materiales,
 * los colores y el estilo del producto. Se utiliza como parte del modelo
 * de dominio en {@link Product}.
 * </p>
 *
 * <p>
 * Esta clase es un objeto de transferencia de datos (DTO) que permite
 * describir de manera detallada los atributos físicos y de diseño de un
 * producto dentro del API.
 * </p>
 *
 * @see Product
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Características físicas y técnicas del producto, incluyendo diseño y materiales.")
public class Characteristics {

    /**
     * Línea o colección a la que pertenece el producto.
     */
    @Schema(description = "Línea o colección a la que pertenece el producto", example = "Seamaster")
    private String line;

    /**
     * Modelo específico del producto.
     */
    @Schema(description = "Modelo específico del producto", example = "Omega Seamaster Diver 300M")
    private String model;

    /**
     * Género al que está dirigido el producto.
     */
    @Schema(description = "Género al que está dirigido el producto", example = "Unisex")
    private String gender;

    /**
     * Rango de edad recomendado para el producto.
     */
    @Schema(description = "Rango de edad recomendado", example = "Adulto")
    private String age;

    /**
     * Color de la caja del producto.
     */
    @Schema(description = "Color de la caja del producto", example = "Plateado")
    private String caseColor;

    /**
     * Material de la correa del producto.
     */
    @Schema(description = "Material de la correa", example = "Acero inoxidable")
    private String strapMaterial;

    /**
     * Tipo de cierre de la correa.
     */
    @Schema(description = "Tipo de cierre de la correa", example = "Hebilla desplegable")
    private String claspType;

    /**
     * Color de la correa del producto.
     */
    @Schema(description = "Color de la correa", example = "Negro")
    private String strapColor;

    /**
     * Color del bisel del producto.
     */
    @Schema(description = "Color del bisel", example = "Azul marino")
    private String bezelColor;

    /**
     * Color de la esfera o carátula del producto.
     */
    @Schema(description = "Color de la esfera o carátula", example = "Blanco")
    private String dialColor;
}
