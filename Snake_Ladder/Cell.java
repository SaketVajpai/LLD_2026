package Snake_Ladder;

public class Cell {
    private int location;
    Cell(int location){
        this.location = location;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
}