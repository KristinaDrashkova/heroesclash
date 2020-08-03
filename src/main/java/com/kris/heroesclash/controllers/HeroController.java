package com.kris.heroesclash.controllers;

import com.kris.heroesclash.dtos.CreateHeroDto;
import com.kris.heroesclash.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;
    
    @PostMapping(value="/create")
    public void createHero(@RequestBody CreateHeroDto createHeroDto) {
        heroService.createHero(createHeroDto.getName(), createHeroDto.getHeroClass());
    }
    
}
