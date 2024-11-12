package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.core.DriverFactory.getDriver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;


public class TablesTest extends BaseTest{
	
	@BeforeEach
	public void setUp() throws Exception {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
		Thread.sleep(2000);
	}
	
	@Test
	public void testValidaXpath() {
		String nome = "Antônio Silva";
		
		WebElement coluna = getDriver().findElement(By.xpath("//td[.='"+ nome +"']/..//td[2]"));
		
		String email = coluna.getText();
		
		WebElement tfReserva = getDriver().findElement(By.name("txtName"));
		tfReserva.sendKeys(email);
		
		assertEquals("antoniosilva@gmail.com", tfReserva.getAttribute("value"));
		
	}
}
