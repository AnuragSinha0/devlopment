package componetns;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	protected static WebDriver driver;

	@BeforeClass
	public void launchDriver() throws Exception {
		String browser = readPropertiesFile.getPropertyByKeyValue("webDriver");
		// drivers.launchBrowser(option);
		System.out.println("***** Running Browser is ***** : " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("***** Chrome Browser Launch Sucessfully *****");
		} else if (browser.equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("***** IE Browser Launch Sucessfully *****");

		} else if (browser.equals("edge")) {

			String edgedriver = System.getProperty("user.dir") + "//drivers//msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", edgedriver);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("***** FireFox Browser Launch Sucessfully *****");
		}

	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void getUrl() throws Exception {
		System.out.println("***** Running Web Page Is ***** : ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readPropertiesFile.getPropertyByKeyValue("webUrl"));
	}

	/*
	 * @AfterMethod public void captureScreenShot(ITestResult result,Method method)
	 * throws Exception {
	 * 
	 * String teststatus = null; switch (result.getStatus()) { case
	 * ITestResult.SUCCESS: teststatus = "PASS"; break; case ITestResult.FAILURE:
	 * teststatus = "FAIL"; break; case ITestResult.SKIP: teststatus = "SKIP";
	 * break; }
	 * 
	 * String timeStamp = new
	 * SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime
	 * ());
	 * 
	 * String timestampPath = File.separator + "screenshots" + File.separator +
	 * method.getName() + "_" + teststatus+ "_" + timeStamp;
	 * 
	 * String path = System.getProperty("user.dir") + File.separator + "Reports" +
	 * timestampPath;
	 * 
	 * try { Screenshot fpScreenshot = new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
	 * .takeScreenshot(driver); ImageIO.write(fpScreenshot.getImage(), "jpg", new
	 * File(path + ".jpg")); } catch (Exception e) { throw new Exception(); }
	 * driver.close(); } }
	 * 
	 * }
	 */

	/*
	 * Properties prop = new Properties();
	 * 
	 * public String getPropertyByKeyValue(String key) throws Exception { String
	 * prpertyFIlepath = System.getProperty("user.dir") +
	 * "/src/test/resources/url.properties"; FileInputStream file = new
	 * FileInputStream(prpertyFIlepath); prop.load(file); String keyValue =
	 * prop.get(key).toString();
	 * 
	 * if (StringUtils.isEmpty(keyValue)) {
	 * 
	 * throw new Exception("***** Value Is Null/Empty for Key ***** :  " + key +
	 * "***** In Properties File ***** "); } return keyValue; }
	 */
}
