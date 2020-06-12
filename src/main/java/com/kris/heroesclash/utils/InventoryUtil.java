package com.kris.heroesclash.utils;

import com.kris.heroesclash.entities.Armor;
import com.kris.heroesclash.entities.Inventory;
import com.kris.heroesclash.entities.Item;
import com.kris.heroesclash.entities.Jewel;
import com.kris.heroesclash.entities.Recipe;
import com.kris.heroesclash.entities.Resource;
import com.kris.heroesclash.entities.Weapon;
import com.kris.heroesclash.services.InventoryService;
import com.kris.heroesclash.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kristina.drashkova
 */
public class InventoryUtil {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private InventoryService inventoryService;

    public Integer getResourceQuantityInInventory(Inventory inventory, Class resourceClass) {
        List<Resource> resources = inventory.getResources();
        for (Resource resource : resources) {
            if (resource.getClass().equals(resourceClass)) {
                return resource.getQuantity();
            }
        }
        return null;
    }

    public Inventory addItemToInventory(Inventory inventory, Item item) {
        switch (item.getClass().getSimpleName()) {
            case "Wood":
            case "Iron":
            case "Leather": {
                Resource resource = (Resource) item;
                Resource resourceFromInventory = inventory.getResources().stream().filter(r -> r.getClass().equals(resource.getClass())).findAny().orElse(null);
                if (resourceFromInventory == null) {
                    inventory.getResources().add(resource);
                } else {
                    resourceService.increaseResourceQuantity(resourceFromInventory, resource.getQuantity());
                }
            }
            break;
            case "Recipe": {
                Recipe recipe = (Recipe) item;
                if (inventory.getRecipes().stream().noneMatch(r -> r.getName().equals(recipe.getName()))) {
                    inventory.getRecipes().add(recipe);
                }
            }
            break;

            case "Armor": {
                Armor armor = (Armor) item;
                if (inventory.getArmors().stream().noneMatch(a -> a.getName().equals(armor.getName()))) {
                    inventory.getArmors().add(armor);
                }
            }
            break;
            case "Weapon": {
                Weapon weapon = (Weapon) item;
                if (inventory.getWeapons().stream().noneMatch(w -> w.getName().equals(weapon.getName()))) {
                    inventory.getWeapons().add(weapon);
                }
            }
            case "Jewel": {
                Jewel jewel = (Jewel) item;
                if (inventory.getJewels().stream().noneMatch(j -> j.getName().equals(jewel.getName()))) {
                    inventory.getJewels().add(jewel);
                }
            }
        }

        inventory = checkRecipesInInventory(inventory);

        return inventory;
    }

    private Inventory checkRecipesInInventory(Inventory inventory) {
        for (Recipe recipe : inventory.getRecipes()) {
            List<Resource> resources = recipe.getResourcesNeeded();
            boolean canBeCombined = true;
            for (Resource resource : resources) {
                if (getResourceQuantityInInventory(inventory, resource.getClass()) < resource.getQuantity()) {
                    canBeCombined = false;
                }
            }
            if (canBeCombined) {
                recipe.setReadyToCombine(true);
            }
        }

        return inventory;
    }
}
