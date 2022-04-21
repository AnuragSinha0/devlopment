package flip;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import componetns.baseClass;
import pageObjects.gmailLoginPage;

public class gmailTestClass extends baseClass {

	@Test
	public void loginToGmail() throws Exception {
		gmailLoginPage gmailLoginPage = PageFactory.initElements(driver, gmailLoginPage.class);
		gmailLoginPage.userName();
		gmailLoginPage.nextButton();
		//gmailLoginPage.passwordValue();
	}

}
