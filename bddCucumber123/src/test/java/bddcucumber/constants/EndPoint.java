package bddcucumber.constants;

public enum EndPoint
{
	STORE("/store"),
	ACCOUNT("/account"), 
	ADD_TO_CART("/?wc-ajax=add_to_cart");
	
	public final String url;
	
	EndPoint(String url)
	{
		this.url = url;
		
		
	}
	

}
