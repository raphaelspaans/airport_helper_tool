package Airport_Helper;

public class Restaurant {

	public String shortcut;
	public String terminalNumber;
	public String name;
	public String cuisine;
	
	Restaurant(String restaurantShortcut, String restaurantTerminalNumber, String restaurantName, String restaurantCuisine)
	{ 
		
			shortcut = restaurantShortcut;
			terminalNumber = restaurantTerminalNumber;
			name = restaurantName;
			cuisine = restaurantCuisine;
	}
	
	Restaurant()
	{
		
	}
}