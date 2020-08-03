package com.kris.heroesclash.dtos;

import com.kris.heroesclash.entities.HeroClass;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class CreateHeroDto {

    private String name;

    private HeroClass heroClass;

}
