package Com.crm.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.crm.qa.base.Testbase;
//import Com.crm.qa.base.Testutil;
import Com.crm.qa.pages.Homepage;
import Com.crm.qa.pages.Loginpage;

public class Homepagetest extends Testbase {
	Loginpage loginpage;
	Homepage homepage;
	public Homepagetest() throws IOException {
		super();
	}
	
@BeforeMethod
public void setup() throws IOException, InterruptedException {
	init();
 loginpage=new Loginpage();
homepage=loginpage.login(pr.getProperty("username"),pr.getProperty("password"));	

}
@Test(priority=1)
public void testtitle() {
	String title=homepage.verifytitle();
	Assert.assertEquals(title, "CRMPRO");
	
}
@Test(priority=2)
public void usernamevalidation() {
	boolean b=homepage.correctusername();
	Assert.assertTrue(b);
}

@AfterMethod
public void end() {
	driver.close();
}
}
