package Snake_Ladder;

import java.util.Deque;

public class Game {
    private final Dice dice;
    private final Board board;
    private final Deque<Player> players;
    Game(Board board, Deque<Player> players){
        this.board = board;
        this.dice = new Dice();
        this.players = players;
    }
    public Dice getDice() {
        return dice;
    }
    public Board getBoard() {
        return board;
    }
    public void playGame(){

        int i=0;
        while(true){
            i++;
            Player player = players.remove();
            System.out.println("Player :--- " + player.getName());
            int val = this.getDice().getRandomValue();
            int loc = player.getCell().getLocation();
            if(loc + val > this.getBoard().getSize()){
                players.add(player);
                continue;
            }
            System.out.println("Dice :--- " + val  + " Location :-- " + loc);
            loc += val;
            if(this.getBoard().checkWin(loc)){
                System.out.println("Game Winner:--- " + player.getName());
                break;
            }
            loc = this.getBoard().checkJump(loc);
            player.getCell().setLocation(loc);
            players.add(player);
            System.out.println();
            // if(i==30)
            //     break;
        }
    }
}
