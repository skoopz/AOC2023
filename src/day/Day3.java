package day;

import solver.day3.GearGrid;

import java.util.ArrayList;

public class Day3 implements Solution {

    private final String filename;

    private final boolean test = false;

    private final ArrayList<Character> number;

    private boolean findGear;

    public Day3(){

        filename = (test) ? "test.txt" : "day3/input.txt";

        number = new ArrayList<>();

        findGear = false;

    }

    private int convertNumber(){

        StringBuilder sb = new StringBuilder();

        try {

            for (Character c : number) {

                sb.append(c);

            }

            number.clear();

            return Integer.parseInt(sb.toString());

        } catch (NumberFormatException e){
            return 0;
        }

    }

    private int peekNumber(){

        StringBuilder sb = new StringBuilder();
        
        try {

            for (Character c : number) {

                sb.append(c);

            }

            return Integer.parseInt(sb.toString());

        } catch (NumberFormatException e){
            return 0;
        }
        
    }

    @Override
    public int easy(){

        GearGrid grid = new GearGrid(INPUT_FOLDER + filename);

        int total = 0;

        if(findGear) grid.enableGear();

        for(int i = 0; i < grid.size; i++){

            for(int j = 0; j < grid.size; j++){

                char current = grid.get(j, i);

                if(Character.isDigit(current)){

                    number.add(current);
                    grid.mark(j, i);

                } else if(!number.isEmpty() && grid.checkMarked(peekNumber())){

                    total += this.convertNumber();

                } else this.number.clear();

            }

        }

        if(findGear) return grid.getRatios();

        return total;

    }

    @Override
    public int hard(){

        findGear = true;

        return easy();

    }

    @Override
    public int getId(){
        return 3;
    }



}
