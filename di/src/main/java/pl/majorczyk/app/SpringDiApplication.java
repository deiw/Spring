package pl.majorczyk.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.majorczyk.beans.printers.MessagePrinter;

@Configuration
@ComponentScan(basePackages = "pl.majorczyk")
public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDiApplication.class);
        MessagePrinter printer = ctx.getBean(MessagePrinter.class);
        printer.print();


        ctx.close();
    }
}
