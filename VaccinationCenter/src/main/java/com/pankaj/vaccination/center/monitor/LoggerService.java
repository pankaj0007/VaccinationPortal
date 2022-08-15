package com.pankaj.vaccination.center.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LoggerService implements HealthIndicator {

	public final String LOGGER_SERVICE = "Logger Service";
	@Override
	public Health health() {
		if(isLoggerServiceHealthy()) {
			return Health.up().withDetail(LOGGER_SERVICE, "Service is up and running").build();
		}else {
			return Health.down().withDetail(LOGGER_SERVICE, "Service isunavailable").build();
		}
	}
	
	public boolean isLoggerServiceHealthy() {
		//Custom logic to check logger service status
		return true;
	}

}
