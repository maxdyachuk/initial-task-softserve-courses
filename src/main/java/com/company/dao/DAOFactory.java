package com.company.dao;

public class DAOFactory {

    private EmployeeDAO employeeDAO = null;
    private DeveloperDAO developerDAO = null;
    private DesignerDAO designerDAO = null;
    private ManagerDAO managerDAO = null;

    private static DAOFactory instance = null;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    private DAOFactory() {
        employeeDAO = new EmployeeDAO();
        developerDAO = new DeveloperDAO();
        designerDAO = new DesignerDAO();
        managerDAO = new ManagerDAO();
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public DeveloperDAO getDeveloperDAO() {
        return developerDAO;
    }

    public DesignerDAO getDesignerDAO() {
        return designerDAO;
    }

    public ManagerDAO getManagerDAO() {
        return managerDAO;
    }
}

