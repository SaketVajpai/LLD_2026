package ElevatorSystem;

import java.util.PriorityQueue;
import ElevatorSystem.Requests.*;


public class Elevator implements Runnable {

    private final int id;
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;

    private final PriorityQueue<Integer> upStops = new PriorityQueue<>();
    private final PriorityQueue<Integer> downStops =
            new PriorityQueue<>((a, b) -> b - a);

    public Elevator(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public synchronized void addStop(int floor) {
        if (floor > currentFloor) {
            upStops.add(floor);
        } else {
            downStops.add(floor);
        }
        notify(); // wake elevator if waiting
    }

    public synchronized void handleInternalRequest(InternalRequest request) {
        addStop(request.getFloor());
    }

    private void moveToFloor(int floor) throws InterruptedException {
        System.out.println("Elevator " + id +
                " moving from " + currentFloor + " to " + floor);
        Thread.sleep(1000);
        currentFloor = floor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                processStops();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private synchronized void processStops() throws InterruptedException {

        while (upStops.isEmpty() && downStops.isEmpty()) {
            direction = Direction.IDLE;
            wait();
        }

        if (!upStops.isEmpty()) {
            direction = Direction.UP;
            int next = upStops.poll();
            moveToFloor(next);
        }

        if (!downStops.isEmpty()) {
            direction = Direction.DOWN;
            int next = downStops.poll();
            moveToFloor(next);
        }
    }
}











// public class Elevator {

//     private final int id;
//     private int currentFloor = 0;
//     private Direction direction = Direction.IDLE;

//     private final PriorityQueue<Integer> upStops = new PriorityQueue<>();
//     private final PriorityQueue<Integer> downStops =
//             new PriorityQueue<>((a, b) -> b - a);

//     public Elevator(int id) {
//         this.id = id;
//     }

//     public int getCurrentFloor() {
//         return currentFloor;
//     }

//     public Direction getDirection() {
//         return direction;
//     }

//     public synchronized void addStop(int floor) {
//         if (floor > currentFloor) {
//             upStops.add(floor);
//         } else {
//             downStops.add(floor);
//         }
//     }

//     public synchronized void handleInternalRequest(InternalRequest request) {
//         addStop(request.getFloor());
//     }

//     public void move() {

//         while (!upStops.isEmpty() || !downStops.isEmpty()) {

//             if (!upStops.isEmpty()) {
//                 direction = Direction.UP;
//                 int next = upStops.poll();
//                 goToFloor(next);
//             }

//             if (!downStops.isEmpty()) {
//                 direction = Direction.DOWN;
//                 int next = downStops.poll();
//                 goToFloor(next);
//             }
//         }

//         direction = Direction.IDLE;
//     }

//     private void goToFloor(int floor) {
//         System.out.println("Elevator " + id +
//                 " moving from " + currentFloor + " to " + floor);
//         currentFloor = floor;
//     }
// }
