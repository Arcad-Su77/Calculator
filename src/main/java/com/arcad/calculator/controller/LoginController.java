package com.arcad.calculator.controller;

import com.arcad.calculator.service.api.LoginService;
import com.arcad.calculator.service.api.ViewService;
import com.arcad.calculator.service.api.WrongLoginException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;
    private final ViewService viewService;

    public LoginController(LoginService loginService, ViewService viewService) {
        this.loginService = loginService;
        this.viewService = viewService;
    }

    @GetMapping("/login")
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        @RequestParam("confirmPassword") String confirmPassword) {
        String strOut = "Авторизация пройдена";
        String sLogin = "Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания";
        String sPassword = "Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания";
        String sComfirmPassword = "Пароль не совпадает с контрольным паролем";
        try {
            loginService.isConfirmPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            strOut = sComfirmPassword;
        }
        try {
            loginService.isPassword(password);
        } catch (WrongLoginException e) {
            strOut = sPassword;
        }
        try {
            loginService.isLogin(login);
        } catch (WrongLoginException e) {
            strOut = sLogin;
        }
        return viewService.viewOut("Пользователь " + login + ": " + strOut);
    }
}
