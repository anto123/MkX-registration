package Browserlaunch;

import org.openqa.selenium.WebDriver;

public class Browser_initiate {
	protected static WebDriver driver;
	protected static String adminUrl;
	protected static String iboUrl;
	protected static String customerUrl;
	protected static String userUrl;

	public static void setItUp(String url) {
		driver = new Browserlaun().getBrowser("Chrome");
		driver.manage().window().maximize();
		
		String urlKey;
		if (url.contains("ibo")) {
		    urlKey = "ibo";
		} else if (url.contains("customer")) {
		    urlKey = "customer";
		} else if (url.contains("userlogin")) {
		    urlKey = "userlogin";
		} else {
		    urlKey = "default";
		}

		// Use switch statement to handle different cases
		switch (urlKey) {
		    case "ibo":
		        iboUrl = "https://mkx.epixel.link/en/register/";
		        driver.get(iboUrl);
		        break;
		    case "customer":
		        customerUrl = "https://mkx.epixel.link/en/customer-register/";
		        driver.get(customerUrl);
		        break;
		    case "userlogin":
		        userUrl = "https://mkx.epixel.link/en/login/";
		        driver.get(userUrl);
		        break;
		    case "default":
		    default:
		    	adminUrl = "https://mkx.epixel.link/en/admin-login/";
		        driver.get(adminUrl);
		        break;
		}
	}

	public static void cardup(String card) {
		driver = new Browserlaun().getBrowser("Chrome");
		if (card.contains("card update")) {

		}
	}
}