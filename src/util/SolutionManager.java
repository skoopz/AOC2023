package util;

import day.Day1;
import day.Solution;

public class SolutionManager {

    private Solution sol;

    public void selectDay(int day){

        switch(day){
            case 1 -> sol = new Day1();
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
        System.out.println("\t\tTotal runtime: " + (endTime-startTime)/1000 + "ms\n");

        startTime = System.nanoTime();

        result = sol.hard();

        endTime = System.nanoTime();

        System.out.println("\tHard:");
        System.out.println("\t\tResult: " + result);
        System.out.println("\t\tTotal runtime: " + (endTime-startTime)/1000 + "ms\n");

    }

}
