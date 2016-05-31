package nl.marcel.gol;

import java.util.*;

/**
 * Created by mgoris on 5-5-2016.
 */
public class Grid {
    private Integer evolution = -1; // Undefined
    private Set<Cell> aliveCells;


    public Grid(Set<Cell> initialAliveCells) {
        this.evolution = 0;
        this.aliveCells = initialAliveCells;
    }

    public void printAliveCells() {
        System.out.println("Evolution:" + evolution);
        for (Cell cell : this.aliveCells) {
            cell.print();
        }
    }

    public boolean lives(){
        return !(aliveCells.isEmpty());
    }

    public void evolve() {
        if (evolution < 0) {
            System.out.println("Invalid evolution value");
        } else {
            evolution = evolution + 1;
            // For every alive cell, evaluate the new state of all its direct neighbours and itself
            // Append alive cells to a new array that is to be switched with the current

            Set<Cell> nextAliveCells = new HashSet<Cell>();
            Set<Cell> neighbours = new HashSet<Cell>();
            for (Cell cell : this.aliveCells) {
                // Determine if it will survive itself
                if (cellWillLive(cell, 2, 3)) {
                    nextAliveCells.add(cell);
                }
                // animate (neighbouring) dead cells when exactly 3 of its neighbours are alive
                neighbours.clear();
                Cell neighbourLeftTop = new Cell(CellState.ALIVE, cell.getX() - 1, cell.getY() + 1);
                Cell neighbourMiddleTop = new Cell(CellState.ALIVE, cell.getX(), cell.getY() + 1);
                Cell neighbourRightTop = new Cell(CellState.ALIVE, cell.getX() + 1, cell.getY() + 1);
                Cell neighbourRightMiddle = new Cell(CellState.ALIVE, cell.getX() + 1, cell.getY());
                Cell neighbourRightBottom = new Cell(CellState.ALIVE, cell.getX() + 1, cell.getY() - 1);
                Cell neighbourMiddleBottom = new Cell(CellState.ALIVE, cell.getX(), cell.getY() - 1);
                Cell neighbourLeftBottom = new Cell(CellState.ALIVE, cell.getX() - 1, cell.getY() - 1);
                Cell neighbourLeftMiddle = new Cell(CellState.ALIVE, cell.getX() - 1, cell.getY());
                neighbours.add(neighbourLeftTop);
                neighbours.add(neighbourMiddleTop);
                neighbours.add(neighbourRightTop);
                neighbours.add(neighbourRightMiddle);
                neighbours.add(neighbourRightBottom);
                neighbours.add(neighbourMiddleBottom);
                neighbours.add(neighbourLeftBottom);
                neighbours.add(neighbourLeftMiddle);
                for (Cell neighbour : neighbours) {
                    if (!(this.aliveCells.contains(neighbour)) && (cellWillLive(neighbour, 3, 3))) {
                        nextAliveCells.add(neighbour);
                    }
                }


            }
            this.aliveCells = nextAliveCells;
        }
    }

    public boolean cellWillLive(Cell cell, Integer lowerBound, Integer upperBound) {
        // TODO determine neighbours and rules
        Integer aliveNeighboursCounter = 0;
        Cell neighbourLeftTop = new Cell(CellState.ALIVE, cell.getX() - 1, cell.getY() + 1);
        Cell neighbourMiddleTop = new Cell(CellState.ALIVE, cell.getX(), cell.getY() + 1);
        Cell neighbourRightTop = new Cell(CellState.ALIVE, cell.getX() + 1, cell.getY() + 1);
        Cell neighbourRightMiddle = new Cell(CellState.ALIVE, cell.getX() + 1, cell.getY());
        Cell neighbourRightBottom = new Cell(CellState.ALIVE, cell.getX() + 1, cell.getY() - 1);
        Cell neighbourMiddleBottom = new Cell(CellState.ALIVE, cell.getX(), cell.getY() - 1);
        Cell neighbourLeftBottom = new Cell(CellState.ALIVE, cell.getX() - 1, cell.getY() - 1);
        Cell neighbourLeftMiddle = new Cell(CellState.ALIVE, cell.getX() - 1, cell.getY());


        if (aliveCells.contains(neighbourLeftTop)) {
            aliveNeighboursCounter += 1;
        }
        if (aliveCells.contains(neighbourMiddleTop)) {
            aliveNeighboursCounter += 1;
        }
        if (aliveCells.contains(neighbourRightTop)) {
            aliveNeighboursCounter += 1;
        }
        if (aliveCells.contains(neighbourRightMiddle)) {
            aliveNeighboursCounter += 1;
        }
        if (aliveCells.contains(neighbourRightBottom)) {
            aliveNeighboursCounter += 1;
        }
        if (aliveCells.contains(neighbourMiddleBottom)) {
            aliveNeighboursCounter += 1;
        }
        if (aliveCells.contains(neighbourLeftBottom)) {
            aliveNeighboursCounter += 1;
        }
        if (aliveCells.contains(neighbourLeftMiddle)) {
            aliveNeighboursCounter += 1;
        }

        if (aliveNeighboursCounter >= lowerBound && aliveNeighboursCounter <= upperBound) {
            return true;
        } else {
            return false;
        }
    }
}




