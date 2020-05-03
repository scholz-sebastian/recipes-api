package de.seblz.recipes.api.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Data
public class RecipeEntity {
    @Id
    private UUID recipeId;

    private List<IngredientEntity> ingredients;

    private String title;

    private List<String> instructions;

    public RecipeEntity() {
        this.recipeId = UUID.randomUUID();
    }

}
