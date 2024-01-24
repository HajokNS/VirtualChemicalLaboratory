package com.chornopyskyi.chemicallaboratory.persistence.entity.impl;

import java.util.UUID;
import java.util.Objects;

public class ChemicalSubstance {

    private UUID id;
    private String name;
    private String description;
    private String substanceType;

    public ChemicalSubstance(UUID id, String name, String description, String substanceType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.substanceType = substanceType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubstanceType() {
        return substanceType;
    }

    public void setSubstanceType(String substanceType) {
        this.substanceType = substanceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChemicalSubstance that = (ChemicalSubstance) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChemicalSubstance{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", substanceType='" + substanceType + '\'' +
            '}';
    }
}

