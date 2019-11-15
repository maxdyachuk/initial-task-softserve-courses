package com.company;

import java.util.ArrayList;
import java.util.List;

public class Department implements Salaried {
    private List<Employee> managers = new ArrayList<>();

    Department() {}

    @Override
    public void getSalary() {
        for (Employee manager : managers) {
            manager.getSalary();
        }
    }

    void addManager(Employee employee) {
        if (employee instanceof Manager) {
            managers.add(employee);
        }
    }

    void removeManager(Employee employee) {
        managers.remove(employee);
    }

    Employee getManager(int i) {
        return managers.get(i);
    }
}
