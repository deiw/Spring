package pl.majorczyk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.majorczyk.model.Book;
import pl.majorczyk.service.GenericRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringApplication.class);

        GenericRepository<String,Book> repo=ctx.getBean(GenericRepository.class);
        repo.add(new Book("1234567890123", "First", "First author"));
        repo.add(new Book("2345678901234", "Second", "Second author"));
        repo.add(new Book("3456789012345", "Third", "Third author"));

        Book book=repo.get("1234567890123");
        System.out.println(book);
        //Book error=repo.get("123");
        ctx.close();
    }
}
