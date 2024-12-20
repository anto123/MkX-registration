package Pageelement;

import java.util.Properties;
import java.util.Random;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogLevelMapping;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.JavascriptExecutor;
import Browserlaunch.Browser_initiate;

public class Registration extends Browser_initiate {
	// Assuming 'elements' is a class that holds locators
	private WebDriverWait wait;
	protected static String getusername;
	protected static String firstnameuser;
	protected static String lastnameuser;
	private Properties properties;
	// private static final String EXCEL_FILE_PATH =
	// "/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx";
	// private static final String PROPERTIES_FILE_PATH =
	// "/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties";

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
		//selectAccept();
		//webelement.wait(1500);
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

    public void testUpdateCardDetailDisplay() {
        // Call the method
    	assertionforgracepperiod();
    }
	public static void assertionforgracepperiod() {
		 boolean isDisplayed = webelement.isDisplay(elements.cardUpdate);
	    // Assert that the cardUpdate element is displayed
		 Assert.assertTrue(isDisplayed);
	    // If the assertion passes, proceed with the clicks
	    webelement.click(elements.cardUpdate);
	    webelement.click(elements.yesOption);
	}
	public void holding_Tank() throws IOException {

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
		// if need no changes
		// placement right
		 webelement.selectDropDownOption("id_binary_position", "Bottom Right");
		// Bottom Left
		 webelement.click(elements.submit);
		 
		 //we need change any sponsor
		//sponsor_choose();
		 
		 
		 //we need change date for grace period
		 date_change();
		
	}
public void holdingtanknosponsorchangeexcel() throws IOException {
	
	FileInputStream excelFile = new FileInputStream(
			"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	Sheet sheet = workbook.getSheetAt(2); // Get the first sheet
	Sheet sheet1 = workbook.getSheetAt(0);
	int targetRowIndex = 1;
	int urlColumnIndex = 0;
    int firstnamecoulumnindex =1;
	Row row = sheet.getRow(targetRowIndex);
	Row row1 = sheet1.getRow(targetRowIndex);
	if (row != null && row1 != null) {

		String url = row.getCell(urlColumnIndex) != null
				? row.getCell(urlColumnIndex).getStringCellValue()
				: "";
		String firstname = getCellValue(row1, firstnamecoulumnindex); 
		 
		WebDriver driver = new ChromeDriver();
	    webelement.setDriver(driver);
         driver.manage().window().maximize();
         webelement.wait(1500);
		driver.get(url);
		adminlog();
		webelement.wait(3500);
		webelement.click(elements.team);
		webelement.click(elements.manage_team);
		webelement.wait(1000);
		webelement.click(elements.holding_Tank);
		webelement.wait(3500);
		webelement.click(elements.filter);
		WebElement userField = driver.findElement(By.xpath(elements.user));
		userField.click();
		userField.sendKeys(firstname);
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
		// if need no changes
		// placement right
		 webelement.selectDropDownOption("id_binary_position", "Bottom Right");
		// Bottom Left
		// webelement.selectDropDownOption("id_binary_position", "Bottom Left");
		 webelement.click(elements.submit);
	}
}
	
public void holdingsponsorchangenoplacement() throws IOException {
	FileInputStream excelFile = new FileInputStream(
			"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	Sheet sheet = workbook.getSheetAt(2); // Get the first sheet
	Sheet sheet1 = workbook.getSheetAt(0);
	int targetRowIndex = 1;
	int urlColumnIndex = 0;
	int firstnamecoulumnindex =1;
	int newsponsorcolumnIndex = 1;
	int newplacementcolumnIndex = 2;
	int incomecenterscolumnIndex = 3;

	Row row = sheet.getRow(targetRowIndex);
	Row row1 = sheet1.getRow(targetRowIndex);
	if (row != null && row1 !=null) {

		String url = row.getCell(urlColumnIndex) != null
				? row.getCell(urlColumnIndex).getStringCellValue()
				: "";
		
		String firstname = getCellValue(row1, firstnamecoulumnindex);
		String new_sponsor = getCellValue(row, newsponsorcolumnIndex);
      
		    
		WebDriver driver = new ChromeDriver();
	    webelement.setDriver(driver);
         driver.manage().window().maximize();
         webelement.wait(1500);
		driver.get(url);
		adminlog();
		webelement.wait(3500);
		webelement.click(elements.team);
		webelement.click(elements.manage_team);
		webelement.wait(1000);
		webelement.click(elements.holding_Tank);
		webelement.wait(3500);
		webelement.click(elements.filter);
		WebElement userField = driver.findElement(By.xpath(elements.user));
		userField.click();
		userField.sendKeys(firstname);
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
		webelement.wait(1500);
		webelement.selectDropDownOption("id_sponsor_change", "Change Sponsor");
		// if need income centers
		// webelement.selectDropDownOption("Income Center", incomecenters);
		webelement.click(elements.new_sponsor);
		webelement.send(elements.new_sponsor, new_sponsor);
		webelement.wait(2000);
		webelement.click(elements.sponsor_choose);
		// if need no changes
				// placement right
				 webelement.selectDropDownOption("id_binary_position", "Bottom Right");
				// Bottom Left
				 webelement.click(elements.submit);
	}
}

public void incomecenterchangenoplacement() throws IOException {
	FileInputStream excelFile = new FileInputStream(
			"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	Sheet sheet = workbook.getSheetAt(2); // Get the first sheet
	Sheet sheet1 = workbook.getSheetAt(0);
	int targetRowIndex = 1;
	int urlColumnIndex = 0;
	int firstnamecoulumnindex =1;
	int newsponsorcolumnIndex = 1;
	int newplacementcolumnIndex = 2;
	int incomecenterscolumnIndex = 3;

	Row row = sheet.getRow(targetRowIndex);
	Row row1 = sheet1.getRow(targetRowIndex);
	if (row != null && row1 !=null) {

		String url = row.getCell(urlColumnIndex) != null
				? row.getCell(urlColumnIndex).getStringCellValue()
				: "";
		String firstname = getCellValue(row1, firstnamecoulumnindex);
		String new_sponsor = getCellValue(row, newsponsorcolumnIndex);
        String placement = getCellValue(row, newplacementcolumnIndex);
        String income_centers = getCellValue(row, incomecenterscolumnIndex);
		    
		WebDriver driver = new ChromeDriver();
	    webelement.setDriver(driver);
         driver.manage().window().maximize();
         webelement.wait(1500);
		driver.get(url);
		adminlog();
		webelement.wait(3500);
		webelement.click(elements.team);
		webelement.click(elements.manage_team);
		webelement.wait(1000);
		webelement.click(elements.holding_Tank);
		webelement.wait(3500);
		webelement.click(elements.filter);
		WebElement userField = driver.findElement(By.xpath(elements.user));
		userField.click();
		userField.sendKeys(firstname);
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
		webelement.wait(1500);
		// if need income centers
	   webelement.selectDropDownOption("id_sponsor_change", "Income Center");
		webelement.click(elements.new_sponsor);
		webelement.send(elements.new_sponsor, income_centers);
		webelement.wait(2000);
		webelement.click(elements.sponsor_choose);
		// if need no changes
				// placement right
				 webelement.selectDropDownOption("id_binary_position", "Bottom Right");
				// Bottom Left
				 webelement.click(elements.submit);
	}
}
public void holdingplacementchange() throws IOException {
	FileInputStream excelFile = new FileInputStream(
			"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	Sheet sheet = workbook.getSheetAt(2); // Get the first sheet
	Sheet sheet1 = workbook.getSheetAt(0);
	int targetRowIndex = 1;
	int firstnamecoulumnindex =1;
	int urlColumnIndex = 0;
	int newsponsorcolumnIndex = 1;
	int newplacementcolumnIndex = 2;
	int incomecenterscolumnIndex = 3;

	Row row = sheet.getRow(targetRowIndex);
	Row row1 = sheet1.getRow(targetRowIndex);
	if (row != null && row1 !=null) {

		String url = row.getCell(urlColumnIndex) != null
				? row.getCell(urlColumnIndex).getStringCellValue()
				: "";
		String firstname = getCellValue(row1, firstnamecoulumnindex);
		String new_sponsor = getCellValue(row, newsponsorcolumnIndex);
        String new_parent = getCellValue(row, newplacementcolumnIndex);
        String sponsor = getCellValue(row, incomecenterscolumnIndex);
		    
		WebDriver driver = new ChromeDriver();
	    webelement.setDriver(driver);
         driver.manage().window().maximize();
         webelement.wait(1500);
		driver.get(url);
		adminlog();
		webelement.wait(3500);
		webelement.click(elements.team);
		webelement.click(elements.manage_team);
		webelement.wait(1000);
		webelement.click(elements.holding_Tank);
		webelement.wait(3500);
		webelement.click(elements.filter);
		WebElement userField = driver.findElement(By.xpath(elements.user));
		userField.click();
		userField.sendKeys(firstname);
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
		webelement.wait(1500);
		webelement.selectDropDownOption("id_sponsor_change", "Change Sponsor");
		// if need income centers
		// webelement.selectDropDownOption("Income Center", incomecenters);
		webelement.click(elements.new_sponsor);
		webelement.send(elements.new_sponsor, new_sponsor);
		webelement.wait(2000);
		webelement.click(elements.sponsor_choose);
		webelement.click(elements.placement_text);
		webelement.send(elements.placement_text, new_parent);
		webelement.click(elements.choose_placement);
		webelement.selectDropDownOption("id_spilling_preference", "Left Spilling");
		webelement.click(elements.submit);
		
	}
}
	public void date_change() {
		
		 //date change scenario
		 webelement.wait(5500);
		 WebElement element = driver.findElement(By.xpath(elements.setting_Menu));

        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Use JavaScript to click
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		// webelement.click(elements.setting_Menu);
		 webelement.click(elements.maintenance);
		 webelement.click(elements.developer_Settings);

		 // Locate the date field
		 WebElement dateField = driver.findElement(By.id("id_datetime"));
		 String currentDateValue = dateField.getAttribute("value");
		 System.out.println("current date"+currentDateValue);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		// Parse the current date from the input field
		LocalDateTime currentDateTime = LocalDateTime.parse(currentDateValue, formatter);

		// Add one year to the current date
		LocalDateTime newDateTime = currentDateTime.plusYears(1);

		// Format the new date back to a string
		String newDateFormatted = newDateTime.format(formatter);

		// Print the new date
		System.out.println("Date after one year: " + newDateFormatted);
		// Use JavaScript to update the value of the date field
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value = arguments[1];", dateField, newDateFormatted);
		
		 webelement.click(elements.save_button);
	
	}
	// choosing sponsor change
	public static void sponsor_choose() throws IOException {
		FileInputStream file = new FileInputStream(
				"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties");
		Properties ps = new Properties();
		ps.load(file);
		String new_sponsor = ps.getProperty("newsponsor");
		String incomecenters = ps.getProperty("incomecenters");
		webelement.wait(1500);
		webelement.selectDropDownOption("id_sponsor_change", "Change Sponsor");
		// if need income centers
		// webelement.selectDropDownOption("Income Center", incomecenters);
		webelement.click(elements.new_sponsor);
		webelement.send(elements.new_sponsor, new_sponsor);
		webelement.wait(2000);
		webelement.click(elements.sponsor_choose);
		placemet_user();
	}

	public static void placemet_user() throws IOException {
		FileInputStream file = new FileInputStream(
				"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties");
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

	public static String firstname1() {
		Faker faker = new Faker();
		String randomName = faker.name().firstName();
		WebElement first = driver.findElement(By.xpath(elements.firstName));
		first.sendKeys(randomName);
		firstnameuser = first.getAttribute("value");
		return firstnameuser;
	}

	public static String lastname1() {
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
		// selectAccept();
		FileInputStream file = new FileInputStream(
				"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/test/java/runner/registrationdata.properties");
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
				.sendKeys("antony" + (new Random().nextInt(100000) + 1) + "@mailinator.com");
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

	// user registration practice
	public static void userregistrationexcel() throws InterruptedException, IOException {
		// selectAccept();

		// Retrieve the properties
		FileInputStream excelFile = new FileInputStream(
				"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

		int targetRowIndex = 1;
		int urlColumnIndex = 0;
		int firstnamecolumnIndex = 1;
		int lastnamecolumnIndex = 2;
		int sponsorcolumnIndex = 3;
		int passwordColumnIndex = 4;
		int confirm_passwordcolumnIntex = 5;
		int choose_enrollmentpackagecolumnIntex = 6;
		int billing_adresscolumnIntex = 7;
		int streetname_columnIntex =8;
		int locality_columnIntex = 9;
		int zipcode_columnIntex = 10;

		Row row = sheet.getRow(targetRowIndex);
		if (row != null) {

			String url = row.getCell(urlColumnIndex) != null
					? row.getCell(urlColumnIndex).getStringCellValue()
					: "";
			String firstname = getCellValue(row, firstnamecolumnIndex);
	        String lastname = getCellValue(row, lastnamecolumnIndex);
	        String sponsor = getCellValue(row, sponsorcolumnIndex);
			String password = getCellValue(row, passwordColumnIndex);
	        String confirmPassword = getCellValue(row, confirm_passwordcolumnIntex);
	        
	        String enrollment = row.getCell(choose_enrollmentpackagecolumnIntex) != null
					? row.getCell(choose_enrollmentpackagecolumnIntex).getStringCellValue()
					: "";
	        
	        Cell cell = row.getCell(billing_adresscolumnIntex);

	     // Initialize the billingAddress variable
	     String billingAddress = "";

	     // Check if the cell is not null and is numeric
	     if (cell != null && cell.getCellType() == CellType.NUMERIC) {
	         // Format the numeric value to a string
	         DecimalFormat df = new DecimalFormat("#.##"); // Adjust the pattern as needed
	         billingAddress = df.format(cell.getNumericCellValue());
	     } else {
	         billingAddress = ""; // Handle cases where the cell is null or not numeric
	     }
	        
	       // String billingAddress = getCellValue(row, billing_adresscolumnIntex);
	        String streetname = getCellValue(row, streetname_columnIntex);
	        String locality = getCellValue(row, locality_columnIntex);
	        
	        Cell cell1 = row.getCell(zipcode_columnIntex);

            // Initialize the zipcode variable
            String zipcode = "";

            // Check if the cell is not null
            if (cell1 != null) {
                // Check the cell type
                if (cell1.getCellType() == CellType.STRING) {
                    zipcode = cell1.getStringCellValue(); // Directly get string value
                } else if (cell1.getCellType() == CellType.NUMERIC) {
                    // Convert numeric to string
                    zipcode = String.valueOf((int) cell1.getNumericCellValue()); // Cast to int
                }
            }
			WebDriver driver = new ChromeDriver();
		    webelement.setDriver(driver);
             driver.manage().window().maximize();
             webelement.wait(1500);
			driver.get(url);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements.sponsor)));
			driver.findElement(By.xpath(elements.sponsor)).sendKeys(sponsor);
			 webelement.wait(1000);
			 driver.findElement(By.xpath(elements.firstName)).sendKeys(firstname);
		     driver.findElement(By.xpath(elements.lastName)).sendKeys(lastname);
		     String prefix = "username";
		        int randomNumber = new Random().nextInt(100000) + 1; // Generates a random number between 1 and 100,000
		        String username = prefix + randomNumber; // Concatenates "user" with the random number

		        // Print the generated username
		        System.out.println("Generated Username: " + username);
		        driver.findElement(By.xpath(elements.userName)).sendKeys(username);
			driver.findElement(By.xpath(elements.emailAddress))
					.sendKeys("antony" + (new Random().nextInt(100000) + 1) + "@gmail.com");
			driver.findElement(By.xpath(elements.domain)).sendKeys("domain" + (new Random().nextInt(100000) + 1));
			webelement.wait(1000);
			driver.findElement(By.xpath(elements.country)).click();
			driver.findElement(By.xpath(elements.India)).click();
			webelement.wait(1000);
			driver.findElement(By.xpath(elements.phoneNumber)).sendKeys("9790" + (new Random().nextInt(100000) + 1));
			driver.findElement(By.xpath(elements.gender)).click();
			driver.findElement(By.xpath(elements.male)).click();
			driver.findElement(By.xpath(elements.password)).sendKeys(password);
			driver.findElement(By.xpath(elements.confirmPassword)).sendKeys(confirmPassword);
			driver.findElement(By.xpath(elements.agreeTermCondition)).click();
			driver.findElement(By.xpath(elements.signupButton)).click();
			webelement.wait(2500);
            webelement.id(enrollment);
			//webelement.click(elements.feepro_Package);
			// webelement.click(elements.founder_package);
			webelement.click(elements.proceedToButton);
			webelement.wait(2500);
			webelement.send(elements.billing, billingAddress);
			webelement.send(elements.street, streetname);
			webelement.send(elements.locality, locality);
			webelement.send(elements.zipCode, zipcode);
			webelement.click(elements.billingCountry);
			webelement.click(elements.indiadrop);
			webelement.click(elements.billingState);
			webelement.click(elements.stateDrop);
			webelement.click(elements.checkout);
			webelement.wait(1000);
			webelement.click(elements.testPayment);
			webelement.wait(2500);
			webelement.selectDropDownOption("id_status", "Confirmed");
			webelement.click(elements.finishButton);
			System.out.println("Registration successful");

		}

		// Close the workbook and file input stream
		workbook.close();
		excelFile.close();

	}
	private static String getCellValue(Row row, int columnIndex) {
	    if (row.getCell(columnIndex) != null) {
	        return row.getCell(columnIndex).getStringCellValue();
	    }
	    return "";
	}
//customer registration page
	public void customerRegistration() throws InterruptedException, IOException {
		webelement.wait(1500);
		// selectAccept();

		// Retrieve the properties
		FileInputStream excelFile = new FileInputStream(
				"/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

		int targetRowIndex = 1;
		int sponsorColumnIndex = 0;
		int passwordColumnIndex = 1;
		int confirm_passwordcolumnIntex = 2;

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
		//selectAccept();
		driver.findElement(By.xpath(elements.username_login)).sendKeys("user54475");
		driver.findElement(By.xpath(elements.password_login)).sendKeys("As@12345");
		webelement.click(elements.signIn);
		UpdateCardDetailDisplay();
		webelement.wait(1500);
		
	}

	public void random_user() {
		//selectAccept();
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
		driver.navigate().refresh();
	}

	public void graceperiod_wait() {
		webelement.wait(100000);
		driver.navigate().refresh();
		testUpdateCardDetailDisplay();
	}
	
	public void days_change() {
		
		 webelement.wait(5500);
		 WebElement element = driver.findElement(By.xpath(elements.setting_Menu));

        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Use JavaScript to click
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		// webelement.click(elements.setting_Menu);
		 webelement.click(elements.maintenance);
		 webelement.click(elements.developer_Settings);

		WebElement dateField = driver.findElement(By.id("id_datetime"));
		String currentDateValue = dateField.getAttribute("value");
		System.out.println("Current date: " + currentDateValue);

		// Define the date formattestUpdateCardDetailDisplay
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		// Parse the current date from the input field
		LocalDateTime currentDateTime = LocalDateTime.parse(currentDateValue, formatter);

		// Add 5 days to the current date
		LocalDateTime newDateTime = currentDateTime.plusDays(25);

		// Format the new date back to a string
		String newDateFormatted = newDateTime.format(formatter);

		// Print the new date
		System.out.println("Date after 25 days: " + newDateFormatted);

		// Use JavaScript to update the value of the date field
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value = arguments[1];", dateField, newDateFormatted);

		// Click the save button
		webelement.click(elements.save_button);
	}
	
	public void days_changeinactive() {
		
		 webelement.wait(5500);
		 WebElement element = driver.findElement(By.xpath(elements.setting_Menu));

       // Scroll to the element
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

       // Use JavaScript to click
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		// webelement.click(elements.setting_Menu);
		 webelement.click(elements.maintenance);
		 webelement.click(elements.developer_Settings);

		WebElement dateField = driver.findElement(By.id("id_datetime"));
		String currentDateValue = dateField.getAttribute("value");
		System.out.println("Current date: " + currentDateValue);

		// Define the date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		// Parse the current date from the input field
		LocalDateTime currentDateTime = LocalDateTime.parse(currentDateValue, formatter);

		// Add 5 days to the current date
		LocalDateTime newDateTime = currentDateTime.plusDays(5);

		// Format the new date back to a string
		String newDateFormatted = newDateTime.format(formatter);

		// Print the new date
		System.out.println("Date after 5 days: " + newDateFormatted);

		// Use JavaScript to update the value of the date field
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value = arguments[1];", dateField, newDateFormatted);

		// Click the save button
		webelement.click(elements.save_button);
	}
	
	public void customerregexcel() throws IOException {
	    // Declare variables
	    Sheet sheet = null;
	    XSSFWorkbook workbook = null;
	    FileInputStream excelFile = null;

	    try {
	        excelFile = new FileInputStream(
	                "/home/eps46-epixel/Desktop/MKxProject/mkxProject/src/main/java/resorce/data.xlsx");
	        workbook = new XSSFWorkbook(excelFile);
	        sheet = workbook.getSheetAt(1); // Get the second sheet
	     // Check the number of sheets in the workbook
//	        int numberOfSheets = workbook.getNumberOfSheets();
//	        if (numberOfSheets > 1) {
//	            sheet = workbook.getSheetAt(1); // Get the second sheet
//	        } else if (numberOfSheets == 1) {
//	            sheet = workbook.getSheetAt(0); // Get the first sheet
//	        } else {
//	            throw new IllegalArgumentException("The workbook has no sheets.");
//	        }
	        int targetRowIndex = 1;
	        int urlColumnIndex = 0;
	        int firstnameColumnIndex = 1;
	        int lastnameColumnIndex = 2;
	        int sponsorColumnIndex = 3;
	        int passwordColumnIndex = 4;
	        int confirmPasswordColumnIndex = 5;

	        Row row = null;
	        if (sheet != null) { // Check if sheet is not null
	            row = sheet.getRow(targetRowIndex);
	        }

	        if (row != null) {
	            String url = row.getCell(urlColumnIndex) != null
	                    ? row.getCell(urlColumnIndex).getStringCellValue()
	                    : "";
	            String firstname = getCellValuee(row, firstnameColumnIndex);
	            String lastname = getCellValuee(row, lastnameColumnIndex);
	            String sponsor = getCellValuee(row, sponsorColumnIndex);
	            String password = getCellValuee(row, passwordColumnIndex);
	            String confirmPassword = getCellValuee(row, confirmPasswordColumnIndex);

	            // Initialize WebDriver
	            WebDriver driver = new ChromeDriver();
	            webelement.setDriver(driver);
	            driver.manage().window().maximize();
	            webelement.wait(1500);
	            driver.get(url);
	            driver.findElement(By.xpath(elements.sponsor)).sendKeys(sponsor);
	            webelement.wait(1000);
	            driver.findElement(By.xpath(elements.firstName)).sendKeys(firstname);
	            driver.findElement(By.xpath(elements.lastName)).sendKeys(lastname);
	            String prefix = "username";
		        int randomNumber = new Random().nextInt(100000) + 1; // Generates a random number between 1 and 100,000
		        String username = prefix + randomNumber; // Concatenates "user" with the random number

		        // Print the generated username
		        System.out.println("Generated Username: " + username);
		        driver.findElement(By.xpath(elements.userName)).sendKeys(username);
	            driver.findElement(By.xpath(elements.emailAddress))
	                    .sendKeys("antony" + (new Random().nextInt(100000) + 1) + "@gmail.com");

	            webelement.wait(500);
	            driver.findElement(By.xpath(elements.country)).click();
	            driver.findElement(By.xpath(elements.India)).click();
	            webelement.wait(1000);
	            driver.findElement(By.xpath(elements.phoneNumber)).sendKeys("9790" + (new Random().nextInt(100000) + 1));
	            driver.findElement(By.xpath(elements.gender)).click();
	            driver.findElement(By.xpath(elements.male)).click();
	            driver.findElement(By.xpath(elements.password)).sendKeys(password);
	            driver.findElement(By.xpath(elements.confirmPassword)).sendKeys(confirmPassword);
	            driver.findElement(By.xpath(elements.agreeTermCondition)).click();
	            driver.findElement(By.xpath(elements.signupButton)).click();
	            webelement.wait(2500);
	        }
	    } catch (IOException e) {
	        e.printStackTrace(); // Handle the exception appropriately
	    } finally {
	        // Close the workbook and file input stream in the finally block
	        try {
	            if (workbook != null) {
	                workbook.close();
	            }
	            if (excelFile != null) {
	                excelFile.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace(); // Handle exceptions when closing resources
	        }
	    }
	}

	private static String getCellValuee(Row row, int columnIndex) {
	    if (row.getCell(columnIndex) != null) {
	        return row.getCell(columnIndex).getStringCellValue();
	    }
	    return "";
	}

	}
