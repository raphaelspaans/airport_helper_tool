package Airport_Helper;

public class Airport {
	 
    public String name;
    public String location;
    public String shortcut; // the shortcut code for an airport. e.g. AMS for amsterdam
       // the area where passengers can check in for their flights. Needs to be connected to flight.
       // the program must calculate the amount of passengers - per airport.
   
    Airport (String Airportname, String AirportLocation, String AirportShortCut)
    {
        name = Airportname;
        location = AirportLocation;
        shortcut = AirportShortCut;
    }

   Airport ()
   {
	   
   }
      
}