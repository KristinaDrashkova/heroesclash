package com.kris.heroesclash.services;

import com.kris.heroesclash.entities.Item;
import com.kris.heroesclash.entities.Recipe;
import com.kris.heroesclash.entities.RecipeType;
import com.kris.heroesclash.entities.Resource;
import com.kris.heroesclash.repositories.RecipeRepository;
import com.kris.heroesclash.utils.InventoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author kristina.drashkova
 */
@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe createRecipe(String name, Set<Resource> resourcesNeeded, RecipeType type) {
        return recipeRepository.save(new Recipe(name, resourcesNeeded, type));
    }

    public void combineRecipe(Recipe recipe, Set<Item> inventory) {
        for (Resource resource : recipe.getResourcesNeeded()) {
            Resource neededResourceInInventory = InventoryUtil.getNeededItem(resource.getClass(), inventory);
            
        }
    }

}
