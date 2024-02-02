package com.chornopyskyi.chemicallaboratory.model;

import java.util.Objects;

/**
 * Клас {@code Experiment} представляє експеримент із вказаною інформацією, такою як ідентифікатор,
 * назва, тема та мета експерименту.
 */
public class Experiment implements Comparable<Experiment> {

    /**
     * Унікальний ідентифікатор для експерименту.
     */
    private long idExperiment;

    /**
     * Назва експерименту.
     */
    private String name;

    /**
     * Тема експерименту.
     */
    private String theme;

    /**
     * Мета експерименту.
     */
    private String goal;

    /**
     * Конструктор для створення нового об'єкта Experiment з вказаними параметрами.
     *
     * @param idExperiment Унікальний ідентифікатор для експерименту.
     * @param name         Назва експерименту.
     * @param theme        Тема експерименту.
     * @param goal         Мета експерименту.
     */
    public Experiment(long idExperiment, String name, String theme, String goal) {
        this.idExperiment = idExperiment;
        this.name = name;
        this.theme = theme;
        this.goal = goal;
    }

    /**
     * Конструктор за замовчуванням, який створює порожній об'єкт Experiment.
     */
    public Experiment() {
    }

    /**
     * Отримує назву експерименту.
     *
     * @return Назва експерименту.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву для експерименту.
     *
     * @param name Назва експерименту.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримує унікальний ідентифікатор для експерименту.
     *
     * @return Унікальний ідентифікатор експерименту.
     */
    public long getIdExperiment() {
        return idExperiment;
    }

    /**
     * Встановлює унікальний ідентифікатор для експерименту.
     *
     * @param idExperiment Унікальний ідентифікатор експерименту.
     */
    public void setIdExperiment(long idExperiment) {
        this.idExperiment = idExperiment;
    }

    /**
     * Отримує тему експерименту.
     *
     * @return Тема експерименту.
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Встановлює тему для експерименту.
     *
     * @param theme Тема експерименту.
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Отримує мету експерименту.
     *
     * @return Мета експерименту.
     */
    public String getGoal() {
        return goal;
    }

    /**
     * Встановлює мету для експерименту.
     *
     * @param goal Мета експерименту.
     */
    public void setGoal(String goal) {
        this.goal = goal;
    }

    /**
     * Порівнює експеримент з іншим експериментом за назвою.
     *
     * @param o Інший об'єкт експерименту для порівняння.
     * @return Значення, яке позначає порівняння за назвою.
     */
    @Override
    public int compareTo(Experiment o) {
        return this.name.compareTo(o.name);
    }

    /**
     * Порівнює об'єкт експерименту з іншим об'єктом на рівність.
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
        Experiment that = (Experiment) o;
        return Objects.equals(idExperiment, that.idExperiment);
    }

    /**
     * Генерує хеш-код об'єкта експерименту.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idExperiment);
    }

    /**
     * Повертає рядкове представлення об'єкта експерименту.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "Experiment{" +
            "name='" + name + '\'' +
            ", theme='" + theme + '\'' +
            ", goal='" + goal + '\'' +
            ", idExperiment=" + idExperiment +
            '}';
    }
}

