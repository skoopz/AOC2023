package solver.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Deck {

    private final Map<Integer, Integer> copies;

    private int lastId;

    public Deck(){

        this.copies = new HashMap<>();

        this.lastId = 0;

        ArrayList<Integer> list = new ArrayList<>();

    }

    public void addCard(Card card){

        int matches = card.findMatches();

        int currentId = card.getId();

        this.lastId = currentId;

        this.copies.put(currentId, this.copies.getOrDefault(currentId, 1));

        if (matches > 0) {

            int currentCopies = this.copies.get(currentId);
            
            for (int i = currentId + 1; i <= (matches + currentId); i++) {
                
                this.copies.put(i, this.copies.getOrDefault(i, 1) + currentCopies);
                
            }

        }
        
    }

    public int findTotalCards(){

        int total = 0;

        for (int i = 1; i <= this.lastId; i++) {
            
            total += this.copies.getOrDefault(i, 0);

        }

        return total;

    }
    
}
