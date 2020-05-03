package de.seblz.recipes.api.services;

import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.db.repository.RecipesRepository;
import de.seblz.recipes.api.dto.request.CreateRecipeRequest;
import de.seblz.recipes.api.mapper.CreateRecipeRequestMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    private static final UUID MOCKED_UUID = UUID.fromString("46532b02-d5b4-4055-b88d-7516c9cf5e40");
    @InjectMocks
    private RecipeService service;

    @Mock
    private RecipesRepository recipesRepository;
    @Mock
    private CreateRecipeRequestMapper createRecipeRequestMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSave() {
        CreateRecipeRequest request = new CreateRecipeRequest();
        RecipeEntity entity = new RecipeEntity();
        entity.setRecipeId(MOCKED_UUID);
        when(createRecipeRequestMapper.map(request)).thenReturn(entity);

        String result = service.create(request);

        verify(recipesRepository, times(1)).save(entity);
        assertEquals(MOCKED_UUID.toString(), result);
    }

    @Test
    void testFindAll() {
        service.findAll();

        verify(recipesRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(recipesRepository.findById(MOCKED_UUID)).thenReturn(Optional.of(new RecipeEntity()));

        service.findById(MOCKED_UUID.toString());

        verify(recipesRepository, times(1)).findById(MOCKED_UUID);
    }

    @Test
    void testFindById_NothingFround() {
        when(recipesRepository.findById(MOCKED_UUID)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
            ()-> service.findById(MOCKED_UUID.toString()));
        verify(recipesRepository, times(1)).findById(MOCKED_UUID);
    }

}