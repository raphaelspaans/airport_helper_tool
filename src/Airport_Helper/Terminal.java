package Airport_Helper;

public class Terminal extends Airport {

	public String number;

	Terminal(String name, String location, String shortcut, String terminalNumber)
	{
        super(name, location, shortcut);
		number = terminalNumber;
	}
	
	Terminal()
	{
		
	}
}
