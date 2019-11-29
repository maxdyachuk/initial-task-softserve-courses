package com.company;

import com.company.Department;
import com.company.models.Developer;
import com.company.models.Employee;
import com.company.models.Manager;
import com.company.exceptions.InvalidManagerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    
    private static final int TIMEOUT = 2000;
    private static Department department;
    
    @BeforeAll
    private static void departmentInit() {
        department = new Department(); 
    }

    @Test
    public void addManager_addDeveloperAsManager_invalidManagerExceptionThrown() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            assertThrows(InvalidManagerException.class, () -> {
                department.addManager(Mockito.mock(Developer.class));
            });
        });
    }

    @Test
    public void removeManager_removeManagerWhichExists_managerIsRemoved() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            Employee manager = Mockito.mock(Manager.class);
            department.addManager(manager);
            boolean isRemoved = department.removeManager(manager);
            assertEquals(true, isRemoved);
        });
    }

    @Test
    public void removeManager_managerWhichDoesntExist_nothingToRemove() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            boolean isRemoved = department.removeManager(Mockito.mock(Manager.class));
            assertEquals(false, isRemoved);
        });
    }

    @Test
    public void getManager_managerWhichExists_managerIsReturned() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            Employee employee = Mockito.mock(Manager.class);
            department.addManager(employee);
            assertEquals(employee, department.getManager(0));
            department.removeManager(employee);
        });
    }

    @Test
    public void getManager_managerWhichDoesntExist_nullIsReturned() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            assertEquals(null, department.getManager(0));
        });
    }
}