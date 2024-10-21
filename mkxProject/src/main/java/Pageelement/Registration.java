package Pageelement;

import java.util.Properties;
import java.util.Random;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogLevelMapping;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;

import Browserlaunch.Browser_initiate;

public class Registration extends Browser_initiate {
	// Assuming 'elements' is a class that holds locators

	private WebDriverWait wait;
	protected static String getusername;
	protected static String firstnameuser;
	protected static String lastnameuser;
	private Properties properties;
	//private static final String EXCEL_FILE_PATH = "/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx";
    //private static final String PROPERTIES_FILE_PATH = "/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties";

	// Constructor
	public Registration(WebDriver driver) {
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20)); // Adjust timeout as needed
	}

	public void selectAccept() {
		webelement.wait(1500);
		if (webelement.isDisplay(elements.close)) {
			webelement.click(elements.close);
		} else {
			System.out.println("Accept popup not is displayed");
		}
	}

	public void adminlog() {
		webelement.wait(2500);
		selectAccept();
		webelement.wait(1500);
		webelement.click(elements.username_login);
		webelement.send(elements.username_login, "mkx-business-admin");
		WebElement passwordField = driver.findElement(By.xpath(elements.password_login));
		passwordField.click();
		passwordField.sendKeys("Bu@Admin123");
		WebElement signInButton = driver.findElement(By.xpath(elements.signIn));
		signInButton.click();
	}

	public void login_user() {
		selectAccept();
//        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.username_login)));
//        usernameField.sendKeys(usr);
		webelement.click(elements.username_login);
		webelement.send(elements.username_login, getusername);
		WebElement passwordField = driver.findElement(By.xpath(elements.password_login));
		passwordField.sendKeys("As@12345");
		WebElement signInButton = driver.findElement(By.xpath(elements.signIn));
		signInButton.click();
		UpdateCardDetailDisplay();
		webelement.wait(1500);
		webelement.click(elements.team);
		webelement.click(elements.manage_team);
		webelement.click(elements.referal_genealogy);
		webelement.wait(3500);
		webelement.click(elements.imagepic);
		webelement.wait(8000);
		webelement.click(elements.sales_amount);

	}

	public static void UpdateCardDetailDisplay() {
		if (webelement.isDisplay(elements.cardUpdate)) {
			webelement.click(elements.cardUpdate);
			webelement.click(elements.yesOption);
		} else {
			System.out.println("not displayed");
		}
	}

	public static void holding_Tank() throws IOException {
		
		webelement.wait(3500);
		webelement.click(elements.team);
		webelement.click(elements.manage_team);
		webelement.click(elements.holding_Tank);
		webelement.wait(3500);
		webelement.click(elements.filter);
		WebElement userField = driver.findElement(By.xpath(elements.user));
		userField.click();
		userField.sendKeys(firstnameuser);
		webelement.wait(4000);
		try {
			WebElement option = driver.findElement(By.xpath("//ul[@id='ui-id-1']//li"));
			option.click();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
			System.out.println("sucess");
		}
		webelement.click(elements.search);
		//if need no changes
		//placement right
				//webelement.selectDropDownOption("id_binary_position", "Bottom Right");
				// Bottom Left
		//webelement.click(elements.submit);
		sponsor_choose();
	}
		//choosing sponsor change
		public static void sponsor_choose() throws IOException {
			FileInputStream file = new FileInputStream("/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties");
			Properties ps = new Properties();
			ps.load(file);
			String new_sponsor = ps.getProperty("newsponsor");
			String incomecenters = ps.getProperty("incomecenters");
			webelement.wait(1500);
			webelement.selectDropDownOption("id_sponsor_change", "Change Sponsor");
			//if need income centers
			//webelement.selectDropDownOption("Income Center", incomecenters);
			webelement.click(elements.new_sponsor);
			webelement.send(elements.new_sponsor, new_sponsor);
			webelement.wait(2000);
			webelement.click(elements.sponsor_choose);
			placemet_user();
		}
		
	 
		public static void placemet_user() throws IOException {
			FileInputStream file = new FileInputStream("/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties");
			Properties ps = new Properties();
			ps.load(file);
			String new_parent = ps.getProperty("newplacement");
			webelement.click(elements.placement_text);
			webelement.send(elements.placement_text, new_parent);
			webelement.click(elements.choose_placement);
			webelement.selectDropDownOption("id_spilling_preference", "Left Spilling");
			webelement.click(elements.submit);
		}


	public String getUser() {
		WebElement user = driver.findElement(By.xpath(elements.userName));
		String generatedUsername = "user" + (new Random().nextInt(100000) + 1);
		user.sendKeys(generatedUsername);
		getusername = user.getAttribute("value");
		return getusername;
	}

	public String firstname1() {
		Faker faker = new Faker();
		String randomName = faker.name().firstName();
		WebElement first = driver.findElement(By.xpath(elements.firstName));
		first.sendKeys(randomName);
		firstnameuser = first.getAttribute("value");
		return firstnameuser;
	}

	public String lastname1() {
		Faker faker = new Faker();
		String randomName = faker.name().lastName();
		WebElement last = driver.findElement(By.xpath(elements.lastName));
		last.sendKeys(randomName);
		lastnameuser = last.getAttribute("value");
		return lastnameuser;
	}
