package org.launchcode.recipemanagementsoftware.data;

import org.launchcode.recipemanagementsoftware.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
