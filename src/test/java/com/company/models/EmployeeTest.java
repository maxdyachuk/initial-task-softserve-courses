package com.company.models;

import com.company.models.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeTest {

    private static final int TIMEOUT = 2000;

    @Test
    public void calculateSalary_expIsLessThan2() {
        calculateSalary_helper(1, 1300, 1300);
    }

    @Test
    public void calculateSalary_expIsGreaterThan2AndLessThan5() {
        calculateSalary_helper(4, 3000, 3200);
    }

    @Test
    public void calculateSalary_expIsGreaterThan5() {
        calculateSalary_helper(6, 5000, 6500);
    }

    @Test
    public void calculateSalary_expIsEqualTo0() {
        calculateSalary_helper(0, 500, 500);
    }

    private void calculateSalary_helper(double experience, double rate, double expected) {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            Employee employee = Mockito.mock(Employee.class);
            when(employee.getExperience()).thenReturn(experience);
            when(employee.getRate()).thenReturn(rate);
            when(employee.calculateSalary()).thenCallRealMethod();
            assertEquals(expected, employee.calculateSalary());
        });
    }
}