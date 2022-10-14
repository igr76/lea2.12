package controller;

import org.example.DivideByZeroExeption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;

import java.util.Objects;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping(path = "/calculator/plus")
    public String plus1(@RequestParam(value = "num1", required = false) int a,@RequestParam(value = "num2", required = false) int b) {
        if (Objects.isNull(a) ||Objects.isNull(b)) {
            return "Должы быть ведены оба значения";
        }
        return buildResult(a,b,calculatorService.plus1(a,b),"+");


    }

    @GetMapping(path = "/calculator/minus")
    public String minus(@RequestParam(value = "num1", required = false) int a,@RequestParam(value = "num2", required = false) int b) {
        if (Objects.isNull(a) ||Objects.isNull(b)) {
            return "Должы быть ведены оба значения";
        }
        return buildResult(a,b,calculatorService.minus(a,b),"");

    }

    @GetMapping(path = "/calculator/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) int a,@RequestParam(value = "num2", required = false) int b) {
        if (Objects.isNull(a) ||Objects.isNull(b)) {
            return "Должы быть ведены оба значения";
        }
        return buildResult(a,b,calculatorService.multiply(a,b),"*");

    }

    @GetMapping(path = "/calculator/divide")
    public String divide(@RequestParam(value = "num1", required = false) int a,@RequestParam(value = "num2", required = false) int b) throws DivideByZeroExeption, DivideByZeroExeption {
        if (Objects.isNull(a) ||Objects.isNull(b)) {
            return "Должы быть ведены оба значения";
        }
        return buildResult(a,b,calculatorService.divide(a,b),"/");

    }

    private String buildResult(Number a,Number b,Number result, String operation) {
        return String.format("%s %s %s = %s", a, operation, b, result);
    }

}