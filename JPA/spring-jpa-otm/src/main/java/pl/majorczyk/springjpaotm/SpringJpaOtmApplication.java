package pl.majorczyk.springjpaotm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.majorczyk.springjpaotm.dao.ClientDao;
import pl.majorczyk.springjpaotm.dao.OrderDao;
import pl.majorczyk.springjpaotm.model.Client;
import pl.majorczyk.springjpaotm.model.Order;

import java.util.List;


@SpringBootApplication
public class SpringJpaOtmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringJpaOtmApplication.class, args);

		Client client = new Client("John", "Smith", "Oxford");
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);
		System.out.println(client);

		Order order = new Order("Notebook","Dell Inspirion");
		order.setClient(client);
		Order order1=new Order("Mobile phone","Samsung Galaxy S8 Edge");
		order1.setClient(client);
		OrderDao orderDao = ctx.getBean(OrderDao.class);
		orderDao.save(order);
		orderDao.save(order1);

		Client c=clientDao.get(1L);
		List<Order> orders=c.getOrders();
		for (Order o:orders){
			System.out.println(o);
		}
        ctx.close();
	}
}
