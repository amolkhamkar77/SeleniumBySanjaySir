//package POM_DDF_TestNG;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//pom with DDF
//public class PBLoginTest 
//{
//	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
//	{		
//	
//		
//		
//		login.clickPBLoginPageSignIN();
//		
//		
//		
//		String MobileNumber = sh.getRow(0).getCell(0).getStringCellValue();
//		mobNum.inpPBMobNumPageMobNum(MobileNumber);
//		mobNum.clickPBMobNumPageSignInWithPwd();
//		Thread.sleep(2000);
//		
//		
//		
//		String password = sh.getRow(0).getCell(1).getStringCellValue();
//		pwd.inpPBPwdPagePWD(password);
//		pwd.clickPBPwdPageSignIn();
//		Thread.sleep(2000);
//		
//		
//		home.openDDOptionPBHomePageMyAcc();
//		Thread.sleep(2000);
//		
//		
//		myAcc.clickPBMyAccPageMyProfile();
//		Thread.sleep(2000);
//		
//		
//		profile.switchToSwitchChildWindow();
//		
//		String expFullName = sh.getRow(0).getCell(2).getStringCellValue();
//		profile.verifyPBProfilePageFullName(expFullName);
//		Thread.sleep(2000);
//		
//		driver.quit();	
//	}
//}
