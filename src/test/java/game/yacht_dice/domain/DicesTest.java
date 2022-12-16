package game.yacht_dice.domain;

import game.yacht_dice.domian.Dices;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

class DicesTest {
    @Test
    @DisplayName("주사위의 개수는 5개")
    void dicesSizeEqual5() {
        // when
        Dices dices = new Dices();
        // then
        int quantity = dices.getNumbers().size();
        // given
        Assertions.assertThat(quantity).isEqualTo(5);
    }

    @Nested
    @DisplayName("주사위 리롤")
    class dicesReRoll {
        @Test
        @DisplayName("리롤을 돌리지 않은 주사위는 동일하다.")
        void DontReRollDiceEquals() {
            // when
            Dices dices = new Dices();
            Integer tempDice = dices.getNumbers().get(4);
            // then
            dices.reRoll(0, 1, 2, 3);
            // given
            Assertions.assertThat(dices.getNumbers().get(4)).isEqualTo(tempDice);
        }

        @Test
        @DisplayName("리롤을 돌린 주사위는 동일하지 않다.")
        void reRollDiceNotEquals() {
            // when
            Dices dices = new Dices();
            String tempDices = dices.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            // then
            dices.reRoll(0, 2, 4);
            String reRollDices = dices.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            // given
            Assertions.assertThat(reRollDices).isNotEqualTo(tempDices);
        }
    }
}
