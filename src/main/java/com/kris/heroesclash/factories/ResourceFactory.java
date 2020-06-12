package com.kris.heroesclash.factories;

import com.kris.heroesclash.entities.Iron;
import com.kris.heroesclash.entities.Leather;
import com.kris.heroesclash.entities.Resource;
import com.kris.heroesclash.entities.ResourceType;
import com.kris.heroesclash.entities.Wood;

/**
 * @author kristina.drashkova
 */
public class ResourceFactory {
    public static Resource getResource(ResourceType resourceType, Integer quantity) {
        switch (resourceType) {
            case IRON:
                return new Iron(quantity);
            case WOOD:
                return new Wood(quantity);
            case LEATHER:
                return new Leather(quantity);
        }
        return null;
    }
}
