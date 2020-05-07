/*
 * @Autohor: Jeji Narayana Kadiyam*
 */

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

public class CorporateDepartments extends Base{
	
	// Page Factory - Objects Repository for ListDivisions Page
	
		@FindBy(xpath = "//*[contains(@id,'Item1_0') and contains(@accesskey,'E')]") WebElement menu_Edit;
		
		@FindBy(xpath = "//*[contains(@id,'Item1_0_0') and contains(@accesskey,'A')]") WebElement submenu_Edit_Add;
		
		@FindBy(xpath = "//*[contains(@id,'Item1_0_1') and contains(@accesskey,'D')]") WebElement submenu_Edit_Delete;
		
		@FindBy(xpath = "//*[contains(@id,'Item1_4') and contains(@accesskey,'C')]") WebElement menu_Close;
		
		@FindBy(xpath = "//tr[@id='ctl04_R0']") WebElement dept_firstRow;
		@FindBy(xpath = "//tr[@id='ctl04_R1']") WebElement dept_secondRow;
		@FindBy(xpath = "//tr[@id='ctl04_R2']") WebElement dept_thirdRow;
		@FindBy(xpath = "//tr[@id='ctl04_R3']") WebElement dept_fourthRow;
		
		
		
		// Objects Initialization
		public CorporateDepartments() {
			PageFactory.initElements(driver, this);
		}
		
		
		//Methods

		public DepartmentDetails navigate_Edit_Add() {
			
			System.out.println("Clicking on Edit -->Add");
				Actions action = new Actions(driver);
				TestUtil.waitForPageToLoad(2000);
			//	action.moveToElement(menu_Edit).moveToElement(submenu_Edit_Add).click().build().perform();
				action.moveToElement(menu_Edit).build().perform();
				submenu_Edit_Add.click();
				return new DepartmentDetails();
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
			TestUtil.waitForPageToLoad(2000);
			String childtWindow = it.next();
			driver.switchTo().window(childtWindow);
			System.out.println("Child Window Name is...."+childtWindow+"........."+"And PageTitle is..... "+driver.getTitle());
			System.out.println("Set Focus to Child Window.."+driver.getTitle());
			driver.switchTo().defaultContent();
			driver.switchTo().frame("IFrame1");
		//	driver.findElement(By.xpath("//input[@name='Button1']")).click();
			driver.findElement(By.xpath("//input[@type='button' and @value='Yes']")).click();
			driver.switchTo().window(parentWindow);
		//	driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
			System.out.println("Set Focus back to Parent Window.."+driver.getTitle());
		
		}
		
		public CorporateManagement CloseDeptPage() {
			menu_Close.click();
			return new CorporateManagement();
		}
		
		public void SelectRowToDeleteDept() {
			System.out.println("Selecting Row to Delete.......");
			driver.switchTo().frame("IFrame1");
			dept_firstRow.click();
			
			
			
		}
		
		
		
		
		
		
}
