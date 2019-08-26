package org.palituxd.pocs.sumandos.dao.repository;

import org.palituxd.pocs.sumandos.dao.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

    OperationEntity findByOpAndNumber1AndNumber2(String op, BigDecimal number1, BigDecimal number2);
}