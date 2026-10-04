package hw.skypro.test_calculator.service;

import hw.skypro.test_calculator.exceptions.DivisionByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final String DIVISION_BY_ZERO_MESSAGE = "Нельзя делить на ноль!";

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new DivisionByZeroException(DIVISION_BY_ZERO_MESSAGE);
        }

        return num1 / num2;
    }
}
