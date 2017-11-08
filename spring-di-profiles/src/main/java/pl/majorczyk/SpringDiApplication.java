package pl.majorczyk;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.majorczyk.beans.NamesRepository;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "pl.majorczyk")
public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDiApplication.class);

        NamesRepository repo=ctx.getBean(NamesRepository.class);
        List<String> allList=repo.getAll();
        allList.forEach(System.out::println);
        ctx.close();
    }
}
