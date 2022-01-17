package org.launchcode.recipemanagementsoftware.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class RecipeDetails extends AbstractEntity{
    @NotBlank(message = "Instruction is required")
    @Size(max = 1500000, message = "Description too long!")
    private String description;


    public RecipeDetails(String description) {
        this.description = description;

    }
    public RecipeDetails() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
