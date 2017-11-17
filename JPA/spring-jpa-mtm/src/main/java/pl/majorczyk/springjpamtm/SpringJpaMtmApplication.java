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

		Client client = new Client("Jan", "Kowalski");
		Order order = new Order("z dostawą do domu");
		Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
		Product product2 = new Product("Telefon Apple iPhone SE", 2200.0, "pokrowiec gratis");
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
