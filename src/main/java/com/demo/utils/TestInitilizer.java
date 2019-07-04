package com.demo.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.sun.javafx.PlatformUtil;
/**
 * @author Vishal.Limbani
 *
 */

public class TestInitilizer extends ObjectRepository{
	
	public static WebDriver driver;
	protected static final Logger log = Logger.getLogger(TestInitilizer.class);
	public static String currentMethodName;
	public static WebDriverWait wait = null;
	public static final PropertiesCache cache = PropertiesCache.getInstance();
	public static String url = cache.getProperty("url");
	public static String ScreenshotsPath = cache.getProperty("Screenshots");
	public static FileInputStream fis = null;
	public FileOutputStream fos = null;
	public static final String CurrentUserDirectory = System.getProperty("user.dir");


	@BeforeSuite
	public static void Setup() throws InterruptedException, IOException {
		
		log.info(":::::::::::::::::::: Launching webdriver ::::::::::::::::::::");
		try {

			if (PlatformUtil.isWindows()) {
				System.setProperty("webdriver.chrome.driver", cache.getProperty("driverPath") + "chromedriver.exe");

			}

			else if (PlatformUtil.isMac()) {
				System.setProperty("webdriver.chrome.driver", cache.getProperty("driverPath") + "chromedriver");
			}
			
			else if (PlatformUtil.isLinux()) {
				System.setProperty("webdriver.chrome.driver", cache.getProperty("driverPath") + "chromedriver_linux");
			}

			log.info(" =================================================== ");
			log.info("Url is :: " + url);
			log.info(" =================================================== ");

			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		} catch (WebDriverException e) {
			driver.close();
		}
	}

	@AfterClass
	public void tearDown() {
		log.info("Tests Ended from class :::::" + this.getClass().getSimpleName());
	}

	@BeforeMethod
	public static void beforeMethodCalled(Method method) throws InterruptedException {

		currentMethodName = method.getName();
		log.info("Testcase name is :::::: " + method.getName());
		log.info(method.getName() + " Started ::::");

	}

	@AfterMethod()
	public static void afterMethodCalled(Method method) throws InterruptedException, IOException {

		log.info("Testcase execution completed :::::: " + method.getName());
	}

	@AfterSuite
	public static void suiteEndReached() throws IOException, InterruptedException {

		log.info("Logger Info:: Inside suiteEndReached Method");
		log.info("Suite ended");
		driver.quit();
	}

	public static void sendKeys(String text, WebElement we, String objectName) throws InterruptedException {

		we.clear();
		we.sendKeys(text);
	}

	public static void sendKeysFromKeyBoard(Keys key, WebElement we, String objectName) throws InterruptedException {
		we.sendKeys(key);
	}
	
	@BeforeClass
	public static void setApplicationLoginPage() throws InterruptedException {
		//String currectClassNameToBeExecuted = this.getClass().getSimpleName();
		//log.info("class Name " + currectClassNameToBeExecuted);
		try {
			driver.navigate().to(url);
		} catch (NoSuchElementException e) {
			log.info("Unable to move login page. trying to logout application");
		}
	}

}
