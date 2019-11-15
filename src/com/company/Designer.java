package com.company;

class Designer extends Employee {

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
        return effectivenessCoefficient <= 0 ? 0 : (effectivenessCoefficient > 1 ? 1 : effectivenessCoefficient);
    }

    @Override
    double calculateSalary() {
        return super.calculateSalary() * this.getEffectivenessCoefficient();
    }
}
