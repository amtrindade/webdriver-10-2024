package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculadoraTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		Thread.sleep(2000);
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testSomaPositivos() throws InterruptedException {
		
		Random random = new Random();
		
		Integer number1 = random.nextInt(100);
		Integer number2 = random.nextInt(100);
		Integer valorTotal = 0;
		
		WebElement tfNumber1 = driver.findElement(By.id("number1"));
		WebElement tfNumber2 = driver.findElement(By.id("number2"));
		WebElement btnSomar = driver.findElement(By.id("somar"));	
		WebElement tfTotal = driver.findElement(By.xpath("//input[@id='total']"));
		
				
		tfNumber1.sendKeys(number1.toString());
		tfNumber2.sendKeys(number2.toString());
		btnSomar.click();
		
		//O teste calcula o valor
		valorTotal = number1 + number2;
		
		Thread.sleep(3000);
		
		assertEquals(valorTotal.toString(), tfTotal.getAttribute("value"));		
	
	}

}
