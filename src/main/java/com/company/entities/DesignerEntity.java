package com.company.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("designer")
public class DesignerEntity extends EmployeeEntity {

    @Column(name = "effectivenessCoefficient")
    private double effectivenessCoefficient;

    public DesignerEntity() {
    }

    public void setEffectivenessCoefficient(double effectivenessCoefficient) {
        this.effectivenessCoefficient = effectivenessCoefficient;
    }

    public double getEffectivenessCoefficient() {
        return effectivenessCoefficient;
    }

    @Override
    public String toString() {
        String managerDetails = getManager() == null ? "none" : getManager().getLastName();
        return "EmployeeEntity{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", rate=" + getRate() +
                ", experience=" + getExperience() +
                ", effectivenessCoefficient=" + effectivenessCoefficient +
                ", manager=" + managerDetails +
                '}';
    }
}
