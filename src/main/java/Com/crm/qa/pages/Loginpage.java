package Com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.qa.base.Testbase;

public class Loginpage extends Testbase{

	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password") 
	WebElement password;
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement login;
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;

	public Loginpage()throws IOException{
		PageFactory.initElements(driver,this);
	}

	public boolean crmimage() {
		System.out.println("crmimage");
	return crmlogo.isDisplayed();	
	}
	public String loginpgtitle() {
		System.out.println("loginpagetitle");
		return driver.getTitle();
	}
	public Homepage login(String us,String ps) throws IOException, InterruptedException {
		username.sendKeys(us);
		System.out.println("inside login"+us);
		password.sendKeys(ps);
		System.out.println("inside login"+ps);
		Thread.sleep(5000);
		System.out.println("inside login");
	login.click();
	return new Homepage();
	
	}
}

