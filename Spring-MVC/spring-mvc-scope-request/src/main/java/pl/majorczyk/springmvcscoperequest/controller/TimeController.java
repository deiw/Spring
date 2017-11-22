package pl.majorczyk.springmvcscoperequest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.majorczyk.springmvcscoperequest.component.TimeComponent;

@Controller
public class TimeController {

    TimeComponent timeComponent;

    @Autowired
    public TimeController(TimeComponent timeComponent){
        this.timeComponent=timeComponent;
    }

    @GetMapping("/")
    public String index(){
        System.out.println(timeComponent.getTime());
        return "index";
    }
}
