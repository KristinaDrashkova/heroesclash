package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface ArmorRepository extends JpaRepository<Armor, Integer> {

    Armor getById(Integer id);
}
