package com.kris.heroesclash.services;

import com.kris.heroesclash.entities.Resource;
import com.kris.heroesclash.entities.ResourceType;
import com.kris.heroesclash.factories.ResourceFactory;
import com.kris.heroesclash.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author kristina.drashkova
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource createResource(ResourceType type, Integer quantity) {
        return resourceRepository.save(Objects.requireNonNull(ResourceFactory.getResource(type, quantity)));
    }
}
