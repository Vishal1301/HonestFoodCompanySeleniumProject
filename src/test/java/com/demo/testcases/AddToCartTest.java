package com.demo.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pages.ClubkitchenHomePage;
import com.demo.pages.ClubkitchenRestaurantMenuPage;
import com.demo.utils.TestInitilizer;

/**
 * @author Vishal.Limbani
 *
 */
public class AddToCartTest extends TestInitilizer{
	
	 @Test
	    public void addToCartFromMamacita() throws InterruptedException {
		 
		 ClubkitchenHomePage clubkitchenHomePage = new ClubkitchenHomePage(driver);
		 ClubkitchenRestaurantMenuPage clubkitchenRestaurantMenuPage = new ClubkitchenRestaurantMenuPage(driver);
		 
		 clubkitchenHomePage.clickOnAgreeCookiesButton();
		 clubkitchenHomePage.clickOnToTheMenuButton();
		 clubkitchenHomePage.enterDeliveryAddress("Semperstrasse 44, 1180 Vienna, Austria");
		 Thread.sleep(3000);
		 clubkitchenHomePage.clickOnToTheMenuSearchButton();
		 Thread.sleep(5000);
		 clubkitchenRestaurantMenuPage.clickOnMenuButton();
		 Thread.sleep(2000);
		 clubkitchenRestaurantMenuPage.clickOnMamacitaLogoButton();
		 Thread.sleep(2000);
		 String price = clubkitchenRestaurantMenuPage.clickOnProductToAddToCart("Avocado Crush Burrito");
		 System.out.println("Price of product is :: " + price);
		 Thread.sleep(2000);
		 clubkitchenRestaurantMenuPage.clickOnAddToCartButton();
		 Thread.sleep(2000);
		 String cartPrice = clubkitchenRestaurantMenuPage.getTotalCartPrice();
		 System.out.println("Cart price is :: " + cartPrice);
		 String pp = clubkitchenRestaurantMenuPage.getAllCartProductsTotal();
		 System.out.println("Total Cart price is :: " + pp);
		 Assert.assertEquals(pp, cartPrice, "Actualt product price does not match with total cart price, Actual price :: " + pp + "Cart price :: " + cartPrice);
	 }
}
