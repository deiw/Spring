package pl.majorczyk.springmvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.majorczyk.springmvcthymeleaf.model.Article;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("helloMessage","Thymeleaf test");
        model.addAttribute("article", new Article());
        return "index";
    }
}
