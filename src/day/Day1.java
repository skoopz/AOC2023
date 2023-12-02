package day;

import util.storage.Pair;

import java.io.*;

public class Day1 implements Solution {

    private final boolean test = false;

    private final String INPUT_FOLDER = "inputs/";

    private final String filename;

    public Day1(){

        filename = (test) ? "test.txt" : "day1/input.txt";

    }

    public int easy() {

        Pair<Integer, Integer> current;

        try(Reader rd = new FileReader(INPUT_FOLDER + this.filename)){

            BufferedReader br = new BufferedReader(rd);

            int total = 0;

            for(String line = br.readLine(); line != null; line = br.readLine()){

                current = stringToPair(line);

                total += Integer.parseInt(current.toString());

            }

            return total;

        } catch (IOException e){
            System.out.println("ERROR: The file could not be found!");
        } catch (NumberFormatException e){
            System.out.println("ERROR: There was an error with the calculations!");
        }

        return -1;

    }

    @Override
    public int hard() {

        Pair<Integer, Integer> current;

        try(Reader rd = new FileReader(INPUT_FOLDER + this.filename)){

            BufferedReader br = new BufferedReader(rd);

            int total = 0;

            for(String line = br.readLine(); line != null; line = br.readLine()){

                line = convertNumbers(line);

                current = stringToPair(line);

                total += Integer.parseInt(current.toString());

            }

            return total;

        } catch (IOException e){
            System.out.println("ERROR: The file could not be found!");
        } catch (NumberFormatException e){
            System.out.println("ERROR: There was an error with the calculations!");
        }

        return -1;

    }

    private String convertNumbers(String line){

        line = line.replace("one", "o1e");
        line = line.replace("two", "t2");
        line = line.replace("three", "3");
        line = line.replace("four", "4");
        line = line.replace("five", "5");
        line = line.replace("six", "6");
        line = line.replace("seven", "7");
        line = line.replace("eight", "8");
        line = line.replace("nine", "9");

        return line;

    }

    private Pair<Integer, Integer> stringToPair(String line){

        int first = -1;
        int second = -1;

        for(char l : line.toCharArray()){

            if(Character.isDigit(l)){

                if(first < 0) {
                    first = Character.getNumericValue(l);
                    continue;
                }

                second = Character.getNumericValue(l);

            }

        }

        if(first < 0) first = 0;

        if(second < 0) second = first;

        return new Pair<>(first, second);

    }

    @Override
    public int getId(){
        return 1;
    }

}
