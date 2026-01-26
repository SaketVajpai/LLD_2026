package ParkingLot.Payment;

public class PaymentFactory {
    public static Payment get(String mode) {
        if (mode.equals("CARD")) return amt -> true;
        return amt -> true;
    }
}

