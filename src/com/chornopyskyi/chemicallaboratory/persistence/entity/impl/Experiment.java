package com.chornopyskyi.chemicallaboratory.persistence.entity.impl;

import java.util.Objects;
import java.util.UUID;
import java.util.List;

public class Experiment implements Comparable<Experiment> {

    private UUID id;
    private String name;
    private String description;
    private List<String> results; // Результати експерименту
    private List<ChemicalReaction> chemicalReactions; // Список хімічних реакцій


    public Experiment(UUID id, String name, String description, List<String> results, List<ChemicalReaction> chemicalReactions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.results = results;
        this.chemicalReactions = chemicalReactions;
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

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public List<ChemicalReaction> getChemicalReactions() {
        return chemicalReactions;
    }

    public void setChemicalReactions(List<ChemicalReaction> chemicalReactions) {
        this.chemicalReactions = chemicalReactions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public int compareTo(Experiment o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Experiment that = (Experiment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Experiment{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", results=" + results +
            ", chemicalReactions=" + chemicalReactions +
            ", id=" + id +
            '}';
    }
}

