package pl.majorczyk.springmvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.majorczyk.springmvcthymeleaf.model.Article;

@Controller
public class ArticleController {

    @PostMapping("/add")
    public String add(@ModelAttribute Article article, Model model){
        if(check(article)){
            model.addAttribute("article",article);
            return "success";
        }
        else
        return "error";
    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }

    private boolean check(Article article){
        return (article.getTitle()!=null&&article.getTitle().length()>0)&&
                (article.getContent()!=null&&article.getContent().length()>0);
    }
}
