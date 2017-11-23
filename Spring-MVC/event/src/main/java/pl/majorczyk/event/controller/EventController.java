package pl.majorczyk.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.majorczyk.event.component.EventHolder;
import pl.majorczyk.event.model.Participant;

@Controller
public class EventController {

    private EventHolder eventHolder;
    @Autowired
    public EventController(EventHolder eventHolder){
        this.eventHolder=eventHolder;
    }
    @PostMapping("/register")
    public String register(@RequestParam String firstname,
                           @RequestParam String lastname){
        Participant participant=new Participant(firstname,lastname);
        if(eventHolder.checkRegistration(participant))
           return "redirect:error";
        else {
            eventHolder.addParticipant(participant);
            return "redirect:success";
        }
    }
    @GetMapping("/success")
    public String success(){
        return "success";
    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }
    @GetMapping("/show")
    public String show(){
        eventHolder.getParticipants().forEach(System.out::println);
        return "redirect:/";
    }

}
