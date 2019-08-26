package org.palituxd.pocs.sumandos.commons;

import lombok.Getter;
import lombok.Setter;
import org.palituxd.pocs.sumandos.dao.entity.OperationResult;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class OperationCommon implements OperationResult, Serializable {
    private Long id;
    private String op;
    private BigDecimal number1;
    private BigDecimal number2;
    private BigDecimal result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationCommon that = (OperationCommon) o;
        return Objects.equals(op, that.op) &&
                Objects.equals(number1, that.number1) &&
                Objects.equals(number2, that.number2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(op, number1, number2);
    }

    @Override
    public String toString() {
        return "OperationCommon{" +
                "op='" + op + '\'' +
                ", number1=" + number1 +
                ", number2=" + number2 +
                ", result=" + result +
                '}';
    }
}
