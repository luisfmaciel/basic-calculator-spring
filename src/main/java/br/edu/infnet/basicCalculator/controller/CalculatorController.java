package br.edu.infnet.basicCalculator.controller;

import br.edu.infnet.basicCalculator.model.CalculatorRequest;
import br.edu.infnet.basicCalculator.model.PowerRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/add/{num1}/{num2}")
    public double addGet(@PathVariable double num1, @PathVariable double num2) {
        return num1 + num2;
    }

    @PostMapping("/add")
    public double addPost(@RequestBody CalculatorRequest calculatorRequest) {
        return calculatorRequest.getNum1() + calculatorRequest.getNum2();
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public double subtractGet(@PathVariable double num1, @PathVariable double num2) {
        return num1 - num2;
    }

    @PostMapping("/subtract")
    public double subtractPost(@RequestBody CalculatorRequest calculatorRequest) {
        return calculatorRequest.getNum1() - calculatorRequest.getNum2();
    }

    @GetMapping("/multiply/{num1}/{num2}")
    public double multiplyGet(@PathVariable double num1, @PathVariable double num2) {
        return num1 * num2;
    }

    @PostMapping("/multiply")
    public double multiplyPost(@RequestBody CalculatorRequest calculatorRequest) {
        return calculatorRequest.getNum1() * calculatorRequest.getNum2();
    }

    @GetMapping("/divide/{num1}/{num2}")
    public double divideGet(@PathVariable double num1, @PathVariable double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    @PostMapping("/divide")
    public double dividePost(@RequestBody CalculatorRequest calculatorRequest) {
        if (calculatorRequest.getNum2() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return calculatorRequest.getNum1() / calculatorRequest.getNum2();
    }

    @GetMapping("/power/{base}/{exponent}")
    public double powerGet(@PathVariable double base, @PathVariable double exponent) {
        return Math.pow(base, exponent);
    }

    @PostMapping("/power")
    public double powerPost(@RequestBody PowerRequest powerRequest) {
        return Math.pow(powerRequest.getBase(), powerRequest.getExponent());
    }
}
