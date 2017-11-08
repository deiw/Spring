package pl.majorczyk.springbootdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.majorczyk.springbootdi.beans.NamesRepository;

import java.util.List;

@SpringBootApplication
public class SpringBootDiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootDiApplication.class, args);
		NamesRepository rep=ctx.getBean(NamesRepository.class);
		List<String> allLines=rep.getAll();
		allLines.forEach(System.out::println);
		ctx.close();
	}
}
