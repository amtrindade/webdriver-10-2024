package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(2000);
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testDragAndDrop() {
		WebElement origin = driver.findElement(By.id("draggable"));
		WebElement destiny = driver.findElement(By.id("droppable"));
		
		assertEquals("Drag me to my target", origin.getText());
		assertEquals("Drop here", destiny.getText());
		
		//Actions webdriver
		new Actions(driver).dragAndDrop(origin, destiny).perform();
		
		assertEquals("Dropped!", destiny.getText());	
	}

}