//ibo registration
	public void IBORegistration() throws InterruptedException, IOException {
		webelement.wait(1000);
		//selectAccept();
        FileInputStream file = new FileInputStream("/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties");
		Properties ps = new Properties();
		ps.load(file);
		String sponsor_name = ps.getProperty("sponsor");
		String password_data = ps.getProperty("password");
		String confirmpassword_data = ps.getProperty("confirmpassword");
		String billingaddress_data = ps.getProperty("billingaddress");
		String street_data = ps.getProperty("street");
		String locality_data = ps.getProperty("locality");
		String zipCode_data = ps.getProperty("zipCode");
		webelement.click(elements.sponsor);
		webelement.send(elements.sponsor, sponsor_name);
		webelement.wait(1000);
		firstname1();
		lastname1();
		getUser();
		driver.findElement(By.xpath(elements.emailAddress))
				.sendKeys("antony" + (new Random().nextInt(100000) + 1) + "@gmail.com");
		driver.findElement(By.xpath(elements.domain)).sendKeys("domain" + (new Random().nextInt(100000) + 1));
		driver.findElement(By.xpath(elements.country)).click();
		driver.findElement(By.xpath(elements.India)).click();
		driver.findElement(By.xpath(elements.phoneNumber)).sendKeys("9790" + (new Random().nextInt(100000) + 1));
		driver.findElement(By.xpath(elements.gender)).click();
		driver.findElement(By.xpath(elements.male)).click();
		driver.findElement(By.xpath(elements.password)).sendKeys(password_data);
		driver.findElement(By.xpath(elements.confirmPassword)).sendKeys(confirmpassword_data);
		driver.findElement(By.xpath(elements.agreeTermCondition)).click();
		driver.findElement(By.xpath(elements.signupButton)).click();
		// Implement the scroll and checkout logic here
		// driver.close();
//        WebElement bronze=driver.findElement(By.xpath(elements.bronzeButton));
//        webelement.scrollByjavaScriptExecutor(driver, bronze);
		webelement.wait(2500);
		
		
		webelement.click(elements.feepro_Package);
		//webelement.click(elements.founder_package);
		webelement.click(elements.proceedToButton);
		webelement.wait(2500);
		webelement.send(elements.billing, billingaddress_data);
		webelement.send(elements.street, street_data);
		webelement.send(elements.locality, locality_data);
		webelement.send(elements.zipCode, zipCode_data);
		webelement.click(elements.billingCountry);
		webelement.click(elements.indiadrop);
		webelement.click(elements.billingState);
		webelement.click(elements.stateDrop);
		webelement.click(elements.checkout);
		webelement.click(elements.testPayment);
		webelement.wait(2500);
		webelement.selectDropDownOption("id_status", "Confirmed");
		webelement.click(elements.finishButton);
		System.out.println("Registration successful");

	}
	
	   
//customer registration page
	public void customerRegistration() throws InterruptedException, IOException {
		webelement.wait(1500);
		//selectAccept();

        // Retrieve the properties
		FileInputStream excelFile = new FileInputStream(
				"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

		int targetRowIndex = 1; 
		int sponsorColumnIndex = 0; 
		int passwordColumnIndex = 1; 
        int confirm_passwordcolumnIntex =2;
		
		Row row = sheet.getRow(targetRowIndex);
		if (row != null) {
			
			String sponsor = row.getCell(sponsorColumnIndex) != null
					? row.getCell(sponsorColumnIndex).getStringCellValue()
					: "";
			String password = row.getCell(passwordColumnIndex) != null
					? row.getCell(passwordColumnIndex).getStringCellValue()
					: "";
			String confirm_password = row.getCell(confirm_passwordcolumnIntex) != null
					? row.getCell(confirm_passwordcolumnIntex).getStringCellValue()
					: "";
			// Send username to the input field
			driver.findElement(By.xpath(elements.sponsor)).sendKeys(sponsor);
			firstname1();
			lastname1();
			driver.findElement(By.xpath(elements.userName)).sendKeys("user" + (new Random().nextInt(100000) + 1));
			driver.findElement(By.xpath(elements.emailAddress))
					.sendKeys("antony" + (new Random().nextInt(100000) + 1) + "@gmail.com");
			driver.findElement(By.xpath(elements.country)).click();
			driver.findElement(By.xpath(elements.India)).click();
			driver.findElement(By.xpath(elements.phoneNumber)).sendKeys("9790" + (new Random().nextInt(100000) + 1));
			driver.findElement(By.xpath(elements.gender)).click();
			driver.findElement(By.xpath(elements.male)).click();
			driver.findElement(By.xpath(elements.password)).sendKeys(password);
			driver.findElement(By.xpath(elements.confirmPassword)).sendKeys(confirm_password);
			driver.findElement(By.xpath(elements.agreeTermCondition)).click();
			driver.findElement(By.xpath(elements.signupButton)).click();
  
		}

		// Close the workbook and file input stream
		workbook.close();
		excelFile.close();

	}

	public void login() {
		selectAccept();
		driver.findElement(By.xpath(elements.username_login)).sendKeys("");
		driver.findElement(By.xpath(elements.password_login)).sendKeys("As@12345");
		webelement.click(elements.signIn);
	}

	public void random_user() {
		selectAccept();
//        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.username_login)));
//        usernameField.sendKeys(usr);
		webelement.click(elements.username_login);
		webelement.send(elements.username_login, getusername);
		WebElement passwordField = driver.findElement(By.xpath(elements.password_login));
		passwordField.sendKeys("As@12345");
		WebElement signInButton = driver.findElement(By.xpath(elements.signIn));
		signInButton.click();
		UpdateCardDetailDisplay();
		webelement.wait(1500);
	}

}