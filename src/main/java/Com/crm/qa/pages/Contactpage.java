package Com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.crm.qa.base.Testbase;

public class Contactpage extends Testbase {
	Newcontact newcontact;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement Contactslabel;
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement Ncontact;

	@FindBy(name="title")
	WebElement title;
	@FindBy(name="first_name")
	WebElement ftname;
	@FindBy(name="surname")
	WebElement ltname;
	@FindBy(name="client_lookup")
	WebElement comp;
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement savebtn;
	public Contactpage()throws IOException {
PageFactory.initElements(driver, this);
	}
	public boolean verifycontactlabel() {
		return Contactslabel.isDisplayed();
	}
	public void clickoncontact(String name) {
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preeceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	public void clicknewcontactlist( String ttle,String firstname,String lastname,String company ) {
//		Ncontact.click();
		System.out.println("inside clicknewcontactlist");
		Select select=new Select(title);
		select.selectByVisibleText(ttle);
		ftname.sendKeys(firstname);
		ltname.sendKeys(lastname);
		comp.sendKeys(company);
		savebtn.click();
//		return new Newcontact();
	}
}
	
