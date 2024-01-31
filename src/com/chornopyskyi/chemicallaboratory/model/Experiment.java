package com.chornopyskyi.chemicallaboratory.model;

import java.util.Objects;
import java.util.UUID;
import java.util.List;

public class Experiment implements Comparable<Experiment> {

    private long idExperiment;
    private String name;
    private String theme;
    private String goal;

    public Experiment(long idExperiment, String name, String theme, String goal) {
        this.idExperiment = idExperiment;
        this.name = name;
        this.theme = theme;
        this.goal = goal;
    }

    public Experiment() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdExperiment() {
        return idExperiment;
    }

    public void setIdExperiment(long idExperiment) {
        this.idExperiment = idExperiment;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
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
        return Objects.equals(idExperiment, that.idExperiment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExperiment);
    }

    @Override
    public String toString() {
        return "Experiment{" +
            "name='" + name + '\'' +
            ", description='" + theme + '\'' +
            ", results=" + goal + '\'' +
            ", id=" + idExperiment + '\'' +
            '}';
    }
}

