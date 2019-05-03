package Com.crm.qa.base;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.TakesScreenshot;

//import com.mongodb.MapReduceCommand.OutputType;

public class Testutil extends Testbase{
//private static final String FileUtils = null;
public static String Testdata_path="C:\\JAVA\\Freecrmtestautomation\\src\\main\\java\\Com\\crm\\qa\\testdata\\freecrmtestdata.xlsx";
public static Workbook book;
public static Sheet sheet;	
public Testutil() throws IOException {
	super();
			}

public void switchtoframe() {
	driver.switchTo().frame("mainpanel");
	}
public static Object[][] gettestdata(String sheetname) throws FileNotFoundException{
FileInputStream file=null;
	try {
		file=new FileInputStream(Testdata_path);	
		System.out.println("insidetry-1st" + file);
}
		catch (FileNotFoundException e)
{
			e.printStackTrace();
}
	try {
		book=WorkbookFactory.create(file);
		System.out.println("insidetry-2nd"+book);

}catch(InvalidFormatException e) {
	e.printStackTrace();
}
catch(IOException e) {
	e.printStackTrace();
	
}
  sheet = book.getSheet("Sheet2");
	System.out.println("sheetname" + sheet);

Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//	Object[][] data=null;	
	
System.out.println("after getrow");
System.out.println(sheet.getLastRowNum());
System.out.println(sheet.getRow(0).getLastCellNum());

for (int i=0;i< sheet.getLastRowNum();i++) {
for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
	System.out.println("insidetry-loop");
data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	}
	}
	return data	;
}

//public static void takeScreenshotAtEndOfTest() throws IOException {
//	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	String currentDir = System.getProperty("user.dir");
//	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//}
}
