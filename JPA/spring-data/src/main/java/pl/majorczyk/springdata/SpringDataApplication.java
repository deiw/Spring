package pl.majorczyk.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.majorczyk.springdata.model.Book;
import pl.majorczyk.springdata.model.Order;
import pl.majorczyk.springdata.model.User;
import pl.majorczyk.springdata.model.UserDetails;
import pl.majorczyk.springdata.repository.BookRepository;
import pl.majorczyk.springdata.repository.OrderRepository;
import pl.majorczyk.springdata.repository.UserRepository;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataApplication.class, args);

		UserRepository userRep=ctx.getBean(UserRepository.class);
		User user=new User("deiw","pass","admin@admin.pl");
		UserDetails details=new UserDetails("dawid","maj","adres");
		Book book1=new Book("Title1","Author1",33.2);
		Book book2=new Book("Title2","Author2",23.0);
		Order order=new Order("opis");
		order.getBooks().add(book1);
		order.getBooks().add(book2);
		user.addOrder(order);
		user.setDetails(details);

		userRep.save(user);
		System.out.println(userRep.findOne(1L));

		OrderRepository orderRep=ctx.getBean(OrderRepository.class);
		orderRep.getAllByUser(user).forEach(System.out::println);

		Book book3=new Book("Title3","Author3",32.1);
		BookRepository bookRep=ctx.getBean(BookRepository.class);
		bookRep.save(book3);

		user.setNickname("danceMacabre");
		userRep.save(user);
		System.out.println(userRep.findOne(1L));


		bookRep.getByAuthorOrTitle("Author2","Title3").forEach(System.out::println);

		ctx.close();
	}
}
