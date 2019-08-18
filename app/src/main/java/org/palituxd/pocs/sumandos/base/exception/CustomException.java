package org.palituxd.pocs.sumandos.base.exception;

import lombok.AllArgsConstructor;
import org.palituxd.pocs.sumandos.base.CustomMessage;

@AllArgsConstructor
public abstract class CustomException extends RuntimeException implements Explainable {

    private CustomMessage customMessage;

    public final CustomMessage getCustomMessage() {
        customMessage.setMessage(getExplanation());
        return customMessage;
    }
}
