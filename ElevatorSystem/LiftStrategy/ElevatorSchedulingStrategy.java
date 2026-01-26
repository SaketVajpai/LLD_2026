package ElevatorSystem.LiftStrategy;
import java.util.*;
import ElevatorSystem.*;
import ElevatorSystem.Requests.*;;

public interface ElevatorSchedulingStrategy {
    Elevator selectElevator(List<Elevator> elevators, ExternalRequest request);
}
