package com.cagen.qa.sample.winasp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cagen.qa.base.Base;

public class EmployeeDetails extends Base {
	
	
	@FindBy(xpath = "//input[@name='Field1']") WebElement Txt_Employee_Number;
	
	@FindBy(xpath = "//input[@name='Field2']") WebElement Txt_Employee_Name;
	
	@FindBy(xpath = "//input[@name='Field3']") WebElement Txt_Employee_Division_Number;
	
	@FindBy(xpath = "//input[@name='Field4']") WebElement Txt_Employee_Department_Number;
	
	@FindBy(xpath = "//input[@name='Button1']") WebElement Btn_OK;
	
	// Objects Initialization
		public EmployeeDetails() {
			PageFactory.initElements(driver, this);
		}
		
		//Methods.........................
		// Enter Division Data
		public CorporateEmployees addEmployeeData(String emptNo, String emptName, String empDivNo, String empDeptNo) {
			System.out.println("Entering Employee Data");
			driver.switchTo().frame("IFrame1");
			Txt_Employee_Number.clear();
			Txt_Employee_Number.sendKeys(emptNo);
			Txt_Employee_Name.clear();
			Txt_Employee_Name.sendKeys(emptName);
			Txt_Employee_Division_Number.clear();
			Txt_Employee_Division_Number.sendKeys(empDivNo);
			Txt_Employee_Department_Number.clear();
			Txt_Employee_Department_Number.sendKeys(empDeptNo);
						
			Btn_OK.click();
			return new CorporateEmployees();
		}
	
	
	
	
	
	
	
	

}
