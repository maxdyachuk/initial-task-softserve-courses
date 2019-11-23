package com.company.exceptions;

public class InvalidTeamMemberException extends RuntimeException {

    public InvalidTeamMemberException() {}

    @Override
    public String toString() {
        return "InvalidTeamMemberException: Can not add this type of employee to the team";
    }
}
