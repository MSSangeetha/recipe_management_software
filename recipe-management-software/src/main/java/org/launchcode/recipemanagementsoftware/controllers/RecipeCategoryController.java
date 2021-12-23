package org.launchcode.recipemanagementsoftware.controllers;

import org.launchcode.recipemanagementsoftware.data.RecipeCategoryRepository;
import org.launchcode.recipemanagementsoftware.models.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("recipeCategories")
public class RecipeCategoryController {
    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;


    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "recipeCategory/index";
    }


    @GetMapping("create")
    public String renderCreateRecipeCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new RecipeCategory());
        model.addAttribute("types", recipeCategoryRepository.findAll());
        return "recipeCategory/create";
    }

    @PostMapping("create")
    public String processCreateRecipeCategoryForm(@Valid @ModelAttribute RecipeCategory recipeCategory, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            model.addAttribute(new RecipeCategory());
            return "recipeCategory/create";
        }

        recipeCategoryRepository.save(recipeCategory);
        return "redirect:";
    }
}
