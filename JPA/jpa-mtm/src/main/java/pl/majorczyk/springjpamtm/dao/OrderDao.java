package pl.majorczyk.springjpamtm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.majorczyk.springjpamtm.model.Order;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order,Long> {
}
