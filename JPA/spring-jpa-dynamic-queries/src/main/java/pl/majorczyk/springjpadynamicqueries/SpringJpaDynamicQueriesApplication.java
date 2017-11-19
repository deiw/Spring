package pl.majorczyk.springjpadynamicqueries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.majorczyk.springjpadynamicqueries.dao.ProductDao;
import pl.majorczyk.springjpadynamicqueries.model.Product;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaDynamicQueriesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringJpaDynamicQueriesApplication.class, args);

		List<Product> products = new ArrayList<>();
		products.add(new Product("Tv",  4500.0));
		products.add(new Product("Toaster",  120.0));
		products.add(new Product("Notebook",  3599.0));
		products.add(new Product("Mobile phone",  2600.0));
		products.add(new Product("Telescope",  2100.0));

		ProductDao productDao = ctx.getBean(ProductDao.class);
		products.forEach(productDao::save);

		System.out.println("All products:");
		List<Product> allProducts = productDao.getAll();
		allProducts.forEach(System.out::println);

		System.out.println("Products more expensive than 3000");
		List<Product> expensiveProducts = productDao.customGet("SELECT p FROM Product p WHERE p.price > 3000");
		expensiveProducts.forEach(System.out::println);

		System.out.println("All products ordered by price");
		List<Product> productsByPrice = productDao.customGet("SELECT p FROM Product p ORDER BY p.price ASC");
		productsByPrice.forEach(System.out::println);



		productDao.removeAll();

		ctx.close();
	}
}
