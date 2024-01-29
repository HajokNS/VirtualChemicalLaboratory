package com.chornopyskyi.chemicallaboratory.model;


import java.util.Objects;
import java.util.UUID;

public class Equipment {

    private long idEquipment;
    private String name;
    private String description;
    private String functionalityDescription;
    private String usageMethod;

    public Equipment(long idEquipment, String name, String description, String functionalityDescription, String usageMethod) {
        this.idEquipment = idEquipment;
        this.name = name;
        this.description = description;
        this.functionalityDescription = functionalityDescription;
        this.usageMethod = usageMethod;
    }

    public Equipment() {

    }
    public long getId() {
        return idEquipment;
    }

    public void setId(long idEquipment) {
        this.idEquipment = idEquipment;
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

    public String getFunctionalityDescription() {
        return functionalityDescription;
    }

    public void setFunctionalityDescription(String functionalityDescription) {
        this.functionalityDescription = functionalityDescription;
    }

    public String getUsageMethod() {
        return usageMethod;
    }

    public void setUsageMethod(String usageMethod) {
        this.usageMethod = usageMethod;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(idEquipment);
    }

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
