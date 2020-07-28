package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basetestpkg.Basetest;

public class Logoutpage extends Basetest {
	
	Actions act = new Actions(driver);
	
	@FindBy(xpath="//div[@class=\"nav-line-1-container\"]/span[1]")
	WebElement loggedinuser;
	
	@FindBy(xpath="//a[@id=\"nav-item-signout\"]/span")
	WebElement signoutbt;
	
	
	public Logoutpage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public Loginpage homepagesignout()
	{
		act.moveToElement(loggedinuser).build().perform();
        signoutbt.click();
        return new Loginpage();
	}
	
	
	

}
