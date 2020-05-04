package com.kris.heroesclash.services;

import com.kris.heroesclash.entities.Weapon;
import com.kris.heroesclash.entities.WeaponType;
import com.kris.heroesclash.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kristina.drashkova
 */
@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    public Weapon createWeapon(String name, WeaponType weaponType, Integer damage) {
        return weaponRepository.save(new Weapon(name, weaponType, damage));
    }
}
