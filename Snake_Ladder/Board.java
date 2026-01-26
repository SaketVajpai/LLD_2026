package Snake_Ladder;

import java.util.*;

public class Board {
    private final int size;
    private final List<Cell> cells;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    public Board(int size){
        this.size = size;
        cells = new ArrayList<>();
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        for(int i=1; i<=size; i++)
            cells.add(new Cell(i));
    }
    public int checkJump(int loc){
        for(Snake snake : this.snakes)
            if(snake.getStart() == loc)
                return snake.getEnd();
        for(Ladder ladder : this.ladders)
            if(ladder.getStart() == loc)
                return ladder.getEnd();
        return loc;
    }
    public void generateSnake(int st, int end){
        snakes.add(new Snake(st, end));
    }
    public void generateLadder(int st, int end){
        ladders.add(new Ladder(st, end));
    }
    public boolean checkWin(int location){
        return this.size == location;
    }
    public int getSize() {
        return size;
    }
    public List<Cell> getCells() {
        return cells;
    }
    public List<Snake> getSnakes() {
        return snakes;
    }
    public List<Ladder> getLadders() {
        return ladders;
    }
}
