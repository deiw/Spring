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
		
		// CREATE
		BookDao dao = ctx.getBean(BookDao.class);
		Book book = new Book("1234567890468", "Cloud Atlas", "David Mitchell");
		dao.save(book);
		System.out.println(book);

		// UPDATE
		Book book2 = new Book("987654321", "Universe in your hand", "Christophe Gallard");
		book2.setId(1L);
		dao.update(book2);
		System.out.println(book2);

		// READ
		Book findBook = dao.get(1L);
		System.out.println(findBook);

		// DELETE
		dao.remove(1L);
		Book book3 = dao.get(1L);
		System.out.println(book3); //null
	}
}
