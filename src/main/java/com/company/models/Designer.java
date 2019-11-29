package com.company.models;

public class Designer extends Employee {

    private double effectivenessCoefficient;

    public Designer() {
    }

    public Designer(String firstName, String lastName, double rate, double experience, double effectivenessCoefficient, Manager manager) {
        super(firstName, lastName, rate, experience);
        this.effectivenessCoefficient = setValidEffectivenessCoefficient(effectivenessCoefficient);
        this.setManager(manager);
    }

    public double getEffectivenessCoefficient() {
        return effectivenessCoefficient;
    }

    public void setEffectivenessCoefficient(double effectivenessCoefficient) {
        this.effectivenessCoefficient = setValidEffectivenessCoefficient(effectivenessCoefficient);
    }

    private double setValidEffectivenessCoefficient(double effectivenessCoefficient) {
        return effectivenessCoefficient <= 0 ? 0 : (effectivenessCoefficient > 1 ? 1 : effectivenessCoefficient);
    }

    @Override
    double calculateSalary() {
        return super.calculateSalary() * this.getEffectivenessCoefficient();
    }
}
