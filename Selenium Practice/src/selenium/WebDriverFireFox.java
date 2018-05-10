package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFireFox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","E:\\Java Workspace\\drivers\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		WebDriver firefoxdriver = new FirefoxDriver();
		firefoxdriver.get("http://google.com");
		firefoxdriver.manage().window().fullscreen();
		firefoxdriver.get("http://gmail.com");
	
	}

}
