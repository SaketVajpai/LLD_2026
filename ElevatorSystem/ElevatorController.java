package ElevatorSystem;
import java.util.*;

import ElevatorSystem.LiftStrategy.ElevatorSchedulingStrategy;
import ElevatorSystem.Requests.ExternalRequest;



public class ElevatorController {

    private final List<Elevator> elevators;
    private final ElevatorSchedulingStrategy strategy;

    public ElevatorController(List<Elevator> elevators,
                              ElevatorSchedulingStrategy strategy) {
        this.elevators = elevators;
        this.strategy = strategy;
    }

    public void handleExternalRequest(ExternalRequest request) {
        Elevator elevator = strategy.selectElevator(elevators, request);
        System.out.println("Request at floor " + request.getFloor()
                + " assigned to Elevator");
        elevator.addStop(request.getFloor());
    }
}









// public class ElevatorController {

//     private final List<Elevator> elevators;
//     private final ElevatorSchedulingStrategy strategy;

//     public ElevatorController(List<Elevator> elevators,
//                               ElevatorSchedulingStrategy strategy) {
//         this.elevators = elevators;
//         this.strategy = strategy;
//     }

//     public void handleExternalRequest(ExternalRequest request) {

//         Elevator elevator = strategy.selectElevator(elevators, request);

//         System.out.println("Assigning Elevator to floor " + request.getFloor());
//         elevator.addStop(request.getFloor());
//     }
// }
