package com.company;

import com.company.entities.ManagerEntity;
import com.company.models.Designer;
import com.company.models.Developer;
import com.company.models.Manager;
import com.company.services.EmployeeService;
import com.company.services.ManagerService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

public class RestApp {
    private static final Logger logger = LoggerFactory.getLogger(RestApp.class);

    public static void main(String[] args) {

        ManagerService managerService = new ManagerService();
        EmployeeService employeeService = new EmployeeService();

        Manager manager = new Manager("Ada", "Petersen", 2500, 4);
        Designer designer = new Designer("Myla", "Bowman", 3000, 4, 1, manager);
        Developer developer = new Developer("Ayanna", "Wood", 3500, 5, manager);

        ManagerEntity managerEntity = new ManagerEntity();

        manager.addTeamMember(designer);
        manager.addTeamMember(developer);
        Mapper.map(manager, managerEntity);
        managerService.addManager(managerEntity);

        MyApplication application = new MyApplication();

        ServletHolder jerseyServlet
                = new ServletHolder(new ServletContainer(application));


        Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);


        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);

        servletContextHandler.addServlet(jerseyServlet, "/v1/*");
//        jerseyServlet.setInitOrder(0);
//        jerseyServlet.setInitParameter(
//                "jersey.config.server.provider.packages",
//                "edu.softserve.eeapp.api"
//        );
        servletContextHandler.addServlet(DefaultServlet.class, "/");

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            logger.error("Error occurred while starting Jetty", ex);
            System.exit(1);
        } finally {
            server.destroy();
        }
    }
}

