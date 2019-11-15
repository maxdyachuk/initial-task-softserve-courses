package com.company;

public class Designer extends Employee {

    private double effectivenessCoefficient;

    Designer(String firstName, String lastName, double rate, double experience, double effectivenessCoefficient, Manager manager) {
        super(firstName, lastName, rate, experience);
        this.effectivenessCoefficient = setValidEffectivenessCoefficient(effectivenessCoefficient);
        this.setManager(manager);
    }

    double getEffectivenessCoefficient() {
        return effectivenessCoefficient;
    }

    void setEffectivenessCoefficient(double effectivenessCoefficient) {
        this.effectivenessCoefficient = setValidEffectivenessCoefficient(effectivenessCoefficient);
    }

    private double setValidEffectivenessCoefficient(double effectivenessCoefficient) {
        if (effectivenessCoefficient <= 0) {
            return 0;
        } else if (effectivenessCoefficient > 1) {
            return 1;
        } else {
            return effectivenessCoefficient;
        }
    }

    @Override
    double calculateSalary() {
        return super.calculateSalary() * effectivenessCoefficient;
    }

    @Override
    public void getSalary() {
        printSalary();
    }
}
