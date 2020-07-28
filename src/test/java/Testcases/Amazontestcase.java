package Testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basetestpkg.Basetest;
import Extentreport.ExtentReporterNG;
import Webpages.Homepage;
import Webpages.Loginpage;
import Webpages.Logoutpage;
import Webpages.Resultpage;

public class Amazontestcase extends Basetest {
	
	Homepage homepg;
	Loginpage loginpg;
	Logoutpage logoutpg;
	Resultpage resultpg;
	


public Amazontestcase()
{
	super();
}

@BeforeMethod
public void browserconfig() throws Exception
{
 System.out.println("Executing @Before Method");
}

@Test(enabled=false)
public void verifytitle()
{
	homepg.homepagetitle();
	
}
@DataProvider

public Object[][] getLoginData() throws Exception {
	Object data[][]=Basetest.getTestData("Values");
	return data;
}

@Test(dataProvider="getLoginData")

public void URLLaunch(String URL) throws Exception {
	initialisation(URL);
	 
	 
	
}
@Test(enabled=false)
public void Applogin() throws Exception
{
	
  homepg.homepagesigin();
  loginpg=new Loginpage();
  loginpg.login();
 
}

@Test(enabled=false)
public void Prodprice()
{
	homepg.Searchproduct();
	resultpg= new Resultpage();
	resultpg.price();
}

@Test(enabled=false)
public void Applogout() throws Exception
{
	//Applogin();
	logoutpg = new Logoutpage();
	logoutpg.homepagesignout();
	
}




@AfterMethod()
public void teardown()
{
	driver.quit();
}

}


