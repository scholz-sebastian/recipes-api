package de.seblz.recipes.api.db.repository;

import de.seblz.recipes.api.db.entity.RecipeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipesRepository extends MongoRepository<RecipeEntity, UUID> {
}
