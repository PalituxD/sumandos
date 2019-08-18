package org.palituxd.pocs.sumandos.actuators;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class HealthCheck implements HealthIndicator {

    private Random random = new Random();

    @Override
    public Health health() {
        int check = check();
        if (check == 10) {
            return Health.up().build();
        } else {
            Map<String, Object> details = new HashMap();
            details.put("Error code", String.valueOf(check));
            return Health.down().withDetails(details).build();
        }
    }

    private int check() {
        int result = 0;
        if (random.nextBoolean()) {
            result = 10;
        }
        return result;
    }
}
