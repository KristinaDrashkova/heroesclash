package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

    Recipe getById(Integer id);
}
