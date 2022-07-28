package emps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "/home/promantus/eclipse-workspace/Allurereports/exe/geckodriver");
	WebDriver driver = new FirefoxDriver();
	driver.get("");
	

}
}
