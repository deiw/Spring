package pl.majorczyk.springmvcrestdata.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.majorczyk.springmvcrestdata.model.City;
import pl.majorczyk.springmvcrestdata.repository.CityRepository;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityControllerRest {

    private CityRepository cityRepo;

    @Autowired
    public CityControllerRest(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCities(){
        List<City> cityList=cityRepo.findAll();
        return cityList;
    }
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCity(@PathVariable Long id){
            City city=cityRepo.findOne(id);
            if(city!=null) return ResponseEntity.ok(city);
            else return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCity(@RequestBody City city){
        cityRepo.save(city);
    }

}
