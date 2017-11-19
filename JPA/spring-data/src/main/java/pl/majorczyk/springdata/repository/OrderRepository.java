package pl.majorczyk.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.majorczyk.springdata.model.Order;
import pl.majorczyk.springdata.model.User;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> getAllByUser(User user);
}
