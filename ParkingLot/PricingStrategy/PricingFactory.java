package ParkingLot.PricingStrategy;

import ParkingLot.VehicleType;

public class PricingFactory {
    public static PricingStrategy get(VehicleType type) {
        switch (type) {
            case BIKE: return h -> (int)(h * 20);
            case CAR: return new CarPricing();
            default: return h -> (int)(h * 80);
        }
    }
}
