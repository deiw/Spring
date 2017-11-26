package pl.majorczyk.resttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.majorczyk.resttest.model.City;
import pl.majorczyk.resttest.repository.CityRepository;

import java.util.Arrays;

@Controller
public class HomeController {

    private CityRepository cityRepository;

    @Autowired
    public HomeController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/")
    public String home(){
        cityRepository.save(Arrays.asList(
           new City("Poland","Kod1","District1",3000000),
           new City("England","Kod2","District2",82434321),
           new City("USA","Kod3","District3",201859432)
        ));
        return "home";
    }
}
