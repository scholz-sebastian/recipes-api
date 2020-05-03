package de.seblz.recipes.api.mapper;

import de.seblz.recipes.api.db.entity.IngredientEntity;
import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.dto.request.CreateRecipeRequest;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CreateRecipeRequestMapper {

    public RecipeEntity map(CreateRecipeRequest request) {
        RecipeEntity entity = new RecipeEntity();

        entity.setTitle(request.getTitle());
        entity.setInstructions(request.getInstructions());
        entity.setIngredients(request.getIngredients().stream().map(ingredient -> {
            IngredientEntity ingredientEntity = new IngredientEntity();
            ingredientEntity.setAmount(ingredient.getAmount());
            ingredientEntity.setUnit(ingredient.getUnit());
            ingredientEntity.setValue(ingredient.getIngredient());
            return ingredientEntity;
        }).collect(Collectors.toList()));
        return entity;
    }
}
