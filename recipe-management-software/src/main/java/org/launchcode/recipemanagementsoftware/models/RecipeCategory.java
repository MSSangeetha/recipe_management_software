package org.launchcode.recipemanagementsoftware.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class RecipeCategory extends AbstractEntity{

    @OneToMany(mappedBy = "recipeCategory")
    private final List<Recipe> recipes = new ArrayList<>();

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    //Constructor
    public RecipeCategory(@Size(min = 3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }
    //Empty constructor for the entity class
        public RecipeCategory() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
    @Override
    public String toString() {
        return name;
    }
}
