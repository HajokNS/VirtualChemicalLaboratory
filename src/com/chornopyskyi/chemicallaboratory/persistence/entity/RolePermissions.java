package com.chornopyskyi.chemicallaboratory.persistence.entity;

public class RolePermissions {

    private boolean addEquipment;
    private boolean removeEquipment;
    private boolean removeChemicalSubstances;
    private boolean addChemicalSubstances;
    private boolean accessExperiments;
    private boolean viewExperimentResults;
    private boolean helpWithExperiment;

    public RolePermissions(
        boolean addEquipment,
        boolean removeEquipment,
        boolean removeChemicalSubstances,
        boolean addChemicalSubstances,
        boolean accessExperiments,
        boolean viewExperimentResults,
        boolean helpWithExperiment
    ) {
        this.addEquipment = addEquipment;
        this.removeEquipment = removeEquipment;
        this.removeChemicalSubstances = removeChemicalSubstances;
        this.addChemicalSubstances = addChemicalSubstances;
        this.accessExperiments = accessExperiments;
        this.viewExperimentResults = viewExperimentResults;
        this.helpWithExperiment = helpWithExperiment;
    }

    public boolean isAddEquipment() {
        return addEquipment;
    }

    public void setAddEquipment(boolean addEquipment) {
        this.addEquipment = addEquipment;
    }

    public boolean isRemoveEquipment() {
        return removeEquipment;
    }

    public void setRemoveEquipment(boolean removeEquipment) {
        this.removeEquipment = removeEquipment;
    }

    public boolean isRemoveChemicalSubstances() {
        return removeChemicalSubstances;
    }

    public void setRemoveChemicalSubstances(boolean removeChemicalSubstances) {
        this.removeChemicalSubstances = removeChemicalSubstances;
    }

    public boolean isAddChemicalSubstances() {
        return addChemicalSubstances;
    }

    public void setAddChemicalSubstances(boolean addChemicalSubstances) {
        this.addChemicalSubstances = addChemicalSubstances;
    }

    public boolean isAccessExperiments() {
        return accessExperiments;
    }

    public void setAccessExperiments(boolean accessExperiments) {
        this.accessExperiments = accessExperiments;
    }

    public boolean isViewExperimentResults() {
        return viewExperimentResults;
    }

    public void setViewExperimentResults(boolean viewExperimentResults) {
        this.viewExperimentResults = viewExperimentResults;
    }

    public boolean isHelpWithExperiment() {
        return helpWithExperiment;
    }

    public void setHelpWithExperiment(boolean helpWithExperiment) {
        this.helpWithExperiment = helpWithExperiment;
    }
}

