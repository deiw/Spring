package pl.majorczyk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping("/")
    public String calculate(@RequestParam(defaultValue = "0") int a,
                            @RequestParam(defaultValue = "0") int b) {
        int sum=a+b;
        System.out.printf("%d + %d = %d\n",a,b,sum);

        return "home";
    }
}
