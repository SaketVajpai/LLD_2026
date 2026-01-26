package ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String id = UUID.randomUUID().toString();
    private final Slot slot;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime = LocalDateTime.now();

    public Ticket(Vehicle vehicle, Slot slot) {
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public LocalDateTime getEntryTime() { return entryTime; }
    public Vehicle getVehicle() { return vehicle; }
    public Slot getSlot() { return slot; }
    public String getId() { return id; }

}
