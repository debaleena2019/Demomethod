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
import Com.crm.qa.pages.Dealspage;
import Com.crm.qa.pages.Homepage;
import Com.crm.qa.pages.Loginpage;

public class Dealspagetest extends Testbase{
	Loginpage loginpage;
	Homepage homepage;
	Contactpage contactpage;
	Testutil testutil;
	Dealspage dealspage;
	String sheetname="Sheet2";
	public Dealspagetest()throws IOException{
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
	dealspage=new Dealspage();	
	
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
	public void clickondealspage( String ttle,String comp,String primcnt,String amt ) {
		homepage.clickondealslink();
//		contactpage.clicknewcontactlist("Mr.","Tom","david","amazon");
		dealspage.clicknewdealslist(ttle,comp,primcnt,amt);

	}
	@AfterTest()
	public void quit() {
		driver.close();
	}
	
}
