package com.kris.heroesclash.repositories;

import com.kris.heroesclash.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kristina.drashkova
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    Resource getById(Integer id);
}
