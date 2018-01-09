package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.AP.pages.AP_HomePage;
import com.AP.pages.AP_MyAccountPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyAccount {
	
	public static WebDriver driver;
	
	@Given("^User is logged in Applicaon$")
	public void user_is_logged_in_Applicaon() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "F:/Selenium/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		AP_HomePage homepage=new AP_HomePage(driver);
		homepage.funLogin("testuser51@test.com","password");
	}

	@When("^User navigates to My Accounts Order details tab$")
	public void user_navigates_to_My_Accounts_Order_details_tab() throws Throwable {
	   
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		accountpage.NavigatetoOrderHistory();
		
				
	}

	@Then("^User should see placed order details$")
	public void user_should_see_placed_order_details() throws Throwable {
		
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		//String message=accountpage.InformationMessage.getText();
		//Assert.assertTrue(message.contains("You have not placed any orders."));
		driver.quit();
		
}
	
	@When("^User tries to navigate to My Account Address tab$")
	public void user_tries_to_navigate_to_My_Account_Address_tab() throws Throwable {
		
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.MyAddresstab);
		accountpage.MyAddresstab.click();
	    
	}

	@Then("^Added address should be shown correctly$")
	public void added_address_should_be_shown_correctly() throws Throwable {
		
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.AddedAddess);
		String address=accountpage.AddedAddess.getText();
		Assert.assertTrue(address.contains("Wisconsin"));
		driver.quit();
		
	   
	}
	
	@Given("^Users address exists$")
	public void users_address_exists() throws Throwable {
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.MyAddresstab);
		accountpage.MyAddresstab.click();
		String AddressHeading=accountpage.AddressLabel.getText();
		//System.out.println(AddressHeading);
		Assert.assertTrue(AddressHeading.contains("MY ADDRESS"));
	    
	}

	@When("^User tries to update the existing address$")
	public void user_tries_to_update_the_existing_address() throws Throwable {
		
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.AddressUpdateButton);
		accountpage.AddressUpdateButton.click();
		accountpage.FirstName.clear();
		accountpage.FirstName.sendKeys("Testa");
		//JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.AddressSavebutton);
		accountpage.AddressSavebutton.click();
		
	}

	@Then("^address should be updated successfully$")
	public void address_should_be_updated_successfully() throws Throwable {
		
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.displayedfirstname);
		String viewfirstname=accountpage.displayedfirstname.getText();
		//System.out.println(viewfirstname);
		Assert.assertTrue(viewfirstname.contains("Testa"));
		driver.quit();
	   
	}
	
	@When("^User adds a item to his whishlist$")
	public void user_adds_a_item_to_his_whishlist() throws Throwable {
	    
		AP_HomePage HomePage=new AP_HomePage(driver);
		HomePage.Searchbox.sendKeys("Blouse");
		HomePage.Searchboxbutton.click();
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", HomePage.Item);
		HomePage.Item.click();
		driver.switchTo().frame(0);
		
		HomePage.WishListbutton.click();
		//driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		HomePage.Wishlistpopupclosebutton.click();
		//driver.switchTo().defaultContent();
		
		
		
	}

	@Then("^item should be added to his wishlist successfully$")
	public void item_should_be_added_to_his_wishlist_successfully() throws Throwable {
		AP_MyAccountPage accountpage=new AP_MyAccountPage(driver);
		String URL=driver.getCurrentUrl();
		driver.get(URL);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.MyaccountIcon);
		accountpage.MyaccountIcon.click();
		//accountpage.MyWishlist.click();
		//JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", accountpage.myaddedwishlist);
		String wishlisttext=accountpage.myaddedwishlist.getText();
		Assert.assertTrue(wishlisttext.contains("My wishlist"));
		accountpage.WishListDelete.click();
		Thread.sleep(3000);
		
		Alert ALT=driver.switchTo().alert();
		ALT.accept();
		driver.quit();
	  
	}
	


}
