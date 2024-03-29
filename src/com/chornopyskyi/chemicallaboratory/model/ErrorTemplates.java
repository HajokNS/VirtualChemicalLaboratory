package com.chornopyskyi.chemicallaboratory.model;

/**
 * Перерахування {@code ErrorTemplates} містить шаблони помилок для валідації полів.
 * Кожен елемент перерахування містить шаблон та надає метод для отримання цього шаблону.
 */
public enum ErrorTemplates {

    /**
     * Поле %s є обов'язковим до заповнення.
     */
    REQUIRED("Поле %s є обов'язковим до заповнення."),

    /**
     * Поле %s не може бути меншим за %d симв.
     */
    MIN_LENGTH("Поле %s не може бути меншим за %d симв."),

    /**
     * Поле %s не може бути більшим за %d симв.
     */
    MAX_LENGTH("Поле %s не може бути більшим за %d симв."),

    /**
     * Поле %s лише латинські символи та символ _.
     */
    ONLY_LATIN("Поле %s лише латинські символи та символ _."),

    /**
     * Поле %s латинські символи, хочаб одна буква з великої,
     * одна з малої та хочаб одна цифра.
     */
    PASSWORD("Поле %s латинські символи, хочаб одна буква з великої, одна з малої та хочаб одна цифра."),

    /**
     * Поле %s має містити @ та одну крапку.
     */
    EMAIL_CONTAINS("Поле %s має містити @ та одну крапку."),

    /**
     * Поле %s не відповідає стандартному формату електронної пошти.
     */
    EMAIL_MATCHES("Поле %s не відповідає стандартному формату електронної пошти.");

    /**
     * Шаблон помилки.
     */
    private String template;

    /**
     * Конструктор, який ініціалізує шаблон помилки.
     *
     * @param template Шаблон помилки.
     */
    ErrorTemplates(String template) {
        this.template = template;
    }

    /**
     * Отримує шаблон помилки.
     *
     * @return Шаблон помилки.
     */
    public String getTemplate() {
        return template;
    }
}

