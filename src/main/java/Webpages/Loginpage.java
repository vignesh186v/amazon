package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basetestpkg.Basetest;

public class Loginpage extends Basetest {
	
	
@FindBy(name="email")
WebElement Emailid;

@FindBy(id="continue")
WebElement continuebt;

@FindBy(name="password")
WebElement Password;

@FindBy(id="signInSubmit")
WebElement Signinbt;

public Loginpage()
{
	PageFactory.initElements(driver, this);
}

public void login() throws Exception
{
	Emailid.sendKeys(getvalue("Username"));
	continuebt.click();
	Password.sendKeys(getvalue("Password"));
	Signinbt.click();
}


}
