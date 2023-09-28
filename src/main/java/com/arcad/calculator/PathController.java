package com.arcad.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {
    private final CalculatorService calculatorService;

    public PathController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping(path = "/calculator/plus")
    public String plus(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        String[] args = {num1, num2};
        String result = "Ошибка в исходных данных.";
        if (calculatorService.isCheckParam(args)) {
            result = calculatorService.plus(args);
        }
        return "Plus: num1=" + num1 + ", num2=" + num2 + ", Resultat=" + result + calculatorService.footer;
    }
    @GetMapping(path = "/calculator/minus")
    public String minus(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        String[] args = {num1, num2};
        String result = "Ошибка в исходных данных.";
        if (calculatorService.isCheckParam(args)) {
            result = calculatorService.minus(args);
        }
        return "Minus: num1=" + num1 + ", num2=" + num2 + ", Resultat=" + result + calculatorService.footer;
    }
    //    /calculator/multiply?num1=5&num2=5
    @GetMapping(path = "/calculator/multiply")
    public String multiply(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        String[] args = {num1, num2};
        String result = "Ошибка в исходных данных.";
        if (calculatorService.isCheckParam(args)) {
            result = calculatorService.multiply(args);
        }
        return "Multiply: num1=" + num1 + ", num2=" + num2 + ", Resultat=" + result + calculatorService.footer;
    }
    //    /calculator/divide?num1=5&num2=5
    @GetMapping(path = "/calculator/divide")
    public String divide(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
        String[] args = {num1, num2};
        String result = "Ошибка в исходных данных.";
        if (calculatorService.isCheckParam(args)) {
            result = calculatorService.divide(args);
        }
        return "Divide: num1=" + num1 + ", num2=" + num2 + ", Resultat=" + result + calculatorService.footer;
    }
}
