package vn.codegym.model.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public String calculator(double firstNumber, double secondNumber, String operator) {
        double result=0;
        switch (operator){
            case "+":
                result = firstNumber+secondNumber;
                break;
            case "-":
                result =firstNumber-secondNumber;
                break;
            case "*":
                result=firstNumber*secondNumber;
                break;
            case "/":
                result=firstNumber/secondNumber;
                break;
        }
        return String.valueOf(result);
    }
}
