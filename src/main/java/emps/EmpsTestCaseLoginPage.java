package emps;

import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.ScreenCapture;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class EmpsTestCaseLoginPage {
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

		driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
	}

	@Test(priority = 1, description = "To Validate the functionalities of the login page when the user entered valid credentials")
	@Description("Entering the valid username and password and the expected result is to navigate into Dash board Page")
	public static void testCase1() throws InterruptedException {
		WebElement username_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='username']"));
		boolean displayed = username_field.isDisplayed();
		boolean enabled = username_field.isEnabled();

		logmessage("Username field is Displayed " + displayed);
		logmessage("username field is enabled  " + enabled);
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed2 = password_field.isDisplayed();
		boolean enabled2 = password_field.isEnabled();
		logmessage("password field is displayed " + displayed2);
		logmessage("password field is enabled " + enabled2);
		username_field.sendKeys("lingeaswaraan@promantus.com");
		logmessage("Entering the username as " + "lingeaswaraan@promantus.com");
		password_field.sendKeys("lin@123");
		logmessage("Entering the password as " + "lin@123");
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']/parent::button"));
		boolean displayed3 = login_button.isDisplayed();

		logmessage("Login button is Displayed " + displayed3);
		logmessage("Clicking on the login button");
		login_button.click();

		Thread.sleep(1500);

		String current_url = "https://dashboard-emps.g10.pw/organization/transport-manager/dashboard";
		

	}

	@Test(priority = 2, description = "To Validate the functionalities of the login page when the user entered  Invalid credentials")
	@Description("Entering the Invalid username and password and the expected result is not to navigate into Dash board Page")
	public static void testCase2() {
		WebElement username_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='username']"));
		boolean displayed = username_field.isDisplayed();
		boolean enabled = username_field.isEnabled();

		logmessage("Username field is Displayed " + displayed);
		logmessage("username field is enabled  " + enabled);
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed2 = password_field.isDisplayed();
		boolean enabled2 = password_field.isEnabled();
		logmessage("password field is displayed " + displayed2);
		logmessage("password field is enabled " + enabled2);
		username_field.sendKeys("abcd@gmail.com");
		logmessage("Entering the username as " + "abcd@gmail.com");
		password_field.sendKeys("hello2");
		logmessage("Entering the password as " + "hello2");
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']/parent::button"));
		boolean displayed3 = login_button.isDisplayed();

		logmessage("Login button is Displayed " + displayed3);
		logmessage("Clicking on the login button");
		login_button.click();
		String current_url = "https://dashboard-emps.g10.pw/organization/transport-manager/login";
	

	}

	@Test(priority = 3, description = "To Validate the functionalities of the login page when the user enters valid username and invalid password")
	@Description("Entering the valid username and Invalidpassword and the expected result is not to navigate into Dash board Page")
	public static void testCase3() {
		WebElement username_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='username']"));
		boolean displayed = username_field.isDisplayed();
		boolean enabled = username_field.isEnabled();

		logmessage("Username field is Displayed " + displayed);
		logmessage("username field is enabled  " + enabled);
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed2 = password_field.isDisplayed();
		boolean enabled2 = password_field.isEnabled();
		logmessage("password field is displayed " + displayed2);
		logmessage("password field is enabled " + enabled2);
		username_field.sendKeys("lingeaswaraan@promantus.com");
		logmessage("Entering the username as " + "lingeaswaraan@promantus.com");
		password_field.sendKeys("hello2");
		logmessage("Entering the password as " + "hello2");
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']/parent::button"));
		boolean displayed3 = login_button.isDisplayed();

		logmessage("Login button is Displayed " + displayed3);
		logmessage("Clicking on the login button");
		login_button.click();
		String current_url = "https://dashboard-emps.g10.pw/organization/transport-manager/login";
		
	}

	@Test(priority = 4, description = "To Validate the functionalities of the login page when the user enters Invalid username and valid password")
	@Description("Entering the Invalid username and valid password and the expected result is not to navigate into Dash board Page")
	public static void testCase4() {
		WebElement username_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='username']"));
		boolean displayed = username_field.isDisplayed();
		boolean enabled = username_field.isEnabled();

		logmessage("Username field is Displayed " + displayed);
		logmessage("username field is enabled  " + enabled);
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed2 = password_field.isDisplayed();
		boolean enabled2 = password_field.isEnabled();
		logmessage("password field is displayed " + displayed2);
		logmessage("password field is enabled " + enabled2);
		username_field.sendKeys("abc@gmail.com");
		logmessage("Entering the username as " + "abc@gmail.com");
		password_field.sendKeys("");
		logmessage("Entering the password as " + "");
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']/parent::button"));
		boolean displayed3 = login_button.isDisplayed();

		logmessage("Login button is Displayed " + displayed3);
		logmessage("Clicking on the login button");
		login_button.click();
		String current_url = "https://dashboard-emps.g10.pw/organization/transport-manager/login";
		
	}

	@Test(priority = 5, description = "To Validate the functionalities of the login page when the user enters Invalid username and valid password")
	@Description("Entering the Invalid username and Valid password and the expected result is not to navigate into Dash board Page")
	public static void testcase5() {
		WebElement username_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='username']"));
		boolean displayed = username_field.isDisplayed();
		boolean enabled = username_field.isEnabled();

		logmessage("Username field is Displayed " + displayed);
		logmessage("username field is enabled  " + enabled);
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed2 = password_field.isDisplayed();
		boolean enabled2 = password_field.isEnabled();
		logmessage("password field is displayed " + displayed2);
		logmessage("password field is enabled " + enabled2);
		username_field.sendKeys("abc@gmail.com");
		logmessage("Entering the username as " + "abc@gmail.com");
		password_field.sendKeys("lin@123");
		logmessage("Entering the password as " + "lin@123");
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']/parent::button"));
		boolean displayed3 = login_button.isDisplayed();

		logmessage("Login button is Displayed " + displayed3);
		logmessage("Clicking on the login button");
		login_button.click();
		String current_url = "https://dashboard-emps.g10.pw/organization/transport-manager/login";
		
	}

	@Test(priority = 6, description = "To Validate the functionalities of the login page when the user enters Invalid username and leaving the password field Blank")
	@Description("Entering the Invalid username and leaving the password field empty and the expected result is not to navigate into Dash board Page")
	public static void testCase6() {
		WebElement username_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='username']"));
		boolean displayed = username_field.isDisplayed();
		boolean enabled = username_field.isEnabled();

		logmessage("Username field is Displayed " + displayed);
		logmessage("username field is enabled  " + enabled);
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed2 = password_field.isDisplayed();
		boolean enabled2 = password_field.isEnabled();
		logmessage("password field is displayed " + displayed2);
		logmessage("password field is enabled " + enabled2);
		username_field.sendKeys("abc@gmail.com");
		logmessage("Entering the username as " + "abc@gmail.com");
		password_field.sendKeys("");
		logmessage("Entering the password as " + "");
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']/parent::button"));
		boolean displayed3 = login_button.isDisplayed();

		logmessage("Login button is Displayed " + displayed3);
		logmessage("Clicking on the login button");
		login_button.click();
		String current_url = "https://dashboard-emps.g10.pw/organization/transport-manager/login";
	
	}

	@Test(priority = 7, description = "To Validate the functionalities of the login page when the user enters both username and password fields Blank")
	@Description("Entering both username and password field empty and the expected result is not to navigate into Dash board Page")
	public static void testCase7() {
		WebElement username_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='username']"));
		boolean displayed = username_field.isDisplayed();
		boolean enabled = username_field.isEnabled();

		logmessage("Username field is Displayed " + displayed);
		logmessage("username field is enabled  " + enabled);
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed2 = password_field.isDisplayed();
		boolean enabled2 = password_field.isEnabled();
		logmessage("password field is displayed " + displayed2);
		logmessage("password field is enabled " + enabled2);
		username_field.sendKeys("");
		logmessage("Entering the username as " + "");
		password_field.sendKeys("");
		logmessage("Entering the password as " + "");
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']/parent::button"));
		boolean displayed3 = login_button.isDisplayed();

		logmessage("Login button is Displayed " + displayed3);
		logmessage("Clicking on the login button");
		login_button.click();
		String current_url = "https://dashboard-emps.g10.pw/organization/transport-manager/login";
		
	}

	@Test(priority = 8, description = "To Validate the functionalities of the login page when the user Clicking on the forgot password option")
	@Description("Clicking on the forgot password option on the Transport Manager Login Page and the expected result is forgot password reset pop up must display.")
	public static void testCase8() {
		WebElement forgot_password = driver.findElement(By.xpath("//a[text()='Forgot Password?']/parent::p"));
		boolean displayed = forgot_password.isDisplayed();
		logmessage("forgot Password option is Displayed " + displayed);
		boolean enabled = forgot_password.isEnabled();
		logmessage("forgot password option is enabled " + enabled);
		logmessage("Clicking on the forgot password option");
		forgot_password.click();
		WebElement email_input = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		boolean displayed2 = email_input.isDisplayed();
		boolean enabled2 = email_input.isEnabled();

		logmessage("password reset pop up is enabled " + enabled2);

	}

	@Test(priority = 9, description = "To Validate the functionalities of the Show password functionality of the transport  Manager login page ")
	@Description("Clicking on the show password option and the expected result is to able to view the password that the user have entered")
	public static void testCase9() {
		WebElement password_field = driver
				.findElement(By.xpath("//div[@class='input-group ']/child::input[@name='password']"));
		boolean displayed = password_field.isDisplayed();
		boolean enabled = password_field.isEnabled();
		logmessage("password field is displayed " + displayed);
		logmessage("Password field is enabled " + enabled);
		password_field.sendKeys("lin@123");
		logmessage("the password entered is " + "lin@123");
		WebElement show_password = driver.findElement(By.xpath("//i[@mattooltip='Show Password']"));
		boolean displayed2 = show_password.isDisplayed();
		boolean enabled2 = show_password.isEnabled();
		logmessage("Show password is displayed " + displayed2);
		logmessage("Show password is enabled " + enabled2);
		show_password.click();
		logmessage("clicking on the show password option");
		screenshotCapture(driver);

	}

	@Attachment(value = "screenshots", type = "image/png")
	public static byte[] screenshotCapture(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@AfterMethod()
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
