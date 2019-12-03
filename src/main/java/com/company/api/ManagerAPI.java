package com.company.api;

import com.company.entities.EmployeeEntity;
import com.company.entities.ManagerEntity;
import com.company.services.ManagerService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("managers")
public class ManagerAPI {

    @GET
    @Produces("application/json")
    public List<ManagerEntity> getManagers() {
        ManagerService managerService = new ManagerService();
        return managerService.getAllManagers();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public ManagerEntity getManager(@PathParam("id") int id) {
        ManagerService managerService = new ManagerService();
        return managerService.getManagerById(id);
    }

    @GET
    @Path("{id}/team")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EmployeeEntity> getTeam(@PathParam("id") int id) {
        ManagerService managerService = new ManagerService();
        return managerService.getManagerById(id).getTeam();
    }
}
