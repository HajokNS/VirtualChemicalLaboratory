package com.chornopyskyi.chemicallaboratory.model;

import java.util.List;
import java.util.Objects;

public class ChemicalReaction {

    private long idReaction;
    private long experimentId;
    private List<String> reactants;
    private List<String> products;
    private String reactionType;
    private List<String> equipmentList;

    public ChemicalReaction(long idReaction, long experimentId, List<String> reactants, List<String> products, String reactionType, List<String> equipmentList) {
        this.idReaction = idReaction;
        this.experimentId = experimentId;
        this.reactants = reactants;
        this.products = products;
        this.reactionType = reactionType;
        this.equipmentList = equipmentList;
    }

    public ChemicalReaction() {
    }

    public long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public void setExperimentId(String experimentId) {
        try {
            this.experimentId = Long.parseLong(experimentId);
        } catch (NumberFormatException e) {
            System.out.println("Помилка конвертації experimentId: " + e.getMessage());
        }
    }

    public long getIdReaction() {
        return idReaction;
    }

    public void setIdReaction(long idReaction) {
        this.idReaction = idReaction;
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
        return Objects.equals(idReaction, that.idReaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReaction);
    }

    @Override
    public String toString() {
        return "ChemicalReaction{" +
            "id=" + idReaction +
            ", experimentId=" + experimentId + '\'' +
            ", reactants=" + reactants +
            ", products=" + products +
            ", reactionType='" + reactionType + '\'' +
            ", equipmentList=" + equipmentList +
            '}';
    }
}
