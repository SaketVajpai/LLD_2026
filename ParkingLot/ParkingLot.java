package ParkingLot;
import java.util.*;

public class ParkingLot {
    private final List<Floor> floors;

    public ParkingLot(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Floor> getFloors() { return floors; }
}
