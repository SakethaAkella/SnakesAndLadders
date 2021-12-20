import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Snake> snakes = new ArrayList<Snake>();
        snakes.add(new Snake(3, 37));
        snakes.add(new Snake(10, 28));
        snakes.add(new Snake(16, 47));
        snakes.add(new Snake(32, 75));
        snakes.add(new Snake(42, 96));
        snakes.add(new Snake(71, 94));
        List<Ladder> ladders = new ArrayList<Ladder>();
        ladders.add(new Ladder(4, 56));
        ladders.add(new Ladder(12, 50));
        ladders.add(new Ladder(14, 55));
        ladders.add(new Ladder(22, 58));
        ladders.add(new Ladder(41, 79));
        ladders.add(new Ladder(54, 88));
        System.out.print("Enter number of players : ");
        int noOfPlayers = in.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 1; i <= noOfPlayers; i++) {
            System.out.print("Enter name of player " + i + ": ");
            players.add(new Player(in.next()));
        }
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        snakesAndLadders.setPlayers(players);
        snakesAndLadders.setSnakes(snakes);
        snakesAndLadders.setLadders(ladders);
        snakesAndLadders.startGame();
        in.close();
    }
}
