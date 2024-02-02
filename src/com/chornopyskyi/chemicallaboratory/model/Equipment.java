package com.chornopyskyi.chemicallaboratory.model;

import java.util.Objects;

/**
 * Клас {@code Equipment} представляє обладнання лабораторії із вказаною інформацією, такою як ідентифікатор,
 * назва, опис, опис функціональності та метод використання.
 */
public class Equipment {

    /**
     * Унікальний ідентифікатор для обладнання.
     */
    private long idEquipment;

    /**
     * Назва обладнання.
     */
    private String name;

    /**
     * Опис обладнання.
     */
    private String description;

    /**
     * Опис функціональності обладнання.
     */
    private String functionalityDescription;

    /**
     * Метод використання обладнання.
     */
    private String usageMethod;

    /**
     * Конструктор для створення нового об'єкта Equipment з вказаними параметрами.
     *
     * @param idEquipment             Унікальний ідентифікатор для обладнання.
     * @param name                    Назва обладнання.
     * @param description             Опис обладнання.
     * @param functionalityDescription Опис функціональності обладнання.
     * @param usageMethod             Метод використання обладнання.
     */
    public Equipment(long idEquipment, String name, String description,
        String functionalityDescription, String usageMethod) {
        this.idEquipment = idEquipment;
        this.name = name;
        this.description = description;
        this.functionalityDescription = functionalityDescription;
        this.usageMethod = usageMethod;
    }

    /**
     * Конструктор за замовчуванням, який створює порожній об'єкт Equipment.
     */
    public Equipment() {
    }

    /**
     * Отримує унікальний ідентифікатор для обладнання.
     *
     * @return Унікальний ідентифікатор обладнання.
     */
    public long getId() {
        return idEquipment;
    }

    /**
     * Встановлює унікальний ідентифікатор для обладнання.
     *
     * @param idEquipment Унікальний ідентифікатор обладнання.
     */
    public void setId(long idEquipment) {
        this.idEquipment = idEquipment;
    }

    /**
     * Отримує назву обладнання.
     *
     * @return Назва обладнання.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву для обладнання.
     *
     * @param name Назва обладнання.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримує опис обладнання.
     *
     * @return Опис обладнання.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Встановлює опис для обладнання.
     *
     * @param description Опис обладнання.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Отримує опис функціональності обладнання.
     *
     * @return Опис функціональності обладнання.
     */
    public String getFunctionalityDescription() {
        return functionalityDescription;
    }

    /**
     * Встановлює опис функціональності для обладнання.
     *
     * @param functionalityDescription Опис функціональності обладнання.
     */
    public void setFunctionalityDescription(String functionalityDescription) {
        this.functionalityDescription = functionalityDescription;
    }

    /**
     * Отримує метод використання обладнання.
     *
     * @return Метод використання обладнання.
     */
    public String getUsageMethod() {
        return usageMethod;
    }

    /**
     * Встановлює метод використання для обладнання.
     *
     * @param usageMethod Метод використання обладнання.
     */
    public void setUsageMethod(String usageMethod) {
        this.usageMethod = usageMethod;
    }

    /**
     * Порівнює об'єкт обладнання з іншим об'єктом на рівність.
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
        Equipment equipment = (Equipment) o;
        return Objects.equals(idEquipment, equipment.idEquipment);
    }

    /**
     * Генерує хеш-код об'єкта обладнання.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idEquipment);
    }

    /**
     * Повертає рядкове представлення об'єкта обладнання.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "Equipment{" +
            "id=" + idEquipment +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", functionalityDescription='" + functionalityDescription + '\'' +
            ", usageMethod='" + usageMethod + '\'' +
            '}';
    }
}

