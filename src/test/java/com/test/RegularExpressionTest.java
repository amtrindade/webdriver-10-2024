package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class RegularExpressionTest extends BaseTest{
	
	
	@BeforeEach
	public void setUp() throws Exception {
		getDriver().get("https://www.geradordecpf.org/");
	}
		
	@Test
	public void testGenerateCpf() throws InterruptedException {
		WebElement cbPoint = getDriver().findElement(By.id("cbPontos"));
		cbPoint.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		Thread.sleep(2000);
		
		WebElement tfNumero = getDriver().findElement(By.id("numero"));
		String cpf = tfNumero.getAttribute("value");
		
		System.out.println(cpf);		
		
		assertTrue(cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"));		
	}
	
	@Test
	public void testGenerateCPFSemMascara() throws InterruptedException {
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		Thread.sleep(2000);
		
		WebElement tfNumero = getDriver().findElement(By.id("numero"));
		String cpf = tfNumero.getAttribute("value");
		
		System.out.println(cpf);		
		
		assertTrue(cpf.matches("^\\d{11}$"));	
		
		
		
		
		
	}

}

