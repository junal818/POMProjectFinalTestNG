package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExelReader;

public class LoginTest {

	WebDriver driver;
	LoginPage loginPage;
	DashboardPage dashboardPage;

	ExelReader exlRead = new ExelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String expectedDashboardHeader = exlRead.getCellData("DashboardInfo", "DashboardHeader", 2);
	String userAlertMsg = exlRead.getCellData("LoginInfo", "alertUserValidationText", 2);
	String passwordAlertMsg = exlRead.getCellData("LoginInfo", "alertPasswordValidationText", 2);

	@Test
	public void userShouldBeAbleToLogin() {

		driver = BrowserFactory.setup();

		// LoginPage loginPage = new LoginPage(driver);

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// dashboardPage.validateDashboardPage()
		Assert.assertEquals(dashboardPage.validateDashboardPage(), expectedDashboardHeader, "Dashboard page not found");
		BrowserFactory.tearDown();
	}

	@Test
	public void validateAlertMessages() {

		driver = BrowserFactory.setup();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSigninButton();
		Assert.assertEquals(loginPage.getAlertMsg(), userAlertMsg, "Alert msg doesnt match");
		loginPage.accetpAlert();

		loginPage.insertUserName(userName);
		loginPage.clickSigninButton();
		Assert.assertEquals(loginPage.getAlertMsg(), passwordAlertMsg, "Alert msg doesnt match");
		loginPage.accetpAlert();
		BrowserFactory.tearDown();
	}

}
