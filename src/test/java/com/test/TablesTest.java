package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesTest {

	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
		Thread.sleep(2000);
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testValidaXpath() {
		String nome = "Antônio Silva";
		
		WebElement coluna = driver.findElement(By.xpath("//td[.='"+ nome +"']/..//td[2]"));
		
		String email = coluna.getText();
		
		WebElement tfReserva = driver.findElement(By.name("txtName"));
		tfReserva.sendKeys(email);
		
		assertEquals("antoniosilva@gmail.com", tfReserva.getAttribute("value"));
		
	}
}
