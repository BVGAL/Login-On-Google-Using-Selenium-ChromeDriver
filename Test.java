
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Main {

	WebDriver driver;

	public static void test() {

		final String proxy = "Your_Proxy_Server_IP" + ":" + "Port_Number"; // Optional: If you have VPN

		// Create a ChromeOptions instance
		ChromeOptions options = new ChromeOptions();

		// Initialize a list with 2 USER-AGENTs, but you can add more:
		List<String> useragentArray = new ArrayList<String>();
		useragentArray.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
		useragentArray.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");

		// Choose a random user agent from the list
		Random rand = new Random();
		int index = rand.nextInt(useragentArray.size());
		String randomUserAgent = useragentArray.get(index);

		// Set the user agent
		options.addArguments("--user-agent=" + randomUserAgent);

		// Add argument to disable the AutomationControlled flag
		options.addArguments("--disable-blink-features=AutomationControlled");

		// Exclude the collection of enable-automation switches
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		// Turn-off userAutomationExtension
		options.setExperimentalOption("useAutomationExtension", false);

		// Optional: Validate only if you use a VPN and configured before the Proxy
		// Server, otherwise cancel this line
		options.addArguments("--proxy-server=" + proxy);

		// Optional: Disable browser notifications
		options.addArguments("--disable-notifications"); // If you don't see certain buttons during navigation on the website, cancel this option

		// Optional: Open the window maximized
		options.addArguments("start-maximized");

		try {
			// Automatic Install the ChromeDriver version that matches your Google Chrome version
			WebDriverManager.chromedriver().setup(); // Use WebDriverManager to manage Chromedriver

			// Or you can do it manually if you have chromedriver.exe installed locally
			// System.setProperty("webdriver.chrome.driver", "Path_To_Chromedriver.exe"); 
			// Set the path of the Chrome driver

			// Create a WebDriver instance using the configured options
			driver = new ChromeDriver(options);

			// Change the property of the navigator value for webdriver to undefined
			((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

			// In this page you'll be able to login via Discord or Google
			driver.get("https://www.example.com");

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
