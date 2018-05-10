// Explicit and Implicit wait @kaka

package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsImplecitExcplicit {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","E:\\Java Workspace\\drivers\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("hemanthsaicharan@gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9494488385");
	}
}
