package de.seblz.recipes.api.controller;

import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.dto.request.CreateRecipeRequest;
import de.seblz.recipes.api.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipesController {

    private final RecipeService recipeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createRecipe(@RequestBody CreateRecipeRequest request) {
        return recipeService.save(request);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecipeEntity> getAll() {
        return recipeService.getAll();
    }
}
