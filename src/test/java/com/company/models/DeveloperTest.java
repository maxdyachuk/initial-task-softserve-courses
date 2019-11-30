package com.company.models;

import com.company.models.Developer;
import com.company.exceptions.InvalidExperienceValueException;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    private static final int TIMEOUT = 2000;

    @Test
    public void createInstanceOfEmployeeWithExpLessThan0_invalidExperienceValueExceptionThrown() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            assertThrows(InvalidExperienceValueException.class, () -> new Developer("Alex", "Smith", 500, -1, null));
        });
    }

    @Test
    public void createInstanceOfEmployeeWithExpGreaterThan0_employeeIsCreated() {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            new Developer("Alex", "Smith", 500, 1, null);
        });
    }
}