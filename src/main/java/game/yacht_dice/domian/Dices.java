package game.yacht_dice.domian;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Dices {
    private final List<Integer> numbers;
    Random random = new Random();

    public Dices() {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(6) + 1;
            this.numbers.add(number);
            dicesSort();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void reRoll(int... index) {
        for (int i : index) {
            int number = random.nextInt(6) + 1;
            this.numbers.set(i, number);
        }
    }

    private void dicesSort() {
        this.numbers.sort(Comparator.naturalOrder());
    }
}
