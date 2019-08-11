package org.palituxd.pocs.sumandos.service.exception;

import lombok.Builder;
import lombok.Getter;
import org.palituxd.pocs.sumandos.base.exception.CustomException;
import org.palituxd.pocs.sumandos.base.CustomMessage;

@Getter
public class OperationException extends CustomException {

    private Reason reason;
    private String[] parameters;
    private String message;

    @Builder
    public OperationException(Reason reason, CustomMessage customMessage, String[] parameters) {
        super(customMessage);
        this.reason = reason;
        this.parameters = parameters;
        this.message = customMessage.getMessage();
    }

    @Override
    public String getExplanation() {
        if (Reason.BAD_NUMBER_FORMAT.equals(this.reason)) {
            return String.format(message, parameters[0]);
        }
        return null;
    }
}