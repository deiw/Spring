package pl.majorczyk.springmvcrestdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.majorczyk.springmvcrestdata.model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
