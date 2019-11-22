package com.company;

import java.util.ArrayList;
import java.util.List;

class Department {

    private List<Employee> managers = new ArrayList<>();

    Department() {}

    void addManager(Employee employee) {
        if (employee instanceof Manager) {
            managers.add(employee);
        } else {
            System.out.println("Can not add employee to department.");
        }
    }

    void removeManager(Employee employee) {
        managers.remove(employee);
    }

    Employee getManager(int i) {
        return managers.get(i);
    }

    void giveSalary() {
        managers.forEach(Employee::giveSalary);
    }
}
