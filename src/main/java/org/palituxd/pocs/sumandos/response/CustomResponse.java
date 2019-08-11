package org.palituxd.pocs.sumandos.response;

import lombok.Getter;
import lombok.Setter;
import org.palituxd.pocs.sumandos.properties.CustomMessage;

@Getter
@Setter
public class CustomResponse<T> {

    public enum Status {
        SUCCESS,
        FAILURE
    }

    private T result;
    private Status status;
    private CustomMessage reason;

}
