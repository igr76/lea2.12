package service;

import org.example.DivideByZeroExeption;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    CalculatorService calculatorService;



    public int plus1(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws DivideByZeroExeption {
        if (b == 0) {
            throw new DivideByZeroExeption("делить на ноль нельзя");
        }
        return a.doubleValue() / b;
    }
}


