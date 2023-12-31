package com.arcad.calculator.service.api;

import com.arcad.calculator.service.impl.CalculatorServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorServiceImpl {

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

    public String plus(String[] args) {
        float[] num = argsStringToFloat(args);
        float fResult = num[0] + num[1];
        return String.valueOf(fResult);
    }

    public String minus(String[] args) {
        float[] num = argsStringToFloat(args);
        float iResult = num[0] - num[1];
        return String.valueOf(iResult);
    }

    public String multiply(String[] args) {
        float[] num = argsStringToFloat(args);
        float iResult = num[0] * num[1];
        return String.valueOf(iResult);
    }

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
