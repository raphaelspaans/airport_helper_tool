package Airport_Helper;

import java.util.ArrayList;
public class Scenario {
	
	public static void main(String[] args)
	{
		
		Passenger activeUser = new Passenger(); 
		
	    Airport Schiphol = new Airport("Schiphol", "Amsterdam", "AMS");  
	    Airport Tegel = new Airport("Tegel", "Berlin", "TXL");          
	    Airport Fiumicino  = new Airport("Fiumicino ", "Rome", "FCO");  
	    Airport ElPrat = new Airport("El Prat", "Barcelona", "BCN");  
	    Airport CharlesdeGaulle = new Airport("Charles de Gaulle", "Paris", "CDG");
		
		Terminal AMS1 = new Terminal(Schiphol.name, Schiphol.location, Schiphol.shortcut, "1");
		Terminal AMS2 = new Terminal(Schiphol.name, Schiphol.location, Schiphol.shortcut, "2");
		Terminal TXL5 = new Terminal(Tegel.name, Tegel.location, Tegel.shortcut, "5");
		Terminal TXL3 = new Terminal(Tegel.name, Tegel.location, Tegel.shortcut, "3");
		Terminal FCO2 = new Terminal(Fiumicino.name, Fiumicino.location, Fiumicino.shortcut, "2");
		Terminal FCO4 = new Terminal(Fiumicino.name, Fiumicino.location, Fiumicino.shortcut, "4");
		Terminal CDG1 = new Terminal(CharlesdeGaulle.name, CharlesdeGaulle.location, CharlesdeGaulle.shortcut, "1");
		Terminal CDG3 = new Terminal(CharlesdeGaulle.name, CharlesdeGaulle.location, CharlesdeGaulle.shortcut, "3");
		Terminal BCN2 = new Terminal(ElPrat.name, ElPrat.location, ElPrat.shortcut, "2");
		Terminal BCN6 = new Terminal(ElPrat.name, ElPrat.location, ElPrat.shortcut, "6");
		
		ArrayList<Flight> ArrayFlight = new ArrayList<Flight>();

		
	    ArrayFlight.add(new Flight(
    			"KL1821",
				"KLM",
				new String[]{"1-4", "8-4", "15-4", "23-4", "30-4", "7-5", "14-5", "21-5", "28-5", "4-6", "11-6", "18-6", "25-6"},
				Flight.generateUpdates(),
				"09:25",
				"10:45",
				Schiphol.shortcut,
				Tegel.shortcut,
				AMS1.number
				));
	    
	    ArrayFlight.add(new Flight(
				"KL605",
				"KLM",
				new String[]{"1-4", "8-4", "15-4", "23-4", "30-4", "7-5", "14-5", "21-5", "28-5", "4-6", "11-6", "18-6", "25-6"},
				Flight.generateUpdates(),
				"09:25",
				"10:45",
				Schiphol.shortcut,
				Fiumicino.shortcut,
				AMS2.number	
			));
	    
	    ArrayFlight.add(new Flight(
				"LU181",
				"Lufthansa",
				new String[]{"1-4", "8-4", "15-4", "23-4", "30-4", "7-5", "14-5", "21-5", "28-5", "4-6", "11-6", "18-6", "25-6"},
				Flight.generateUpdates(),
				"09:25",
				"10:45",
				Tegel.shortcut,
				Schiphol.shortcut,
				TXL5.number
			));
	    
	    ArrayFlight.add(new Flight(
				"LU6449",
				"Lufthansa",
				new String[]{"3-4", "9-4", "20-4", "23-4", "29-4", "10-5", "16-5", "27-5", "28-5", "4-7", "11-8", "18-9", "25-12"},
				Flight.generateUpdates(),
				"18:50",
				"21:05",
				Tegel.shortcut,
				Fiumicino.shortcut,
				TXL3.number
				));

		ArrayFlight.add(new Flight(
				"VA606",
				"Virgin",
				new String[]{"1-3", "8-2", "15-3", "23-4", "29-4", "8-5", "29-5", "21-6", "29-7", "4-8", "26-9", "14-10", "31-12"},
				Flight.generateUpdates(),
				"14:45",
				"17:00",
				Fiumicino.shortcut,
				Schiphol.shortcut,
				FCO2.number
				));

		ArrayFlight.add(new Flight(
				"VA42",
				"Virgin",
				new String[]{"1-3", "8-2", "15-3", "23-4", "29-4", "8-5", "29-5", "21-6", "29-7", "4-8", "26-9", "14-10", "31-12"},
				Flight.generateUpdates(),
				"21:05",
				"22:15",
				Fiumicino.shortcut,
				ElPrat.shortcut,
				FCO4.number
				));
		
		ArrayFlight.add(new Flight(
				"AF1434",
				"AirFrance",
				new String[]{"5-1", "26-1", "15-2", "23-4", "1-4", "7-4", "28-5", "21-6", "29-6", "8-7", "11-7", "18-10", "12-12"},
				Flight.generateUpdates(),
				"7:30",
				"9:10",
				CharlesdeGaulle.shortcut,
				Tegel.shortcut,
				CDG1.number
				));
		
		ArrayFlight.add(new Flight(
				"AF3884",
				"AirFrance",
				new String[]{"5-1", "26-1", "15-2", "23-4", "1-4", "7-4", "28-5", "21-6", "29-6", "8-7", "11-7", "18-10", "12-12"},
				Flight.generateUpdates(),
				"13:50",
				"15:25",
				CharlesdeGaulle.shortcut,
				ElPrat.shortcut,
				CDG3.number
				));
		
		ArrayFlight.add(new Flight(
				"AF3831",
				"AirFrance",
				new String[]{"5-1", "26-1", "15-2", "23-4", "1-4", "7-4", "28-5", "21-6", "29-6", "8-7", "11-7", "18-10", "12-12"},
				Flight.generateUpdates(),
				"12:40",
				"14:00",
				ElPrat.shortcut,
				CharlesdeGaulle.shortcut,
				BCN2.number
				));
		
		ArrayFlight.add(new Flight(
				"E71",
				"Emirates",
				new String[]{"1-1", "2-1", "13-3", "24-4", "31-4", "8-5", "28-5", "21-6", "28-11", "10-11", "11-12", "18-12", "25-12"},
				Flight.generateUpdates(),
				"11:30",
				"13:35",
				ElPrat.shortcut,
				Schiphol.shortcut,
				BCN6.number
				));
		
		ArrayList<DutyFreeStore> ArrayStore = new ArrayList<DutyFreeStore>();
		ArrayStore.add(new DutyFreeStore(Schiphol.location, Schiphol.shortcut, "SeeBuyFly", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(Schiphol.location, Schiphol.shortcut, "Suit Supply", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(Tegel.location, Tegel.shortcut, "Heinemann Duty Free", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(Tegel.location, Tegel.shortcut, "Capi – The Travellers Electronics Company", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(Fiumicino.location, Fiumicino.shortcut, "Ferrari Souvenirs", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(Fiumicino.location, Fiumicino.shortcut, "Esprit", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(ElPrat.location, ElPrat.shortcut, "Drug Store", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(ElPrat.location, ElPrat.shortcut, "Burberry", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(CharlesdeGaulle.location, CharlesdeGaulle.shortcut, "ICI Paris", DutyFreeStore.discountDutyFreeStore()));
		ArrayStore.add(new DutyFreeStore(CharlesdeGaulle.location, CharlesdeGaulle.shortcut, "Prada", DutyFreeStore.discountDutyFreeStore())); 
		
		ArrayList<Restaurant> ArrayRestaurant = new ArrayList<Restaurant>();
		ArrayRestaurant.add(new Restaurant (Schiphol.shortcut, AMS1.number, "Java Burger", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (Schiphol.shortcut, AMS1.number, "KFC", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (Schiphol.shortcut, AMS1.number, "CityWok", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (Schiphol.shortcut, AMS1.number, "Julia's", "ITALIAN"));
		ArrayRestaurant.add(new Restaurant (Schiphol.shortcut, AMS2.number, "KFC", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (Schiphol.shortcut, AMS2.number, "Pasta di Pesto", "ITALIAN"));
		ArrayRestaurant.add(new Restaurant (Schiphol.shortcut, AMS2.number, "Bar du Fromage", "FRENCH"));
		ArrayRestaurant.add(new Restaurant (Tegel.shortcut, TXL3.number, "Wendy's", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (Tegel.shortcut, TXL3.number, "Si Bueno", "ITALIAN"));
		ArrayRestaurant.add(new Restaurant (Tegel.shortcut, TXL3.number, "Wok This Away", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (Tegel.shortcut, TXL5.number, "MacDonalds", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (Tegel.shortcut, TXL5.number, "Thai Tanic", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (Tegel.shortcut, TXL5.number, "Moulin Rouge", "FRENCH"));
		ArrayRestaurant.add(new Restaurant (Tegel.shortcut, TXL5.number, "Escargots Show", "FRENCH"));
		ArrayRestaurant.add(new Restaurant (Fiumicino.shortcut, FCO2.number, "Thai-Me-Up", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (Fiumicino.shortcut, FCO2.number, "Pizza di Roy", "ITALIAN"));
		ArrayRestaurant.add(new Restaurant (Fiumicino.shortcut, FCO2.number, "MacDonalds", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (Fiumicino.shortcut, FCO4.number, "MacDonalds", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (Fiumicino.shortcut, FCO4.number, "Vino", "FRENCH"));
		ArrayRestaurant.add(new Restaurant (Fiumicino.shortcut, FCO4.number, "Warung Java", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (ElPrat.shortcut, BCN2.number, "MacDonalds", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (ElPrat.shortcut, BCN2.number, "KFC", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (ElPrat.shortcut, BCN2.number, "Cafe Olive", "ITALIAN"));
		ArrayRestaurant.add(new Restaurant (ElPrat.shortcut, BCN2.number, "Cafe Camembert", "FRENCH"));
		ArrayRestaurant.add(new Restaurant (ElPrat.shortcut, BCN6.number, "Fat Fred", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (ElPrat.shortcut, BCN6.number, "Yin Yan", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (ElPrat.shortcut, BCN6.number, "Vesuvius", "ITALIAN"));
		ArrayRestaurant.add(new Restaurant (CharlesdeGaulle.shortcut, CDG1.number, "Voila Java", "FRENCH"));
		ArrayRestaurant.add(new Restaurant (CharlesdeGaulle.shortcut, CDG1.number, "Burger King", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (CharlesdeGaulle.shortcut, CDG1.number, "China Town", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (CharlesdeGaulle.shortcut, CDG1.number, "MacDonalds", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (CharlesdeGaulle.shortcut, CDG3.number, "Trump's Burgers", "AMERICAN"));
		ArrayRestaurant.add(new Restaurant (CharlesdeGaulle.shortcut, CDG3.number, "Noodle Doodle", "ASIAN"));
		ArrayRestaurant.add(new Restaurant (CharlesdeGaulle.shortcut, CDG3.number, "Tour du Jour", "FRENCH"));
		
		Passenger.printWelcomeMessage();			

		do
		{	
		String answer = activeUser.beforeLoginMenu();

			if (answer.equals("1"))
			{
				activeUser = activeUser.loginMenu();
				System.out.println(activeUser.username);
				System.out.println(activeUser.password);
				System.out.println(activeUser.firstName);
				System.out.println(activeUser.surName);
				System.out.println(activeUser.safetyQuestion);
				System.out.println(activeUser.answer);
				break;
			}
			else if (answer.equals("2"))
			{
				Passenger.passwordRetrieval();
			}
			else if (answer.equals("3"))
			{
				activeUser = activeUser.createAccount();
				System.out.println(activeUser.username);
				System.out.println(activeUser.password);
				System.out.println(activeUser.firstName);
				System.out.println(activeUser.surName);
				System.out.println(activeUser.safetyQuestion);
				System.out.println(activeUser.answer);
			}
		}
		while(true);
		
		activeUser.afterLoginMenu(activeUser, ArrayFlight, ArrayRestaurant, ArrayStore); 
	
	} 
}




