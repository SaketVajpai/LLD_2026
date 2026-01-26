package ParkingLot;

public class Slot {
    private final int id;
    private final VehicleType supportedType;
    private boolean free = true;

    public Slot(int id, VehicleType type) {
        this.id = id;
        this.supportedType = type;
    }

    public synchronized boolean isFree() { return free; }

    public synchronized void occupy() { free = false; }

    public synchronized void vacate() { free = true; }

    public VehicleType getSupportedType() { return supportedType; }
}
