package flip;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import componetns.readPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class drivers {
public static WebDriver driver;
	
	public static  void launchBrowser( String browser) throws Exception {
		/*String option = readPropertiesFile.getPropertyByKeyValue("chromeBrowser");
		drivers.launchBrowser(option);*/
		System.out.println("***** Running Browser is ***** : " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("***** Chrome Browser Launch Sucessfully *****");
		}
		else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("***** IE Browser Launch Sucessfully *****");
			
		}
		else if (browser.equals("fireFox")) {
			
			String geckodriver = System.getProperty("user.dir") + "//drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckodriver);
			driver = new  FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("***** FireFox Browser Launch Sucessfully *****");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static String getUrl(String application) throws Exception {
		System.out.println("***** Running Web Page Is ***** : " + application);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(readPropertiesFile.getPropertyByKeyValue(application));
		return application;
	}
	
}
