package util.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Grid {

    protected char[][] grid;

    public int size;

    public Grid(String file){

        parseGrid(file);

    }

    private void parseGrid(String file){

        try(FileReader rd = new FileReader(file)){

            this.size = (int)Files.lines(Path.of(file)).count();

            this.grid = new char[this.size][this.size];

            BufferedReader br = new BufferedReader(rd);

            int i = 0;

            for(String line = br.readLine(); line != null; line = br.readLine(), i++){

                grid[i] = line.toCharArray();

            }

        } catch (IOException e){

            System.out.println("ERROR: Could not parse the grid!");

        }

    }

    public char get(int x, int y){

        return this.grid[y][x];

    }

}
