package pl.majorczyk.springjpaoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.majorczyk.springjpaoto.dao.UserDao;
import pl.majorczyk.springjpaoto.dao.UserDetailsDao;
import pl.majorczyk.springjpaoto.model.User;
import pl.majorczyk.springjpaoto.model.UserDetails;

@SpringBootApplication
public class SpringJpaOtoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringJpaOtoApplication.class, args);

		UserDao userDao = ctx.getBean(UserDao.class);
		User user = new User("johny", "pass", "john@smith.com");
		UserDetails userDetails = new UserDetails("John", "Smith", "wesson 34, Oxford");
		user.setDetails(userDetails);
		userDao.create(user);

		UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class);
		UserDetails getUserDetails = userDetailsDao.read(1L);
		System.out.println(getUserDetails.getUser());

		ctx.close();
	}
}
