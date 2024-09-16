package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExelReader exlRead = new ExelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String expectedDashboardHeader = exlRead.getCellData("DashboardInfo", "DashboardHeader", 2);
	String expectedAddcustomerHeader = exlRead.getCellData("AddContactInfo", "AddContactValidationText", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.setup();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		//Assert.assertEquals(dashboardPage.validateDashboardPage(), "expectedDashboardHeader", "Dashboard page not found!!");
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		assertEquals(addCustomerPage.validateAddCustomerPage(), expectedAddcustomerHeader, "Add Customer page not found!!");
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickOnSave();
		Thread.sleep(20000);
		
		addCustomerPage.validateInsertedNameAndDelete();
	}

}
