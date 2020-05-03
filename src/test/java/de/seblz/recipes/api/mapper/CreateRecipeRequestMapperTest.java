package de.seblz.recipes.api.mapper;

import de.seblz.recipes.api.db.entity.IngredientEntity;
import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.dto.Ingredient;
import de.seblz.recipes.api.dto.request.CreateRecipeRequest;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateRecipeRequestMapperTest {

    private static final String TITLE = "TITLE";
    private static final String INSTRUCTION_ONE = "instruction_one";
    private static final String INSTRUCTION_TWO = "instruction_two";
    private static final double INGREDIENT_ONE_AMOUNT = 1.5;
    private static final String INGREDIENT_ONE__UNIT = "TL";
    private static final String INGREDIENT_ONE_VALUE = "Salz";
    private static final double INGREDIENT_TWO_AMOUNT = 5;
    private static final String INGREDIENT_TWO_UNIT = "EL";
    private static final String INGREDIENT_TWO_VALUE = "Pfeffer";

    private CreateRecipeRequestMapper mapper = new CreateRecipeRequestMapper();

    @Test
    void shouldMapTitle() {
        CreateRecipeRequest request = new CreateRecipeRequest();
        request.setTitle(TITLE);

        RecipeEntity result = mapper.map(request);

        assertEquals(TITLE, result.getTitle());
    }

    @Test
    void shouldMapInstructions() {
        CreateRecipeRequest request = new CreateRecipeRequest();
        request.setInstructions(Lists.newArrayList(INSTRUCTION_ONE, INSTRUCTION_TWO));

        RecipeEntity result = mapper.map(request);

        assertEquals(2, result.getInstructions().size());
        assertEquals(INSTRUCTION_ONE, result.getInstructions().get(0));
        assertEquals(INSTRUCTION_TWO, result.getInstructions().get(1));
    }

    @Test
    void shouldMapIngredients() {
        CreateRecipeRequest request = new CreateRecipeRequest();
        Ingredient ingredientOne = new Ingredient();
        ingredientOne.setAmount(INGREDIENT_ONE_AMOUNT);
        ingredientOne.setUnit(INGREDIENT_ONE__UNIT);
        ingredientOne.setIngredient(INGREDIENT_ONE_VALUE);

        Ingredient ingredientTwo = new Ingredient();
        ingredientTwo.setAmount(INGREDIENT_TWO_AMOUNT);
        ingredientTwo.setUnit(INGREDIENT_TWO_UNIT);
        ingredientTwo.setIngredient(INGREDIENT_TWO_VALUE);
        request.setIngredients(Lists.newArrayList(ingredientOne, ingredientTwo));

        RecipeEntity result = mapper.map(request);

        assertEquals(2, result.getIngredients().size());

        IngredientEntity first = result.getIngredients().get(0);
        assertEquals(INGREDIENT_ONE__UNIT, first.getUnit());
        assertEquals(INGREDIENT_ONE_VALUE, first.getValue());
        assertEquals(INGREDIENT_ONE_AMOUNT, first.getAmount());

        IngredientEntity second = result.getIngredients().get(1);
        assertEquals(INGREDIENT_TWO_UNIT, second.getUnit());
        assertEquals(INGREDIENT_TWO_VALUE, second.getValue());
        assertEquals(INGREDIENT_TWO_AMOUNT, second.getAmount());
    }

}