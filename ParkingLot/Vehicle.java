package ParkingLot;

public class Vehicle {
    private final String regNo;
    private final VehicleType type;

    public Vehicle(String regNo, VehicleType type) {
        this.regNo = regNo;
        this.type = type;
    }

    public VehicleType getType() { return type; }
    public String getRegNo() { return regNo; }
}

