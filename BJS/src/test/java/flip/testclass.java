package flip;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import componetns.baseClass;
import pageObjects.newHomePage;

public class testclass extends baseClass {

	@Test
	public void countofElement() throws Exception {
		newHomePage newHomePage = PageFactory.initElements(driver, newHomePage.class);
		newHomePage.elementCount();
		newHomePage.getLinkText();
		driver.quit();
	}
	
}
