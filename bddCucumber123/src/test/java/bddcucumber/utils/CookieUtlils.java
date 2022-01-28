package bddcucumber.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Cookie;

import io.restassured.http.Cookies;

public class CookieUtlils
{
	public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies)
	{
		List<io.restassured.http.Cookie> restAssuredCookies;
		restAssuredCookies=cookies.asList();
		List<Cookie>seleniumCookies=new ArrayList<>();
		for(io.restassured.http.Cookie cookie: restAssuredCookies)
		{
			seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),cookie.getPath(),cookie.getExpiryDate(),cookie.isSecured(),cookie.isHttpOnly(),cookie.getSameSite()));
		}
		return seleniumCookies;
	
	}

}
