package Browserlaunch;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Browserlaun {
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	public WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				String uAgent = System.getProperty("os.name");
				if (uAgent.contains("Windows")) {
				}
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile ffprofile = profile.getProfile("default");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			break;
		case "Edge":
			if (driver == null) {
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("allow-blocked-content", true);
				capabilities.setCapability("allowBlockedContent", true);

			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
                ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--allow-running-insecure-content");
				prefs.put("profile.default_content_settings.geolocation", false);
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("Chrome");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				capabilities.setVersion("ANY");
				capabilities.setPlatform(Platform.WINDOWS);
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				 driver.manage().deleteAllCookies();
				 //driver.get("chrome://settings/clearBrowserData");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
}
			break;
		}
		return driver;
	}
}
