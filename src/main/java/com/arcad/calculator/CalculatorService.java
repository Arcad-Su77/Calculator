package com.arcad.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorServiceImpl{
    public final String footer = "<br><a href=\"/\">HOME</a>";
    @Override
    public boolean isCheckParam(String[] args) {
        boolean isReturn = true;
        for (String arg : args) {
            try {
                Float.parseFloat(arg);
            } catch (NumberFormatException e) {
                isReturn = false;
                break;
            }
        }
        return isReturn;
    }

    float[] argsStringToFloat(String[] args){
        return new float[]{Float.parseFloat(args[0]), Float.parseFloat(args[1])};
    }

    @Override
    public String plus(String[] args) {
        float[] num = argsStringToFloat(args);
        float fResult = num[0] + num[1];
        return String.valueOf(fResult);
    }

    @Override
    public String minus(String[] args) {
        float[] num = argsStringToFloat(args);
        float iResult = num[0] - num[1];
        return String.valueOf(iResult);
    }

    @Override
    public String multiply(String[] args) {
        float[] num = argsStringToFloat(args);
        float iResult = num[0] * num[1];
        return String.valueOf(iResult);
    }

    @Override
    public String divide(String[] args) {
        float[] num = argsStringToFloat(args);
        if (num[1] != 0) {
            float fResult = num[0] / num[1];
            return String.valueOf(fResult);
        } else {
            return "Деление на ноль не допустимо";
        }
    }
}
