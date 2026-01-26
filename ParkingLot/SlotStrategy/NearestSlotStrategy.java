package ParkingLot.SlotStrategy;

import ParkingLot.Floor;
import ParkingLot.ParkingLot;
import ParkingLot.Slot;
import ParkingLot.VehicleType;

public class NearestSlotStrategy implements SlotAllocationStrategy {
    public Slot findSlot(ParkingLot lot, VehicleType type) {
        for (Floor floor : lot.getFloors()) {
            for (Slot slot : floor.getSlots()) {
                if (slot.isFree() && slot.getSupportedType() == type) {
                    return slot;
                }
            }
        }
        return null;
    }
}
