package com.company.models;

import com.company.exceptions.InvalidExperienceValueException;

public abstract class Employee {

    private String firstName;
    private String lastName;
    private double rate;
    private double experience;
    private Employee manager;

    public Employee() {
    }

    public Employee(String firstName, String lastName, double rate, double experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rate = rate;
        if (experience < 0) {
            throw new InvalidExperienceValueException();
        } else {
            this.experience = experience;
        }
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        String managerLastName = (getManager() == null) ? "none" : getManager().getLastName();
        return this.getFirstName() + " " +
                this.getLastName() + ", manager: " +
                managerLastName + ", experience: " +
                (int) this.getExperience();
    }

    double calculateSalary() {
        if (this.getExperience() > 5) {
            return this.getRate() * 1.2 + 500;
        }
        return (this.getExperience() > 2) ? (this.getRate() + 200) : this.getRate();
    }

    public void giveSalary() {
        String salaryDetails = this.getFirstName() + " " +
                this.getLastName() + ": got salary: " +
                this.calculateSalary();
        System.out.println(salaryDetails);
    }
}
