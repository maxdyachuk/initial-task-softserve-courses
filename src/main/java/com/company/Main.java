package com.company;

public class Main {

    public static void main(String[] args) {
        Department department = new Department();

        Manager manager1 = new Manager("Ada", "Petersen", 2500, 4);
        department.addManager(manager1);
        manager1.addTeamMember(new Developer("Quintin", "Pennington", 4500, 7, manager1));
        manager1.addTeamMember(new Developer("Duncan", "Clarke", 3500, 5, manager1));
        manager1.addTeamMember(new Developer("Ayanna", "Wood", 3500, 5, manager1));
        manager1.addTeamMember(new Developer("Tim", "Lowell", 600, 0.5, manager1));
        manager1.addTeamMember(new Designer("Myla", "Bowman", 3000, 4, 1, manager1));
        manager1.addTeamMember(new Designer("Angelique", "Molina", 1500, 1.7, 0.8, manager1));

        Manager manager2 = new Manager("Amelia", "Heath", 1500, 2);
        department.addManager(manager2);
        manager2.addTeamMember(new Developer("Alex", "Smith", 500, 0, manager2));

        department.giveSalary();
    }
}
