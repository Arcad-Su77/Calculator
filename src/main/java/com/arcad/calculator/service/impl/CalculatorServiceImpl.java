package com.arcad.calculator.service.impl;

public interface CalculatorServiceImpl {
    boolean isCheckParam(String[] args);
    String plus(String[] args);

    String minus(String[] args);

    String multiply(String[] args);

    String divide(String[] args);
}
