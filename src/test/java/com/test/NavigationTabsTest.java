package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class NavigationTabsTest extends BaseTest{
	
	
	@BeforeEach
	public void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao");
		
	}

	@Test
	public void testNavegacaoPorAbas() {
		
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
				
		WebElement linkBookStore = getDriver().findElement(By.linkText("Book Store"));
		linkBookStore.click();
		
		WebElement linkDragAndDrop = getDriver().findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		//Cria um array com as posições das tabs que estão abertas
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		//navega posicão 1
		getDriver().switchTo().window(tabs.get(1));
				
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());

		//navega posicão 2
		getDriver().switchTo().window(tabs.get(2));

		assertEquals("Login", getDriver().getTitle());
		
		//navega posicão 0
		getDriver().switchTo().window(tabs.get(0));
		
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
	}


}
