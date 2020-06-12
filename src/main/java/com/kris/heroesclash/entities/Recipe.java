package com.kris.heroesclash.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author kristina.drashkova
 */
@Entity
@Slf4j
@Getter
@Setter
@ToString
@Table(name = "recipes")
public class Recipe extends Item {

    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "recipe_resource",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<Resource> resourcesNeeded;

    private Boolean readyToCombine;

    private RecipeType type;

    public Recipe(String name, List<Resource> resourcesNeeded, RecipeType type) {
        this.name = name;
        this.resourcesNeeded = resourcesNeeded;
        this.type = type;
    }
}
