package com.company;

public class Developer extends Employee {

    Developer(String firstName, String lastName, double rate, double experience, Manager manager) {
        super(firstName, lastName, rate, experience);
        this.setManager(manager);
    }

    @Override
    public void getSalary() {
        printSalary();
    }
}
