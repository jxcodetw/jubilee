package com.jubilee.dummy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.cloud.config.enabled=false")
class DummyApplicationTests {

	@Test
	void contextLoads() {
	}

}
