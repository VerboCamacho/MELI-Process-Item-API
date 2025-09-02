package com.example.itemapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Reseñas y opiniones de los clientes sobre un {@link Product}.
 *
 * <p>
 * Contiene la calificación promedio, el total de reseñas
 * y los comentarios escritos por los usuarios que adquirieron
 * el producto.
 * </p>
 *
 * <p>
 * Esta clase se utiliza para mostrar información relevante sobre
 * la experiencia de otros compradores y sirve como referencia
 * para futuros clientes.
 * </p>
 *
 * @see Product
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Reseñas y calificaciones de clientes sobre el producto.")
public class Reviews {

    /**
     * Calificación promedio del producto.
     * <p>
     * Se mide en una escala de 1 a 5.
     * </p>
     */
    @Schema(description = "Calificación promedio del producto en una escala de 1 a 5", example = "4.5")
    private Double rating;

    /**
     * Número total de reseñas registradas.
     */
    @Schema(description = "Número total de reseñas registradas", example = "120")
    private Integer totalReviews;

    /**
     * Lista de comentarios escritos por los clientes.
     */
    @Schema(
        description = "Comentarios escritos por los clientes",
        example = "[\"Excelente calidad y diseño\", \"El envío fue muy rápido\"]"
    )
    private List<String> comments;
}
