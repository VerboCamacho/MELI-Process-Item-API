package com.example.itemapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Información general de un producto.
 *
 * <p>
 * Contiene los datos comerciales principales del producto,
 * incluyendo precios originales y con descuento, porcentajes de
 * rebaja, detalles de financiamiento y opciones de envío.
 * </p>
 *
 * <p>
 * Esta clase se utiliza como parte del modelo de dominio en {@link Product}
 * y actúa como un objeto de transferencia de datos (DTO) que representa
 * información de valor para el cliente final.
 * </p>
 *
 * @see Product
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Información general de un producto, incluyendo precios, descuentos y envío.")
public class GeneralInfo {

    /**
     * Precio del producto con el descuento aplicado.
     */
    @Schema(description = "Precio con descuento aplicado", example = "899.99")
    private Double discountPrice;

    /**
     * Precio original del producto antes de aplicar descuentos.
     */
    @Schema(description = "Precio original antes del descuento", example = "1200.00")
    private Double originalPrice;

    /**
     * Porcentaje de descuento aplicado al producto.
     */
    @Schema(description = "Porcentaje de descuento aplicado al producto", example = "25")
    private Integer discountPercentage;

    /**
     * Detalle de las cuotas o plazos de pago disponibles para el producto.
     */
    @Schema(description = "Detalle de cuotas o plazos de pago disponibles", example = "12x 75.00 USD")
    private String installments;

    /**
     * Indica si el producto cuenta con envío gratuito.
     */
    @Schema(description = "Indica si el producto tiene envío gratuito", example = "true")
    private Boolean freeShipping;
}
