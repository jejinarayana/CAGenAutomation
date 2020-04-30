package com.cagen.qa.sample.winasp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cagen.qa.base.Base;
import com.cagen.qa.utils.TestUtil;

public class CorporateManagement extends Base {
	
	// Page Factory - Objects Repository for HomePage
	
	@FindBy(xpath = "//*[contains(@id,'Item1_0') and contains(@accesskey,'L')]") WebElement menu_List;
	@FindBy(xpath = "//*[contains(@id,'Item1_0_0') and contains(@accesskey,'D')]") WebElement submenu_List_Divisions;
	
	@FindBy(xpath = "//*[contains(@id,'Item1_0_1') and contains(@accesskey,'p')]") WebElement submenu_List_Departments;
	
	@FindBy(xpath = "//*[contains(@id,'Item1_0_2') and contains(@accesskey,'E')]") WebElement submenu_List_Employees;
	@FindBy(xpath = "//span[contains(text(),'CA Gen Sample Model - Window')]") WebElement homePageWelcomeText;
	
	// Intializing Corporate Management Page Objects
	public CorporateManagement() {
		PageFactory.initElements(driver, this);
	}
	
	// Corporate Management Page Methods --- Operations
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageWelcomeText() {
		return homePageWelcomeText.getText();
	}
	
	// Click on List-->Divisions
	
	public CorporateDivisions navigate_List_Division(){
		Actions action = new Actions(driver);
		TestUtil.waitForPageToLoad(2000);
		System.out.println("Clicking on List -->Divsion");
	//	action.moveToElement(menu_List).moveToElement(submenu_List_Divisions).click().build().perform();
		action.moveToElement(menu_List).build().perform();
		submenu_List_Divisions.click();
		return new CorporateDivisions();
	}
	
	// Click on List-->Departments
	
	public CorporateDepartments navigate_List_Department() {
		Actions action = new Actions(driver);
		TestUtil.waitForPageToLoad(2000);
		System.out.println("Clicking on List --> Departments");
	//	action.moveToElement(menu_List).moveToElement(submenu_List_Departments).click().build().perform();
		action.moveToElement(menu_List).build().perform();
		submenu_List_Departments.click();
		return new CorporateDepartments();
	}
	
	// Click on List--> Employee
	public CorporateEmployees navigate_List_Employees() {
		Actions action = new Actions(driver);
		TestUtil.waitForPageToLoad(2000);
		System.out.println("Clicking on List --> Employees");
	//	action.moveToElement(menu_List).moveToElement(submenu_List_Employees).click().build().perform();
		action.moveToElement(menu_List).build().perform();
		submenu_List_Employees.click();
		return new CorporateEmployees();
	}
	
	
	
	
	
	
	
	
	
	
}
