package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("First application task: ");
        FirstApplicationTask firstTaskA = new FirstApplicationTask(6, 90, 10);
        firstTaskA.generateApplication();
        System.out.println("All applications:");
        firstTaskA.printAllApplications();
        List<Application> applications = firstTaskA.solve();
        System.out.println("===================================");
        System.out.println("First task (a) solution:");
        for (Application application : applications) {
            System.out.println(application);
        }

        FirstApplicationTask firstTaskB = new FirstApplicationTask(7, 120, 15);
        firstTaskB.generateApplication();
        applications = firstTaskB.solve();
        System.out.println("===================================");
        System.out.println("First task (b) solution:");
        for (Application application : applications) {
            System.out.println(application);
        }
        System.out.println("===================================");
        System.out.println("Second application task: ");
        SecondTask secondTask = new SecondTask();
        secondTask.generateItems();
        int stolenSum = secondTask.solve();
        System.out.println("Second task solution: " + stolenSum + "/468");

    }

}