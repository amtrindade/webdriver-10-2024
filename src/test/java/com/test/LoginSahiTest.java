package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.IndexPage;
import com.page.LoginPage;

public class LoginSahiTest extends BaseTest{
	
	@Test 
	public void testLoginPasswordInvalid() {
		
		LoginPage loginPage = new LoginPage();
		loginPage.open();
		loginPage.insertUsername("test");
		loginPage.insertPass("error");
		loginPage.clickLoginInvalid();
		
		assertEquals("Invalid username or password", loginPage.getMessageError());
	}
	
	@Test 
	public void testLoginUserInvalid() {
		
		LoginPage loginPage = new LoginPage();
		loginPage.open();
		loginPage.insertUsername("error");
		loginPage.insertPass("secret");
		loginPage.clickLoginInvalid();
		
		assertEquals("Invalid username or password", loginPage.getMessageError());
	}
	
	@Test 
	public void testLoginSuccess() {
		
		LoginPage loginPage = new LoginPage();
		loginPage.open();
		loginPage.insertUsername("test");
		loginPage.insertPass("secret");
		IndexPage indexPage = loginPage.clickLoginValid();
		assertTrue(indexPage.isLoggedUser());		
	}

}
