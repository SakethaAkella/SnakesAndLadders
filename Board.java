import java.util.*;

public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String, Integer> playerPieces;

    public Board(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPieces = new HashMap<String, Integer>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<String, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }
}
