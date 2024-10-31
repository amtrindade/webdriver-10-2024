package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
		Thread.sleep(2000);
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
	
	@Test
	public void testValidaTextFieldHabilitadoEDesabilitado() {
		WebElement textFieldName = driver.findElement(By.name("txtbox1"));
		assertTrue(textFieldName.isEnabled());
		
		WebElement textFieldNameDisable = driver.findElement(By.name("txtbox2"));
		assertFalse(textFieldNameDisable.isEnabled());		
	}
	
	@Test
	public void testValidaRadioGroup() throws InterruptedException {
		List<WebElement> listRadios = driver.findElements(By.name("radioGroup1"));
		
		for (WebElement radio : listRadios) {
			System.out.println(radio.getAttribute("value"));
			
			if (radio.getAttribute("value").equals("Radio 3")) {
				radio.click();
				break;
			}
		}
		
		//listRadios.get(2).click();
		
		Thread.sleep(2000);
		
		assertFalse(listRadios.get(0).isSelected());
		assertFalse(listRadios.get(1).isSelected());
		assertTrue(listRadios.get(2).isSelected());
		assertFalse(listRadios.get(3).isSelected());
	}

}





