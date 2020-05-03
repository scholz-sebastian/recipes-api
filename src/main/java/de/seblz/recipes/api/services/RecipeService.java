package de.seblz.recipes.api.services;

import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.db.repository.RecipesRepository;
import de.seblz.recipes.api.dto.request.CreateRecipeRequest;
import de.seblz.recipes.api.mapper.CreateRecipeRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipesRepository recipesRepository;
    private final CreateRecipeRequestMapper createRecipeRequestMapper;

    public RecipeEntity create(CreateRecipeRequest request) {
        RecipeEntity entity = createRecipeRequestMapper.map(request);
        entity.setRecipeId(UUID.randomUUID());
        recipesRepository.save(entity);
        return entity;
    }

    public RecipeEntity update(String recipeId, CreateRecipeRequest request) {
        RecipeEntity entity = createRecipeRequestMapper.map(request);
        entity.setRecipeId(UUID.fromString(recipeId));
        recipesRepository.save(entity);
        return entity;
    }

    public List<RecipeEntity> findAll() {
        return recipesRepository.findAll();
    }

    public RecipeEntity findById(String id) {
        return recipesRepository.findById(UUID.fromString(id)).orElseThrow(ResourceNotFoundException::new);
    }
}
