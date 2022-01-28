package bddcucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage
{ 

	@FindBy(xpath="//td[@class=\"product-name\"]") private WebElement productNameFld;
	@FindBy(xpath="//input[@type=\"number\"]")private WebElement productQuantityFld;
	@FindBy(xpath="//a[@class=\"checkout-button button alt wc-forward\"]") private WebElement proceedToCheckoutBtn;
	
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getProductName()
	{
		System.out.println(productNameFld.getText());
		return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
		
	}
	
	public int getProductQuantity()
	{
		return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityFld)).getAttribute("value"));
				
	}
	
	public void checkout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
	}

}
