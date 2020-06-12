package com.kris.heroesclash.exceptions;

/**
 * @author kristina.drashkova
 */
public class BaseHeroesClashException extends RuntimeException {
    public BaseHeroesClashException(String message) {
        super(message);
    }

    public BaseHeroesClashException(String message, Throwable cause) {
        super(message, cause);
    }
}
