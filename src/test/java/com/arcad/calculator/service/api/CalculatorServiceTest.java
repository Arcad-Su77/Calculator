package com.arcad.calculator.service.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService cs = new CalculatorService();

    @BeforeEach
    void setUp() {
        System.out.println("Приступим к тесту");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тестирование завершено");
    }

    @Test
    void isCheckParam() {
        String[] args = {"20", "70", "100"};
        assertTrue(cs.isCheckParam(args));
        args = new String[]{"1.2", "100"};
        assertTrue(cs.isCheckParam(args));
        args = new String[]{"1,2", "100"};
        assertFalse(cs.isCheckParam(args));
        System.out.println("cs.isCheckParam(args) = " + cs.isCheckParam(args));
    }

    @Test
    void argsStringToFloat() {
        String[] args = {"20", "70"};
        var out = new float[]{20F, 70F};
        var test = cs.argsStringToFloat(args);
        assertArrayEquals(out, test);
        args = new String[]{"1.2", "0.5"};
        out = new float[]{1.2F, 0.5F};
        assertArrayEquals(out, cs.argsStringToFloat(args));
        System.out.println("cs.argsStringToFloat = " + Arrays.toString(cs.argsStringToFloat(args)));
    }

    @Test
    void plus() {
        String[] args = new String[]{"1.2", "0.5"};
        String out = "1.7";
        assertEquals(out, cs.plus(args));
    }

    @Test
    void minus() {
        String[] args = new String[]{"1.2", "0.5"};
        String out = "0.70000005";
        assertEquals(out, cs.minus(args));
    }

    @Test
    void multiply() {
        String[] args = new String[]{"1.2", "0.5"};
        String out = "0.6";
        assertEquals(out, cs.multiply(args));
    }

    @Test
    void divide() {
        String[] args = new String[]{"1.2", "0.5"};
        String out = "2.4";
        assertEquals(out, cs.divide(args));
    }

    @Test
    void divideZerro() {
        String[] args = new String[]{"1.2", "0"};
        String out = "Деление на ноль не допустимо";
        assertEquals(out, cs.divide(args));
    }
}