package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DashboardPage {
	//declare WebDriver
	WebDriver driver;
	
	//Constructor to hold driver
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//identify element using FindBy
	@FindBy(how = How.XPATH, using = "//strong[text()='Dashboard']") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Customers']") WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Add Customer']") WebElement ADD_CUSTOMER_MENU_ELEMENT;

	//Intractable methods
	public String validateDashboardPage() {
		String dashboardHeaderText = DASHBOARD_HEADER_ELEMENT.getText();
		return dashboardHeaderText;
	}
	
	public void clickCustomerMenuButton() {
		CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickAddCustomerMenuButton() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
	
}
