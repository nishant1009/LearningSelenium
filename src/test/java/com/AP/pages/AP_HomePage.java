package com.AP.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AP_HomePage {

	public AP_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='login']")
	public WebElement Signin;
	
	@FindBy(how=How.XPATH,using=".//*[@id='email']")
	public WebElement Email;
	
	@FindBy(how=How.XPATH,using=".//*[@id='passwd']")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using=".//*[@id='SubmitLogin']")
	public WebElement btnSubmit;
	
	@FindBy(how=How.XPATH,using=".//*[@id='search_query_top']")
	public WebElement Searchbox;
	
	@FindBy(how=How.XPATH,using=".//*[@id='searchbox']/button")
	public WebElement Searchboxbutton;
	
	@FindBy(how=How.XPATH,using="//a[@title='Blouse']")
	public WebElement Item;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wishlist_button']")
	public WebElement WishListbutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='search']/div[2]/div/div/a")
	public WebElement Wishlistpopupclosebutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='add_to_cart']/button")
	public WebElement AddtoCartButton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='layer_cart']/div[1]/div[1]/h2")
	public WebElement AddtoCartMessage;
	
	@FindBy(how=How.XPATH,using=".//*[@id='layer_cart']/div[1]/div[2]/div[1]/span")
	public WebElement ItemCost;
	
	@FindBy(how=How.XPATH,using=".//*[@id='layer_cart']/div[1]/div[2]/div[2]/span")
	public WebElement ItemShippingCost;
	
	@FindBy(how=How.XPATH,using=".//*[@id='layer_cart']/div[1]/div[2]/div[3]/span")
	public WebElement ItemTotalCost;
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	public WebElement ProceedToCheckoutbutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/p[2]/a[1]/span")
	public WebElement Sum_ProceedToCheckoutbutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/form/p/button")
	public WebElement Address_ProceedToCheckoutbutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='cgv']")
	public WebElement TermsofService;
	
	@FindBy(how=How.XPATH,using=".//*[@id='form']/p/button")
	public WebElement Shipping_ProceedToCheckoutbutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	public WebElement PaymentMethod_Bankwire;
	
	@FindBy(how=How.XPATH,using=".//*[@id='cart_navigation']/button")
	public WebElement ConfirmPaymentbutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div/p/strong")
	public WebElement OrderConfirmation;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/p/a")
	public WebElement BacktoOrder;
	
	
	
	
	
	public void funLogin(String Username,String Pas)
	{
		Signin.click();
		Email.sendKeys(Username);
		Password.sendKeys(Pas);
		btnSubmit.click();
		
	}
	
}
