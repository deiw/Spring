package pl.majorczyk.springjpamtm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.majorczyk.springjpamtm.model.Product;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product,Long> {
}
