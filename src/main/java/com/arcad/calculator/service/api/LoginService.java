package com.arcad.calculator.service.api;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final String forgetChar = "^[a-zA-Z0-9_]{1,20}$";

    public void isLogin(String login) throws WrongLoginException {
        if (!login.matches(forgetChar)) {
            throw new WrongLoginException("Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }

    }

    public void isPassword(String password) throws WrongLoginException {
        if (!password.matches(forgetChar) || password.isEmpty()) {
            throw new WrongLoginException("Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
    }

    public void isConfirmPassword(String password, String confirmPassword) throws WrongLoginException {
        if (!password.equals(confirmPassword)) {
            throw new WrongLoginException("Пароль не совпадает с контрольным паролем");
        }
    }
}
