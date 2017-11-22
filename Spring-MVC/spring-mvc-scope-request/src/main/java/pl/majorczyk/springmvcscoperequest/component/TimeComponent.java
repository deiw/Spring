package pl.majorczyk.springmvcscoperequest.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TimeComponent {

    private long time;

    public TimeComponent(){
        time=System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }
    @PostConstruct
    public void afterCreate(){
        System.out.println(this + " created "+System.currentTimeMillis());
    }
    @PreDestroy
    public void beforeDestroy(){
        System.out.println(this + " destroyed "+System.currentTimeMillis());
    }
}
