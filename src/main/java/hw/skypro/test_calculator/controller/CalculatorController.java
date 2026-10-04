package hw.skypro.test_calculator.controller;

import hw.skypro.test_calculator.service.CalculatorServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String getGreeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String add(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2) {
        int result = calculatorService.add(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String subtract(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2) {
        int result = calculatorService.subtract(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2) {
        int result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2) {
        int result = calculatorService.divide(num1, num2);
        return num1 + " / " + num2 + " = " + result;
    }
}
