package com.demo.utils;

/**
 * @author Vishal.Limbani
 *
 */
public class ObjectRepository {
	
	protected static class HomeScreen {
		
		public static final String toTheMenuButton_Xpath = "//a[@class='btn club-home-button shop-menu-btn']";
		public static final String addressTextBox_Xpath = "//input[@id='address-input']";
		public static final String toTheMenuSearchButton_Xpath = "//input[@class='btn--honest blattgold--form-banner-submit']";
		public static final String agreeCookiesButton_Xpath = "//button[@class='agree-cookie']";
		
	}
	
	protected static class MenuScreen {
		
		public static final String menuButton_Xpath = "//a[contains(@class,'burger-menu btn')]";
		public static final String mamacitaLogo_Xpath = "//*[@title='Mamacita' and @class = 'navigation--link logo--link  mamacita']";
		public static final String restaurantProductsList_Xpath = "//a[@class = 'product--title']";
		public static final String restaurantProductsPriceList_Xpath = "//div[@class = 'product--price']";
		public static final String addToCartButton_Xpath = "//button[@id='topup-modal--close']";
		
		public static final String shoppingCartAmount_Xpath = "//span[@class = 'prices--articles-amount']";
		public static final String shoppingCartItemNameList_Xpath = "//span[contains(@class,'item--name')]";
		public static final String shoppingCartItemPriceList_Xpath = "//span[@class = 'item--price']";
	}

}
