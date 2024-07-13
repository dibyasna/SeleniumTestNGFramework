package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest {
	ExtentReports extent;
	ExtentTest logger;
	ExtentSparkReporter spark;
	public static WebDriver driver;

	@BeforeTest
	public void beforeTestMethod() {
		spark = new ExtentSparkReporter("D:\\Auomation\\Framework\\SeleniumTestNGFramework\\reports");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setReportName("FreeCRMReport");
		spark.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Environment", "QA");
		spark.config().setDocumentTitle("AutomationTesting.in Demo Report");
		spark.config().setReportName("My Own Report");
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String brower, Method testMehod) {
		logger = extent.createTest(testMehod.getName());
		setUpDriver(brower);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void aferMethodMehod(ITestResult result) {
		if (driver != null) {
			System.out.println("deleteAllCookies");
			driver.manage().deleteAllCookies();
		}

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println(">>>Test Failed"); // Which Test Failed and Why (Method Name Output)
			logger.log(Status.FAIL, MarkupHelper
					.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable());
			System.out.println("Automation Test Run: " + result.getMethod().toString()); // Testing and Results
			// (Relevant)
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(">>>Test Passed");
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			logger.info(MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			System.out.println(
					"=====================================================================================================");
			System.out.println("Automation Test Run: " + result.getMethod().toString()); // Testing and Results
			System.out.println(
					"=====================================================================================================");
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println(">>>Test Skipped");
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
			System.out.println("Automation Test Run: " + result.getMethod().toString()); // Testing and Results
		}

		if (driver != null) {
			driver.manage().deleteAllCookies();
		}
	}

	@AfterTest
	public void testComplete() {
		extent.flush();
//		driver.manage().deleteAllCookies();
		driver.quit();
	}

	public void setUpDriver(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Auomation\\Framework\\SeleniumTestNGFramework\\driver\\chromedriver.exe");
			//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			System.out.println(driver);
		}
	}

}
