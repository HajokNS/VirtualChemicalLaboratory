package com.chornopyskyi.chemicallaboratory.persistence.entity.impl;


import java.util.Objects;
import java.util.UUID;

public class Equipment {

    private UUID id;
    private String name;
    private String description;
    private String functionalityDescription;
    private String usageMethod;

    public Equipment(UUID id, String name, String description, String functionalityDescription, String usageMethod) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.functionalityDescription = functionalityDescription;
        this.usageMethod = usageMethod;
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
        return Objects.equals(id, equipment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Equipment{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", functionalityDescription='" + functionalityDescription + '\'' +
            ", usageMethod='" + usageMethod + '\'' +
            '}';
    }
}
