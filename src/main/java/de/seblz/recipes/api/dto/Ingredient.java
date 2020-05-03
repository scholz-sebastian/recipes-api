package de.seblz.recipes.api.dto;

import lombok.Data;

@Data
public class Ingredient {

    private double amount;
    private String unit;
    private String value;
}
