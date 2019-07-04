package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.demo.utils.TestInitilizer;
import com.demo.utils.TestUtil;

/**
 * @author Vishal.Limbani
 * 
 */
public class ClubkitchenHomePage extends TestInitilizer{
	
	static WebDriver driver;
	
	public ClubkitchenHomePage(WebDriver driver) {
		ClubkitchenHomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = HomeScreen.toTheMenuButton_Xpath)
	public WebElement toTheMenuButton;
	
	@FindBy(how = How.XPATH, using = HomeScreen.addressTextBox_Xpath)
	public WebElement addressTextBox;
	
	@FindBy(how = How.XPATH, using = HomeScreen.toTheMenuSearchButton_Xpath)
	public WebElement toTheMenuSearchButton;
	
	@FindBy(how = How.XPATH, using = HomeScreen.agreeCookiesButton_Xpath)
	public WebElement agreeCookiesButton;
	
	public void clickOnToTheMenuButton() {
		
		try {
			toTheMenuButton.click();
		} catch (Exception e) {
			log.info("Exception occured while clicking on To the menu button" + e);
		}
	}
	
	public void enterDeliveryAddress(String address) {
		
		try {
			sendKeys(address, addressTextBox, "Enter delivery address");
		} catch (Exception e) {
			log.info("Exception occured while entering delivery address" + e);
		}
	}
	
	public void clickOnToTheMenuSearchButton() {
		
		try {
			toTheMenuSearchButton.click();
		} catch (Exception e) {
			log.info("Exception occured while clicking on To the menu search button" + e);
		}
	}
	
	public void clickOnAgreeCookiesButton() {
		
		try {
			TestUtil.explicitWait(agreeCookiesButton, "Agree cookies button");
			agreeCookiesButton.click();
		} catch (Exception e) {
			log.info("Exception occured while clicking on Agree cookies button" + e);
		}
	}
}
