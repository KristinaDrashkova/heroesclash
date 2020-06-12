package com.kris.heroesclash.exceptions;

/**
 * @author kristina.drashkova
 */
public class NotEnoughQuantityException extends BaseHeroesClashException {
    public NotEnoughQuantityException(String message) {
        super(message);
    }

    public NotEnoughQuantityException(String message, Throwable cause) {
        super(message, cause);
    }
}
