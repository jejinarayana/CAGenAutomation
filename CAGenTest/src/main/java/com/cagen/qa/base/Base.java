package com.cagen.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cagen.qa.utils.TestUtil;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {
		try {
			// Get Project Directory
			String currentDirectory = System.getProperty("user.dir");
			prop = new Properties();
			//FileInputStream in = new FileInputStream("C:\\CAGen-Automation\\eclipse-workspaces\\CAGenTest\\src\\main\\java\\com\\cagen\\qa\\config\\config.properties");
			
			FileInputStream in = new FileInputStream(currentDirectory + "\\src\\main\\java\\com\\cagen\\qa\\config\\config.properties");
						prop.load(in);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void driverSetup() { 
	//	System.setProperty("webdriver.chrome.driver","C:\\CAGen-Automation\\BrowserDrivers\\chromedriver.exe");
	//	driver = new ChromeDriver();
	//	System.setProperty("webdriver.ie.driver","C:\\CAGen-Automation\\BrowserDrivers\\IEDriverServer.exe");
	//	driver = new InternetExplorerDriver();
		String currentDirectory = System.getProperty("user.dir");
		String browserName = prop.getProperty("browser");
	//	if (browserName.equalsIgnoreCase("chrome")) {
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", currentDirectory + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", currentDirectory + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else 
			System.out.println("Please Specify the Valid Browser......");
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	//	driver.get(prop.getProperty("sample_winasp_url"));
	//	System.out.println("Application has Launched...........");
	}
	


}
