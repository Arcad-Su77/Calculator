package com.arcad.calculator.service.api;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final String forgetChar = "^[a-zA-Z0-9_]{1,20}$";

    public boolean isLogin(String login) throws WrongLoginException {
        if (login.matches(forgetChar)) {
            return true;
        } else {
            return false;
//            throw new WrongLoginException();
        }
    }

    public boolean isPassword(String password) throws WrongLoginException {
        if (password.matches(forgetChar) || password.isEmpty()) {
            return true;
        } else {
            return false;
//            throw new WrongLoginException();
        }
    }

    public boolean isConfirmPassword(String password, String confirmPassword) throws WrongLoginException {
        if (password.equals(confirmPassword)) {
            return true;
        } else {
            return false;
//            throw new WrongLoginException();
        }
    }
}
