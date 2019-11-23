package com.company;

import com.company.exceptions.InvalidTeamMemberException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private static final int TIMEOUT = 2000;
    private static Manager manager;

    @BeforeAll
    private static void managerInit() {
        manager = new Manager("Alex", "Smith", 500, 1);
    }

    @Test
    public void addTeamMember_addManager_invalidTeamMemberExceptionThrown() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            assertThrows(InvalidTeamMemberException.class, () -> {
                manager.addTeamMember(Mockito.mock(Manager.class));
            });
        });
    }

    @Test
    public void removeTeamMember_removeDeveloperWhichExists_developerIsRemoved() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            Employee developer = Mockito.mock(Developer.class);
            manager.addTeamMember(developer);
            boolean isRemoved = manager.removeTeamMember(developer);
            assertEquals(true, isRemoved);
        });
    }

    @Test
    public void removeTeamMember_removeDesignerWhichDoesntExist_nothingToRemove() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            boolean isRemoved = manager.removeTeamMember(Mockito.mock(Designer.class));
            assertEquals(false, isRemoved);
        });
    }

    @Test
    public void getTeamMember_getEmployeeWhichExists_employeeIsReturned() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            Employee employee = Mockito.mock(Developer.class);
            manager.addTeamMember(employee);
            assertEquals(employee, manager.getTeamMember(0));
            manager.removeTeamMember(employee);
        });
    }

    @Test
    public void getTeamMember_getEmployeeWhichDoesntExist_nullIsReturned() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            assertEquals(null, manager.getTeamMember(0));
        });
    }

    @Test
    public void calculateSalary_teamSizeLessThan5AndLessThanHalfAreDevelopers_correctCalculation() {
        calculateSalary_helper(500, 1, 2);
    }

    @Test
    public void calculateSalary_teamSizeGreaterThan5AndMoreThanHalfAreDevelopers_correctCalculation() {
        calculateSalary_helper(770.0000000000001, 4, 2);
    }

    @Test
    public void calculateSalary_teamSizeGreaterThan10AndLessThanHalfAreDevelopers_correctCalculation() {
        calculateSalary_helper(800, 4, 7);
    }

    private void calculateSalary_helper(double expected, int developersNumber, int designersNumber) {
        Manager manager = new Manager("Alex", "Smith", 500, 1);
        IntStream.range(0, developersNumber).mapToObj(i -> Mockito.mock(Developer.class)).forEach(manager::addTeamMember);
        IntStream.range(0, designersNumber).mapToObj(i -> Mockito.mock(Designer.class)).forEach(manager::addTeamMember);
        assertEquals(expected, manager.calculateSalary());
    }
}