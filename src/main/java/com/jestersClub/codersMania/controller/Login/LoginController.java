package com.jestersClub.codersMania.controller.Login;

import com.jestersClub.codersMania.service.Login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping
    public boolean login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        boolean result;
        result = loginService.login(email, password);
        return result;
    }
    @GetMapping("/forget")
    public void forgetPassword(){

    }


}
