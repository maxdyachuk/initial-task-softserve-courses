package com.company;

class Developer extends Employee {

    Developer(String firstName, String lastName, double rate, double experience, Manager manager) {
        super(firstName, lastName, rate, experience);
        this.setManager(manager);
    }
}
