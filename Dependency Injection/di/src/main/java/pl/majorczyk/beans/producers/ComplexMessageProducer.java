package pl.majorczyk.beans.producers;

import org.springframework.stereotype.Component;

@Component
@Producer(type = Producer.ProducerType.COMPLEX)
public class ComplexMessageProducer implements MessageProducer {
    @Override
    public String getMessage() {
        return "Complex Message Producer";
    }
}
