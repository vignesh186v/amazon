package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Basetestpkg.Basetest;

public class Homepage extends Basetest{
	
	@FindBy(xpath="//div[@class=\"nav-line-1-container\"]/span[1]")
	WebElement firstsigninbtn;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement searchbtn;
	
	
	public Homepage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void homepagetitle() {
		
		String title = driver.getTitle();
		
		String Actualtitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		Assert.assertEquals(title,Actualtitle,"title did not match");
	}
	
	public Loginpage homepagesigin()
	{
		firstsigninbtn.click();
		
		return new Loginpage();
	}
	
	public Resultpage Searchproduct() {
	
	if(searchbox.isEnabled());
	{
		searchbox.sendKeys(prop.getProperty("product"));
		searchbtn.click();
		return new Resultpage();	
	}
		
		
	}
	


}
