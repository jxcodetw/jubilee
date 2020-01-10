package com.jubilee.eurekaservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.cloud.config.enabled=false")
class EurekaServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
