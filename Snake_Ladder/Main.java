package Snake_Ladder;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        Player player1 = new Player("AAAAAA", new Cell(0));
        Player player2 = new Player("BBBBBB", new Cell(0));

        Board board = new Board(100);
        board.generateLadder(3, 25);
        board.generateLadder(45, 75);
        board.generateLadder(66, 93);
        board.generateSnake(99, 2);
        board.generateSnake(85, 55);
        board.generateSnake(44, 17);

        Deque<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        Game game = new Game(board, players);
        game.playGame();

    }
}

