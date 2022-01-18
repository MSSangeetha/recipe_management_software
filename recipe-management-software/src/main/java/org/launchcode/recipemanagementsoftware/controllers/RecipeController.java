package org.launchcode.recipemanagementsoftware.controllers;

import org.launchcode.recipemanagementsoftware.data.RecipeCategoryRepository;
import org.launchcode.recipemanagementsoftware.data.RecipeRepository;
import org.launchcode.recipemanagementsoftware.models.Recipe;
import org.launchcode.recipemanagementsoftware.models.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("recipe")

public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping
    public String displayAllRecipes(@RequestParam(required = false) Integer categoryId, Model model) {
        if(categoryId == null) {
            model.addAttribute("title", "All Recipes");
            model.addAttribute("recipes", recipeRepository.findAll());
        }
        else{
            Optional<RecipeCategory> result = recipeCategoryRepository.findById(categoryId);
            if(result.isEmpty()){
                model.addAttribute("title", "Invalid Recipe Id : " + categoryId);
            }else{
                RecipeCategory category = result.get();
                model.addAttribute("title", "Recipes in Category : " + category.getName());
                model.addAttribute("recipes", category.getRecipes());
            }
        }
        return "recipe/index";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model) {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "recipe/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "recipe/create";
        }

        recipeRepository.save(newRecipe);
        return "redirect:";
    }

//    @GetMapping("delete")
//    public String displayDeleteEventForm(Model model) {
//        model.addAttribute("title", "Delete Events");
//        model.addAttribute("events", eventRepository.findAll());
//        return "events/delete";
//    }
//
//    @PostMapping("delete")
//    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
//
//        if (eventIds != null) {
//            for (int id : eventIds) {
//                eventRepository.deleteById(id);
//            }
//        }
//
//        return "redirect:";
//    }

    @GetMapping("detail")
    public String displayRecipeDetails(@RequestParam Integer recipeId, Model model) {

        Optional<Recipe> result = recipeRepository.findById(recipeId);
        if(result.isEmpty()){
            model.addAttribute("title", "Invalid Recipe Id : " + recipeId);
        }else{
            Recipe recipe = result.get();
            model.addAttribute("title", recipe.getRecipeName());
            model.addAttribute("recipe", recipe);

//            model.addAttribute("tags",event.getTags());
        }

        return "recipe/detail";
    }



}
