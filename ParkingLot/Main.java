package ParkingLot;

import java.util.*;

import ParkingLot.Payment.Payment;
import ParkingLot.Payment.PaymentFactory;
import ParkingLot.SlotStrategy.NearestSlotStrategy;
import ParkingLot.SlotStrategy.SlotAllocationStrategy;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // -------- Create Slots --------
        List<Slot> floor1Slots = Arrays.asList(
                new Slot(1, VehicleType.BIKE),
                new Slot(2, VehicleType.CAR),
                new Slot(3, VehicleType.CAR),
                new Slot(4, VehicleType.TRUCK)
        );

        List<Slot> floor2Slots = Arrays.asList(
                new Slot(5, VehicleType.BIKE),
                new Slot(6, VehicleType.CAR),
                new Slot(7, VehicleType.TRUCK)
        );

        // -------- Create Floors --------
        Floor floor1 = new Floor(floor1Slots);
        Floor floor2 = new Floor(floor2Slots);

        // -------- Create Parking Lot --------
        ParkingLot parkingLot = new ParkingLot(Arrays.asList(floor1, floor2));

        // -------- Slot Allocation Strategy --------
        SlotAllocationStrategy strategy = new NearestSlotStrategy();

        // -------- Initialize Parking Service (Singleton) --------
        ParkingService service = ParkingService.getInstance(parkingLot, strategy);

        // -------- Create Vehicles --------
        Vehicle car = new Vehicle("KA-01-1234", VehicleType.CAR);
        Vehicle bike = new Vehicle("KA-02-5678", VehicleType.BIKE);

        // -------- Park Vehicles --------
        Ticket carTicket = service.park(car);
        System.out.println("Car parked. Ticket ID: " + carTicket.getId());

        Ticket bikeTicket = service.park(bike);
        System.out.println("Bike parked. Ticket ID: " + bikeTicket.getId());

        // Simulate time spent in parking
        Thread.sleep(2000);

        // -------- Unpark Car --------
        int carAmount = service.unpark(carTicket.getId());
        System.out.println("Car unparked. Amount to pay: " + carAmount);

        Payment carPayment = PaymentFactory.get("CARD");
        carPayment.pay(carAmount);

        // -------- Unpark Bike --------
        int bikeAmount = service.unpark(bikeTicket.getId());
        System.out.println("Bike unparked. Amount to pay: " + bikeAmount);

        Payment bikePayment = PaymentFactory.get("CASH");
        bikePayment.pay(bikeAmount);

        System.out.println("Parking simulation completed.");
    }
}
