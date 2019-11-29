package com.company.dao;

import com.company.entities.EmployeeEntity;

public class EmployeeDAO extends ElementDAOImpl<EmployeeEntity> {

    public EmployeeDAO() {
        super(EmployeeEntity.class);
    }
}
