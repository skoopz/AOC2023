package day;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import solver.day4.Card;
import solver.day4.Deck;

public class Day4 implements Solution {

    private final String filename;

    private boolean isHard = false;

    private final boolean test = false;

    public Day4(){

        filename = (test) ? "test.txt" : "day4/input.txt";

    }

    @Override
    public int easy() {

        Deck deck = new Deck();

        try(Reader rd = new FileReader(INPUT_FOLDER + this.filename)){

            BufferedReader br = new BufferedReader(rd);

            int total = 0;

            for(String line = br.readLine(); line != null; line = br.readLine()){

                Card card = new Card(line.replaceAll(" +", " "));

                deck.addCard(card);

                total += card.findPoints();

            }

            return (isHard) ? deck.findTotalCards() : total;

        } catch (IOException e){
            e.printStackTrace();
        }

        return 0;

    }

    @Override
    public int hard() {

        this.isHard = true;

        return this.easy();

    }

    @Override
    public int getId() {
        return 4;
    }



}
