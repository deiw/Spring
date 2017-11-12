package pl.majorczyk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.majorczyk.dao.BookDaoImpl;
import pl.majorczyk.model.Book;

@Configuration
@ComponentScan(basePackages = "pl.majorczyk")
public class SpringJpaApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=
                new AnnotationConfigApplicationContext(SpringJpaApplication.class);

        BookDaoImpl bookDao=ctx.getBean(BookDaoImpl.class);
        Book book=new Book("123456789","Cloud Atlas","David Mitchell");
        bookDao.save(book);
        ctx.close();
    }
}
