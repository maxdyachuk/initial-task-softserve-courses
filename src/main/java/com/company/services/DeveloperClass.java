package com.company.services;

import com.company.dao.DAOFactory;
import com.company.entities.DeveloperEntity;

import java.util.List;

public class DeveloperClass {

    public void addDeveloper(DeveloperEntity developer) {
        DAOFactory.getInstance().getDeveloperDAO().addElement(developer);
    }

    public void updateDeveloper(DeveloperEntity developer) {
        DAOFactory.getInstance().getDeveloperDAO().updateElement(developer);
    }

    public DeveloperEntity getDeveloperById(int developerId) {
        return DAOFactory.getInstance().getDeveloperDAO().getElementByID(developerId);
    }

    public List<DeveloperEntity> getAllDevelopers() {
        return DAOFactory.getInstance().getDeveloperDAO().getAllElements();
    }

    public void deleteDeveloper(DeveloperEntity developer) {
        DAOFactory.getInstance().getDeveloperDAO().deleteElement(developer);
    }
}
