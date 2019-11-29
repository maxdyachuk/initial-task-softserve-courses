package com.company.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("manager")
public class ManagerEntity extends EmployeeEntity {

    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<EmployeeEntity> team = new ArrayList<>();

    public ManagerEntity() {
    }

    public void setTeam(List<EmployeeEntity> team) {
        this.team = team;
    }

    public List<EmployeeEntity> getTeam() {
        return team;
    }

    @Override
    public String toString() {
        String managerDetails = "none";
        return "EmployeeEntity{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", rate=" + getRate() +
                ", experience=" + getExperience() +
                ", manager=" + managerDetails +
                '}';
    }
}
