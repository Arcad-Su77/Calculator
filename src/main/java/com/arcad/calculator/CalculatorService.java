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
                Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                isReturn = false;
                break;
            }
        }
        return isReturn;
    }

    @Override
    public String plus(String[] args) {
        int iNum1 = Integer.parseInt(args[0]);
        int iNum2 = Integer.parseInt(args[1]);
        int iResult = iNum1 + iNum2;
        return String.valueOf(iResult);
    }

    @Override
    public String minus(String[] args) {
        int iNum1 = Integer.parseInt(args[0]);
        int iNum2 = Integer.parseInt(args[1]);
        int iResult = iNum1 - iNum2;
        return String.valueOf(iResult);
    }

    @Override
    public String multiply(String[] args) {
        int iNum1 = Integer.parseInt(args[0]);
        int iNum2 = Integer.parseInt(args[1]);
        int iResult = iNum1 * iNum2;
        return String.valueOf(iResult);
    }

    @Override
    public String divide(String[] args) {
        int iNum1 = Integer.parseInt(args[0]);
        int iNum2 = Integer.parseInt(args[1]);
        if (iNum2 != 0) {
            Float fResult = (float) iNum1 / (float) iNum2;
            return String.valueOf(fResult);
        } else {
            return "Деление на ноль не допустимо";
        }
    }
}
