package ElevatorSystem;

import ElevatorSystem.Requests.ExternalRequest;

public class Floor {

    private final int number;
    private final ElevatorController controller;

    public Floor(int number, ElevatorController controller) {
        this.number = number;
        this.controller = controller;
    }

    public void pressUp() {
        controller.handleExternalRequest(
                new ExternalRequest(number, Direction.UP));
    }

    public void pressDown() {
        controller.handleExternalRequest(
                new ExternalRequest(number, Direction.DOWN));
    }
}
