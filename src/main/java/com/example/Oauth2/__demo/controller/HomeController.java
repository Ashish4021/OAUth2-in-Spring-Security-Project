package com.example.Oauth2.__demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    @GetMapping("/")
//    public String home(){
//        return "Google Login Successfull!";
//    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal OAuth2User user){
        String name = user.getAttribute("name");
        String email = user.getAttribute("email");

        return "Name : " + name + ", Email : " + email;
    }

}
