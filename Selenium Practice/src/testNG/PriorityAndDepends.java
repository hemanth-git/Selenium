package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityAndDepends {
	@Test
	public void login(){
		System.out.println("login completed");
	}
	@Test(dependsOnMethods={"login"})
	public void navigate(){
		System.out.println("navigation done");
	}
	@Test(dependsOnMethods={"login","navigate"})
	public void logout(){
		System.out.println("logout done");
	}

}
