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
		Order order = new Order("deliver free");
		Product product1 = new Product("Tv LG 42'", 4800.0, "dolby surround");
		Product product2 = new Product("Mobile phone Samsung Galaxy S6 Edge", 2200.0, "free headphones");
		order.getProducts().add(product1);
		order.getProducts().add(product2);
		client.getOrders().add(order);
		client.addOrder(order);

		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);

		Client getClient = clientDao.get(client.getId());
		System.out.println(getClient);



		ctx.close();

	}
}
