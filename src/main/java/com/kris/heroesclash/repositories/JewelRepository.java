package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface JewelRepository extends JpaRepository<Jewel, Integer> {

    Jewel getById(Integer id);
}
