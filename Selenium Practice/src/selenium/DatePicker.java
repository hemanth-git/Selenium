// Date Picker Demo @kaka


package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker extends SeliniumSystemProperties{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		setSeliniumSystemProperites();
		driver = new FirefoxDriver();
		driver.get("https://www.tripadvisor.in/");
		driver.findElement(By.xpath("//*[@id='taplc_trip_search_home_default_0']/div[2]/div[1]/div/span/input")).sendKeys("Rajahmundry");
		String CheckInDay = "8";
		String CheckInMonth = "May";
		String CheckInYear = "2018";
		String checkInMonth_Year=CheckInMonth +" "+CheckInYear;
		System.out.println(checkInMonth_Year);
		driver.findElement(By.xpath("//div[@class='ui_picker no-caret']/span[@data-datetype='CHECKIN']")).click();
		selectDatePicker(CheckInDay,checkInMonth_Year);
		

	}
	
	public static void selectDatePicker(String day, String checkInMonth_Year) throws InterruptedException{
		
		List<WebElement> monthList=driver.findElements(By.xpath("//div[@class='dsdc-months']/span[@class='dsdc-month']/span[@class='dsdc-month-title']"));
		for(int i=0;i<monthList.size();i++){
			
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals(checkInMonth_Year)){
				List<WebElement> daysList = driver.findElements(By.xpath("//div[@class='dsdc-months']/span[@class='dsdc-month']/span[@class='dsdc-cell dsdc-day']"));
				for(WebElement e:daysList){
					if(e.getText().equals(day)){
						e.click();
						return;
					}
				}
			}
		}
		driver.findElement(By.xpath("//div[@class='dsdc-next ui_icon single-chevron-right-circle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='dsdc-next ui_icon single-chevron-right-circle']")).click();
		Thread.sleep(1000);
		selectDatePicker(day,checkInMonth_Year);
		
	}

}
