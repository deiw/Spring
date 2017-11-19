package pl.majorczyk.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.majorczyk.springdata.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
