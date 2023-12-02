package util;

import java.util.Scanner;

public class MenuManager {

    private final SolutionManager sm;

    private final int days;

    private boolean runAll;

    public MenuManager(){

        sm = new SolutionManager();

        runAll = false;

        days = 2;

    }

    public boolean showMenu(){

        Scanner sc = new Scanner(System.in);

        int option;

        System.out.println("""
                Welcome to skoopz's AOC2023 solutions!
                
                Please select the day you want to run:""");

        while(true){

            for(int i = 0; i < days; i++){
                System.out.println("\t" + (i+1) + ") Day " + (i+1));
            }

            System.out.println("\t" + (days + 1) + ") Run all days");
            System.out.println("\t" + (days + 2) + ") Exit");

            System.out.print("Your selection: ");

            option = (sc.hasNextInt()) ? sc.nextInt() : -1;

            if(option > 0 && option <= (days + 2)){

                if(option == days + 2) return false;
                else {
                    if(option != days + 1) sm.selectDay(option);
                    else runAll = true;
                    return true;
                }

            } else {
                System.out.print("ERROR: Please select a number from 1 to " + (days + 2) + ": ");
                sc.next();
            }

        }

    }

    public void showDayResults(){

        if(runAll) sm.runAll(days);
        else sm.runSolution();

    }

}
