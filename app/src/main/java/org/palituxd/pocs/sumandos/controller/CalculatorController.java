package org.palituxd.pocs.sumandos.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.palituxd.pocs.sumandos.base.CustomMessage;
import org.palituxd.pocs.sumandos.base.exception.CustomException;
import org.palituxd.pocs.sumandos.base.response.CustomResponse;
import org.palituxd.pocs.sumandos.service.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorController {

    private Counter counter;

    @Autowired
    private Operation operation;

    public CalculatorController(@Autowired MeterRegistry registry) {
        this.counter = Counter.builder("service.invocations").description("Total service invocations").register(registry);
    }

    @RequestMapping(value = "${url.addition}/{num1}/{num2}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public CustomResponse<BigDecimal> add(@PathVariable String num1, @PathVariable String num2) {
        counter.increment();
        CustomResponse<BigDecimal> customResponse = new CustomResponse<>();
        try {
            customResponse.setResult(operation.sum(num1, num2));
            customResponse.setStatus(CustomResponse.Status.SUCCESS);
        } catch (CustomException e) {
            customResponse.setStatus(CustomResponse.Status.FAILURE);
            customResponse.setReason(e.getCustomMessage());
        } catch (Exception e) {
            customResponse.setStatus(CustomResponse.Status.FAILURE);
            CustomMessage cm = new CustomMessage();
            cm.setMessage(e.getMessage());
            cm.setCode("NN");
            customResponse.setReason(cm);
        }
        return customResponse;
    }
}
