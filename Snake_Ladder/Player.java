package Snake_Ladder;

public class Player {
    private final String name;
    private Cell cell;
    Player(String name, Cell cell){
        this.name = name;
        this.cell = cell;
    }
    public String getName() {
        return name;
    }
    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
