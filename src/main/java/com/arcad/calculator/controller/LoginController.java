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
                        @RequestParam("login") String password,
                        @RequestParam("login") String confirmPassword) throws WrongLoginException {
        String strOut = "Авторизация пройдена";
        if (!loginService.isLogin(login)) {
            strOut = "Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания";
        } else if (!loginService.isPassword(password)) {
            strOut = "Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания";
        } else if (!loginService.isConfirmPassword(password, confirmPassword)) {
            strOut = "Пароль не совпадает с контрольным паролем";
        }
        return viewService.viewOut(strOut);
    }
}
