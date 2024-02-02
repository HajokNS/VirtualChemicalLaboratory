package com.chornopyskyi.chemicallaboratory.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактний клас {@code EntityErrors} представляє базовий клас для обробки помилок у сутностях (entities)
 * у лабораторії. Кожна конкретна сутність може розширити цей клас для обробки конкретних помилок.
 */
public abstract class EntityErrors {

    /**
     * Список помилок, що виникли при валідації сутності.
     */
    protected List<String> errors;

    /**
     * Прапорець, який вказує, чи є сутність валідною (без помилок).
     */
    protected boolean isValid;

    /**
     * Конструктор, який ініціалізує пустий список помилок при створенні об'єкта.
     */
    protected EntityErrors() {
        errors = new ArrayList<>();
    }

    /**
     * Перевіряє, чи є сутність валідною (без помилок).
     *
     * @return {@code true}, якщо сутність валідна; {@code false}, якщо є помилки.
     */
    public boolean isValid() {
        return errors.isEmpty();
    }

    /**
     * Отримує список помилок, що виникли при валідації сутності.
     *
     * @return Список помилок.
     */
    public List<String> getErrors() {
        return errors;
    }
}

