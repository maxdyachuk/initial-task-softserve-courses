package com.company;

import com.company.exceptions.InvalidTeamMemberException;

import java.util.ArrayList;
import java.util.List;

class Manager extends Employee {

    private List<Employee> team = new ArrayList<>();

    Manager(String firstName, String lastName, double rate, double experience) {
        super(firstName, lastName, rate, experience);
    }

    void addTeamMember(Employee employee) {
        if (employee instanceof Developer || employee instanceof Designer) {
            team.add(employee);
        } else {
            throw new InvalidTeamMemberException();
        }
    }

    boolean removeTeamMember(Employee employee) {
        return team.remove(employee);
    }

    Employee getTeamMember(int i) {
        try {
            return team.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    double calculateSalary() {
        double salary = super.calculateSalary();

        if (team.size() > 10) {
            salary += 300;
        } else if (team.size() > 5) {
            salary += 200;
        }

        if (countDevelopersInTeam() > (team.size() / 2) && countDevelopersInTeam() != 0) {
            salary *= 1.1;
        }

        return salary;
    }

    private int countDevelopersInTeam() {
        return (int) team.stream().filter(e -> e instanceof Developer).count();
    }

    @Override
    void giveSalary() {
        super.giveSalary();
        team.forEach(Employee::giveSalary);
    }
}
