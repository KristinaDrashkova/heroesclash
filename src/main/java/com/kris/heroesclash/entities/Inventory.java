package com.kris.heroesclash.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Entity
@Slf4j
@Getter
@Setter
@ToString
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "inventory_resource",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<Resource> resources;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "inventory_recipe",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipes;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "inventory_armor",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "armor_id")
    )
    private List<Armor> armors;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "inventory_weapon",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id")
    )
    private List<Weapon> weapons;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "inventory_jewel",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "jewel_id"))
    private List<Jewel> jewels;

    public Inventory() {
        this.resources = new ArrayList<>();
        this.recipes = new ArrayList<>();
        this.armors = new ArrayList<>();
        this.weapons = new ArrayList<>();
    }
}
