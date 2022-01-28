package bddcucumber.context;

import org.openqa.selenium.WebDriver;
import bddcucumber.domainobjects.*;

public class TestContext 
{
	public WebDriver driver;
	public Cookies cookies;
	
	public TestContext()
	{
		cookies = new Cookies();
		cookies.setCookies(new io.restassured.http.Cookies());
	}

}
