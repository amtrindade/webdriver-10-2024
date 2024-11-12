package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.DriverFactory;

public class IndexPage {
	
	public Boolean isLoggedUser() {
		WebElement h2Title = DriverFactory.getDriver().findElement(By.xpath("//div[@id='available']/h2"));
		return h2Title.getText().equals("All available books");		
	}

}
