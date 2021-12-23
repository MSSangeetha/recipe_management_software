package org.launchcode.recipemanagementsoftware.data;

import org.launchcode.recipemanagementsoftware.models.Recipe;
import org.launchcode.recipemanagementsoftware.models.RecipeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
}
