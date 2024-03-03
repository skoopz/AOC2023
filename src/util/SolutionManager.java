package util;

import day.*;

import java.util.ArrayList;

public class SolutionManager {

    private Solution sol;

    private final ArrayList<Long> allTimes;

    public SolutionManager(){

        allTimes = new ArrayList<>();

    }

    public void selectDay(int day){

        switch(day){
            case 1 -> sol = new Day1();
            case 2 -> sol = new Day2();
            case 3 -> sol = new Day3();
        }

    }

    public void runSolution(){

        System.out.println("\nSolution of day " + sol.getId() + ":");

        int result;

        long startTime = System.nanoTime();

        result = sol.easy();

        long endTime = System.nanoTime();

        System.out.println("\tEasy:");
        System.out.println("\t\tResult: " + result);
        System.out.println("\t\tTotal runtime: " + (endTime-startTime) / 1000 + "ms\n");

        startTime = System.nanoTime();

        result = sol.hard();

        endTime = System.nanoTime();

        System.out.println("\tHard:");
        System.out.println("\t\tResult: " + result);
        System.out.println("\t\tTotal runtime: " + (endTime-startTime) / 1000 + "ms");

    }

    public void runAll(int days){

        for(int i = 1; i <= days; i++){

            selectDay(i);

            runSolution();

        }

    }

}
