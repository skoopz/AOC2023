package util;

import java.util.Scanner;

public class MenuManager {

    private final SolutionManager sm;
    private final int days;

    public MenuManager(){

        sm = new SolutionManager();

        days = 1;

    }

    public boolean showMenu(){

        Scanner sc = new Scanner(System.in);

        int option = -1;

        System.out.println("""
                Welcome to skoopz's AOC2023 solutions!
                
                Please select the day you want to run:""");

        while(true){

            for(int i = 0; i < days; i++){
                System.out.println("\t" + (i+1) + ") Day " + (i+1));
            }

            System.out.println("\t" + (days + 1) + ") Exit");

            System.out.print("Your selection: ");

            if(sc.hasNextInt()){
                if(option == days + 1) return false;
                else {
                    sm.selectDay(sc.nextInt());
                    return true;
                }
            } else {
                System.out.println("ERROR: Please select a number from 1 to " + (days + 1) + ":");
                sc.next();
            }

        }

    }

    public void showDayResults(){

        sm.runSolution();

    }

}
