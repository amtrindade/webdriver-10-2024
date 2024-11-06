package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressionTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.geradordecpf.org/");
		Thread.sleep(2000);
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testGenerateCpf() throws InterruptedException {
		WebElement cbPoint = driver.findElement(By.id("cbPontos"));
		cbPoint.click();
		
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		Thread.sleep(2000);
		
		WebElement tfNumero = driver.findElement(By.id("numero"));
		String cpf = tfNumero.getAttribute("value");
		
		System.out.println(cpf);		
		
		assertTrue(cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"));		
	}
	
	@Test
	public void testGenerateCPFSemMascara() throws InterruptedException {
		
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		Thread.sleep(2000);
		
		WebElement tfNumero = driver.findElement(By.id("numero"));
		String cpf = tfNumero.getAttribute("value");
		
		System.out.println(cpf);		
		
		assertTrue(cpf.matches("^\\d{11}$"));	
		
		
		
		
		
	}

}

