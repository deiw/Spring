package pl.majorczyk.resttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.majorczyk.resttest.model.City;
import pl.majorczyk.resttest.repository.CityRepository;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @RequestMapping
    public List<City> getCities(@RequestParam(required = false, defaultValue = "0") int population){
        List<City> cityList=cityRepository.getCitiesByPopulationGreaterThan(population);
        return cityList;
    }
    @RequestMapping("/{id}")
    public City getCity(@PathVariable int id){
        City city=cityRepository.findOne(id);
        return city;
    }
}
