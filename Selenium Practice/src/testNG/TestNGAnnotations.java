package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	
	@BeforeMethod
	public void openBrowser(){
		System.out.println("Before method will apply to all the methods in the class");
	}
	
	@Test
	public void login(){
		System.out.println("login with facebook");
	}
	@Test
	public void logout(){
		System.out.println("logout facebook");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("After method will apply to all the methods in the class");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before class is to run before the current class loading");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("After class is to run after the current class completed loading");
	}

}
