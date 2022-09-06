package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ElementPage extends BasePage{
	
	WebDriver driver;
	String insertedCategoryName;
	String existingCategories;

	public ElementPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@value = 'Add category']") WebElement ADD_CATEGORY_ELEMENT;
	
	@FindBy(how = How.NAME, using = "categorydata") WebElement CATEGORY_INPUT_ELEMENT;

	@FindBy(how = How.NAME, using = "category") WebElement CATEGORY_DROPDOWN_ELEMENT;
	
	@FindBy(how = How.NAME, using = "due_month") WebElement MONTH_DROPDOWN_ELEMENT;

	public void insertCategory(String data) {
		insertedCategoryName = data+generateRandomNumber(999);
		CATEGORY_INPUT_ELEMENT.sendKeys(insertedCategoryName);
	}
	
	public void clickAddCategory() {
		ADD_CATEGORY_ELEMENT.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Test 1: Validate a user is able to add a category and once the category is added it should display.
	
	//xpath of changing data in table://body/div[3]/a[553]/span
	////body/div[3]/a[550]/span
	
	String beforeXpath="//body/div[3]/a[";
	String afterXpath="]/span";
	
	public void validateCategoryAdded(String names) {
		
		for(int i=700;i<+200;i--) {
			existingCategories=driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			if(existingCategories.equalsIgnoreCase(insertedCategoryName)) {
				System.out.println("Inserted category exists");
		}break;
		}
	}
	
	/* Test 2: Validate a user is not able to add a duplicated category. If it does
	 * then the following message will display:
	 * "The category you want to add already exists: <duplicated category name>."
	 */
	
	public void validateDuplicatesAreNotEntered(String data) {
		
		ADD_CATEGORY_ELEMENT.sendKeys(data);
		if(data.equalsIgnoreCase(existingCategories)) {
			System.out.println("The category you want to add already exists: <duplicated category name>.");
		}
	}
	
	//Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.

	public void validateAllMonthsInDateDropdown(String text) {
		
		selectFromDropdown(MONTH_DROPDOWN_ELEMENT, text);			
	}
}
