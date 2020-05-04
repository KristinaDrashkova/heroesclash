package com.kris.heroesclash.services;

import com.kris.heroesclash.entities.Jewel;
import com.kris.heroesclash.repositories.JewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author kristina.drashkova
 */
@Service
public class JewelService {

    @Autowired
    private JewelRepository jewelRepository;

    public Jewel createJewel(String name, Map<String, Integer> bonuses) {
        return jewelRepository.save(new Jewel(name, bonuses));
    }
}
