package Basetestpkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utils.WebEventListener;

public class Basetest{
public	static WebDriver driver;
public	static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventlistener;
public static Workbook Workbook;
public static org.apache.poi.ss.usermodel.Sheet sheet;
public static Row row;
public static String value="";
public static String path="C:\\Users\\Vignesh\\Documents\\Testdata.xlsx";
	
	public Basetest()
	
	{
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Vignesh\\eclipse-workspace\\amazon\\src\\main\\java\\Properties\\Config.properties");			prop.load(ip);
		prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}	
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}		
		}
	
	public static void initialisation(String URL) throws Exception
	{
		String Browsername = prop.getProperty("browser");
		if(Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\geckodriver\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		//driver.get(prop.getProperty("url"));
		//driver.get(getvalue("URL"));
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("URL Launched successfully");
	}

	public static void loadexcel() throws Exception {
		 
		FileInputStream fis= new FileInputStream(path);
		Workbook = new XSSFWorkbook(fis);
		sheet=Workbook.getSheet("Credentials");
		fis.close();
	}
	
	
	public static Map<String,Map<String,String>> getMapdata() throws Exception{
		loadexcel();
		Map<String,Map<String,String>> supermap= new HashMap<String,Map<String,String>>();
		Map<String,String> myMap= new HashMap<String,String>();
		int rows= sheet.getLastRowNum();
		row=sheet.getRow(0);
		for (int j=1;j<=rows;j++) {
			String Flag=sheet.getRow(j).getCell(0).getStringCellValue();
			myMap.put("Flag",Flag);
			System.out.println("The flag set is :: " +myMap.get("Flag"));
		if(myMap.get("Flag").contentEquals("YES")) {
			myMap.put("Flag1",Flag);
			System.out.println("The flag set is :: " +myMap.get("Flag1"));		
			String URL=sheet.getRow(j).getCell(1).getStringCellValue();
			String Username = sheet.getRow(j).getCell(2).getStringCellValue();
			String Password = sheet.getRow(j).getCell(3).getStringCellValue();
			myMap.put("URL", URL);
			System.out.println("The URL is ::" +myMap.get("URL"));
			myMap.put("Username", Username);
			System.out.println("The Username is ::" +myMap.get("Username"));
			myMap.put("Password", Password);
			System.out.println("The Password is ::" +myMap.get("Password"));
			
		}
		/*
		 * else { System.out.println("Valid Flag value is not set for testdata ");
		 */
				
		//}
			}
		    supermap.put("Datasheet", myMap);
		   
		
		return supermap;
		
		
	}		
	

public static String getvalue(String key) throws Exception {
	Basetest.getMapdata();
	Map<String,String> myval=Basetest.getMapdata().get("Datasheet");
	value=myval.get(key);
	return value;
	
}
public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
	FileInputStream file = null;
	try {
		file = new FileInputStream(path);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		Workbook = WorkbookFactory.create(file);
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = Workbook.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			 System.out.println(data[i][k]);
		}
	}
	return data;
}


	
}
