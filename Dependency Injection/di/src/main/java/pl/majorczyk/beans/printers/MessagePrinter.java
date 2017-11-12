package pl.majorczyk.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.majorczyk.beans.producers.MessageProducer;
import pl.majorczyk.beans.decoratos.MessageDecorator;
import pl.majorczyk.beans.producers.Producer;

@Component
public class MessagePrinter {

    private MessageProducer producer;
    private MessageDecorator decorator;

    MessagePrinter(){}

    @Autowired
    public MessagePrinter(@Producer(type = Producer.ProducerType.SIMPLE) MessageProducer producer){
        this.producer=producer;
    }

    public MessageProducer getProducer() {
        return producer;
    }

    public void setProducer(MessageProducer producer) {
        this.producer = producer;
    }
    public void print(){
        String message=producer.getMessage();
        message=decorator!=null?decorator.decorate(message):message;
        System.out.println(message);
    }

    public MessageDecorator getDecorator() {
        return decorator;
    }
    @Autowired(required = false)
    public void setDecorator(MessageDecorator decorator) {
        this.decorator = decorator;
    }
}
