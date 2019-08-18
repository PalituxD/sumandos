package org.palituxd.pocs.sumandos.services.conf;

import org.palituxd.pocs.sumandos.properties.MessageConfigProperties;
import org.palituxd.pocs.sumandos.service.exception.OperationExceptionService;
import org.palituxd.pocs.sumandos.service.impl.OperationImp;
import org.springframework.context.annotation.Bean;

public class SumandosServicesConfiguration {

    @Bean
    public OperationImp operationDefault() {
        return new OperationImp();
    }

    @Bean
    public OperationExceptionService operationExceptionService() {
        return new OperationExceptionService();
    }

    @Bean
    public MessageConfigProperties messageConfigProperties() {
        return new MessageConfigProperties();
    }
}
