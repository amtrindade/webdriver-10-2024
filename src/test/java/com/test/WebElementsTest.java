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
import org.openqa.selenium.support.ui.Select;

public class WebElementsTest {

	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		// Alterar a pasta de acordo com o path no seu computador
		// C:\\drivers\\chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		// cria o driver
		driver = new ChromeDriver();
		// abre o site
		driver.get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
		Thread.sleep(2000);
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testValidaTituloDaPagina() {
		assertEquals("WebElements Test Page Lab", driver.getTitle());
	}

	@Test
	public void testValidaTextoNoTextField() throws InterruptedException {
		// 1 - Identica o elemento na página
		WebElement textFieldName = driver.findElement(By.name("txtbox1"));

		// 2 - Interação com o elemento na página
		textFieldName.sendKeys("Hello world automation test");

		// 3 - Valida o resultado
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

		// listRadios.get(2).click();

		assertFalse(listRadios.get(0).isSelected());
		assertFalse(listRadios.get(1).isSelected());
		assertTrue(listRadios.get(2).isSelected());
		assertFalse(listRadios.get(3).isSelected());
	}

	@Test
	public void testValidaCheckBoxes() {
		List<WebElement> listCheckBoxes = driver.findElements(By.name("chkbox"));

		assertEquals(4, listCheckBoxes.size());

		for (WebElement checkBox : listCheckBoxes) {
			System.out.println(checkBox.getAttribute("value"));

			// se a condição for verdadeira ou falsa => verdadeiro

			if ((checkBox.getAttribute("value").equals("Check 3"))
					|| (checkBox.getAttribute("value").equals("Check 4"))) {
				checkBox.click();
			}
		}

		assertFalse(listCheckBoxes.get(0).isSelected());
		assertFalse(listCheckBoxes.get(1).isSelected());
		assertTrue(listCheckBoxes.get(2).isSelected());
		assertTrue(listCheckBoxes.get(3).isSelected());
	}

	@Test
	public void testValidaSelectSingle() throws InterruptedException {
		WebElement comboSingle = driver.findElement(By.name("dropdownlist"));

		Select selectSingle = new Select(comboSingle);

		selectSingle.selectByIndex(1);
		assertEquals("Item 2", selectSingle.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		selectSingle.selectByValue("item3");
		assertEquals("Item 3", selectSingle.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		selectSingle.selectByVisibleText("Item 7");

		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());
	}
	
	@Test
	public void testValidaSelectMulti() throws InterruptedException {
		WebElement comboMulti = driver.findElement(By.name("multiselectdropdown"));
		
		Select selectMulti = new Select(comboMulti);
		
		selectMulti.selectByVisibleText("Item 5");
		Thread.sleep(1000);
		selectMulti.selectByVisibleText("Item 8");
		Thread.sleep(1000);
		selectMulti.selectByVisibleText("Item 9");

		List<WebElement> listAllOptions = selectMulti.getAllSelectedOptions();
		
		assertEquals(3, listAllOptions.size());
		
		assertEquals("Item 5", listAllOptions.get(0).getText());
		assertEquals("Item 8", listAllOptions.get(1).getText());
		assertEquals("Item 9", listAllOptions.get(2).getText());
	}

}
