package ParkingLot.PricingStrategy;

public class CarPricing implements PricingStrategy {
    public int calculate(long hours) { return (int) (hours * 50); }
}

