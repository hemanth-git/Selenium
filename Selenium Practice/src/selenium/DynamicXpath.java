package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DynamicXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","E:\\Java Workspace\\drivers\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://stackoverflow.com/questions/41857614/how-to-find-xpath-of-an-element-in-firefox-inspector");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/header/div/form/input")).sendKeys("stackoverflow");
		driver.findElement(By.xpath("/html/body/header/div/form/button")).click();
	}

}
