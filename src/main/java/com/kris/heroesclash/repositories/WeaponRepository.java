package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kristina.drashkova
 */
@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

    Weapon getById(Integer id);
}
