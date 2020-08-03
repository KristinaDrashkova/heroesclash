package com.kris.heroesclash.services;

import com.kris.heroesclash.entities.Armor;
import com.kris.heroesclash.repositories.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kristina.drashkova
 */
@Service
public class ArmorService {

    @Autowired
    private ArmorRepository armorRepository;

    public Armor createArmor(String name, Integer defense) {
        return armorRepository.save(new Armor(name, defense));
    }
}
