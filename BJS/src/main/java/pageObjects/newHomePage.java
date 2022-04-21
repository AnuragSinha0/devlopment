package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class newHomePage {

	WebDriver driver;

	public newHomePage(WebDriver ldriver) {
		this.driver = ldriver;

	}

	@FindBy(xpath = "//input[@class=\"gLFyf gsfi\"]")
	WebElement clickOnElement;

	@FindBy(tagName = "a")
	List<WebElement> elementCount;

	public void elementCount() {
		System.out.println(" value " + elementCount.size());
	}

	public void clickOnElement() {
		clickOnElement.click();
	}

	public void getLinkText() {
		for (int i = 0; i < elementCount.size(); i++) {
			System.out.println("***** Link Text Is ***** : " + i + " *********** " + elementCount.get(i).getText());

			System.out.println("***** Link URL Is ***** : " + i + " ********** "+ elementCount.get(i).getAttribute("href"));
		}
	}

}
