package com.kris.heroesclash.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

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

    @Column(unique = true)
    private String name;

    private HeroClass heroClass;

    private Integer level;

    private Integer wisdom;

    private Integer strength;

    private Integer dexterity;

    @ManyToOne
    @JoinColumn(name = "armor_id")
    private Armor armor;

    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Hero(String name, HeroClass heroClass) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = 1;
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
