package com.cagen.qa.sample.winasp.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cagen.qa.base.Base;
import com.cagen.qa.sample.winasp.pageobjects.CorporateManagement;
import com.cagen.qa.sample.winasp.pageobjects.DepartmentDetails;
import com.cagen.qa.sample.winasp.pageobjects.CorporateDepartments;
import com.cagen.qa.sample.winasp.pageobjects.CorporateDivisions;
import com.cagen.qa.sample.winasp.pageobjects.CorporateEmployees;
import com.cagen.qa.sample.winasp.pageobjects.DivisionsDetails;
import com.cagen.qa.sample.winasp.pageobjects.EmployeeDetails;
import com.cagen.qa.utils.TestUtil;

public class SampleModelTests extends Base{
	CorporateManagement corpMgmt;
	CorporateDivisions corpDivs;
	DivisionsDetails divisionDetails;
	CorporateDepartments corpDept;
	DepartmentDetails deptDetails;
	CorporateEmployees corpEmp;
	EmployeeDetails empDetails;
	
	
	public SampleModelTests() {
		super();
	}
	
	@BeforeMethod
	public void appLaunch(){
		driverSetup();
		driver.get(prop.getProperty("sample_winasp_url"));
		System.out.println("Application has Launched...........");
		corpMgmt = new CorporateManagement();
	}	
	
	
	//@Test(priority=1)
	public void homePageTitleTest() {
		String title = corpMgmt.getHomePageTitle();
		Assert.assertEquals(title, "Corporate Management");
	}
	
	// Data Provider for Division Data
		@DataProvider(name="SampleModel_DivData")
		public Object[][] getSampleModel_DivData() {
			Object data[][] = TestUtil.getTestData("Sample_Div");
			return data;
		}	
		
	// Data Provider for Dept Data
		@DataProvider(name="SampleModel_DeptData")
		public Object[][] getSampleModel_DeptData() {
			Object data[][] = TestUtil.getTestData("Sample_Dept");
			return data;
		}		
	// Data Provider for Employee Data	
		@DataProvider(name="SampleModel_EmpData")
		public Object[][] getSampleModel_EmpData() {
			Object data[][] = TestUtil.getTestData("Sample_Emp");
			return data;
		}	
	//@Test(priority=2, dataProvider="SampleModel_DivData")
	public void addDivision_DP(String divNo, String divName, String divMgrNo) {
		corpDivs = corpMgmt.navigate_List_Division();
		divisionDetails = corpDivs.navigate_Edit_Add();
	//	corpDivs = divisionDetails.addDivisionData_DP( "111", "Div111", "0");
		corpDivs = divisionDetails.addDivisionData_DP(divNo, divName, divMgrNo);
		corpDivs.CloseDivisionPage();		
		System.out.println("By Data Provider .... Division Added successfully");
		
	}
	@Test(priority=2)
	public void addDivison() {
		corpDivs = corpMgmt.navigate_List_Division();
		divisionDetails = corpDivs.navigate_Edit_Add();
		corpDivs = divisionDetails.addDivisionData("111", "Div111", "0");
	//	divisionDetails = corpDivs.navigate_Edit_Add();
	//	corpDivs = divisionDetails.addDivisionData("222", "Div222", "0");
		corpDivs.CloseDivisionPage();		
		System.out.println("Division Added successfully");
	}
	
	@Test(priority=3)
	public void addDept() {
		corpDept = corpMgmt.navigate_List_Department();
		deptDetails = corpDept.navigate_Edit_Add();
		corpDept = deptDetails.addDeptData("1111", "Dept1111", "0", "111");
	//	deptDetails = corpDept.navigate_Edit_Add();
	//	corpDept = deptDetails.addDeptData("2222", "Dept2222", "0", "222");
		corpDept.CloseDeptPage();		
		System.out.println("Department Added successfully");
	}
	
	@Test(priority=4)
	public void addEmployee() {
		corpEmp = corpMgmt.navigate_List_Employees();
		empDetails = corpEmp.navigate_Edit_Add();
		corpEmp = empDetails.addEmployeeData("101", "Emp101", "111", "1111");
		corpEmp.CloseDeptPage();		
		System.out.println("Employee Added successfully");
	}
	
	@Test(priority=5)
	public void deleteEmp() {
		corpEmp = corpMgmt.navigate_List_Employees();
		TestUtil.waitForPageToLoad(1000);
		corpEmp.SelectRowToDeleteDept();
		corpEmp.navigate_Edit_Delete();
		TestUtil.waitForPageToLoad(1000);
		corpEmp.CloseDeptPage();
		System.out.println("Employee Deleted successfully");
	}
	
	@Test(priority=6)
	public void deleteDept() {
		corpDept = corpMgmt.navigate_List_Department();
		TestUtil.waitForPageToLoad(1000);
		corpDept.SelectRowToDeleteDept();
		corpDept.navigate_Edit_Delete();
		TestUtil.waitForPageToLoad(1000);
		corpDept.CloseDeptPage();
		System.out.println("Department Deleted successfully");
	}
	
	@Test(priority=7)
	public void deleteDivison() {
		corpDivs = corpMgmt.navigate_List_Division();
		TestUtil.waitForPageToLoad(1000);
		corpDivs.SelectRowTODelete();
		corpDivs.navigate_Edit_Delete();
		TestUtil.waitForPageToLoad(1000);
		corpDivs.CloseDivisionPage();
		System.out.println("Division Deleted successfully");
		}
	
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}	
	
	
	
	
	
	
	
	

}
