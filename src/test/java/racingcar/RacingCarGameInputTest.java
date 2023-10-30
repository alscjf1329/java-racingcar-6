package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCar;
import racingcar.utils.RacingCarGameInput;

public class RacingCarGameInputTest {
    @Test
    void validateCarNamesInput_메소드를_사용시_자동차_이름_입력에_공백이_들어가는_경우_예외_발생() {
        String input = "pobi, javaji";
        assertThatThrownBy(() -> RacingCarGameInput.validateCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_EMPTY);
    }


    @Test
    void validateCarNames_메소드를_사용시_자동차_이름이_5자가_넘어가는_경우_예외_발생() {
        List<RacingCar> carList = List.of(
                new RacingCar("exception")
        );
        assertThatThrownBy(() -> RacingCarGameInput.validateCarNames(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_BIGGER_THAN_5CHAR);
    }

    @Test
    void validateNumber_메소드를_사용시_숫자가_아닌_경우_예외_반환() {
        assertThatThrownBy(() -> RacingCarGameInput.validateNumber("12ad"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_NOT_NUMBER);
    }

    @Test
    void validateMoveCount_메소드를_사용시_1이상이_아닌_경우_예외_반환() {
        assertThatThrownBy(() -> RacingCarGameInput.validateMoveCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingCarGameInput.ERROR_MESSAGE_NOT_POSITIVE);
    }
}
