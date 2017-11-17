package pl.majorczyk.springjpamtm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.majorczyk.springjpamtm.model.Order;
import pl.majorczyk.springjpamtm.model.Product;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order,Long> {

    public void addProductsToOrder(Long orderId, Product... products){
        Order order=get(orderId);
        if(order!=null){
            for (Product product:products){
                order.getProducts().add(product);
            }
        }
    }
}
