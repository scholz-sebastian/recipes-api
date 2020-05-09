package de.seblz.recipes.api.controller;

import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.dto.request.Recipe;
import de.seblz.recipes.api.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipesController {

    private final RecipeService recipeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecipeEntity> createRecipe(@RequestBody Recipe request) {
        RecipeEntity entity = recipeService.create(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(entity);
    }

    //FIXME ApplicationConfig (cors e.g. -allowed methods et al)
    @PutMapping(path = "{recipeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecipeEntity> updateRecipe(@PathVariable String recipeId, @RequestBody Recipe request) {
        RecipeEntity entity = recipeService.update(recipeId, request);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(path = "{recipeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity.HeadersBuilder<?> deleteRecipe(@PathVariable String recipeId) {
        recipeService.delete(recipeId);
        return ResponseEntity.noContent();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecipeEntity> getAll() {
        return recipeService.findAll();
    }

    @GetMapping(path = "{recipeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeEntity getById(@PathVariable String recipeId) {
        return recipeService.findById(recipeId);
    }
}
