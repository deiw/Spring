package pl.majorczyk.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.majorczyk.springbootjpa.dao.BookDao;
import pl.majorczyk.springbootjpa.model.Book;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext ctx= SpringApplication.run(SpringBootJpaApplication.class, args);
		BookDao dao=ctx.getBean(BookDao.class);
		dao.save(new Book("123","Cloud Atlas","David Mitchell"));
		System.out.println("book saved");
	}
}
