package Snake_Ladder;

import java.util.Random;

public class Dice {
    private final int size = 6;
    public int getRandomValue(){
        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(6) + 1;
        return randomNumber;
    }
}
