package org.palituxd.pocs.sumandos.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.palituxd.pocs.sumandos.service.Operation;
import org.palituxd.pocs.sumandos.services.conf.SumandosServicesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SumandosServicesConfiguration.class)
public class SumandosServicesTests {

    @Autowired
    private Operation operationService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSum() {
        final String num1 = "2";
        final String num2 = "5";

        BigDecimal sum = operationService.sum(num1, num2);
        Assert.assertEquals(sum, BigDecimal.valueOf(7));
    }

}
