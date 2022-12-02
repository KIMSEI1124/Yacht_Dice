package game.yacht_dice.domain;

import game.yacht_dice.domian.Dices;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class DicesTest {
    @Test
    @DisplayName("주사위의 개수는 5개")
    public void dicesSizeEqual5() {
        // when
        Dices dices = new Dices();
        // then
        int quantity = dices.getNumbers().size();
        // given
        Assertions.assertThat(quantity).isEqualTo(5);
    }

    @Test
    @DisplayName("123")
    public void dicesReRoll() {
        // when
        Dices dices = new Dices();
        List<Integer> tempNumbers = dices.getNumbers();
        // then
        dices.reRoll(0, 1, 2, 3, 4);
        List<Integer> numbers = dices.getNumbers();
        // given
        Assertions.assertThat(numbers).isNotEqualTo(tempNumbers);
    }
}
