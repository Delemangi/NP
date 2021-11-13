package k1.petkaIliGlava;

import java.util.Random;

public class LoadedCoin extends Coin {
    private final int probability;

    public LoadedCoin(int probability) {
        this.probability = probability;
    }

    @Override
    public SIDE flip() {
        Random random = new Random();
        int a = random.nextInt(100);

        if (a < probability) {
            return SIDE.HEAD;
        } else {
            return SIDE.TAIL;
        }
    }
}