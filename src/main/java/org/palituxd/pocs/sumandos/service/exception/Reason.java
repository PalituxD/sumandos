package org.palituxd.pocs.sumandos.service.exception;

import lombok.Getter;

public enum Reason {

    BAD_NUMBER_FORMAT("bad-number-format");

    @Getter
    private String key;

    Reason(String key) {
        this.key = key;
    }
}
