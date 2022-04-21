package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import componetns.readPropertiesFile;

public class gmailLoginPage {

	WebDriver driver;

	public gmailLoginPage(WebDriver ldriver) {
		this.driver = ldriver;

	}

	@FindBy(xpath = "//input[@type='email']")
	WebElement userName;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextButton;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordValue;

	@FindBy(xpath = "//img[@class='gb_Aa gbii']")
	WebElement profileLogo;

	@FindBy(xpath = "//div[text()='Sign out']")
	WebElement logOutButton;

	public void userName() throws Exception {
		userName.sendKeys(readPropertiesFile.getPropertyByKeyValue("userName"));
	}

	public void nextButton() {
		nextButton.click();
	}

	public void passwordValue() throws Exception {
		passwordValue.sendKeys(readPropertiesFile.getPropertyByKeyValue("passwordValue"));
	}

	public void profileLogo() {
		profileLogo.click();
	}

	public void logOutButton() {
		logOutButton.click();
	}
}
