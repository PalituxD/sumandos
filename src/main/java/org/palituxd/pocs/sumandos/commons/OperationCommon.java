package org.palituxd.pocs.sumandos.commons;

import lombok.Getter;
import lombok.Setter;
import org.palituxd.pocs.sumandos.dao.entity.OperationResult;

import java.math.BigDecimal;

@Getter
@Setter
public class OperationCommon implements OperationResult {
    private Long id;
    private String op;
    private BigDecimal number1;
    private BigDecimal number2;
    private BigDecimal result;
}
