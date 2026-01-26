package ParkingLot.SlotStrategy;

import ParkingLot.ParkingLot;
import ParkingLot.Slot;
import ParkingLot.VehicleType;

public interface SlotAllocationStrategy {
    Slot findSlot(ParkingLot lot, VehicleType type);
}
