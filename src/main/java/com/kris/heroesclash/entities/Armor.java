package com.kris.heroesclash.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author kristina.drashkova
 */
@Entity
@Slf4j
@Getter
@Setter
@ToString
@Table(name = "armors")
public class Armor extends Item {

    @Column(unique = true)
    private String name;

    private Integer defense;

    public Armor(String name, Integer defense) {
        this.name = name;
        this.defense = defense;
    }
}
