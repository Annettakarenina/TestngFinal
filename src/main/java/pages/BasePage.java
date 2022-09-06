package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public int generateRandomNumber(int boundaryNumber) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundaryNumber);
		return generatedNum;
	}

	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
		List<WebElement> data = sel.getOptions();
		for (WebElement i : data) {
			
		}System.out.println(element.getText());
	}
	
}
