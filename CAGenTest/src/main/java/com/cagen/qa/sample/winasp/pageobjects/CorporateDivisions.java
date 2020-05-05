package com.cagen.qa.sample.winasp.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cagen.qa.base.Base;
import com.cagen.qa.utils.TestUtil;

public class CorporateDivisions extends Base{
	
	// Page Factory - Objects Repository for ListDivisions Page
	
	@FindBy(xpath = "//*[contains(@id,'Item1_0') and contains(@accesskey,'E')]") WebElement menu_Edit;
	
	@FindBy(xpath = "//*[contains(@id,'Item1_0_0') and contains(@accesskey,'A')]") WebElement submenu_Edit_Add;
	
	@FindBy(xpath = "//*[contains(@id,'Item1_0_1') and contains(@accesskey,'D')]") WebElement submenu_Edit_Delete;
	
	@FindBy(xpath = "//*[contains(@id,'Item1_4') and contains(@accesskey,'C')]") WebElement menu_Close;
	
	@FindBy(xpath = "//tr[@id='ctl03_R0']") WebElement div_firstRow;
	@FindBy(xpath = "//tr[@id='ctl03_R1']") WebElement div_secondRow;
	@FindBy(xpath = "//tr[@id='ctl03_R2']") WebElement div_thirdRow;
	@FindBy(xpath = "//tr[@id='ctl03_R3']") WebElement div_fourthRow;
	
	// Objects Initialization
	public CorporateDivisions() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods
	
	public DivisionsDetails navigate_Edit_Add() {
		System.out.println("Clicking on Edit -->Add");
	//	driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		Actions action = new Actions(driver);
		TestUtil.waitForPageToLoad(2000);
	//	action.moveToElement(menu_Edit).moveToElement(submenu_Edit_Add).click().build().perform();
		action.moveToElement(menu_Edit).build().perform();
	//	TestUtil.waitForPageToLoad(2000);
		submenu_Edit_Add.click();
		return new DivisionsDetails();
		
	}
	
	public void navigate_Edit_Delete() {
		driver.switchTo().defaultContent();
		System.out.println("Clicking on Edit -->Delete");
	//	driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		Actions action = new Actions(driver);
		TestUtil.waitForPageToLoad(1000);
		action.moveToElement(menu_Edit).build().perform();
		submenu_Edit_Delete.click();
		TestUtil.waitForPageToLoad(2000);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindow = it.next();
		System.out.println("Parent Window Name is...."+parentWindow+"........."+"And PageTitle is..... "+driver.getTitle());
		String childtWindow = it.next();
		driver.switchTo().window(childtWindow);
		System.out.println("Child Window Name is...."+childtWindow+"........."+"And PageTitle is..... "+driver.getTitle());
		System.out.println("Set Focus to Child Window.."+driver.getTitle());
		driver.switchTo().frame("IFrame1");
		driver.findElement(By.xpath("//input[@type='button' and @value='Yes']")).click();
		driver.switchTo().window(parentWindow);
	//	driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		System.out.println("Set Focus to Parent Window.."+driver.getTitle());
		menu_Close.click();
	}
	
	public CorporateManagement CloseDivisionPage() {
		menu_Close.click();
		return new CorporateManagement();
	}
	
	public void SelectRowTODelete() {
		System.out.println("Selecting Row to Dlete.......");
		driver.switchTo().frame("IFrame1");
		div_firstRow.click();
		
		
		
	}
	
	

}
