package com.cagen.qa.sample.winasp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cagen.qa.base.Base;

public class DepartmentDetails extends Base {
		
	
	@FindBy(xpath = "//input[@name='Field1']") WebElement Txt_Dept_Number;
	
	@FindBy(xpath = "//input[@name='Field2']") WebElement Txt_Dept_Name;
	
	@FindBy(xpath = "//input[@name='Field3']") WebElement Txt_Dept_Manager_No;
	
	@FindBy(xpath = "//input[@name='Field4']") WebElement Txt_Dept_Div_Number;
	
	@FindBy(xpath = "//input[@name='Button1']") WebElement Btn_OK;
	
	
	
	
	// Objects Initialization
		public DepartmentDetails() {
			PageFactory.initElements(driver, this);
		}
	
	
	//Methods.........................
		// Enter Department Data
		public CorporateDepartments addDeptData(String deptNo, String deptName, String deptMgrNo, String deptDivNo) {
			System.out.println("Entering Department Data");
			driver.switchTo().frame("IFrame1");
			Txt_Dept_Number.clear();
			Txt_Dept_Number.sendKeys(deptNo);
			Txt_Dept_Name.clear();
			Txt_Dept_Name.sendKeys(deptName);
			Txt_Dept_Manager_No.clear();
			Txt_Dept_Manager_No.sendKeys(deptMgrNo);
			Txt_Dept_Div_Number.clear();
			Txt_Dept_Div_Number.sendKeys(deptDivNo);
			Btn_OK.click();
			return new CorporateDepartments();
		}


			
		
	
	
	
	
	
	
	

}
