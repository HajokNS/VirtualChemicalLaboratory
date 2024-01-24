package com.chornopyskyi.chemicallaboratory.persistence.entity;

public enum ErrorTemplates {
    REQUIRED("Поле %s є обов'язковим до заповнення."),
    MIN_LENGTH("Поле %s не може бути меншим за %d симв."),
    MAX_LENGTH("Поле %s не може бути більшим за %d симв."),
    ONLY_LATIN("Поле %s лише латинські символи та символ _."),
    PASSWORD("Поле %s латинські миволи, хочаб одна буква з великої, одна з малої та хочаб одна цифра."),
    EMAIL_CONTAINS("Поле %s має містити @ та одну крапку."),
    EMAIL_MATCHES("Поле %s не відповідає стандартному формату електронної пошти.");

    private String template;

    ErrorTemplates(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
