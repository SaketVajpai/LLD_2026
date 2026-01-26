package ParkingLot;

import ParkingLot.PricingStrategy.PricingFactory;
import ParkingLot.PricingStrategy.PricingStrategy;
import ParkingLot.SlotStrategy.SlotAllocationStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingService {

    private static ParkingService instance;
    private final ParkingLot lot;
    private final SlotAllocationStrategy strategy;

    private final ConcurrentHashMap<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    private ParkingService(ParkingLot lot, SlotAllocationStrategy strategy) {
        this.lot = lot;
        this.strategy = strategy;
    }

    public static synchronized ParkingService getInstance(
            ParkingLot lot,
            SlotAllocationStrategy strategy) {

        if (instance == null) {
            instance = new ParkingService(lot, strategy);
        }
        return instance;
    }

    public synchronized Ticket park(Vehicle v) {
        Slot slot = strategy.findSlot(lot, v.getType());
        if (slot == null) throw new RuntimeException("No slot");

        slot.occupy();
        Ticket t = new Ticket(v, slot);
        activeTickets.put(t.getId(), t);
        return t;
    }

    public synchronized int unpark(String ticketId) {
        Ticket t = activeTickets.remove(ticketId);

        t.getSlot().vacate();

        long hours = Duration.between(
                t.getEntryTime(),
                LocalDateTime.now()).toHours() + 1;

        PricingStrategy ps = PricingFactory.get(t.getVehicle().getType());
        return ps.calculate(hours);
    }
}
