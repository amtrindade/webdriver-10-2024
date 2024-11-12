package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class CalculadoraTest extends BaseTest{
		
	public Random random; 
	//WebDriver wait sendo declarado
	public WebDriverWait wait;
	private WebElement tfNumber1;
	private WebElement tfNumber2;
	private WebElement tfTotal;

	@BeforeEach
	public void setUp() throws Exception {
		
		//WebDriverWait sendo criado
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		random = new Random();
		
		//Abre a página
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		
		//mapeia
		tfNumber1 = getDriver().findElement(By.id("number1"));
		tfNumber2 = getDriver().findElement(By.id("number2"));
		tfTotal = getDriver().findElement(By.xpath("//input[@id='total']"));
	
	}
	
	
	@Test
	public void testSomaPositivos() throws InterruptedException {

		Integer number1 = random.nextInt(100);
		Integer number2 = random.nextInt(100);
		Integer valorTotal = 0;
	
		WebElement btnSomar = getDriver().findElement(By.id("somar"));	
						
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
	
	@Test
	public void testSubtracao() {
		Integer number1 = random.nextInt(100);
		Integer number2 = random.nextInt(100);
		Integer valorTotal = 0;
	
		WebElement btnSubtrair = getDriver().findElement(By.id("subtrair"));	
						
		tfNumber1.sendKeys(number1.toString());
		tfNumber2.sendKeys(number2.toString());
		btnSubtrair.click();
		
		//O teste calcula o valor
		valorTotal = number1 - number2;
		
		//utiliza espera explicita
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.xpath("//input[@id='total']"), valorTotal.toString()));
				
		assertEquals(valorTotal.toString(), tfTotal.getAttribute("value"));		
	
	}
	
	@Test
	public void testMultiplicacao() {
		Integer number1 = random.nextInt(100);
		Integer number2 = random.nextInt(100);
		Integer valorTotal = 0;
	
		WebElement btnMultiplica = getDriver().findElement(By.id("multiplicar"));	
						
		tfNumber1.sendKeys(number1.toString());
		tfNumber2.sendKeys(number2.toString());
		btnMultiplica.click();
		
		//O teste calcula o valor
		valorTotal = number1 * number2;
		
		//utiliza espera explicita
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.xpath("//input[@id='total']"), valorTotal.toString()));
				
		assertEquals(valorTotal.toString(), tfTotal.getAttribute("value"));		
	}
	
	@Test
	public void testDivisao() {
		Integer number1 = 100;
		Integer number2 = 50;
		Integer valorTotal = 0;
	
		WebElement btnDivisao = getDriver().findElement(By.id("dividir"));	
						
		tfNumber1.sendKeys(number1.toString());
		tfNumber2.sendKeys(number2.toString());
		btnDivisao.click();
		
		//O teste calcula o valor
		valorTotal = number1 / number2;
		
		//utiliza espera explicita
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.xpath("//input[@id='total']"), valorTotal.toString()));
				
		assertEquals(valorTotal.toString(), tfTotal.getAttribute("value"));
	}
	
	@Test
	public void testDivisaoPorZero() {
		Integer number1 = 100;
		Integer number2 = 0;
			
		WebElement btnDivisao = getDriver().findElement(By.id("dividir"));	
						
		tfNumber1.sendKeys(number1.toString());
		tfNumber2.sendKeys(number2.toString());
		btnDivisao.click();
				
		//utiliza espera explicita
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.xpath("//input[@id='total']"), "Infinity"));
				
		assertEquals("Infinity", tfTotal.getAttribute("value"));
	}
	
	

}
