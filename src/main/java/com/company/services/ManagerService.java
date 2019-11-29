package com.company.services;

import com.company.dao.DAOFactory;
import com.company.entities.DesignerEntity;
import com.company.entities.DeveloperEntity;
import com.company.entities.ManagerEntity;

import java.util.List;

public class ManagerService {

    public void addManager(ManagerEntity managerEntity) {
        EmployeeService employeeService = new EmployeeService();
        DAOFactory.getInstance().getManagerDAO().addElement(managerEntity);
        managerEntity.getTeam().forEach(employeeEntity -> {
            if (employeeEntity instanceof DesignerEntity || employeeEntity instanceof DeveloperEntity) {
                employeeService.addEmployee(employeeEntity);
            }
        });
    }

    public void updateManager(ManagerEntity managerEntity) {
        DAOFactory.getInstance().getManagerDAO().updateElement(managerEntity);
    }

    public ManagerEntity getManagerById(int managerEntityId) {
        return DAOFactory.getInstance().getManagerDAO().getElementByID(managerEntityId);
    }

    public List<ManagerEntity> getAllManagers() {
        return DAOFactory.getInstance().getManagerDAO().getAllElements();
    }

    public void deleteManager(ManagerEntity managerEntity) {
        EmployeeService employeeService = new EmployeeService();
        managerEntity.getTeam().forEach(employeeService::deleteEmployee);
        employeeService.deleteEmployee(managerEntity);
    }
}
