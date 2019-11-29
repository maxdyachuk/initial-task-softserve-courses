package com.company.services;

import com.company.dao.DAOFactory;
import com.company.entities.EmployeeEntity;

import java.util.List;

public class EmployeeService {

    public void addEmployee(EmployeeEntity employee) {
        DAOFactory.getInstance().getEmployeeDAO().addElement(employee);
    }

    public void updateEmployee(EmployeeEntity employee) {
        DAOFactory.getInstance().getEmployeeDAO().updateElement(employee);
    }

    public EmployeeEntity getEmployeeById(int employeeId) {
        return DAOFactory.getInstance().getEmployeeDAO().getElementByID(employeeId);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return DAOFactory.getInstance().getEmployeeDAO().getAllElements();
    }

    public void deleteEmployee(EmployeeEntity employee) {
        DAOFactory.getInstance().getEmployeeDAO().deleteElement(employee);
    }
}
