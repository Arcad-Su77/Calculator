package com.arcad.calculator.service.api;

public class WrongLoginException extends Throwable {

    public WrongLoginException(String s) {
        System.out.println(s);
    }
}
