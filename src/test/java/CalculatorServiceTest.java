

import org.example.DivideByZeroExeption;
import org.junit.jupiter.api.Test;
import service.CalculatorService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        Number actual = calculatorService.plus1(2,3);
        assertThat(actual).isEqualTo(5);

        actual = calculatorService.plus1(-4,1);
        assertThat(actual).isEqualTo(-3);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(5,3);
        assertThat(actual).isEqualTo(2);

        actual = calculatorService.minus(-4,1);
        assertThat(actual).isEqualTo(-5);
    }
    @Test
    public void multiplyTest() {
        Number actual = calculatorService.multiply(1,3);
        assertThat(actual).isEqualTo(3);

        actual = calculatorService.multiply(2,2);
        assertThat(actual).isEqualTo(4);
    }
    @Test
    public void divideTest() throws DivideByZeroExeption {
        Number actual = calculatorService.divide(6,3);
        assertThat(actual).isEqualTo(2);

        actual = calculatorService.divide(8,2);
        assertThat(actual).isEqualTo(4);

        assertThatExceptionOfType(DivideByZeroExeption.class)
                .isThrownBy(()-> calculatorService.divide(1,0))
                .withMessage("делить на ноль нельзя");
    }
}

