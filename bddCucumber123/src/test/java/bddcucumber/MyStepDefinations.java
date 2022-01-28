package bddcucumber;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.xml.bind.CycleRecoverable.Context;

import bddcucumber.apis.CartApi;
import bddcucumber.constants.EndPoint;
import bddcucumber.constants.MyConstants;
import bddcucumber.context.TestContext;
import bddcucumber.domainobjects.Product;
import bddcucumber.factory.DriverFactory;
import bddcucumber.pages.CartPage;
import bddcucumber.pages.CheckoutPage;
import bddcucumber.pages.StorePage;
import bddcucumber.utils.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.EndOfDataDecoderException;
import junit.framework.Assert;

public class MyStepDefinations 

{
	private WebDriver driver;
	private TestContext context;

@Given("I'm on the Store Page")
public void i_m_on_the_store_page() 
{
	driver=DriverFactory.getDriver();

	new StorePage(driver).load(EndPoint.STORE.url);
}

@When("I add a {product} to the cart")
public void i_add_a_to_the_cart(Product product) throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)", "");
	new StorePage(driver).addToCart(product.getName());    
}

@Then("I should see {int} {product} in the cart")
public void i_should_see_in_the_cart(int quantity, Product product) throws InterruptedException
{
	
	CartPage cartpage = new CartPage(driver);
	Thread.sleep(300);
  
   Assert.assertEquals(product.getName(), cartpage.getProductName());
   Assert.assertEquals(quantity, cartpage.getProductQuantity());
}


@Given("I'm a guest customer")
public void i_m_a_guest_customer() 
{
	driver=DriverFactory.getDriver();
	
	new StorePage(driver).load(MyConstants.STORE);
   
}

@Given("I have a product in the cart")
public void i_have_a_product_in_the_cart() throws InterruptedException
{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)", "");
	
	new StorePage(driver).addToCart("Blue Shoes");
	//CartApi cartApi=new CartApi(context.cookies.getCookies());
    //cartApi.addToCart(1215,1);
	//context.cookies.setCookies(cartApi.getCookies());
	//context.cookies.injectCookiesToBrowser(context.driver);
	
			
  
}

@Given("I'm on the Checkout page")
public void i_m_on_the_checkout_page() throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,600)", "");
	new CartPage(driver).checkout();
}

@When("I provide billing details")
public void i_provide_billing_details(List<Map<String,String>> billingDetails) throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,600)", "");
	CheckoutPage checkoutPage =new CheckoutPage(driver);
	checkoutPage.setBillingDetails(billingDetails.get(0).get("firstname"),billingDetails.get(0).get("lastname"),billingDetails.get(0).get("address_line1"),billingDetails.get(0).get("city"),billingDetails.get(0).get("state"),billingDetails.get(0).get("zip"),billingDetails.get(0).get("email"));
	
}

@When("I place an order")
public void i_place_an_order() 
{
	new CheckoutPage(driver).placeOrder();
}

@Then("the order should be placed succesfully")
public void the_order_should_be_placed_succesfully() throws InterruptedException {
	
	

    Assert.assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).getNotice());
}


}
