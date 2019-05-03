package Com.crm.qa.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Com.crm.qa.base.Testbase;

import Com.crm.qa.pages.Homepage;
import Com.crm.qa.pages.Loginpage;
import junit.framework.Assert;

public class Loginpagetest extends Testbase{
	Loginpage loginpage;
	Homepage homepage;
	
	public Loginpagetest() throws IOException {
		super(); 
//		String us2=pr.getProperty("username");
		
//		System.out.println("inside super"+us2);
	}
@BeforeMethod
		public void setup() throws IOException{
		init();
		loginpage=new Loginpage();
		homepage=new Homepage();
		
		}
	
@Test(priority=1)
	public void loginpgtitletest() {
		String title=loginpage.loginpgtitle();
		System.out.println("title"+title);
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
@Test(priority=2)
public void imagetest() {
	Boolean bool=loginpage.crmimage();
	System.out.println("bool"+bool);		
	Assert.assertTrue(bool);
}
@Test(priority=3)
public void logincheck() throws IOException, InterruptedException {
	System.out.println("before stmt");
	String us1=pr.getProperty("username");
			System.out.println("username"+us1);	
	String ps1=pr.getProperty("password");
			System.out.println("password"+ps1);		
	
	homepage=loginpage.login(pr.getProperty("username"),pr.getProperty("password"));
	System.out.println("after stmt");
}

@AfterMethod()
public void close(){
	driver.quit();
}}

