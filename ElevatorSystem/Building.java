package ElevatorSystem;

import java.util.List;

import java.util.ArrayList;

public class Building {

    private final List<Floor> floors = new ArrayList<>();

    public Building(int totalFloors, ElevatorController controller) {
        for (int i = 0; i < totalFloors; i++) {
            floors.add(new Floor(i, controller));
        }
    }

    public Floor getFloor(int number) {
        return floors.get(number);
    }
}

