package com.page;


import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public LoginPage open() {		
		getDriver().get("http://sahitest.com/demo/training/login.htm");		
		return this;
	}
	
	public LoginPage insertUsername(String user) {
		WebElement tfUser = getDriver().findElement(By.name("user"));
		tfUser.sendKeys(user);
		return this;
	}
	
	public LoginPage insertPass(String password) {
		WebElement tfPass = getDriver().findElement(By.name("password"));
		tfPass.sendKeys(password);
		return this;
	}
	
	public LoginPage clickLoginInvalid() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();
		return this;
	}
	
	public String getMessageError() {
		WebElement divError = getDriver().findElement(By.id("errorMessage"));
		return divError.getText();
	}
	
	public IndexPage clickLoginValid() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();
		return new IndexPage();
	}

}
