package com.company.services;

import com.company.dao.DAOFactory;
import com.company.entities.DesignerEntity;

import java.util.List;

public class DesignerService {

    public void addDesigner(DesignerEntity designer) {
        DAOFactory.getInstance().getDesignerDAO().addElement(designer);
    }

    public void updateDesigner(DesignerEntity designer) {
        DAOFactory.getInstance().getDesignerDAO().updateElement(designer);
    }

    public DesignerEntity getDesignerById(int designerId) {
        return DAOFactory.getInstance().getDesignerDAO().getElementByID(designerId);
    }

    public List<DesignerEntity> getAllDesigners() {
        return DAOFactory.getInstance().getDesignerDAO().getAllElements();
    }

    public void deleteDesigner(DesignerEntity designer) {
        DAOFactory.getInstance().getDesignerDAO().deleteElement(designer);
    }
}
