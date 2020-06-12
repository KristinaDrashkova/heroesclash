package com.kris.heroesclash.services;

import com.kris.heroesclash.entities.Armor;
import com.kris.heroesclash.entities.Recipe;
import com.kris.heroesclash.entities.Resource;
import com.kris.heroesclash.entities.Weapon;
import com.kris.heroesclash.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Resource> getInventoryResources(Integer id) {
        return inventoryRepository.getById(id).getResources();
    }

    public List<Recipe> getInventoryRecipes(Integer id) {
        return inventoryRepository.getById(id).getRecipes();
    }

    public List<Armor> getInventoryArmors(Integer id) {
        return inventoryRepository.getById(id).getArmors();
    }

    public List<Weapon> getInventoryWeapons(Integer id) {
        return inventoryRepository.getById(id).getWeapons();
    }


}
