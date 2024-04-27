
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test{

      public static void openWebPage() {

            WebDriver driver;

            try {      
                  // Optional: If you have VPN
                  final String PROXY = "Your_Proxy_Server_IP" + ":" + "Port_Number";
      
                  // Initialize a list with 2 USER-AGENTs, but you can add more:
                  List<String> useragentArray = new ArrayList<String>();
                  useragentArray.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
                  useragentArray.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
            
                  // Create a ChromeOptions instance
                  ChromeOptions options = new ChromeOptions();
            
                  // Iterate through the list of user agents
                  for (String userAgent : useragentArray) {
                        // Set the user agent iteratively
                        options.addArguments("--user-agent=" + userAgent);
                  }
            
                  // Disable browser notifications
                  // If you don't see certain buttons during navigation on the website, cancel this option
                  // options.addArguments("--disable-notifications");
            
                  // Optional: Open the window maximized
                  options.addArguments("start-maximized");
            
                  // Optional: Validate only if you use a VPN and configured before the Proxy Server
                  // options.addArguments("--proxy-server=" + PROXY);
            
                  // Add argument to disable the AutomationControlled flag
                  options.addArguments("--disable-blink-features=AutomationControlled");
            
                  // Exclude the collection of enable-automation switches
                  options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            
                  // Turn-off userAutomationExtension
                  options.setExperimentalOption("useAutomationExtension", false);
      
                  // Automatic Install ChromeDriver last version
                  // Use WebDriverManager to manage Chromedriver
                  WebDriverManager.chromedriver().setup();
      
                  // Or you can do it manually if you have chromedriver.exe installed locally
                  // Set the path of the Chrome driver
                  // System.setProperty("webdriver.chrome.driver", "Path_To_Chromedriver.exe");
      
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
