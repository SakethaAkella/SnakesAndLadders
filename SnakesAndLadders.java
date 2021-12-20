import java.util.*;

public class SnakesAndLadders {
    private Board board;
    private Queue<Player> players;
    private int initialPlayers;
    private static final int defaultNoOfTiles = 100;
    private static final int defaultNoOfDice = 1;

    public SnakesAndLadders(int boardSize) {
        this.board = new Board(boardSize);
        this.players = new LinkedList<Player>();
    }

    public SnakesAndLadders() {
        this(SnakesAndLadders.defaultNoOfTiles);
    }

    public void setNoOfDice(int noOfDice) {
        noOfDice = defaultNoOfDice; // default only 1 dice
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.initialPlayers = players.size();
        Map<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player : players) {
            this.players.add(player);
            playerPieces.put(player.getId(), 0);
        }
        board.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        board.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        board.setLadders(ladders);
    }

    private int getNewPosition(int newPosition) {
        int prevPosition;
        do {
            prevPosition = newPosition;
            for (Snake snake : board.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd();
                }
            }
            for (Ladder ladder : board.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd();
                }
            }
        } while (newPosition != prevPosition);
        return newPosition;
    }

    private void movePlayer(Player player, int pos) {
        int oldPosition = board.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + pos;
        int boardSize = board.getSize();
        if (newPosition > boardSize) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPosition(newPosition);
        }
        board.getPlayerPieces().put(player.getId(), newPosition);
        System.out.println(player.getName() + " rolls " + pos + " and moved " + oldPosition + " to " + newPosition);
    }

    private boolean playerWon(Player player) {
        int playerPosition = board.getPlayerPieces().get(player.getId());
        int winningPosition = board.getSize();
        return playerPosition == winningPosition;
    }

    private boolean isGameOver() {
        int currentPlayers = players.size();
        return currentPlayers < initialPlayers;
    }

    private int getDiceRoll() {
        return Dice.roll();
    }

    public void startGame() {
        while (!isGameOver()) {
            int diceValue = getDiceRoll();
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, diceValue);
            if (playerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " won!!");
            } else {
                players.add(currentPlayer);
            }
        }
    }
}