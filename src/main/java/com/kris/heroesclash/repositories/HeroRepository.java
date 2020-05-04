package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer>{
    Hero getById(Integer id);
}
