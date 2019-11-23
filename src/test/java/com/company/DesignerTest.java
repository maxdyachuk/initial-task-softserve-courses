package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DesignerTest {

    private static final int TIMEOUT = 2000;
    private static Designer designer;

    @BeforeAll
    private static void designerInit() {
        designer = new Designer("Alex", "Smith", 500, 1, 1, null);
    }

    @Test
    public void setValidEffectivenessCoefficient_coeffIsLessThan0_coeffIsSetTo0() {
        setValidEffectivenessCoefficient_helper(0, -1);
    }

    @Test
    public void setValidEffectivenessCoefficient_coeffIsGreaterThan1_coeffIsSetTo1() {
        setValidEffectivenessCoefficient_helper(1, 2);
    }

    private void setValidEffectivenessCoefficient_helper(double expected, double effectivenessCoefficient) {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            designer.setEffectivenessCoefficient(effectivenessCoefficient);
            assertEquals(expected, designer.getEffectivenessCoefficient());
        });
    }

    @Test
    public void calculateSalary_coeffIsLessThan0_methodResultIsEqualToManualCalculation() {
        calculateSalary_helper(-2414);
    }

    @Test
    public void calculateSalary_coeffIsGreaterThan1_methodResultIsEqualToManualCalculation() {
        calculateSalary_helper(213);
    }


    private void calculateSalary_helper(double effectivenessCoefficient) {
        assertTimeout(Duration.ofMillis(TIMEOUT), () -> {
            designer.setEffectivenessCoefficient(effectivenessCoefficient);
            assertEquals(designer.getRate() * designer.getEffectivenessCoefficient(), designer.calculateSalary());
        });
    }
}