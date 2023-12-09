package com.piinalpin.rnd.workitemservice;

import org.kie.server.springboot.autoconfiguration.drools.ScenarioSimulationKieServerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		ScenarioSimulationKieServerAutoConfiguration.class
})
public class WorkitemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkitemServiceApplication.class, args);
	}

}
