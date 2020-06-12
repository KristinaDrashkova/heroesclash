package com.kris.heroesclash.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author kristina.drashkova
 */
@Entity
@Slf4j
@Getter
@Setter
@ToString
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private HeroClass heroClass;

    private Integer level;

    private Integer wisdom;

    private Integer strength;

    private Integer dexterity;

    @ManyToOne
    @JoinColumn(name = "armor_id", nullable = false)
    private Armor armor;

    @ManyToOne
    @JoinColumn(name = "weapon_id", nullable = false)
    private Weapon weapon;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Hero(String name, HeroClass heroClass) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = 1;
        this.inventory = new Inventory();
    }

    public void updateDexterity(Integer updater) {
        this.setDexterity(this.getDexterity() + updater);
    }

    public void updateStrength(Integer updater) {
        this.setStrength(this.getStrength() + updater);
    }

    public void updateWisdom(Integer updater) {
        this.setWisdom(this.getWisdom() + updater);
    }

    public void updateCharacterSpecificStats(Integer updater) {
        switch (this.heroClass) {
            case ARCHER:
                updateDexterity(updater);
            case WARRIOR:
                updateStrength(updater);
            case WIZARD:
                updateWisdom(updater);

        }
    }
}
