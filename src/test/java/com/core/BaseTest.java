package com.core;

import org.junit.jupiter.api.AfterEach;

public class BaseTest {
	
	@AfterEach
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		DriverFactory.killDriver();
	}

}
