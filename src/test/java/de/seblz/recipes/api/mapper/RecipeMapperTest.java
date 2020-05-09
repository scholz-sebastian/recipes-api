package de.seblz.recipes.api.mapper;

import de.seblz.recipes.api.db.entity.IngredientEntity;
import de.seblz.recipes.api.db.entity.RecipeEntity;
import de.seblz.recipes.api.dto.Ingredient;
import de.seblz.recipes.api.dto.request.Recipe;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeMapperTest {

    private static final String TITLE = "TITLE";
    private static final String INSTRUCTION_ONE = "instruction_one";
    private static final String INSTRUCTION_TWO = "instruction_two";
    private static final double INGREDIENT_ONE_AMOUNT = 1.5;
    private static final String INGREDIENT_ONE__UNIT = "TL";
    private static final String INGREDIENT_ONE_VALUE = "Salz";
    private static final double INGREDIENT_TWO_AMOUNT = 5;
    private static final String INGREDIENT_TWO_UNIT = "EL";
    private static final String INGREDIENT_TWO_VALUE = "Pfeffer";

    private final RecipeMapper mapper = new RecipeMapper();

    @Test
    void entity_shouldMapTitle() {
        Recipe request = new Recipe();
        request.setTitle(TITLE);

        RecipeEntity result = mapper.mapRecipe(request);

        assertEquals(TITLE, result.getTitle());
    }

    @Test
    void entity_shouldMapInstructions() {
        Recipe request = new Recipe();
        request.setInstructions(Lists.newArrayList(INSTRUCTION_ONE, INSTRUCTION_TWO));

        RecipeEntity result = mapper.mapRecipe(request);

        assertEquals(2, result.getInstructions().size());
        assertEquals(INSTRUCTION_ONE, result.getInstructions().get(0));
        assertEquals(INSTRUCTION_TWO, result.getInstructions().get(1));
    }

    @Test
    void entity_shouldMapIngredients() {
        Recipe request = new Recipe();
        Ingredient ingredientOne = new Ingredient();
        ingredientOne.setAmount(INGREDIENT_ONE_AMOUNT);
        ingredientOne.setUnit(INGREDIENT_ONE__UNIT);
        ingredientOne.setIngredient(INGREDIENT_ONE_VALUE);

        Ingredient ingredientTwo = new Ingredient();
        ingredientTwo.setAmount(INGREDIENT_TWO_AMOUNT);
        ingredientTwo.setUnit(INGREDIENT_TWO_UNIT);
        ingredientTwo.setIngredient(INGREDIENT_TWO_VALUE);
        request.setIngredients(Lists.newArrayList(ingredientOne, ingredientTwo));

        RecipeEntity result = mapper.mapRecipe(request);

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

    @Test
    void recipe_shouldMapTitle() {
        RecipeEntity entity = new RecipeEntity();
        entity.setTitle(TITLE);

        Recipe result = mapper.mapEntity(entity);

        assertEquals(TITLE, result.getTitle());
    }

    @Test
    void recipe_shouldMapInstructions() {
        RecipeEntity entity = new RecipeEntity();
        entity.setInstructions(Lists.newArrayList(INSTRUCTION_ONE, INSTRUCTION_TWO));

        Recipe result = mapper.mapEntity(entity);

        assertEquals(2, result.getInstructions().size());
        assertEquals(INSTRUCTION_ONE, result.getInstructions().get(0));
        assertEquals(INSTRUCTION_TWO, result.getInstructions().get(1));
    }

    @Test
    void recipe_shouldMapIngredients() {
        RecipeEntity entity = new RecipeEntity();
        IngredientEntity ingredientOne = new IngredientEntity();
        ingredientOne.setAmount(INGREDIENT_ONE_AMOUNT);
        ingredientOne.setUnit(INGREDIENT_ONE__UNIT);
        ingredientOne.setValue(INGREDIENT_ONE_VALUE);

        IngredientEntity ingredientTwo = new IngredientEntity();
        ingredientTwo.setAmount(INGREDIENT_TWO_AMOUNT);
        ingredientTwo.setUnit(INGREDIENT_TWO_UNIT);
        ingredientTwo.setValue(INGREDIENT_TWO_VALUE);
        entity.setIngredients(Lists.newArrayList(ingredientOne, ingredientTwo));

        Recipe result = mapper.mapEntity(entity);

        assertEquals(2, result.getIngredients().size());

        Ingredient first = result.getIngredients().get(0);
        assertEquals(INGREDIENT_ONE__UNIT, first.getUnit());
        assertEquals(INGREDIENT_ONE_VALUE, first.getIngredient());
        assertEquals(INGREDIENT_ONE_AMOUNT, first.getAmount());

        Ingredient second = result.getIngredients().get(1);
        assertEquals(INGREDIENT_TWO_UNIT, second.getUnit());
        assertEquals(INGREDIENT_TWO_VALUE, second.getIngredient());
        assertEquals(INGREDIENT_TWO_AMOUNT, second.getAmount());
    }

}