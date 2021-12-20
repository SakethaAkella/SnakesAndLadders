import java.util.Random;

public class Dice {
    int dice;

    public static int roll() {
        int dice = new Random().nextInt(6) + 1;
        return dice;
    }
}
