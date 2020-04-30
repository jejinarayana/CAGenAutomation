package com.cagen.qa.sample.winasp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cagen.qa.base.Base;

public class DivisionsDetails extends Base{
	
	@FindBy(xpath = "//input[@name='Field1']") WebElement Txt_Division_Number;
	
	@FindBy(xpath = "//input[@name='Field2']") WebElement Txt_Division_Name;
	
	@FindBy(xpath = "//input[@name='Field3']") WebElement Txt_Division_Manager_Number;
	
	@FindBy(xpath = "//input[@name='Button1']") WebElement Btn_OK;
	
	// Objects Initialization
	public DivisionsDetails() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods.........................
	// Enter Division Data
	public CorporateDivisions addDivisionData(String divNo, String divName, String divMgrNo) {
		System.out.println("Entering Division Data");
		driver.switchTo().frame("IFrame1");
		Txt_Division_Number.clear();
		Txt_Division_Number.sendKeys(divNo);
		Txt_Division_Name.clear();
		Txt_Division_Name.sendKeys(divName);
		Txt_Division_Manager_Number.clear();
		Txt_Division_Manager_Number.sendKeys(divMgrNo);
		Btn_OK.click();
		return new CorporateDivisions();
	}
	
	public CorporateDivisions addDivisionData_DP(String divNo, String divName, String divMgrNo) {
		System.out.println("Entering Division Data");
		driver.switchTo().frame("IFrame1");
		Txt_Division_Number.clear();
		Txt_Division_Number.sendKeys(divNo);
		Txt_Division_Name.clear();
		Txt_Division_Name.sendKeys(divName);
		Txt_Division_Manager_Number.clear();
		Txt_Division_Manager_Number.sendKeys(divMgrNo);
		Btn_OK.click();
		return new CorporateDivisions();
	}
	
	
	
	
	
	
	
	

}
