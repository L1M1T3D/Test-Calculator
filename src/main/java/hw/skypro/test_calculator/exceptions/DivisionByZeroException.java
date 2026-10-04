package hw.skypro.test_calculator.exceptions;

public class DivisionByZeroException extends IllegalArgumentException {
    public DivisionByZeroException() {
    }

    public DivisionByZeroException(String s) {
        super(s);
    }

    public DivisionByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivisionByZeroException(Throwable cause) {
        super(cause);
    }
}
