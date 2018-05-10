
//checkbox program @kaka


package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBoxes extends SeliniumSystemProperties {

	public static void main(String[] args) {
		// program to check the check box with only value = football and uncheck the remaining
		setSeliniumSystemProperites();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		List<WebElement> checkList = driver.findElements(By.xpath("//div[@class='display'][2]//input[@name='sports']"));
		for(WebElement e: checkList){
			System.out.println(e.isSelected()+" "+e.getAttribute("value"));
		}
		
		for(WebElement e: checkList){
			if(e.getAttribute("value").equals("football") && !e.isSelected()){
				e.click();
			}
			else if(e.isSelected()){
				e.click();
			}
		}
		System.out.println("------------");
		for(WebElement e: checkList){
			System.out.println(e.isSelected()+" "+e.getAttribute("value"));
		}
	
	
	}

}
