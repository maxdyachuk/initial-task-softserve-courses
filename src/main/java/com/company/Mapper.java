package com.company;

import com.company.entities.*;
import com.company.models.*;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static void map(Developer developer, DeveloperEntity developerEntity) {
        mapModelToEntity(developer, developerEntity);
    }

    public static void map(DeveloperEntity developerEntity, Developer developer) {
        mapEntityToModel(developerEntity, developer);
    }

    public static void map(Designer designer, DesignerEntity designerEntity) {
        mapModelToEntity(designer, designerEntity);
        designerEntity.setEffectivenessCoefficient(designer.getEffectivenessCoefficient());
    }

    public static void map(DesignerEntity designerEntity, Designer designer) {
        mapEntityToModel(designerEntity, designer);
        designer.setEffectivenessCoefficient(designerEntity.getEffectivenessCoefficient());
    }

    public static void map(Manager manager, ManagerEntity managerEntity) {
        mapModelToEntity(manager, managerEntity);
        List<EmployeeEntity> team = new ArrayList<>();
        manager.getTeam().forEach(employee -> {
            if (employee instanceof Designer) {
                DesignerEntity designerEntity = new DesignerEntity();
                map((Designer) employee, designerEntity);
                designerEntity.setManager(managerEntity);
                team.add(designerEntity);
            } else if (employee instanceof Developer) {
                DeveloperEntity developerEntity = new DeveloperEntity();
                map((Developer) employee, developerEntity);
                developerEntity.setManager(managerEntity);
                team.add(developerEntity);
            }
        });
        managerEntity.setTeam(team);
    }

    public static void map(ManagerEntity managerEntity, Manager manager) {
        mapEntityToModel(managerEntity, manager);
        List<Employee> team = new ArrayList<>();
        managerEntity.getTeam().forEach(employeeEntity -> {
            if (employeeEntity instanceof DesignerEntity) {
                Designer designer = new Designer();
                map((DesignerEntity) employeeEntity, designer);
                designer.setManager(manager);
                team.add(designer);
            } else if (employeeEntity instanceof DeveloperEntity) {
                Developer developer = new Developer();
                map((DeveloperEntity) employeeEntity, developer);
                developer.setManager(manager);
                team.add(developer);
            }
        });
        manager.setTeam(team);
    }

    private static void mapModelToEntity(Employee employee, EmployeeEntity employeeEntity) {
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setRate(employee.getRate());
        employeeEntity.setExperience(employee.getExperience());
    }

    private static void mapEntityToModel(EmployeeEntity employeeEntity, Employee employee) {
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setRate(employeeEntity.getRate());
        employee.setExperience(employeeEntity.getExperience());
    }
}
