package com.company.models;

public class Developer extends Employee {

    public Developer() {
    }

    public Developer(String firstName, String lastName, double rate, double experience, Manager manager) {
        super(firstName, lastName, rate, experience);
        this.setManager(manager);
    }
}
