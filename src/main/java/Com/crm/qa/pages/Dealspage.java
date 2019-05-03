package Com.crm.qa.pages;

import java.io.IOException;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import Com.crm.qa.base.Testbase;

public class Dealspage extends Testbase {
	Newcontact newcontact;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement deals;
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement newdeal;

	@FindBy(name="title")
	WebElement title;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(name="contact_lookup")
	WebElement primcontact;
	@FindBy(name="amount")
	WebElement amt;
	@FindBy(xpath="//*[@id=\"prospectForm\"]/table/tbody/tr[1]/td/input[1]")
	WebElement savebtn;
	public Dealspage()throws IOException {
PageFactory.initElements(driver, this);
	}
	public boolean verifycontactlabel() {
		return deals.isDisplayed();
	}
	
	public void clicknewdealslist( String t1,String c1,String p1,String a1 ) {
//		Ncontact.click();
		title.sendKeys(t1);
		company.sendKeys(c1);
		primcontact.sendKeys(p1);
		amt.sendKeys(a1);
		savebtn.click();
//		return new Newcontact();
	}
}
	
