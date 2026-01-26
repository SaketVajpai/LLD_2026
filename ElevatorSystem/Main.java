package ElevatorSystem;

import java.util.Arrays;
import ElevatorSystem.LiftStrategy.ElevatorSchedulingStrategy;
import ElevatorSystem.LiftStrategy.NearestElevatorStrategy;
import ElevatorSystem.Requests.*;
import java.util.List;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        Elevator e1 = new Elevator(1);
        Elevator e2 = new Elevator(2);

        List<Elevator> elevators = Arrays.asList(e1, e2);

        ElevatorSchedulingStrategy strategy =
                new NearestElevatorStrategy();

        ElevatorController controller =
                new ElevatorController(elevators, strategy);

        // Start elevators as threads
        new Thread(e1).start();
        new Thread(e2).start();

        Building building = new Building(10, controller);

        // Simulate floor requests
        building.getFloor(3).pressUp();
        building.getFloor(7).pressDown();

        // Simulate internal request after some time
        Thread.sleep(3000);
        e1.handleInternalRequest(new InternalRequest(9));
    }
}














// public class Main {

//     public static void main(String[] args) {

//         Elevator e1 = new Elevator(1);
//         Elevator e2 = new Elevator(2);

//         List<Elevator> elevators = Arrays.asList(e1, e2);

//         ElevatorSchedulingStrategy strategy = new NearestElevatorStrategy();

//         ElevatorController controller =
//                 new ElevatorController(elevators, strategy);

//         // External requests from floors
//         controller.handleExternalRequest(
//                 new ExternalRequest(5, Direction.UP));

//         controller.handleExternalRequest(
//                 new ExternalRequest(2, Direction.DOWN));

//         // Internal request inside elevator
//         e1.handleInternalRequest(new InternalRequest(8));

//         // Start elevators
//         e1.move();
//         e2.move();
//     }
// }
