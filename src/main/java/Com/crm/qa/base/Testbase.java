package Com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import javax.print.DocFlavor.STRING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Com.crm.qa.util.WebEventListener;

public class Testbase {
public static WebDriver driver;
public static Properties pr;
public static EventFiringWebDriver edrive;
public static WebEventListener weblist;
public static EventFiringWebDriver e_driver;
public Testbase() throws IOException{
	try {
		 pr=new Properties();
		FileInputStream fp=new FileInputStream("C:\\JAVA\\Freecrmtestautomation\\src\\main\\java\\Com\\crm\\qa\\base\\config.properties");
pr.load(fp);

	}
	catch(FileNotFoundException e){
		e.printStackTrace();
		
	}
}
public static void init() throws IOException {
//String browser1=pr.getProperty("browser");
//if (browser1.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
driver=new ChromeDriver();
edrive=new EventFiringWebDriver(driver);
weblist=new WebEventListener();
//e_driver=new EventFiringWebDriver(driver);
edrive.register(weblist);	
driver=edrive;
	driver.get("https://classic.crmpro.com/index.html?e=2");
//}
}
}
