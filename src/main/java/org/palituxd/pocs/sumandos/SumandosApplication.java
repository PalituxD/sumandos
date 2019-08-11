package org.palituxd.pocs.sumandos;

import org.palituxd.pocs.sumandos.properties.MessageConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MessageConfigProperties.class)
public class SumandosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SumandosApplication.class, args);
    }

}
