package solver.day4;

import java.util.ArrayList;

public class Card {

    private final int id;

    private final ArrayList<Integer> owned;

    private final ArrayList<Integer> winner;

    public Card(String data){

        this.owned = new ArrayList<>();

        this.winner = new ArrayList<>();
        
        String[] nameAndNums = data.split(":");

        this.id = Integer.parseInt(nameAndNums[0].split(" ")[1]);

        String[] winnerAndOwned = nameAndNums[1].split("\\|");

        loadValues(winnerAndOwned[0].trim(), this.winner);

        loadValues(winnerAndOwned[1].trim(), this.owned);

    }

    private void loadValues(String data, ArrayList<Integer> list){

        String[] values = data.split(" ");

        for (String value : values) {

            list.add(Integer.parseInt(value));

        }

    }

    public int findPoints(){

        int points = 0;

        for (int num : owned) {

            if (winner.contains(num)) {

                points = (points == 0) ? 1 : points * 2;

            }

        }

        return points;

    }

    public int findMatches(){

        int matching = 0;

        for (int num : owned) {

            if (winner.contains(num)) {

                matching++;

            }

        }

        return matching;

    }

    public int getId(){
        return this.id;
    }

}
