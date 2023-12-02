package day;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Day2 implements Solution {

    private final boolean test = false;

    private final String INPUT_FOLDER = "inputs/";

    private int powerSum = 0;

    private boolean isCorrect = true;

    private final String filename;

    public Day2(){

        filename = (test) ? "test.txt" : "day2/input.txt";

    }

    @Override
    public int easy() {

        int[] maxCubes = {-1, -1, -1};

        try(Reader rd = new FileReader(INPUT_FOLDER + this.filename)){

            BufferedReader br = new BufferedReader(rd);

            int total = 0;

            for(String line = br.readLine(); line != null; line = br.readLine()){

                String[] id_content = line.split(": ");

                int current_id = Integer.parseInt(id_content[0].split(" ")[1]);

                String[] sets = id_content[1].split("; ");

                for(String set : sets){

                    checkSet(set, maxCubes);

                }

                powerSum += (maxCubes[0] * maxCubes[1] * maxCubes[2]);

                resetCubes(maxCubes);

                if(this.isCorrect) total += current_id;

                this.isCorrect = true;

            }

            return total;

        } catch (IOException e){
            System.out.println("ERROR: The file could not be found!");
        } catch (NumberFormatException e){
            System.out.println("ERROR: There was an error with the calculations!");
        }

        return 0;

    }

    private void checkSet(String set, int[] maxCubes){

        int[] totalCubes = {12, 13, 14};

        String[] elements = set.split(", ");

        for(String element : elements){

            String[] qty_name = element.split(" ");

            int qty = Integer.parseInt(qty_name[0]);

            if(qty_name[1].equals("red")){

                if(qty > totalCubes[0]){
                    this.isCorrect = false;
                }

                maxCubes[0] = Math.max(maxCubes[0], qty);

            } else if(qty_name[1].equals("green")){

                if(qty > totalCubes[1]){
                    this.isCorrect = false;
                }

                maxCubes[1] = Math.max(maxCubes[1], qty);

            } else {

                if(qty > totalCubes[2]){
                    this.isCorrect = false;
                }

                maxCubes[2] = Math.max(maxCubes[2], qty);

            }

        }

    }

    public void resetCubes(int[] maxCubes){

        maxCubes[0] = -1;
        maxCubes[1] = -1;
        maxCubes[2] = -1;

    }

    @Override
    public int hard() {
        return powerSum;
    }

    @Override
    public int getId(){
        return 2;
    }


}
