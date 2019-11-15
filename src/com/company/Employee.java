package com.company;

public abstract class Employee implements Salaried {

    private String firstName;
    private String lastName;
    private double rate;
    private double experience;
    private Employee manager;

    Employee(String firstName, String lastName, double rate, double experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rate = rate;
        this.experience = experience;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    double getRate() {
        return rate;
    }

    void setRate(double rate) {
        this.rate = rate;
    }

    double getExperience() {
        return experience;
    }

    void setExperience(double experience) {
        this.experience = experience;
    }

    Employee getManager() {
        return manager;
    }

    void setManager(Employee manager) {
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
        } else if (this.getExperience() > 2) {
            return this.getRate() + 200;
        } else {
            return this.getRate();
        }
    }

    void printSalary() {
        String salaryDetails = this.getFirstName() + " " +
                this.getLastName() + ": got salary: " +
                this.calculateSalary();
        System.out.println(salaryDetails);
    }
}
