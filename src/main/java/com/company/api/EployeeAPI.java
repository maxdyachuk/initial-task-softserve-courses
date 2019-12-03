package com.company.api;

import com.company.entities.*;
import com.company.services.EmployeeService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import java.util.List;

@Path("employees")
public class EployeeAPI {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeEntity> getEmployees() {
        EmployeeService employeeService = new EmployeeService();
        return employeeService.getAllEmployees();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public EmployeeEntity getEmployeeById(@PathParam("id") int id) {
        EmployeeService employeeService = new EmployeeService();
        return employeeService.getEmployeeById(id);
    }
}
