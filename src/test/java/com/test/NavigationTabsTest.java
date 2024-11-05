package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTabsTest {
	
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
	public void testNavegacaoPorAbas() {
		
		assertEquals("Treino Automação de Testes", driver.getTitle());
				
		WebElement linkBookStore = driver.findElement(By.linkText("Book Store"));
		linkBookStore.click();
		
		WebElement linkDragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		//Cria um array com as posições das tabs que estão abertas
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		//navega posicão 1
		driver.switchTo().window(tabs.get(1));
				
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());

		//navega posicão 2
		driver.switchTo().window(tabs.get(2));

		assertEquals("Login", driver.getTitle());
		
		//navega posicão 0
		driver.switchTo().window(tabs.get(0));
		
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
	}


}
