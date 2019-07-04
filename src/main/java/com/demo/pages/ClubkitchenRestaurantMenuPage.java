package com.demo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.demo.utils.TestInitilizer;

/**
 * @author Vishal.Limbani
 *
 */
public class ClubkitchenRestaurantMenuPage extends TestInitilizer {

	static WebDriver driver;

	public ClubkitchenRestaurantMenuPage(WebDriver driver) {
		ClubkitchenRestaurantMenuPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = MenuScreen.menuButton_Xpath)
	public WebElement menuButton;

	@FindBy(how = How.XPATH, using = MenuScreen.mamacitaLogo_Xpath)
	public WebElement mamacitaLogo;

	@FindBy(how = How.XPATH, using = MenuScreen.restaurantProductsList_Xpath)
	public List<WebElement> restaurantProducts;
	
	@FindBy(how = How.XPATH, using = MenuScreen.shoppingCartAmount_Xpath)
	public WebElement shoppingCartAmount;
	
	@FindBy(how = How.XPATH, using = MenuScreen.restaurantProductsPriceList_Xpath)
	public List<WebElement> restaurantProductsPrice;
	
	@FindBy(how = How.XPATH, using = MenuScreen.shoppingCartItemPriceList_Xpath)
	public List<WebElement> shoppingCartItemPriceList;
	
	@FindBy(how = How.XPATH, using = MenuScreen.addToCartButton_Xpath)
	public WebElement addToCartButton;
	
	
	public void clickOnMenuButton() {
		
		try {
			menuButton.click();
		} catch (Exception e) {
			log.info("Exception occured while clicking on menu button" + e);
		}
	}
	
	public void clickOnMamacitaLogoButton() {
	
		try {
			mamacitaLogo.click();
		} catch (Exception e) {
			log.info("Exception occured while clicking on mamacita logo button" + e);
		}
	}
	
	public String clickOnProductToAddToCart(String product) {
		
		//Map<String, String> productAndPriceMap = new HashMap<String, String>();
		String price = "";
		try {
			
			for (int i = 0; i < restaurantProducts.size(); i++) {
					if (restaurantProducts.get(i).getText().equalsIgnoreCase(product)) {
						System.out.println("Product found is :: " + restaurantProducts.get(i).getText());
						Thread.sleep(3000);
						restaurantProducts.get(i).click();
						price = restaurantProductsPrice.get(i).getText();
				}
			}
		} catch (Exception e) {
			log.info("Exception occured while adding product" + e);
		}
		return price;
	}
	
	public void clickOnAddToCartButton() {
		
		try {
			addToCartButton.click();
		} catch (Exception e) {
			log.info("Exception occured while clicking on add to cart button" + e);
		}
	}
	
	public String getTotalCartPrice() {
		
		String cartAmount = "";
		try {
			cartAmount = shoppingCartAmount.getText();
		} catch (Exception e) {
			log.info("Exception occured while getting Shopping cart amount" + e);
		}
		return cartAmount;
	}
	
	public String getAllCartProductsTotal() {
		
		String totalValue = "";
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		try {
			for (int i = 0; i < shoppingCartItemPriceList.size(); i++) {
				
				String s = shoppingCartItemPriceList.get(i).getText();
				
				String[] s1 = s.split(",");
				
				String[] s2 = s1[1].split(" ");
				
				a = a + Integer.parseInt(s1[0]);
				
				b = b + Integer.parseInt(s2[0]);
			}
			
			c = b % 100;
			d = b / 100;
			
			a = a + d;
			
			totalValue = Integer.toString(a) + "," + Integer.toString(c) + " €";
			
		} catch (Exception e) {
			log.info("Exception occured while getting Shopping cart amount" + e);
		}
		return totalValue;
	}
	
}
