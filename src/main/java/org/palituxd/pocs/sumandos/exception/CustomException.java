package org.palituxd.pocs.sumandos.exception;

import lombok.AllArgsConstructor;
import org.palituxd.pocs.sumandos.properties.CustomMessage;

@AllArgsConstructor
public abstract class CustomException extends RuntimeException implements Explainable {

    private CustomMessage customMessage;

    public final CustomMessage getCustomMessage() {
        customMessage.setMessage(getExplanation());
        return customMessage;
    }
}
