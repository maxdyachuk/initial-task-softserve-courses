package com.company.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employeeType")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "rate")
    private double rate;
    @Column(name = "experience")
    private double experience;
    @ManyToOne()
    @JoinColumn(name = "managerId")
    private ManagerEntity manager;

    public EmployeeEntity() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getExperience() {
        return experience;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    public ManagerEntity getManager() {
        return manager;
    }

    @Override
    public String toString() {
        String managerDetails = manager == null ? "none" : manager.getLastName();
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rate=" + rate +
                ", experience=" + experience +
                ", manager=" + managerDetails +
                '}';
    }
}
