package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DropDownSelector extends SeliniumSystemProperties{

	public static void main(String[] args) {
		setSeliniumSystemProperites();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		WebElement select = driver.findElement(By.xpath("//*[@id='speed']"));
		
		List<WebElement> option = select.findElements(By.tagName("option"));
		
		System.out.println(option.size());
		
		for(int list =0;list<option.size();list++){
			System.out.println(option.get(list).getText());
		}
	}

}
