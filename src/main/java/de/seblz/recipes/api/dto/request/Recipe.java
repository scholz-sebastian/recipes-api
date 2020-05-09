package de.seblz.recipes.api.dto.request;

import com.google.common.collect.Lists;
import de.seblz.recipes.api.dto.Ingredient;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class Recipe {

    @Schema(example = "Cheesecake")
    private String title;
    private List<Ingredient> ingredients = Lists.newArrayList();
    @Schema(example = "")
    private List<String> instructions = Lists.newArrayList();
}
