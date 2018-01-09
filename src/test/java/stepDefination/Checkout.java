package stepDefination;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.AP.pages.AP_HomePage;
import com.AP.pages.AP_MyAccountPage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Checkout {
	
	public static WebDriver driver;
	
	List<String> ItemCostDetails=new ArrayList<String>();
	
	@Given("^User is logged in Application$")
	public void user_is_logged_in_Application() throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver", "F:/Selenium/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		AP_HomePage homepage=new AP_HomePage(driver);
		homepage.funLogin("testuser51@test.com","password");
	}
	
	
	
	
	
	@When("^User adds a product in basket$")
	public void user_adds_a_product_in_basket() throws Throwable {
		
		AP_HomePage HomePage= new AP_HomePage(driver);
		HomePage.Searchbox.sendKeys("Blouse");
		HomePage.Searchboxbutton.click();
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", HomePage.Item);
		HomePage.Item.click();
		driver.switchTo().frame(0);
		HomePage.AddtoCartButton.click();
//		Alert ALT=driver.switchTo().alert();
//		ALT.accept();
		Thread.sleep(3000);
		//String Cartmessage=HomePage.AddtoCartMessage.getText();
		//String Productcost=HomePage.ItemCost.getText();
		//ItemCostDetails.add(Productcost.replace("$", ""));
		//String ProductShippingCost=HomePage.ItemShippingCost.getText();
		//ItemCostDetails.add(ProductShippingCost.replace("$", ""));
		//String ProductTotalCost=HomePage.ItemTotalCost.getText();
		//ItemCostDetails.add(ProductTotalCost.replace("$", ""));
		
		//Assert.assertTrue(Cartmessage.contains("Product successfully added to your shopping cart"));
	    
	}

	@When("^initiates the checkout process using bankwire payment method$")
	public void initiates_the_checkout_process_using_bankwire_payment_method() throws Throwable {
		
		AP_HomePage homepage=new AP_HomePage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		//je.executeScript("arguments[0].scrollIntoView(true);", homepage.ProceedToCheckoutbutton);
		//driver.switchTo().frame(0);
		//driver.switchTo().w+
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium")).click();
		homepage.ProceedToCheckoutbutton.click();
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.Sum_ProceedToCheckoutbutton);
		homepage.Sum_ProceedToCheckoutbutton.click();
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.Address_ProceedToCheckoutbutton);
		homepage.Address_ProceedToCheckoutbutton.click();
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.TermsofService);
		homepage.TermsofService.click();
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.Shipping_ProceedToCheckoutbutton);
		homepage.Shipping_ProceedToCheckoutbutton.click();
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.PaymentMethod_Bankwire);
		homepage.PaymentMethod_Bankwire.click();
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.ConfirmPaymentbutton);
		homepage.ConfirmPaymentbutton.click();
	    
	}

	@Then("^Order should be placed sucessfully$")
	public void order_should_be_placed_sucessfully() throws Throwable {
		AP_HomePage homepage=new AP_HomePage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.OrderConfirmation);
		String Ordersuccessmessage=homepage.OrderConfirmation.getText();
		Assert.assertTrue(Ordersuccessmessage.contains("Your order on My Store is complete."));
	   
	}

	@Then("^placed order should be visible in My accounts Orders details tab$")
	public void placed_order_should_be_visible_in_My_accounts_Orders_details_tab() throws Throwable {
		
		AP_HomePage homepage=new AP_HomePage(driver);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", homepage.BacktoOrder);
		homepage.BacktoOrder.click();
		
		AP_MyAccountPage myaccountpage=new AP_MyAccountPage(driver);
		je.executeScript("arguments[0].scrollIntoView(true);", myaccountpage.OrderTotalPrice);
		String Totalprice=myaccountpage.OrderTotalPrice.getText();
		Totalprice=Totalprice.replace("$", "");
		String Actualprice=ItemCostDetails.get(2);
		Assert.assertSame(Totalprice, Actualprice);
		driver.quit();    
	}


}
