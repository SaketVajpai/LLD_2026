package ParkingLot;
import java.util.*;

public class Floor {
    private final List<Slot> slots;

    public Floor(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Slot> getSlots() { return slots; }
}
