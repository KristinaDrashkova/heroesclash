package com.kris.heroesclash.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

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
@Table(name = "weapons")
public class Weapon extends Item {

    private String name;

    private WeaponType weaponType;

    private Integer damage;

    public Weapon(String name, WeaponType weaponType, Integer damage) {
        this.name = name;
        this.weaponType = weaponType;
        this.damage = damage;
    }
}
