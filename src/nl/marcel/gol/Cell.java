package nl.marcel.gol;

/**
 * Created by mgoris on 5-5-2016.
 */
public class Cell {
    private CellState state;
    private Integer x;
    private Integer y;

    public Cell(CellState state, Integer x, Integer y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public CellState getState() {
        return state;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void print(){
        System.out.println("X: " + x + " Y: " + y + " State: " + state);
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cell)) {
            return false;
        }

        Cell that = (Cell) other;

        // Custom equality check here.
        return this.state.equals(that.getState())
                && this.x.equals(that.getX())
                && this.y.equals(that.getY());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 37 + this.state.hashCode();
        hashCode = hashCode * 37 + this.x.hashCode();
        hashCode = hashCode * 37 + this.y.hashCode();

        return hashCode;
    }

}
