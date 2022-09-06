package examTestngProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ElementPage;
import util.BrowserFactory;

public class ElementPageTest {
	

	WebDriver driver;
	ElementPage elementPage;
	
	@BeforeMethod
	public void beforeTest() {
		driver = BrowserFactory.init();
		elementPage=PageFactory.initElements(driver, ElementPage.class);
	}
	
//	Test 1: Validate a user is able to add a category and once the category is added it should display.
	@Test()
	public void insertCategory() {
		
		elementPage.insertCategory("september");
		elementPage.clickAddCategory();
		elementPage.validateCategoryAdded("september");	
	/*Test 2: Validate a user is not able to add a duplicated category. If it does then the following message will display:
	 *  "The category you want to add already exists: <duplicated category name>."
	 */

		elementPage.validateDuplicatesAreNotEntered("september");	
	
	/* Test 3: Validate the month drop down has all the months (jan, feb, mar ...)
	 *  in the Due Date dropdown section.
	 */
	
		elementPage.validateAllMonthsInDateDropdown("Jan");
	}
	
	@AfterTest
	public void tearDown() {
		BrowserFactory.tearDown();
	}
	
	
}
