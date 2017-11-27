package pl.majorczyk.springbootdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.majorczyk.springbootdi.config.profiles.DevProfile;
import pl.majorczyk.springbootdi.config.profiles.ProdProfile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @DevProfile
    public DatabaseDatasource getH2Database(){
        return (()-> Arrays.asList("DawidTest","MarekTest","MagdaTest"));
    }
    @Bean
    @ProdProfile
    public DatabaseDatasource getMySqlDatabase(){
        return new DatabaseDatasource() {
            @Override
            public List<String> getDatabase() {
                try{
                    Path filePath=new File(getClass().getResource("/data.txt").toURI()).toPath();
                    List<String>allLines= Files.readAllLines(filePath);
                    return allLines;
                }catch (IOException | URISyntaxException e){
                    e.printStackTrace();
                }
                return new ArrayList<>();
            }
        };
    }

}
