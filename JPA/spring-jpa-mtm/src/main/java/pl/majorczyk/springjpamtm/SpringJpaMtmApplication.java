package pl.majorczyk.springjpamtm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.majorczyk.springjpamtm.dao.ClientDao;
import pl.majorczyk.springjpamtm.dao.OrderDao;
import pl.majorczyk.springjpamtm.dao.ProductDao;
import pl.majorczyk.springjpamtm.model.Client;
import pl.majorczyk.springjpamtm.model.Order;
import pl.majorczyk.springjpamtm.model.Product;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaMtmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringJpaMtmApplication.class, args);


		Client client = new Client("John", "Smith");
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);

		Order order = new Order("free deliver");
		order.setClient(client);
		OrderDao orderDao = ctx.getBean(OrderDao.class);
		orderDao.save(order);

		Product product1 = new Product("Tv LG 42'", 4800.0, "dolby surround");
		Product product2 = new Product("Mobile phone Samsung Galaxy S6 Edge", 2200.0, "headphones free");
		ProductDao productDao = ctx.getBean(ProductDao.class);
		productDao.save(product1);
		productDao.save(product2);

		orderDao.addProductsToOrder(order.getId(), product1, product2);

		Client getClient = clientDao.get(client.getId());
		System.out.println("\n"+getClient);
		ctx.close();

	}
}
