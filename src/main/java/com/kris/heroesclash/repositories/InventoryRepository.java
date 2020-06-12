package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Inventory getById(Integer id);
}
