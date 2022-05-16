package com.tekact.platform.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "Welcome To Tekact Admin.";
    }
}
