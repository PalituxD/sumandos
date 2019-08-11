package org.palituxd.pocs.sumandos.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomMessage implements Cloneable {

    private String code;
    private String message;
    private String source;

    @Override
    public CustomMessage clone() {
        CustomMessage newObject = new CustomMessage();
        newObject.setCode(code);
        newObject.setMessage(message);
        return newObject;
    }
}
