package com.AP.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class AP_MyAccountPage {
	
	public AP_MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
	public WebElement tabOrderandHistoryDetails;
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='block-history']/p")
	public WebElement InformationMessage;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/ul/li[1]/a/span")
	public WebElement BackButton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div/div[1]/ul/li[3]/a/span")
	public WebElement MyAddresstab;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div[1]/div/div/ul/li[5]/span[2]")
	public WebElement AddedAddess;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div[1]/div/div/ul/li[1]/h3")
	public WebElement AddressLabel;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div[1]/div/div/ul/li[9]/a[1]/span")
	public WebElement AddressUpdateButton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='firstname']")
	public WebElement FirstName;
	
	@FindBy(how=How.XPATH,using=".//*[@id='submitAddress']")
	public WebElement AddressSavebutton;
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div[1]/div/div/ul/li[2]/span[1]")
	public WebElement displayedfirstname;
	
	@FindBy(how=How.XPATH,using=".//*[@id='left_column']/div[4]/div/ul/li[5]/a/span")
	public WebElement MyaccountIcon;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'My wishlists')]")
	public WebElement MyWishlist;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'My wishlist')]")
	public WebElement myaddedwishlist;
	
	@FindBy(how=How.XPATH,using="//td[@class='wishlist_delete']/a[@class='icon']")
	public WebElement WishListDelete;
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='order-list']/tbody/tr/td[3]")
	public WebElement OrderTotalPrice;
	
	
	
	
	
	public void NavigatetoOrderHistory()
	{
		tabOrderandHistoryDetails.click();
		
	}
	
	public void verifyaddressupdate()
	{
		
		
		
	}
	
	

	
	
}
