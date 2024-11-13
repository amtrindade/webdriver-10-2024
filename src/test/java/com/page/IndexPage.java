package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;

public class IndexPage {
	
	public Boolean isLoggedUser() {
		WebElement h2Title = getDriver().findElement(By.xpath("//div[@id='available']/h2"));
		return h2Title.getText().equals("All available books");		
	}
	
	public IndexPage insertQuantity(String bookName, String quantity) {
		WebElement tfBook = getDriver().findElement(By.xpath("//td[.='"+ bookName +"']/..//input"));
		tfBook.sendKeys(quantity);
		return this;	
	}
	
	public IndexPage addCart() {
		WebElement btnAddCart = getDriver().findElement(By.xpath("//input[@value='Add']"));
		btnAddCart.click();
		return this;
	}
	
	public String getTotalValue() {
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		return tfTotal.getAttribute("value");
	}
	

}
