package com.company.dao;

import com.company.entities.DeveloperEntity;

public class DeveloperDAO extends ElementDAOImpl<DeveloperEntity> {

    public DeveloperDAO() {
        super(DeveloperEntity.class);
    }
}
