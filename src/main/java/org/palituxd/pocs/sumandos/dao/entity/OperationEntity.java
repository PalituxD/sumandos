package org.palituxd.pocs.sumandos.dao.entity;

import org.palituxd.pocs.sumandos.commons.OperationCommon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "operation")
public class OperationEntity extends OperationCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getOp() {
        return super.getOp();
    }

    @Override
    public BigDecimal getNumber1() {
        return super.getNumber1();
    }

    @Override
    public BigDecimal getNumber2() {
        return super.getNumber2();
    }

    @Override
    public BigDecimal getResult() {
        return super.getResult();
    }
}
