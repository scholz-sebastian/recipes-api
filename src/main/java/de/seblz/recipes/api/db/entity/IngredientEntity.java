package de.seblz.recipes.api.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document(collection = "IngredientEntity")
public class IngredientEntity {

    @Id
    private UUID ingredientId;

    private double amount;
    private String unit;
    private String value;

    public IngredientEntity() {
        this.ingredientId = UUID.randomUUID();
    }
}
