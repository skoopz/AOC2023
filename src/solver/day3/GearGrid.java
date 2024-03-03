package solver.day3;

import util.storage.Grid;
import util.storage.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GearGrid extends Grid {

    private final ArrayList<Pair<Integer,Integer>> marked;

    private final Map<String, ArrayList<Integer>> gears;

    private boolean gearMode;

    public GearGrid(String file) {

        super(file);

        this.marked = new ArrayList<>();
        this.gears = new HashMap<>();

        gearMode = false;

    }

    public void mark(int x, int y){

        this.marked.add(new Pair<>(x, y));

    }

    public boolean checkMarked(int ratio){

        for(int i = 0; i < marked.size(); i++){

            Pair<Integer, Integer> p = marked.get(i);

            if(checkNeighbours(p.first(), p.second(), ratio)){
                clearMarked();
                return true;
            }

        }

        clearMarked();

        return false;

    }

    public void clearMarked(){

        this.marked.clear();

    }

    private boolean checkNeighbours(int x, int y, int ratio){

        for (int i = -1; i <= 1; i++) {

            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) continue; // Skip the center point

                int newX = x + i;
                int newY = y + j;

                // Check if the position is within the grid boundaries
                if (newX >= 0 && newX < this.size && newY >= 0 && newY < this.size) {

                    char current = super.grid[newY][newX];

                    if(current != '.' && !Character.isDigit(current) && !gearMode) return true;
                    else if (current == '*' && gearMode){

                        String index = newX + "-" + newY;

                        this.gears.computeIfAbsent(index, k -> new ArrayList<Integer>());

                        this.gears.get(index).add(ratio);

                        return true;

                    }

                }

            }

        }

        return false;

    }

    public void enableGear(){

        this.gearMode = true;

    }

    public int getRatios(){

        int total = 0;

        for(String key : gears.keySet()){

            ArrayList<Integer> ratios = gears.get(key);

            if(ratios.size() == 2){
                total += ratios.get(0) * ratios.get(1);
            }

        }

        return total;

    }

}
