package POM_With_Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sampleOf_POM_Class_Creation
{
	//step1:declaration--> data member declared globally with acces specifier Private
	private int a;
	@FindBy(xpath = "Xpath expression") private WebElement myAcc;
	
	//step2: initialization --> Constructor with access Specifier Public..Using Page factory class
	public sampleOf_POM_Class_Creation()
	//public sampleOf_POM_Class_Creation(WebDriver driver)
	{
		a=10;
	//	PageFactory.initElements(driver, this);
	}
	
	
	//step3: Utilize within a method with access level public
	public void m1()
	{
		System.out.println(a*a);
	}

}
