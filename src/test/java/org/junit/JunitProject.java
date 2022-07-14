package org.junit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class JunitProject {
	static WebDriver driver;
	static long browserstart;
	static long start;
	static String parent;
	static String text1;
	static String text2;
	static String text3;
	static FileOutputStream screenshot;
@BeforeClass
public static void browser() {
	browserstart= System.currentTimeMillis();
	System.out.println(browserstart);	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\pratheep.km\\eclipse-workspace\\JunitProject\\src\\Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
	 String url="https://www.flipkart.com/";
	driver.get(url);
	driver.manage().window().maximize();
}
@AfterClass
public static void browserQuit() {
long	browerend= System.currentTimeMillis();
	System.out.println("Browser Quit Time taken"+(browerend-browserstart)/100);
driver.quit();
}
@Before
public  void click() {
start= System.currentTimeMillis();

}
@After
public  void Closed() {
	long end=System.currentTimeMillis();
	
	System.out.println("time taken:"+(end-start)/100);
}
@Test
public void method1() throws Exception {
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[text()])[1]")).click();
	System.out.println("closed the pop up");
}
@Test
public void method2() throws Exception {
	Thread.sleep(2000);
	System.out.println("Enter the mobil");
driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Redmi mobile",Keys.ENTER);
driver.findElement(By.xpath("//*[@type='submit']"));
WebElement move=driver.findElement(By.xpath("//*[contains(text(),'Explore')]"));
Thread.sleep(3000);
Actions ac=new Actions(driver);
ac.moveToElement(move).perform();

}
@Test
public void method3() {
	String parent=driver.getWindowHandle();
	System.out.println(parent);	
}
@Test
public void method4(){
WebElement mobil1=driver.findElement(By.xpath("(//*[contains(text(),'REDMI 10')])[1]"));
mobil1.click();
 text1=mobil1.getText();
System.out.println(text1);
driver.switchTo().window(parent);
}
@Test
public void method5() throws Exception{
Thread.sleep(3000);
WebElement mobil2=	driver.findElement(By.xpath("(//*[contains(text(),'REDMI 10')])[2]"));
mobil2.click();
 text2=mobil2.getText();
System.out.println(text2);
driver.switchTo().window(parent);
}
@Test
public void method6() throws InterruptedException{

Thread.sleep(3000);
WebElement mobil3=driver.findElement(By.xpath("(//*[contains(text(),'REDMI 10')])[3]"));
mobil3.click();
 text3=mobil3.getText();
System.out.println(text3);
driver.switchTo().window(parent);
Thread.sleep(3000);
Set<String> multi=driver.getWindowHandles();
List<String>child=new ArrayList<String>(multi);
for (int i = 0; i < child.size(); i++) {	
driver.switchTo().window(parent);
}
}
@Test
public void method7() throws InterruptedException, IOException  {
	Thread.sleep(3000);
	TakesScreenshot st= (TakesScreenshot)driver;
	File type= st.getScreenshotAs(OutputType.FILE);
	File Loc=new File("C:\\Users\\pratheep.km\\eclipse-workspace\\JunitProject\\target\\Screen shot\\Junit");
	FileUtils.copyFile(type,Loc);
		System.out.println("Screen shot taken");
}
@Test
public void method8() throws Exception {
	File list= new File("C:\\Users\\pratheep.km\\eclipse-workspace\\JunitProject\\target\\Excel\\mobiles.xlsx");
    FileOutputStream fl=new FileOutputStream(list);
    XSSFWorkbook work=new XSSFWorkbook();
   XSSFSheet sheet=work.createSheet("Mobiles");
   XSSFRow row= sheet.createRow(0);
   XSSFCell cell=row.createCell(0);
    cell.setCellValue("mobile List");
    
    XSSFRow row1= sheet.createRow(1);
    XSSFCell cell1=row1.createCell(0);
     cell1.setCellValue(text1);
     
     XSSFRow row2= sheet.createRow(2);
     XSSFCell cell2=row2.createCell(0);
      cell2.setCellValue(text2);
      
      XSSFRow row3= sheet.createRow(3);
      XSSFCell cell3=row3.createCell(0);
       cell3.setCellValue(text3);
 work.write(fl);
 work.close();
 System.out.println("Excel file updated");
}


}














						
