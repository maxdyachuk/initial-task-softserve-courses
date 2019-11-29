package com.company;

import com.company.models.Employee;
import com.company.models.Manager;
import com.company.exceptions.InvalidManagerException;

import java.util.ArrayList;
import java.util.List;

class Department {

    private List<Employee> managers = new ArrayList<>();

    Department() {}

    void addManager(Employee employee) {
        if (employee instanceof Manager) {
            managers.add(employee);
        } else {
            throw new InvalidManagerException();
        }
    }

    boolean removeManager(Employee employee) {
        return managers.remove(employee);
    }

    Employee getManager(int i) {
        try {
            return managers.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }

    void giveSalary() {
        managers.forEach(Employee::giveSalary);
    }
}
