// resizeable program @kaka
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeableJquery extends SeliniumSystemProperties {

	public static void main(String[] args) {
		setSeliniumSystemProperites();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/resizable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		WebElement resizeElement = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		Actions act = new Actions(driver);
		act.moveToElement(resizeElement).dragAndDropBy(resizeElement, 100, 100).build().perform();
		
	}

}
