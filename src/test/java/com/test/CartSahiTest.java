package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.IndexPage;
import com.page.LoginPage;

public class CartSahiTest extends BaseTest{
	
	LoginPage loginPage;
	IndexPage indexPage;
	
	@BeforeEach
	public void setUp() {
		loginPage = new LoginPage();
		loginPage.open();
		loginPage.insertUsername("test");
		loginPage.insertPass("secret");
		indexPage = loginPage.clickLoginValid();		
	}
	
	@Test
	public void testAddCart() {
		indexPage.insertQuantity("Core Java", "2");
		indexPage.insertQuantity("Ruby for Rails", "3");
		indexPage.insertQuantity("Python Cookbook", "4");
		
		indexPage.addCart();
		
		assertEquals("2600", indexPage.getTotalValue());		
	}
	
	@Test
	public void testAddCartTwoBooks() {
		indexPage.insertQuantity("Core Java", "10");
		indexPage.insertQuantity("Ruby for Rails", "3");	
		
		indexPage.addCart();
		
		assertEquals("3600", indexPage.getTotalValue());
		
	}

}
