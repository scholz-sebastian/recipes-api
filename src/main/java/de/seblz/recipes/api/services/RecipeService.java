package de.seblz.recipes.api.services;

import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.db.repository.RecipesRepository;
import de.seblz.recipes.api.dto.request.CreateRecipeRequest;
import de.seblz.recipes.api.mapper.CreateRecipeRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipesRepository recipesRepository;
    private final CreateRecipeRequestMapper createRecipeRequestMapper;

    public String save(CreateRecipeRequest request) {
        RecipeEntity entity = createRecipeRequestMapper.map(request);
        recipesRepository.save(entity);
        return entity.getRecipeId().toString();
    }

    public List<RecipeEntity> getAll() {
        return recipesRepository.findAll();
    }
}
