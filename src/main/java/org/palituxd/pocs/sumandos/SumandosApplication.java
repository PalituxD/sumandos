package org.palituxd.pocs.sumandos;

import org.palituxd.pocs.sumandos.properties.MessageConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableConfigurationProperties(MessageConfigProperties.class)
@PropertySources({
        @PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:endpoints.properties")
})
public class SumandosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SumandosApplication.class, args);
    }

}
