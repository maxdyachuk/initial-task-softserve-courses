package com.company;

import com.company.entities.*;
import com.company.models.*;
import com.company.services.*;

import java.util.List;

public class DaoApp {

    public static void main(final String[] args) {
        ManagerService managerService = new ManagerService();
        EmployeeService employeeService = new EmployeeService();
        DesignerService designerService = new DesignerService();

        Manager manager = new Manager("Ada", "Petersen", 2500, 4);
        Designer designer = new Designer("Myla", "Bowman", 3000, 4, 1, manager);
        Developer developer = new Developer("Ayanna", "Wood", 3500, 5, manager);

        ManagerEntity managerEntity = new ManagerEntity();
        DesignerEntity designerEntity = new DesignerEntity();

        manager.addTeamMember(designer);
        manager.addTeamMember(developer);
        Mapper.map(manager, managerEntity);
        managerService.addManager(managerEntity);
        List<EmployeeEntity> list = employeeService.getAllEmployees();
        list.forEach(employeeEntity -> System.out.println(employeeEntity.toString()));
        Manager newManager = new Manager();
        Mapper.map(managerService.getManagerById(1), newManager);
        System.out.println(newManager.toString());
        newManager.getTeam().forEach(employee -> System.out.println(employee.toString()));
        employeeService.deleteEmployee(employeeService.getEmployeeById(2));
        designer = new Designer("Angelique", "Molina", 1500, 1.7, 0.8, null);
        Mapper.map(designer, designerEntity);
        employeeService.addEmployee(designerEntity);
        list = employeeService.getAllEmployees();
        list.forEach(employeeEntity -> System.out.println(employeeEntity.toString()));
        designerEntity = designerService.getDesignerById(4);
        designerEntity.setEffectivenessCoefficient(1);
        employeeService.updateEmployee(designerEntity);
        System.out.println(employeeService.getEmployeeById(4).toString());
    }
}