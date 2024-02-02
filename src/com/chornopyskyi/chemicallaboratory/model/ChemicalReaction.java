package com.chornopyskyi.chemicallaboratory.model;

import java.util.List;
import java.util.Objects;

/**
 * Клас {@code ChemicalReaction} представляє хімічну реакцію у лабораторному експерименті.
 * Він містить інформацію, таку як ідентифікатор реакції, ідентифікатор експерименту, реагенти,
 * продукти, тип реакції та список обладнання.
 */
public class ChemicalReaction {

    /**
     * Унікальний ідентифікатор для хімічної реакції.
     */
    private long idReaction;

    /**
     * Ідентифікатор експерименту, до якого належить хімічна реакція.
     */
    private long experimentId;

    /**
     * Список реагентів, що беруть участь у хімічній реакції.
     */
    private List<String> reactants;

    /**
     * Список продуктів, які утворюються в результаті хімічної реакції.
     */
    private List<String> products;

    /**
     * Тип або категорія хімічної реакції.
     */
    private String reactionType;

    /**
     * Список обладнання, використаного у хімічній реакції.
     */
    private List<String> equipmentList;

    /**
     * Конструктор для створення нового об'єкту ChemicalReaction з вказаними параметрами.
     *
     * @param idReaction     Унікальний ідентифікатор для хімічної реакції.
     * @param experimentId   Ідентифікатор експерименту, до якого належить хімічна реакція.
     * @param reactants      Список реагентів, що беруть участь у хімічній реакції.
     * @param products       Список продуктів, які утворюються в результаті хімічної реакції.
     * @param reactionType   Тип або категорія хімічної реакції.
     * @param equipmentList  Список обладнання, використаного у хімічній реакції.
     */
    public ChemicalReaction(long idReaction, long experimentId, List<String> reactants,
        List<String> products, String reactionType, List<String> equipmentList) {
        this.idReaction = idReaction;
        this.experimentId = experimentId;
        this.reactants = reactants;
        this.products = products;
        this.reactionType = reactionType;
        this.equipmentList = equipmentList;
    }

    /**
     * Конструктор за замовчуванням, який створює порожній об'єкт ChemicalReaction.
     */
    public ChemicalReaction() {
    }

    /**
     * Отримує ідентифікатор експерименту, до якого належить хімічна реакція.
     *
     * @return Ідентифікатор експерименту.
     */
    public long getExperimentId() {
        return experimentId;
    }

    /**
     * Встановлює ідентифікатор експерименту для хімічної реакції.
     *
     * @param experimentId Ідентифікатор експерименту.
     */
    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    /**
     * Встановлює ідентифікатор експерименту для хімічної реакції з рядка.
     * Якщо конвертація не вдається, виводить помилку у консоль.
     *
     * @param experimentId Рядкове представлення ідентифікатора експерименту.
     */
    public void setExperimentId(String experimentId) {
        try {
            this.experimentId = Long.parseLong(experimentId);
        } catch (NumberFormatException e) {
            System.out.println("Помилка конвертації experimentId: " + e.getMessage());
        }
    }

    /**
     * Отримує унікальний ідентифікатор для хімічної реакції.
     *
     * @return Унікальний ідентифікатор хімічної реакції.
     */
    public long getIdReaction() {
        return idReaction;
    }

    /**
     * Встановлює унікальний ідентифікатор для хімічної реакції.
     *
     * @param idReaction Унікальний ідентифікатор хімічної реакції.
     */
    public void setIdReaction(long idReaction) {
        this.idReaction = idReaction;
    }

    /**
     * Отримує список реагентів, що беруть участь у хімічній реакції.
     *
     * @return Список реагентів.
     */
    public List<String> getReactants() {
        return reactants;
    }

    /**
     * Встановлює список реагентів для хімічної реакції.
     *
     * @param reactants Список реагентів.
     */
    public void setReactants(List<String> reactants) {
        this.reactants = reactants;
    }

    /**
     * Отримує список продуктів, які утворюються в результаті хімічної реакції.
     *
     * @return Список продуктів.
     */
    public List<String> getProducts() {
        return products;
    }

    /**
     * Встановлює список продуктів для хімічної реакції.
     *
     * @param products Список продуктів.
     */
    public void setProducts(List<String> products) {
        this.products = products;
    }

    /**
     * Отримує тип або категорію хімічної реакції.
     *
     * @return Тип або категорія хімічної реакції.
     */
    public String getReactionType() {
        return reactionType;
    }

    /**
     * Встановлює тип або категорію хімічної реакції.
     *
     * @param reactionType Тип або категорія хімічної реакції.
     */
    public void setReactionType(String reactionType) {
        this.reactionType = reactionType;
    }

    /**
     * Отримує список обладнання, використаного у хімічній реакції.
     *
     * @return Список обладнання.
     */
    public List<String> getEquipmentList() {
        return equipmentList;
    }

    /**
     * Встановлює список обладнання для хімічної реакції.
     *
     * @param equipmentList Список обладнання.
     */
    public void setEquipmentList(List<String> equipmentList) {
        this.equipmentList = equipmentList;
    }

    /**
     * Порівнює об'єкт хімічної реакції з іншим об'єктом на рівність.
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
        ChemicalReaction that = (ChemicalReaction) o;
        return Objects.equals(idReaction, that.idReaction);
    }

    /**
     * Генерує хеш-код об'єкта хімічної реакції.
     *
     * @return Хеш-код об'єкта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idReaction);
    }

    /**
     * Повертає рядкове представлення об'єкта хімічної реакції.
     *
     * @return Рядкове представлення об'єкта.
     */
    @Override
    public String toString() {
        return "ChemicalReaction{" +
            "id=" + idReaction +
            ", experimentId=" + experimentId +
            ", reactants=" + reactants +
            ", products=" + products +
            ", reactionType='" + reactionType + '\'' +
            ", equipmentList=" + equipmentList +
            '}';
    }
}



