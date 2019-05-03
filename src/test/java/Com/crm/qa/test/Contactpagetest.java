package Com.crm.qa.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.crm.qa.base.Testbase;
import Com.crm.qa.base.Testutil;
import Com.crm.qa.pages.Contactpage;
import Com.crm.qa.pages.Homepage;
import Com.crm.qa.pages.Loginpage;

public class Contactpagetest extends Testbase{
	Loginpage loginpage;
	Homepage homepage;
	Contactpage contactpage;
	Testutil testutil;
	String sheetname="Sheet1";
	public Contactpagetest()throws IOException{
		super();
	}
	@BeforeTest()
	
	public void setup() throws IOException, InterruptedException	{
		init();
		loginpage=new Loginpage();
		homepage=new Homepage();
		homepage=loginpage.login(pr.getProperty("username"),pr.getProperty("password"));
	contactpage=new Contactpage();
	testutil=new Testutil();
		
	
	}
	
	@Test(priority=1)

	public void verifycontactpagelabeltest() {
		testutil.switchtoframe();
//		testutil.switchtoframe();

		Assert.assertTrue(contactpage.verifycontactlabel());
	}
//	@Test(priority=2)
//	public void clickoncontacttest() {
//		contactpage.clickoncontact("test 2 test 2");
//	}
	@DataProvider
	public Object[][] getcrmtestdata() throws FileNotFoundException{
		Object data[][]=Testutil.gettestdata(sheetname);
		return data;
	}
	@Test(priority=2,dataProvider="getcrmtestdata")
	public void validatecreatenewcontact(String title,String firstname,String lastname,String company) throws IOException {
		homepage.clickoncontactslink();
//		contactpage.clicknewcontactlist("Mr.","Tom","david","amazon");
		contactpage.clicknewcontactlist(title,firstname,lastname,company);

	}
	@AfterTest()
	public void quit() {
		driver.close();
	}
	
}
