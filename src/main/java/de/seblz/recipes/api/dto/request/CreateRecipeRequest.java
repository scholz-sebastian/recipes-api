package de.seblz.recipes.api.dto.request;

import com.google.common.collect.Lists;
import de.seblz.recipes.api.dto.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class CreateRecipeRequest {

    private String title;
    private List<Ingredient> ingredients = Lists.newArrayList();
    private List<String> instructions = Lists.newArrayList();
}
