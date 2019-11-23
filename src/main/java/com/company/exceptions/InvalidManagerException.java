package com.company.exceptions;

public class InvalidManagerException extends RuntimeException {

    public InvalidManagerException() {}

    @Override
    public String toString() {
        return "InvalidManagerException: Can not add this type of employee as a manager";
    }
}
