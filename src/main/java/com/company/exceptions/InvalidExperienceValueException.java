package com.company.exceptions;

public class InvalidExperienceValueException extends RuntimeException {

    public InvalidExperienceValueException() {
    }

    @Override
    public String toString() {
        return "InvalidExperienceValueException: Can not create employee with invalid experience value";
    }
}
