package hw.skypro.test_calculator;

import hw.skypro.test_calculator.exceptions.DivisionByZeroException;
import hw.skypro.test_calculator.service.CalculatorService;
import hw.skypro.test_calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TestCalculatorApplicationTests  {

	private final CalculatorService calculatorService = new CalculatorServiceImpl();

	@Test
	void addShouldReturnCorrectResult() {
		assertEquals(10, calculatorService.add(5, 5));
	}

	@Test
	void addShouldReturnCorrectResultWithNegativeNumbers() {
		assertEquals(-10, calculatorService.add(-5, -5));
	}

	@Test
	void subtractShouldReturnCorrectResult() {
		assertEquals(5, calculatorService.subtract(10, 5));
	}

	@Test
	void subtractShouldReturnCorrectResultWithNegativeNumbers() {
		assertEquals(-5, calculatorService.subtract(-10, -5));
	}

	@Test
	void multiplyShouldReturnCorrectResult() {
		assertEquals(25, calculatorService.multiply(5, 5));
	}

	@Test
	void multiplyShouldReturnCorrectResultWithNegativeNumber() {
		assertEquals(-25, calculatorService.multiply(-5, 5));
	}

	@Test
	void divideShouldReturnCorrectResult() {
		assertEquals(5, calculatorService.divide(10, 2));
	}

	@Test
	void divideShouldReturnCorrectResultWithNegativeNumber() {
		assertEquals(-5, calculatorService.divide(-10, 2));
	}

	@Test
	void divideShouldThrowExceptionWhenDividingByZero() {
		assertThrows(DivisionByZeroException.class,
					() -> calculatorService.divide(10, 0));
	}

	@ParameterizedTest
	@MethodSource("additionArguments")
	void addShouldReturnCorrectResult(int num1, int num2, int expected) {
		assertEquals(expected, calculatorService.add(num1, num2));
	}

	static Stream<Arguments> additionArguments() {
		return Stream.of(
				Arguments.of(2, 3, 5),
				Arguments.of(5, 5, 10),
				Arguments.of(-2, -3, -5),
				Arguments.of(100, 50, 150)
		);
	}

	@ParameterizedTest
	@MethodSource("subtractionArguments")
	void subtractShouldReturnCorrectResult(int num1, int num2, int expected) {
		assertEquals(expected, calculatorService.subtract(num1, num2));
	}

	static Stream<Arguments> subtractionArguments() {
		return Stream.of(
				Arguments.of(5, 3, 2),
				Arguments.of(10, 5, 5),
				Arguments.of(-5, -3, -2),
				Arguments.of(3, 5, -2)
		);
	}

	@ParameterizedTest
	@MethodSource("multiplicationArguments")
	void multiplyShouldReturnCorrectResult(int num1, int num2, int expected) {
		assertEquals(expected, calculatorService.multiply(num1, num2));
	}

	static Stream<Arguments> multiplicationArguments() {
		return Stream.of(
				Arguments.of(2, 3, 6),
				Arguments.of(5, 5, 25),
				Arguments.of(-2, 3, -6),
				Arguments.of(10, 0, 0)
		);
	}

	@ParameterizedTest
	@MethodSource("divisionArguments")
	void divideShouldReturnCorrectResult(int num1, int num2, int expected) {
		assertEquals(expected, calculatorService.divide(num1, num2));
	}

	static Stream<Arguments> divisionArguments() {
		return Stream.of(
				Arguments.of(10, 2, 5),
				Arguments.of(20, 4, 5),
				Arguments.of(-10, 2, -5),
				Arguments.of(100, 10, 10)
		);
	}
}
