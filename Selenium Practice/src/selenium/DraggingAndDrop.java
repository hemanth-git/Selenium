package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DraggingAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","E:\\Java Workspace\\drivers\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/slider/");
		List<WebElement> list = driver.findElements(By.tagName("iframe"));
		System.out.println(list.size());
		
		driver.switchTo().frame(0);
		WebElement slider= driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions act = new Actions(driver);
		//act.moveToElement(slider).moveToElement(slider, 100, 0).build().perform();
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		
		
		
		
	
	}
	
}