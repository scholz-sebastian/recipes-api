package de.seblz.recipes.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Ingredient {

    @Schema(example = "1.5")
    private double amount;

    @Schema(example = "tsp")
    private String unit;

    @Schema(example = "flour")
    private String ingredient;
}
