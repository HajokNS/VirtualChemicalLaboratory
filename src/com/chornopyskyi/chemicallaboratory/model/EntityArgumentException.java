package com.chornopyskyi.chemicallaboratory.model;

import java.util.List;

/**
 * Клас {@code EntityArgumentException} представляє виняток, який виникає при некоректних аргументах
 * при створенні об'єктів сутностей (entity) в лабораторії.
 * Розширює клас IllegalArgumentException.
 */
    public class EntityArgumentException extends IllegalArgumentException {

    /**
     * Список помилок, які виникли при некоректних аргументах для створення сутності.
     */
    private final List<String> errors;

    /**
     * Конструктор, що приймає список помилок як аргумент та ініціалізує виняток.
     *
     * @param errors Список помилок.
     */
    public EntityArgumentException(List<String> errors) {
        this.errors = errors;
    }

    /**
     * Отримує список помилок, які виникли при некоректних аргументах для створення сутності.
     *
     * @return Список помилок.
     */
    public List<String> getErrors() {
        return errors;
    }
}
