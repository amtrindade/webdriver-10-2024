package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.core.BaseTest;

public class WebElementsTest extends BaseTest{

	
	@BeforeEach
	public void setUp() throws Exception {
		// abre o site
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}
	
	@Test
	public void testValidaTituloDaPagina() {
		assertEquals("WebElements Test Page Lab", getDriver().getTitle());
	}

	@Test
	public void testValidaTextoNoTextField() throws InterruptedException {
		// 1 - Identica o elemento na página
		WebElement textFieldName = getDriver().findElement(By.name("txtbox1"));

		// 2 - Interação com o elemento na página
		textFieldName.sendKeys("Hello world automation test");

		// 3 - Valida o resultado
		assertEquals("Hello world automation test", textFieldName.getAttribute("value"));
	}

	@Test
	public void testValidaTextFieldHabilitadoEDesabilitado() {
		WebElement textFieldName = getDriver().findElement(By.name("txtbox1"));
		assertTrue(textFieldName.isEnabled());

		WebElement textFieldNameDisable = getDriver().findElement(By.name("txtbox2"));
		assertFalse(textFieldNameDisable.isEnabled());
	}

	@Test
	public void testValidaRadioGroup() throws InterruptedException {
		List<WebElement> listRadios = getDriver().findElements(By.name("radioGroup1"));

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
		List<WebElement> listCheckBoxes = getDriver().findElements(By.name("chkbox"));

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
		WebElement comboSingle = getDriver().findElement(By.name("dropdownlist"));

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
		WebElement comboMulti = getDriver().findElement(By.name("multiselectdropdown"));
		
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
	
	@Test
	public void testIFrame() {
		//Entra no iframe
		getDriver().switchTo().frame(0);
		
		WebElement tfIframe = getDriver().findElement(By.id("tfiframe"));
		tfIframe.sendKeys("Escreve no iframe");
		
		assertEquals("Escreve no iframe", tfIframe.getAttribute("value"));
		
		//Volta para o contexto default, a origem
		getDriver().switchTo().defaultContent();
		
	}
	
	@Test
	public void testAlert() throws InterruptedException {
		WebElement btnAlert = getDriver().findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert myAlert = getDriver().switchTo().alert();
			
		assertEquals("Eu sou um alerta!", myAlert.getText());
		
		Thread.sleep(2000);
		
		myAlert.accept();		
		
	}
	
	@Test
	public void testPromptCaminhoFeliz() throws InterruptedException {
		WebElement btnPrompt = getDriver().findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Alert prompt01 = getDriver().switchTo().alert();
		prompt01.sendKeys("2024");
		Thread.sleep(3000);
		prompt01.accept();
		
		Alert prompt02 = getDriver().switchTo().alert();
		assertEquals("O ano é 2024?", prompt02.getText());
		Thread.sleep(2000);
		prompt02.accept();
		
		Alert prompt03 = getDriver().switchTo().alert();
		assertEquals("Feito!", prompt03.getText());
		Thread.sleep(2000);

		prompt03.accept();
	}

}
