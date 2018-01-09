package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import com.AP.pages.AP_HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	public static WebDriver driver;
	
	
	@Given("^Application is open in Chrome browser$")
	public void Application_is_open_in_Chrome_browser() throws Throwable {
				
			System.setProperty("webdriver.chrome.driver", "F:/Selenium/chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		
	}

	@When("^User tries to login using valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void User_tries_to_login_using_valid_Username_and_Password(String uname, String pass) throws Throwable {
		AP_HomePage homepage=new AP_HomePage(driver);
		homepage.funLogin(uname,pass);
	}

	@Then("^Login to application should be successfull$")
	public void Login_to_application_should_be_successfull() throws Throwable {
	   
		String PageTitle=driver.getTitle();
		Assert.assertTrue(PageTitle.contains("account"));
		
		driver.quit();
	}

	@When("^User tries to login using invalid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void User_tries_to_login_using_invalid_and(String uname, String pass) throws Throwable {
		AP_HomePage homepage=new AP_HomePage(driver);
		homepage.funLogin(uname,pass);
	}
	
	@Then("^Login to application should not be successfull$")
	public void Login_to_application_should_not_be_successfull() throws Throwable {
		String PageTitle=driver.getTitle();
		Assert.assertTrue(PageTitle.contains("Login"));
		driver.quit();
	}
	
}
