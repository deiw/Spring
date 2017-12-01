package pl.majorczyk.springvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.majorczyk.springvalidation.model.User;
import pl.majorczyk.springvalidation.service.UserService;


@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute User user, RedirectAttributes redirectAttributes){
        Errors errors=userService.addUser(user);
        if(!errors.hasErrors()) redirectAttributes.addFlashAttribute("success","User added successfully!");
        else redirectAttributes.addFlashAttribute("errors",errors);
        return "redirect:/";
    }
}
