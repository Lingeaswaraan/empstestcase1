package emps;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class EmpsTestCaseHomepage {
	static WebDriver driver;

	@BeforeMethod
	public static void initializeDriver() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"/home/promantus/eclipse-workspace/Allurereports/exe/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");

		options.addArguments("--headless"); // should be enabled for Jenkins
		options.addArguments("--disable-dev-shm-usage"); // should be enabled for Jenkins
		options.addArguments("--window-size=1920x1080"); // should be enabled for Jenkins
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://dashboard-emps.g10.pw/homepage");
	}

	@Test(priority = 1, description = "Clicking on the customer login button on the EMPS Homepage ")
	@Description("Checking the existence of the customer login button and also clicking on the customer login button")
	public static void testcase1() throws InterruptedException {
		WebElement customer_loginbutton = driver
				.findElement(By.xpath("//div[@id='banner']/child::button[text()='Customer login']"));
		boolean displayed = customer_loginbutton.isDisplayed();
		logmessage("customer login button is displayed" + displayed);
		customer_loginbutton.click();
		logmessage("Clicking on the customer login Button");
		String title = driver.getTitle();

		String title2 = "Employee App - Group10 Technologies";

		
		logmessage("Successfully navigated to Transport-manager login page");
		Thread.sleep(2000);
	}

	@AfterMethod
	public static void loginPageTest() {
		driver.close();
	}

	@Step("{0}")
	public static String logmessage(String message) {
		return message;
	}

	public static String getpageTitle() {
		return driver.getTitle();
	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
