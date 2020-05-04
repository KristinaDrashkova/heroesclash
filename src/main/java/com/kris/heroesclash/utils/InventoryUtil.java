package com.kris.heroesclash.utils;

import com.kris.heroesclash.entities.Item;

import java.util.Set;

/**
 * @author kristina.drashkova
 */
public class InventoryUtil {
    public static <T extends Item> T getNeededItem(Class neededClass, Set<Item> inventory) {
        return (T) inventory.stream().filter(i -> i.getClass().equals(neededClass)).findFirst().orElse(null);
    }
}
