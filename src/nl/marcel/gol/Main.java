package nl.marcel.gol;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // an infinite grid at given moment time is defined by a finite set of alive cells
        // initial parameters:
        // Set of initial alive cells
        // number of evolutions
        // abstractions:
        // grid
        // cell

        // alive cell with 2 or 3 alive neigbours remains alive
        // rest of alive cells die
        // dead cell with 3 alive neighbours comes to live

        Integer MAXIMUM_EVOLUTION = 1000;

        Set<Cell> initialAliveCells = new HashSet<Cell>();
        //Block pattern (stable)
        initialAliveCells.add(new Cell(CellState.ALIVE,0,0));
        initialAliveCells.add(new Cell(CellState.ALIVE,0,1));
        initialAliveCells.add(new Cell(CellState.ALIVE,1,0));
        initialAliveCells.add(new Cell(CellState.ALIVE,1,1));
        //Blinker (Oscillator)
        initialAliveCells.add(new Cell(CellState.ALIVE,87,80));
        initialAliveCells.add(new Cell(CellState.ALIVE,88,80));
        initialAliveCells.add(new Cell(CellState.ALIVE,89,80));
        //Glider (Spaceship)
        initialAliveCells.add(new Cell(CellState.ALIVE,100,20));
        initialAliveCells.add(new Cell(CellState.ALIVE,101,20));
        initialAliveCells.add(new Cell(CellState.ALIVE,102,20));
        initialAliveCells.add(new Cell(CellState.ALIVE,102,21));
        initialAliveCells.add(new Cell(CellState.ALIVE,101,22));


        Grid grid = new Grid(initialAliveCells);
        grid.printAliveCells();

        for (Integer i = 1; i < MAXIMUM_EVOLUTION; i++) {
            if (grid.lives()) {
                grid.evolve();
                grid.printAliveCells();
            }
            else {
                System.out.println("Grid has died!");
            return;
            }
        }
    }
}
