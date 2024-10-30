package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebElementsTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		//Alterar a pasta de acordo com o path no seu computador
		//C:\\drivers\\chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		//cria o driver
		driver = new ChromeDriver();
		//abre o site
		driver.get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testValidaTituloDaPagina() {
		assertEquals("WebElements Test Page Lab", driver.getTitle());
	}
	
	@Test
	public void testValidaTextoNoTextField() throws InterruptedException {
		//1 - Identica o elemento na página
		WebElement textFieldName = driver.findElement(By.name("txtbox1"));
		//2 - Interação com o elemento na página		
		textFieldName.sendKeys("Hello world automation test");
				
		Thread.sleep(3000);
		//3 - Valida o resultado
		assertEquals("Hello world automation test", textFieldName.getAttribute("value"));
	}

}
