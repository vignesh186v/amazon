package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basetestpkg.Basetest;

public class Resultpage extends Basetest {
	
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	WebElement Productprice;
	
	
	public Resultpage() {
		PageFactory.initElements(driver, this);
	}

	public void price() {
		String firstprice = Productprice.getText();
		System.out.println(firstprice);
	}
	
}
