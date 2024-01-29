package com.chornopyskyi.chemicallaboratory.model;

import java.util.UUID;
import java.util.Objects;

public class ChemicalSubstance {

    private long idSubstance;
    private String name;
    private String molecularFormula;
    private String description;
    private String substanceType;

    public ChemicalSubstance(long idSubstance, String name, String molecularFormula, String description, String substanceType) {
        this.idSubstance = idSubstance;
        this.name = name;
        this.molecularFormula = molecularFormula;
        this.description = description;
        this.substanceType = substanceType;
    }

    public ChemicalSubstance() {

    }

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    public long getId() {
        return idSubstance;
    }

    public void setId(long idSubstance) {
        this.idSubstance = idSubstance;
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
        return Objects.equals(idSubstance, that.idSubstance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubstance);
    }

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

