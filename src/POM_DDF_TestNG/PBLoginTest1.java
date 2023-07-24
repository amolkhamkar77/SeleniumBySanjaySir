package POM_DDF_TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PBLoginTest1 
{
	int a;     //declare globally --> DataType Variable
	PBLoginPage login;
	PBMobNumPage mobNum;
	PBPwdPage pwd;
	PBHomePage home;
	PBMyAccPage myAcc;
	PBProfilePage profile;
	Sheet sh;
	WebDriver driver;
	
	
	@BeforeClass
	//Browser Opening code + Excel Sheet code + Object Creation of multiple POM classes --> those code which is used one time
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\sanja\\OneDrive\\Desktop\\Study\\28Th Jan Eve\\28thJan.xlsx");
		 sh = WorkbookFactory.create(file).getSheet("DDF");
		
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//  PBLoginPage	login=new PBLoginPage(driver); --> Object creation
// Left part Declared Globally i.e 	PBLoginPage	login; --> ClassName objRefVariable
//	login=new PBLoginPage(driver); -->Declared Locally --> objRefVariable = new ClassName(parameter if any);
		 login=new PBLoginPage(driver);
		 mobNum=new PBMobNumPage(driver);
		 pwd=new PBPwdPage(driver);
		 home=new PBHomePage(driver);
		 myAcc=new PBMyAccPage(driver);
		 profile=new PBProfilePage(driver);
		 a=10;         //initialize locally --> Variablr = Value;
	}
	
	@BeforeMethod
	// Application login functionality flow code
	public void loginToApp() throws InterruptedException
	{
		System.out.println(a);
		login.clickPBLoginPageSignIN();
		mobNum.inpPBMobNumPageMobNum(sh.getRow(0).getCell(0).getStringCellValue());
		mobNum.clickPBMobNumPageSignInWithPwd();
		pwd.inpPBPwdPagePWD(sh.getRow(0).getCell(1).getStringCellValue());
		pwd.clickPBPwdPageSignIn();
		Thread.sleep(3000);
	}
	
	
	@Test
	// Test case --> Flow of Test Case functionality
	public void verifyFullName() throws InterruptedException 
	{
		home.openDDOptionPBHomePageMyAcc();
		Thread.sleep(2000);
		myAcc.clickPBMyAccPageMyProfile();
		profile.switchToSwitchChildWindow();
		//profile.verifyPBProfilePageFullName(sh.getRow(0).getCell(2).getStringCellValue());	
		
		String actFullName=profile.getPBProfilePageFullName();
		String expFullName=sh.getRow(0).getCell(2).getStringCellValue();
		
		Assert.assertEquals(actFullName, expFullName, "Failed: both names are diff- ");
	}
	
	@AfterMethod
// Application logout functionality--> if you dont want to logout your application then keep it empty or you can delete this annotation
	public void name() 
	{
		
	}
	
	
	@AfterClass
// browser closig code	
	public void closeBrowser()
	{
		driver.quit();
	}

}
