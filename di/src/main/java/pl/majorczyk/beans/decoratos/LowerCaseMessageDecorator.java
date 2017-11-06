package pl.majorczyk.beans.decoratos;

import org.springframework.stereotype.Component;

@Component
public class LowerCaseMessageDecorator implements MessageDecorator {
    @Override
    public String decorate(String msg) {
        return msg.toLowerCase();
    }
}
