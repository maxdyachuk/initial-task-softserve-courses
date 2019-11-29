package com.company.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("developer")
public class DeveloperEntity extends EmployeeEntity {

    public DeveloperEntity() {
    }
}
