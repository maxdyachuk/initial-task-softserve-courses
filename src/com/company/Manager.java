package com.company;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> team = new ArrayList<>();

    Manager(String firstName, String lastName, double rate, double experience) {
        super(firstName, lastName, rate, experience);
    }

    double calculateSalary() {
        double salary = super.calculateSalary();
        if (team.size() > 10) {
            salary += 300;
        } else if (team.size() > 5) {
            salary += 200;
        }

        if (countDevelopersInTeam() >= (team.size() / 2) && countDevelopersInTeam() != 0) {
            salary *= 1.1;
        }

        return salary;
    }

    private int countDevelopersInTeam() {
        int counter = 0;
        for (Employee employee : team) {
            if (employee instanceof Developer) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void getSalary() {
        printSalary();
        for (Employee employee : team) {
            System.out.print("---");
            employee.getSalary();
        }
    }

    void addTeamMember(Employee employee) {
        if (employee instanceof Developer || employee instanceof Designer) {
            team.add(employee);
        }
    }

    void removeTeamMember(Employee employee) {
        team.remove(employee);
    }

    Employee getTeamMember(int i) {
        return team.get(i);
    }
}
