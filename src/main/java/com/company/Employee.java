package com.company;

abstract class Employee {

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
        return (this.getExperience() > 5) ? (this.getRate() * 1.2 + 500) : (
                (this.getExperience() > 2) ? (this.getRate() + 200) : this.getRate()
        );
    }

    void giveSalary() {
        String salaryDetails = this.getFirstName() + " " +
                this.getLastName() + ": got salary: " +
                this.calculateSalary();
        System.out.println(salaryDetails);
    }
}
