package org.palituxd.pocs.sumandos.service.impl;

import org.palituxd.pocs.sumandos.commons.OperationCommon;
import org.palituxd.pocs.sumandos.dao.entity.OperationEntity;
import org.palituxd.pocs.sumandos.dao.repository.OperationRepository;
import org.palituxd.pocs.sumandos.dao.repository.cache.OperationRepositoryCache;
import org.palituxd.pocs.sumandos.service.Operation;
import org.palituxd.pocs.sumandos.service.OperationType;
import org.palituxd.pocs.sumandos.service.exception.OperationExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OperationImp implements Operation {

    @Autowired
    private OperationExceptionService operationExceptionService;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationRepositoryCache operationRepositoryCache;

    public BigDecimal sum(String op1, String op2) {

        validateNumbers(OperationType.ADDITION, op1, op2);
        BigDecimal result = BigDecimal.valueOf(Double.valueOf(op1).intValue() + Double.valueOf(op2).intValue());
        OperationCommon operationCommon = new OperationCommon();
        operationCommon.setOp(OperationType.ADDITION.name());
        operationCommon.setNumber1(new BigDecimal(op1));
        operationCommon.setNumber2(new BigDecimal(op2));
        operationCommon.setResult(result);

        if (operationRepositoryCache.contains(operationCommon)) {
            return operationRepositoryCache.get(operationCommon).getResult();
        } else {
            operationRepositoryCache.add(operationCommon);
        }

        OperationEntity savedOperation = operationRepository.findByOpAndNumber1AndNumber2(
                operationCommon.getOp(),
                operationCommon.getNumber1(),
                operationCommon.getNumber2());

        if (savedOperation != null) {
            return savedOperation.getResult();
        }
        persistOperation(operationCommon);
        return operationCommon.getResult();
    }

    private void persistOperation(OperationCommon operationCommon) {
        OperationEntity operationEntity = new OperationEntity();
        operationEntity.setOp(operationCommon.getOp());
        operationEntity.setNumber1(operationCommon.getNumber1());
        operationEntity.setNumber2(operationCommon.getNumber2());
        operationEntity.setResult(operationCommon.getResult());
        operationRepository.save(operationEntity);
    }

    private void validateNumbers(OperationType operationSource, String... numbers) {
        for (int index = 0, limit = numbers.length; index < limit; index++) {
            try {
                Double.valueOf(numbers[index]);
            } catch (NumberFormatException nfe) {
                throw operationExceptionService.throwBadNumberFormat(operationSource, numbers[index]);
            }
        }
    }
}
