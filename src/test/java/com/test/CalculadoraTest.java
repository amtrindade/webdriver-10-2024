package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculadoraTest {
	
	public WebDriver driver;
	public Random random; 
	//WebDriver wait sendo declarado
	public WebDriverWait wait;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		//Espera implícita
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebDriverWait sendo criado
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		random = new Random();
		
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		Thread.sleep(2000);
	}

	@AfterEach
	public void tearDown() throws Exception {		
		driver.quit();
	}
	
	@Test
	public void testSomaPositivos() throws InterruptedException {

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
		
		//utiliza espera explicita
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.xpath("//input[@id='total']"), valorTotal.toString()));
				
		assertEquals(valorTotal.toString(), tfTotal.getAttribute("value"));		
	
	}

}
