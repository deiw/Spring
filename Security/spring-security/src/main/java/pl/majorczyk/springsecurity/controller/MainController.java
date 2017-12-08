package pl.majorczyk.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/secured")
    public String secured(){
        return "secured";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
