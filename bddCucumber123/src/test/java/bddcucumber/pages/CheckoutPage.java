package bddcucumber.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage
{
	@FindBy(id="billing_first_name") private WebElement billingFirstNameFld;
	@FindBy(id="billing_last_name") private WebElement billingLastNameFld;
	@FindBy(id="billing_address_1") private WebElement billingAddressOneFld;
	@FindBy(id="billing_city") private WebElement billingCityFld;
	@FindBy(id="billing_state") private WebElement billingStateDropDown;
	@FindBy(id="billing_postcode") private WebElement billingZipFld;
	@FindBy(xpath="//input[@type=\"email\"]") private WebElement billingEmailFld;
	@FindBy(xpath="//button[@name=\"woocommerce_checkout_place_order\"]") private WebElement placeOrderBtn;
	@FindBy(css=".woocommerce-notice") private WebElement noticeTxt;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CheckoutPage enterBillingFirstName(String billingFirstName)
	{
		WebElement e= wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
		e.clear();
		e.sendKeys(billingFirstName);
		return this;
	}
	
	public CheckoutPage enterBillingLastName(String billingLastName)
	{
		WebElement e= wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
		e.clear();
		e.sendKeys(billingLastName);
		return this;
	}
	
	public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne)
	{
		WebElement e= wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
		e.clear();
		e.sendKeys(billingAddressLineOne);
		return this;
	}
	
	public CheckoutPage enterBillingCity(String billingCity)
	{
		WebElement e= wait.until(ExpectedConditions.visibilityOf(billingCityFld));
		e.clear();
		e.sendKeys(billingCity);
		return this;
	}
	
	public CheckoutPage enterBillingState(String billingStateName)
	{
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
		select.selectByVisibleText(billingStateName);
		return this;
	}
	

	public CheckoutPage enterBillingZip(String billingZip)
	{
		WebElement e= wait.until(ExpectedConditions.visibilityOf(billingZipFld));
		e.clear();
		e.sendKeys(billingZip);
		return this;
	}
	
	public CheckoutPage enterBillingEmail(String billingEmail)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		WebElement e= wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
		e.clear();
		e.sendKeys(billingEmail);
		return this;
	}
	
	public CheckoutPage setBillingDetails(String billingFirstName, String billingLastName, String billingAddressOne, String billingCity, String billingStateName, String billingZip, String billingEmail)
	{
		return enterBillingFirstName(billingFirstName).enterBillingLastName(billingLastName).enterBillingAddressLineOne(billingAddressOne).enterBillingCity(billingCity).enterBillingState(billingStateName).enterBillingZip(billingZip).enterBillingEmail(billingEmail);
		
	}
	
	public CheckoutPage placeOrder()
	{
		wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
		return this;
	}
	
	public String getNotice() throws InterruptedException
	{
		Thread.sleep(6000);
		
		return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
	}
	

}
