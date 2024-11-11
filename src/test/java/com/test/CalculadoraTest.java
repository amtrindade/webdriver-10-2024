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
	private WebElement tfNumber1;
	private WebElement tfNumber2;
	private WebElement tfTotal;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		//Espera implícita
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebDriverWait sendo criado
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		random = new Random();
		
		//Abre a página
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		
		//mapeia
		tfNumber1 = driver.findElement(By.id("number1"));
		tfNumber2 = driver.findElement(By.id("number2"));
		tfTotal = driver.findElement(By.xpath("//input[@id='total']"));
		
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
	
		WebElement btnSomar = driver.findElement(By.id("somar"));	
						
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
	
		WebElement btnSubtrair = driver.findElement(By.id("subtrair"));	
						
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
	
		WebElement btnMultiplica = driver.findElement(By.id("multiplicar"));	
						
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
	
		WebElement btnDivisao = driver.findElement(By.id("dividir"));	
						
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
			
		WebElement btnDivisao = driver.findElement(By.id("dividir"));	
						
		tfNumber1.sendKeys(number1.toString());
		tfNumber2.sendKeys(number2.toString());
		btnDivisao.click();
				
		//utiliza espera explicita
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.xpath("//input[@id='total']"), "Infinity"));
				
		assertEquals("Infinity", tfTotal.getAttribute("value"));
	}
	
	

}
