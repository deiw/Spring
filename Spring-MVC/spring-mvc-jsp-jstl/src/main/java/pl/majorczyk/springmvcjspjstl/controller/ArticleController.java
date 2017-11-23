package pl.majorczyk.springmvcjspjstl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.majorczyk.springmvcjspjstl.model.Article;

@Controller
public class ArticleController {

    @PostMapping("/add")
    public String add(@RequestParam String title,
                      @RequestParam String content,
                      @RequestParam String tags,
                      Model model){
        if(check(title,content)){
            Article article=new Article(title,content,tags);
            model.addAttribute("article",article);
            return "success";
        }
        else return "error";

    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }
    private boolean check(String title,String content){
        return (title!=null&&title.length()>0)&&(content!=null&&content.length()>0);
    }
}
