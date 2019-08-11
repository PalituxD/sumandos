package org.palituxd.pocs.sumandos.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@PropertySource("classpath:messages.properties")
@ConfigurationProperties
@Getter
@Setter
public class MessageConfigProperties {

    private Map<String, CustomMessage> messages;
}
