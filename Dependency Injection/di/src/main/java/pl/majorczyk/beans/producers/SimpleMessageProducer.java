package pl.majorczyk.beans.producers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Producer(type = Producer.ProducerType.SIMPLE)
@PropertySource("classpath:appConfig.properties")
public class SimpleMessageProducer implements MessageProducer {

    @Autowired
    Environment env;

    @Override
    public String getMessage() {
        return "Simple Message Producer "+env.getProperty("randomNumber") ;
    }
}
