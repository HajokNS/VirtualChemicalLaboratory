package com.chornopyskyi.chemicallaboratory.persistence.entity.impl;

import java.util.UUID;

import java.util.List;
import java.util.Objects;

public class ChemicalReaction {

    private UUID id;
    private List<String> reactants;
    private List<String> products;
    private String reactionType;
    private List<String> equipmentList;

    public ChemicalReaction(UUID id, List<String> reactants, List<String> products, String reactionType, List<String> equipmentList) {
        this.id = id;
        this.reactants = reactants;
        this.products = products;
        this.reactionType = reactionType;
        this.equipmentList = equipmentList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getReactants() {
        return reactants;
    }

    public void setReactants(List<String> reactants) {
        this.reactants = reactants;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public String getReactionType() {
        return reactionType;
    }

    public void setReactionType(String reactionType) {
        this.reactionType = reactionType;
    }

    public List<String> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<String> equipmentList) {
        this.equipmentList = equipmentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChemicalReaction that = (ChemicalReaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChemicalReaction{" +
            "id=" + id +
            ", reactants=" + reactants +
            ", products=" + products +
            ", reactionType='" + reactionType + '\'' +
            ", equipmentList=" + equipmentList +
            '}';
    }
}

