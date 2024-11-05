package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CacheTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao");
		Thread.sleep(2000);
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testNavegacaCache() throws InterruptedException {
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement linkCalculadora = driver.findElement(By.linkText("Calculadora"));
		linkCalculadora.click();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		
		WebElement linkLocalicarTable = driver.findElement(By.linkText("Localizar Table"));
		linkLocalicarTable.click();
		assertEquals("Trabalhando com tables", driver.getTitle());
		
		//Ações de navegação
		driver.navigate().back();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().back();
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		driver.navigate().forward();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().forward();
		assertEquals("Trabalhando com tables", driver.getTitle());
	}


}
