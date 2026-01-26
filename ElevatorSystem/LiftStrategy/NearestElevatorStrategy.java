package ElevatorSystem.LiftStrategy;

import java.util.List;
import ElevatorSystem.Elevator;
import ElevatorSystem.Requests.*;

public class NearestElevatorStrategy implements ElevatorSchedulingStrategy {

    @Override
    public Elevator selectElevator(List<Elevator> elevators, ExternalRequest request) {

        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - request.getFloor());

            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        return best;
    }
}

