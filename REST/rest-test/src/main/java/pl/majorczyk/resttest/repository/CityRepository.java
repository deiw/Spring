package pl.majorczyk.resttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.majorczyk.resttest.model.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {
    List<City> getCitiesByPopulationGreaterThan(int population);
}
