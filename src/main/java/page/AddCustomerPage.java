package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {
	// declare WebDriver
	WebDriver driver;

	// Constructor to hold driver
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// identify element using FindBy
	@FindBy(how = How.XPATH, using = "//strong[text()='New Customer']")
	WebElement ADD_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[1]/div/input")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[2]/div/select")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[3]/div/input")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[5]/div/input")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[6]/div/input")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"port\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[8]/div[1]/select")
	WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"save_btn\"]")
	WebElement SAVE_BUTTON_ELEMENT;

	// Intractable methods
	public String validateAddCustomerPage() {
		String addCustomerHeaderText = ADD_CUSTOMER_HEADER_ELEMENT.getText();
		return addCustomerHeaderText;
	}

	String insertedName;

	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandomNum(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}

	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNum(9999) + email);
	}

	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNum(999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}

	public void clickOnSave() {
		SAVE_BUTTON_ELEMENT.click();
	}

	// tbody/tr[1]/td[2]/a
	//tbody/tr[2]/td[2]/a
	//tbody/tr[3]/td[2]/a
	//tbody/tr[i]/td[2]/a
		

	public void validateInsertedNameAndDelete() {
		String before_Xpath = "//tbody/tr[";
		String after_Xpath = "]/td[2]/a";
		String after_Xpath_delete = "]/td[9]/button";
		
		for (int i = 1; i <= 5; i++) {
//			driver.findElement(By.xpath("//tbody/tr[i]/td[2]/a"));
			String actualText = driver.findElement(By.xpath(before_Xpath + i + after_Xpath)).getText();
			System.out.println(actualText);
			if(actualText.contains(insertedName)) {
				System.out.println("Name exist!!");
				driver.findElement(By.xpath(before_Xpath + i + after_Xpath_delete)).click();
			}
			break;
		}
	}
	
	
}
