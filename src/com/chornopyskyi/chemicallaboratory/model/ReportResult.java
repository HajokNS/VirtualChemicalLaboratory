package com.chornopyskyi.chemicallaboratory.model;

import java.util.Objects;

/**
 * Клас {@code ReportResult} представляє результат звіту із вказаною інформацією,
 * такою як ідентифікатор та результат.
 */
public class ReportResult {

    /**
     * Ідентифікатор результату звіту.
     */
    private String id;

    /**
     * Результат звіту.
     */
    private String result;

    /**
     * Конструктор для створення нового об'єкта ReportResult з вказаними параметрами.
     *
     * @param id     Ідентифікатор результату звіту.
     * @param result Результат звіту.
     */
    public ReportResult(String id, String result) {
        this.id = id;
        this.result = result;
    }

    /**
     * Отримує ідентифікатор результату звіту.
     *
     * @return Ідентифікатор результату звіту.
     */
    public String getId() {
        return id;
    }

    /**
     * Встановлює ідентифікатор для результату звіту.
     *
     * @param id Ідентифікатор результату звіту.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Отримує результат звіту.
     *
     * @return Результат звіту.
     */
    public String getResult() {
        return result;
    }

    /**
     * Встановлює результат для звіту.
     *
     * @param result Результат звіту.
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Порівнює об'єкт результату звіту з іншим об'єктом на рівність.
     *
     * @param o Інший об'єкт для порівняння.
     * @return {@code true}, якщо об'єкти рівні; {@code false} в іншому випадку.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReportResult that = (ReportResult) o;
        return Objects.equals(id, that.id);
    }

    /**
     * Генерує хеш-код об'єкта результату звіту.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Повертає рядкове представлення об'єкта результату звіту.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "ReportResult{" +
            "result='" + result + '\'' +
            ", id='" + id + '\'' +
            '}';
    }
}

