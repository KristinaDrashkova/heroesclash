package com.kris.heroesclash.services;

import com.kris.heroesclash.entities.Hero;
import com.kris.heroesclash.entities.HeroClass;
import com.kris.heroesclash.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kristina.drashkova
 */
@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Hero createHero(String name, HeroClass heroClass) {
        Hero hero = new Hero(name, heroClass);
        hero.setDexterity(5);
        hero.setStrength(5);
        hero.setWisdom(5);
        hero.updateCharacterSpecificStats(5);
        return heroRepository.save(hero);
    }

    public Hero levelUp(Integer heroId) {
        Hero hero = heroRepository.getById(heroId);
        hero.setLevel(hero.getLevel() + 1);
        hero = updateBaseStats(hero);
        return heroRepository.save(hero);
    }

    private Hero updateBaseStats(Hero hero) {
        hero.updateDexterity(5);
        hero.updateStrength(5);
        hero.updateWisdom(5);
        hero.updateCharacterSpecificStats(5);

        return hero;
    }

    public Integer getEvasionPercentage(Integer heroId) {
        Hero hero = heroRepository.getById(heroId);
        Integer dexterity = hero.getDexterity();

        return dexterity / 5;
    }

    public Integer getSpellBlockPercentage(Integer heroId) {
        Hero hero = heroRepository.getById(heroId);
        Integer wisdom = hero.getWisdom();

        return wisdom / 5;
    }

    public Integer getLife(Integer heroId) {
        Hero hero = heroRepository.getById(heroId);
        Integer strength = hero.getStrength();

        return strength * 50;
    }

    public Integer getDamage(Integer heroId) {
        Hero hero = heroRepository.getById(heroId);
        Integer damage = 0;
        switch (hero.getHeroClass()) {
            case ARCHER:
                damage += hero.getDexterity() * 10;
            case WARRIOR:
                damage += hero.getStrength() * 10;
            case WIZARD:
                damage += hero.getWisdom() * 10;
        }

        return damage + hero.getWeapon().getDamage();
    }

}
