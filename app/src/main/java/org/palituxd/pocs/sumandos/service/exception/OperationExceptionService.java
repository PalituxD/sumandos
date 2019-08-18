package org.palituxd.pocs.sumandos.service.exception;

import org.palituxd.pocs.sumandos.base.CustomMessage;
import org.palituxd.pocs.sumandos.properties.MessageConfigProperties;
import org.palituxd.pocs.sumandos.service.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationExceptionService {

    @Autowired
    private MessageConfigProperties messageConfigProperties;

    public OperationException throwBadNumberFormat(OperationType operationType, String op) {

        Reason reason = Reason.BAD_NUMBER_FORMAT;
        CustomMessage customMessage = messageConfigProperties.getMessages().get(reason.getKey()).clone();
        customMessage.setSource(operationType.name());
        String parameters[] = {op};

        return OperationException.builder()
                .reason(reason)
                .customMessage(customMessage)
                .parameters(parameters)
                .build();
    }

}
