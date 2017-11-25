package pl.majorczyk.springmvcjpathymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.majorczyk.springmvcjpathymeleaf.model.Book;

import java.util.ArrayList;


@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("bookList",new ArrayList<>());
        model.addAttribute("book",new Book());
        return "home";
    }
}
