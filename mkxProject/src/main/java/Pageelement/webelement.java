package Pageelement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import Browserlaunch.Browser_initiate;

import org.openqa.selenium.By;


public class webelement extends Browser_initiate{
	   // protected static WebDriver driver;
	    
	    public static void setDriver(WebDriver webDriver) {
	        driver = webDriver;
	    }
		public static void click(String locator) {
			driver.findElement(By.xpath(locator)).click();
		}
		
		public static void id(String locator) {
			driver.findElement(By.xpath("//input[@id='" + locator + "']")).click();
		}

		public static void clear(String locator) {
			driver.findElement(By.xpath(locator)).clear();
		}

		public static void send(String locator, String value) {

			driver.findElement(By.xpath(locator)).sendKeys(value);

		}

		
		public static String getCurrentDateTime() {

			Date date = new Date();

			DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");

			String formattedDate = dateFormat.format(date);

			System.out.println("Current Date and Time: " + formattedDate);

			return formattedDate;

			}

//			public static boolean isErrorPopupDisplay() {
	//
//			return WebElements.isDisplay(Locators.errorValidation);
	//
//			 
	//
//			}

//			public static boolean isSuccessPopupDisplay() {
	//
//			return WebElements.isDisplay(Locators.SaveValidation);
	//
//			 
	//
//			}

		public static String getRandomStringNumber() {

			return String.valueOf(getRandomNumber(99999));

		}

		public static int getRandomNumber(int upperBound) {

			if (upperBound < 0) {

				// fail("bound must be positive: " + upperBound);

			}

			int randomNumber = new Random().nextInt(upperBound);

			randomNumber = randomNumber == 0 ? 1 : randomNumber;

			return randomNumber;

		}

		public static String GetRandomPhone() {

			String phoneNumber = String.format("(%03d) %03d-%04d", (int) Math.floor(999 * Math.random()),

					(int) Math.floor(999 * Math.random()), (int) Math.floor(9999 * Math.random()));

			System.out.println("the random phone number is " + phoneNumber);

			return phoneNumber;

		}

		public static String getText(String locator) {

			WebElement process = driver.findElement(By.xpath(locator));

			return process.getText();

		}
		
		
		public static void selectDropDownOption(String option, String dropDownOption) {
			WebElement findElement = driver.findElement(By.xpath("//select[@id='" + option + "']"));
			Select select = new Select(findElement);
			select.selectByVisibleText(dropDownOption);
			}

		public static void dropdown(WebDriver driver, By locator, String text) {

			WebElement element = driver.findElement(locator);

			Select choice = new Select(element);

			choice.selectByVisibleText(text);

		}

		public static void simpleAlert(WebDriver driver) {

			Alert confirm = driver.switchTo().alert();

			confirm.accept();

		}

		public static void popup() {

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--disable-notifications");

		}

		public static void wait(int duration) {

			try {

				Thread.sleep(duration);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		public static void frameElement() {

			WebElement element = driver.findElement(By.xpath("//iframe[@title='Secure card payment input frame']"));

			driver.switchTo().frame(element);

		}

		public static void scrollByjavaScriptExecutor(WebDriver driver, WebElement element) {

			JavascriptExecutor js1 = (JavascriptExecutor) driver;

			js1.executeScript("arguments[0].scrollIntoView();", element);

		}

		public static boolean isDisplay(String element)

		{

			try {

				driver.findElement(By.xpath(element)).isDisplayed();

				return true;

			}

			catch (Exception ex) {

				System.out.println("not displayed");

				return false;

			}

		}

		public static void enter(String dateOfBirth, Keys enter) {
			
			driver.findElement(By.xpath(dateOfBirth));
		}

	}