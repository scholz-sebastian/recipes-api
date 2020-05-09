package de.seblz.recipes.api.mapper;

import de.seblz.recipes.api.db.entity.IngredientEntity;
import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.dto.Ingredient;
import de.seblz.recipes.api.dto.request.Recipe;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    public RecipeEntity mapRecipe(Recipe request) {
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

    public Recipe mapEntity(RecipeEntity entity) {
        Recipe recipe = new Recipe();

        recipe.setTitle(entity.getTitle());
        recipe.setInstructions(entity.getInstructions());
        if(entity.getIngredients() != null) {
            recipe.setIngredients(entity.getIngredients().stream().map(ingredientEntity -> {
                Ingredient ingredient = new Ingredient();
                ingredient.setAmount(ingredientEntity.getAmount());
                ingredient.setUnit(ingredientEntity.getUnit());
                ingredient.setIngredient(ingredientEntity.getValue());
                return ingredient;
            }).collect(Collectors.toList()));
        }
        return recipe;
    }
}
