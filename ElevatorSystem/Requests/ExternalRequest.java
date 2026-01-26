package ElevatorSystem.Requests;

import ElevatorSystem.Direction;

public class ExternalRequest extends Request {
    private final Direction direction;

    public ExternalRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
