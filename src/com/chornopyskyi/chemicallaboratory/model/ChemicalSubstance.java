package com.chornopyskyi.chemicallaboratory.model;

import java.util.Objects;

/**
 * Клас {@code ChemicalSubstance} представляє хімічну речовину із вказаною інформацією,
 * такою як ідентифікатор речовини, назва, молекулярна формула, опис та тип речовини.
 */
public class ChemicalSubstance {

    /**
     * Унікальний ідентифікатор для хімічної речовини.
     */
    private long idSubstance;

    /**
     * Назва хімічної речовини.
     */
    private String name;

    /**
     * Молекулярна формула хімічної речовини.
     */
    private String molecularFormula;

    /**
     * Опис хімічної речовини.
     */
    private String description;

    /**
     * Тип або категорія хімічної речовини.
     */
    private String substanceType;

    /**
     * Конструктор для створення нового об'єкта ChemicalSubstance з вказаними параметрами.
     *
     * @param idSubstance      Унікальний ідентифікатор для хімічної речовини.
     * @param name             Назва хімічної речовини.
     * @param molecularFormula Молекулярна формула хімічної речовини.
     * @param description      Опис хімічної речовини.
     * @param substanceType    Тип або категорія хімічної речовини.
     */
    public ChemicalSubstance(long idSubstance, String name, String molecularFormula,
        String description, String substanceType) {
        this.idSubstance = idSubstance;
        this.name = name;
        this.molecularFormula = molecularFormula;
        this.description = description;
        this.substanceType = substanceType;
    }

    /**
     * Конструктор за замовчуванням, який створює порожній об'єкт ChemicalSubstance.
     */
    public ChemicalSubstance() {
    }

    /**
     * Отримує молекулярну формулу хімічної речовини.
     *
     * @return Молекулярна формула.
     */
    public String getMolecularFormula() {
        return molecularFormula;
    }

    /**
     * Встановлює молекулярну формулу для хімічної речовини.
     *
     * @param molecularFormula Молекулярна формула.
     */
    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    /**
     * Отримує ідентифікатор хімічної речовини.
     *
     * @return Ідентифікатор хімічної речовини.
     */
    public long getId() {
        return idSubstance;
    }

    /**
     * Встановлює ідентифікатор для хімічної речовини.
     *
     * @param idSubstance Ідентифікатор хімічної речовини.
     */
    public void setId(long idSubstance) {
        this.idSubstance = idSubstance;
    }

    /**
     * Отримує назву хімічної речовини.
     *
     * @return Назва хімічної речовини.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву для хімічної речовини.
     *
     * @param name Назва хімічної речовини.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримує опис хімічної речовини.
     *
     * @return Опис хімічної речовини.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Встановлює опис для хімічної речовини.
     *
     * @param description Опис хімічної речовини.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Отримує тип або категорію хімічної речовини.
     *
     * @return Тип або категорія хімічної речовини.
     */
    public String getSubstanceType() {
        return substanceType;
    }

    /**
     * Встановлює тип або категорію для хімічної речовини.
     *
     * @param substanceType Тип або категорія хімічної речовини.
     */
    public void setSubstanceType(String substanceType) {
        this.substanceType = substanceType;
    }

    /**
     * Порівнює об'єкт хімічної речовини з іншим об'єктом на рівність.
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
        ChemicalSubstance that = (ChemicalSubstance) o;
        return Objects.equals(idSubstance, that.idSubstance);
    }

    /**
     * Генерує хеш-код об'єкта хімічної речовини.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idSubstance);
    }

    /**
     * Повертає рядкове представлення об'єкта хімічної речовини.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "ChemicalSubstance{" +
            "id=" + idSubstance +
            ", name='" + name + '\'' +
            ", molecularFormula='" + molecularFormula + '\'' +
            ", description='" + description + '\'' +
            ", substanceType='" + substanceType + '\'' +
            '}';
    }
}

