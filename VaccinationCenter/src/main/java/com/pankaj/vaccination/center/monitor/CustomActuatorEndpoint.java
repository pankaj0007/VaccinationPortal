package com.pankaj.vaccination.center.monitor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "custom")
@Component
public class CustomActuatorEndpoint {
	
	@ReadOperation
	public Map<String, String> getDetails(String username){
		Map<String, String> details = new HashMap<>();
		details.put("stats", "up");
		details.put("key", "down");
		details.put("username", username);
		
		return details;
	}

}
