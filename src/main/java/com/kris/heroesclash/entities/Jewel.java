package com.kris.heroesclash.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

/**
 * @author kristina.drashkova
 */
@Entity
@Slf4j
@Getter
@Setter
@ToString
@Table(name = "jewels")
public class Jewel extends Item {

    private String name;

    @ElementCollection
    private Map<String, Integer> bonuses;

    public Jewel(String name, Map<String, Integer> bonuses) {
        this.name = name;
        this.bonuses = bonuses;
    }
}
