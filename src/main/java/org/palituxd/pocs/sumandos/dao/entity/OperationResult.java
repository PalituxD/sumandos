package org.palituxd.pocs.sumandos.dao.entity;

import java.math.BigDecimal;

public interface OperationResult {

    Long getId();

    String getOp();

    BigDecimal getNumber1();

    BigDecimal getNumber2();

    BigDecimal getResult();

}
