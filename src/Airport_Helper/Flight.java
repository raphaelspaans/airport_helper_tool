package Airport_Helper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Flight {

	public String number;
	public String airlineCode;
	public String[] date = new String[365]; 
	public int[] update = new int[365];
	public String deptTime;
	public String arTime;
	public String deptAirport;
	public String arAirport;
	public String deptTerminal;
	static Scanner userInput = new Scanner(System.in);

	// Constructor
	Flight(String flightNumber, String flightAirlineCode, String[] flightDate, int[] flightUpdate, String flightDeptTime, String flightArTime, String flightDeptAirport, String flightArAirport, String flightDeptTerminal)
	{
		number = flightNumber;
		airlineCode = flightAirlineCode;
		date = flightDate;
		update = flightUpdate;
		deptTime = flightDeptTime;
		arTime = flightArTime;
		deptAirport = flightDeptAirport;
		arAirport = flightArAirport;
		deptTerminal = flightDeptTerminal;
	}


   	public static int[] generateUpdates()
   	{
   		int randomUpdate = 0;
   		int[] flightUpdates = new int[365];
   		for (int i = 0; i < 365; i++)
   		{
   			randomUpdate = (int) (Math.random() * 1000 + 1);
   			if (randomUpdate > 985)  	
   			{
   				flightUpdates[i] = 150;
   			}
   			else if (randomUpdate > 950)
   			{
   				flightUpdates[i] = 90;
   			}
   			else if (randomUpdate > 850)  	
   			{
   				flightUpdates[i] = 60;
   			}
   			else if (randomUpdate > 700)  	
   			{
   				flightUpdates[i] = 30;
   			}
   			else if (randomUpdate > 500)  	
   			{
   				flightUpdates[i] = 15;
   			}
   		}
   		return flightUpdates;
   	}
   	
	
	// Method die vraagt hoeveel nieuwe "flight" objects er moeten worden gemaakt
	public static void amountNewFlights() 
	{
		int userChoice;
		System.out.println("How many new flights do you want to save in the system?");
		if (userInput.hasNextInt())
		{
			userChoice = Integer.parseInt(userInput.nextLine());
			if (userChoice == 0)
			{
				System.exit(0);
			}
			else if (userChoice == 1)
			{
				System.out.println("You want to add " + userChoice + " new flight to the system.");
				arrayNewFlights(userChoice); // Doorsturen naar de arrayNewFlights method
			}
			else if (userChoice > 1)
			{
				System.out.println("You want to add " + userChoice + " new flights to the system.");
				arrayNewFlights(userChoice); // Doorsturen naar de arrayNewFlights method
			}
			else
			{
				System.out.println("Make sure to enter a positive number.");
				amountNewFlights();
			}
		}
		else
		{
			System.out.println("The value you entered is not an integer.");
			amountNewFlights(); // change to a correct loop 
		}
	}


	// Method die de array van nieuwe objects maakt
	public static void arrayNewFlights(int size) 
	{
		Flight[] flightArray = new Flight[size];
		for (int i = 0; i < size; i++)
		{
			String flightNumber = getFlightNumber();
			String flightAirlineCode = getAirlineCode();
			String [] flightDate = getFlightDate();
			String flightDeptTime = getFlightDeptTime();
			String flightArTime = getFlightArTime();
			String flightDeptAirport = getFlightDeptAirport();
			String flightArAirport = getFlightArAirport();
			String flightDeptTerminal = getFlightDeptTerminal();
			flightArray[i] = new Flight(flightNumber, flightAirlineCode, flightDate, flightDeptTime, flightArTime, flightDeptAirport, flightArAirport, flightDeptTerminal);
			addNewFlight(flightArray[i]);
		}
	}


	// Method die de airlinecode van een nieuw object vraagt
	public static String getAirlineCode()
	{
		String userChoice = null; 
		String flightAirlineCode = null;
		System.out.println("What is the airline?"); 
		System.out.println("1. KLM");					
		System.out.println("2. Lufthansa");
		System.out.println("3. Virgin Atlantic");
		System.out.println("4. Air France");
		System.out.println("5. Emirates");
		System.out.println("Press 1 to 5 for the right airline");
		System.out.println("Press 0 for other airline");

		while (userChoice == null)
		{
			userChoice = userInput.nextLine();

			switch (userChoice)
			{
			case "1":
				flightAirlineCode = "KL";
				break; 
			case "2":
				flightAirlineCode = "LU";
				break; 
			case "3":
				flightAirlineCode = "VA";
				break; 
			case "4":
				flightAirlineCode = "AF";
				break; 
			case "5":
				flightAirlineCode = "E";
				break; 
			case "0":
				System.out.println("Please enter the name and abbreviation of the airline");
				System.out.println("Name: ");
				String airlineName = userInput.nextLine(); // will not be used i guess 
				System.out.println("Abbreviation: ");
				flightAirlineCode = userInput.nextLine();
				break; 
			default:
				System.out.println("Input mismatch. Please pick one the next choices");
				userChoice = null;
			}
		}
	
	return flightAirlineCode;
}


// Method die de datum van een nieuw object vraagt, volgens mij is dit gewoon een array van size 2 (dag en maand)

public static String getFlightDay()
{
	while (true)
	{
		System.out.println("Day: ");
		int userChoice = Integer.parseInt(userInput.nextLine());
		if (userInput.hasNextInt())
		{
			if (userChoice <= 31 && userChoice > 0) // Check of de value voor "dag" goed is (tussen 1 en 31)
			{
				return "" + userChoice;
			}
			else
			{
				System.out.println("Invalid input");
			}
		}
		else
		{
			System.out.println("Invalid input");
		}
	}

}

public static String getFlightMonth()
{
	System.out.println("Month (XX): ");
	int userChoice = Integer.parseInt(userInput.nextLine());
	if (userInput.hasNextInt())
	{
		if (userChoice <= 12 && userChoice > 0) // Check of de value voor "maand" goed is (tussen 1 en 12)
		{
			return  "" + userChoice;
		}
		else
		{
			System.out.println("Invalid input");
			return  "";
		}
	}
	else
	{
		System.out.println("Invalid input");
		return "";
	}

}

public static String [] getFlightDate()
{
	String [] flightDate = {"0","0"};
	Boolean ok = false;
	while (!ok)
	{
		System.out.println("Please enter the date of departure ");
		flightDate[0] = getFlightDay();
		flightDate[1] = getFlightMonth();
		ok =  flightDate[1] != "";
	}
	return flightDate;
}


// Method die de vertrektijd van een nieuw object vraagt
public static String getFlightDeptTime()
{
	int userChoice;
	String flightDeptTime = null;
	String flightDeptTimeHour = null;
	String flightDeptTimeMin = null;
	String colon = ":"; // : tussen uur en minuut (uur:minuut)
	System.out.println("Please enter the departure time");
	System.out.println("Hour: ");
	userChoice = Integer.parseInt(userInput.nextLine());
	if (userInput.hasNextInt())
	{
		if (userChoice < 24 && userChoice >= 0)
		{
			flightDeptTimeHour = userInput.nextLine();
		}
		else
		{
			System.out.println("Invalid input");
			getFlightDeptTime();
		}
	}
	else
	{
		System.out.println("Invalid input");
		getFlightDeptTime();
	}
	System.out.println("Minute: ");
	userChoice = Integer.parseInt(userInput.nextLine());
	if (userInput.hasNextInt())
	{
		if (userChoice < 24 && userChoice >= 0)
		{
			flightDeptTimeMin = userInput.nextLine();
		}
		else
		{
			System.out.println("Invalid input");
			getFlightDeptTime();
		}
	}
	else
	{
		System.out.println("Invalid input");
		getFlightDeptTime();
	}
	flightDeptTime = flightDeptTimeHour + colon + flightDeptTimeMin;
	return flightDeptTime;
}


// Method die de aankomsttijd van een nieuw object vraagt
public static String getFlightArTime()
{
	int userChoice; // hier wel int omdat er datums ingevoerd moeten worden. We kunnen er ook nog voor kiezen de functie: date te gaan begrijpen. x saso
	String flightArTime = null;
	String flightArTimeHour = null;
	String flightArTimeMin = null;
	String colon = ":";
	System.out.println("Please enter the arrival time");
	System.out.println("Hour: ");
	userChoice = Integer.parseInt(userInput.nextLine());
	if (userInput.hasNextInt())
	{
		if (userChoice < 24 && userChoice >= 0)
		{
			flightArTimeHour = userInput.nextLine();
		}
		else
		{
			System.out.println("Invalid input");
			getFlightArTime();
		}
	}
	else
	{
		System.out.println("Invalid input");
		getFlightArTime();
	}
	System.out.println("Minute: ");
	userChoice = Integer.parseInt(userInput.nextLine());
	if (userInput.hasNextInt())
	{
		if (userChoice < 24 && userChoice >= 0)
		{
			flightArTimeMin = userInput.nextLine();
		}
		else
		{
			System.out.println("Invalid input");
			getFlightArTime();
		}
	}
	else
	{
		System.out.println("Invalid input");
		getFlightArTime();
	}
	flightArTime = flightArTimeHour + colon + flightArTimeMin;
	return flightArTime;
}


// Method die de vertrekairport van een nieuw object vraagt
public static String getFlightDeptAirport()
{
	String userChoice = null; 
	String flightDeptAirport = null;
	System.out.println("Please enter the departure airport.");
	System.out.println("1. Amsterdam - Schiphol Airport");
	System.out.println("2. Berlin - Tegel Airport");
	System.out.println("3. Rome - Fiumicino Airport"); 
	System.out.println("4. Paris - Charles De Gaulle Airport");
	System.out.println("5. Barcelona - El Prat Airport");  
	System.out.println("Press 1 to 5 for the right airport.");
	System.out.println("Press 0 for another airport");
	userChoice = userInput.nextLine();

	while(userChoice == null)
	{
		userChoice = userInput.nextLine();

		switch (userChoice)
		{
		case "1":
			flightDeptAirport = "AMS";
			break; 
		case "2":
			flightDeptAirport = "TXL";
			break; 
		case "3":
			flightDeptAirport = "FCO"; 
			break;
		case "4":
			flightDeptAirport = "CDG";
			break;
		case "5":
			flightDeptAirport = "BCN"; 
			break;
		case "0":
			System.out.println("Please enter the name and abbreviation of the airport. Example Amsterdam Schiphol: AMS");
			System.out.println("Name: ");
			String airportName = userInput.nextLine(); // not used anywhere. 
			System.out.println("Abbreviation: ");
			flightDeptAirport = userInput.nextLine();
			break;
		default:
			System.out.println("Invalid input");
			userChoice = null; 
		}
	}
	return flightDeptAirport;
}


// Method die de aankomstairport van een nieuw object vraagt
public static String getFlightArAirport()
{
	String userChoice = null; 
	String flightArAirport = null;
	System.out.println("Please enter the arrival airport.");
	System.out.println("1. Amsterdam - Schiphol Airport");
	System.out.println("2. Berlin - Tegel Airport");
	System.out.println("3. Rome - Fiumicino Airport"); 
	System.out.println("4. Paris - Charles De Gaulle Airport");
	System.out.println("5. Barcelona - El Prat Airport");  
	System.out.println("Press 1 to 5 for the right airport.");
	System.out.println("Press 0 for another airport");
	while (userChoice.equals(null))
		userChoice = userInput.nextLine();

	switch (userChoice)
	{
	case "1":
		flightArAirport = "AMS";
		break; 
	case "2":
		flightArAirport = "TXL";
		break; 
	case "3":
		flightArAirport = "FCO"; 
		break;
	case "4":
		flightArAirport = "CDG";
		break;
	case "5":
		flightArAirport = "BCN"; 
		break;
	case "0":
		System.out.println("Please enter the name and abbreviation of the airport. Example Amsterdam Schiphol: AMS");
		System.out.println("Name: ");
		String airportName = userInput.nextLine();
		System.out.println("Abbreviation: ");
		flightArAirport = userInput.nextLine();
		break;
	default:
		System.out.println("Invalid input");
		userChoice = null; 
	}
	return flightArAirport;
}


// Method die de vertrekterminal van een nieuw object vraagt
public static String getFlightDeptTerminal()
{
	String flightDeptTerminal = null;
	System.out.println("Please enter the terminal");
	if (userInput.hasNextInt())
	{
		flightDeptTerminal = userInput.nextLine();
	}
	else
	{
		System.out.println("Invalid input");
		getFlightDeptTerminal();
	}
	return flightDeptTerminal;
}


// Method die een nieuw object in excel bestand zet
public static void addNewFlight(Flight flight)

{
	try
	{
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("fileName.xls", true)));
		pr.print(flight.number);
		pr.print("\t"); // "\t"(tab) betekent een cel naar rechts in excel
		pr.print(flight.airlineCode);
		pr.print("\t");
		pr.print(flight.date);
		pr.print("\t");
		pr.print(flight.deptTime);
		pr.print("\t");
		pr.print(flight.arTime);
		pr.print("\t");
		pr.print(flight.deptAirport);
		pr.print("\t");
		pr.print(flight.arAirport);
		pr.print("\t");
		pr.println(flight.deptTerminal);
		pr.close();
	}
	catch (IOException ex)
	{
		System.out.println("The file does not exist");
	}
}


// Method die vertrektijd kan veranderen
public void changeDeptTime()
{
	System.out.println("Enter flightnumber: ");
	String flightNumber = userInput.nextLine();
	try
	{
		String line;
		BufferedReader br = new BufferedReader(new FileReader("fileName.txt"));
		while((line = br.readLine()) != null)
		{
			String[] wordsInFile = line.split("\t");
			if (wordsInFile[0].equals(flightNumber))
			{
				String deptTime = wordsInFile[3];
				System.out.println("Do you want to change the departure time (" + deptTime + ") of flight " + flightNumber + "?");
				System.out.println("0. No");
				System.out.println("1. Yes");
				System.out.println("Press 0 or 1");
				int userChoice = Integer.parseInt(userInput.nextLine());
				if (userInput.hasNextInt())
				{
					if (userChoice == 0)
					{
						System.exit(0);
					}
					else if (userChoice == 1)
					{
						wordsInFile[3] = updateDeptTime();
					}
					else
					{
						System.out.println("Invalid input");
						changeDeptTime();
					}
				}
				else
				{
					System.out.println("Invalid input");
					changeDeptTime();
				}
			}
		}
		br.close();
	}
	catch (IOException ex)
	{
		System.out.println("The file does not exist");
	}
}


// Method die de nieuwe vertrektijd van een object vraagt

public String updateDeptTime() // deze is een beetje raar  
{
	String flightDeptTime = null;
	String flightDeptTimeHour = null;
	String flightDeptTimeMin = null;
	String colon = ":";
	System.out.println("Please enter the new departure time");
	System.out.println("Hour: ");
	int userChoice; 
	userChoice = Integer.parseInt(userInput.nextLine());
	if (userInput.hasNextInt())
	{
		if (userChoice < 24 && userChoice >= 0)
		{
			flightDeptTimeHour = userInput.nextLine();
		}
		else
		{
			System.out.println("Invalid input");
		}
	}
	else
	{
		System.out.println("Invalid input");
		updateDeptTime();
	}
	System.out.println("Minute: ");
	userChoice = Integer.parseInt(userInput.nextLine());
	if (userInput.hasNextInt())
	{
		if (userChoice < 24 && userChoice >= 0)
		{
			flightDeptTimeMin = userInput.nextLine();
		}
		else
		{
			System.out.println("Invalid input");
			updateDeptTime();
		}
	}
	else
	{
		System.out.println("Invalid input");
		updateDeptTime();
	}
	flightDeptTime = flightDeptTimeHour + colon + flightDeptTimeMin;
	System.out.println("The new departure time is: "+ flightDeptTime);
	return flightDeptTime;
}

public void printDeptTime()
{
	System.out.println("Departure time: " + deptTime);
}

public void printFlightNumber()
{
	System.out.println("Flight number: " + airlineCode + number);
}

public static void viewFlightNumbers(Flight [] flightArray)  

{
	System.out.println("");
	System.out.println("please your flight number");
	String number = userInput.nextLine();

	for (int i = 0; i < flightArray.length; i++)
		if (number.equals(flightArray[i].number))
		{
			System.out.println(flightArray[i].deptAirport);
			System.out.println(flightArray[i].deptTerminal);
			System.out.println(flightArray[i].deptTime);
			System.out.println(flightArray[i].arAirport);
			System.out.println(flightArray[i].arTime);
		}
		else
			System.out.println("flight not found");
}

public static void printAllFlights(ArrayList<Flight> ArrayFlight)

{
	for(int i = 0; i < ArrayFlight.size(); i++)
	{
		Flight activeFlight = ArrayFlight.get(i);
		System.out.println("Flight number of flight " + (i + 1) + " is: " + activeFlight.number);
		System.out.println("Departure airport of flight " + (i + 1) + " is: " + activeFlight.deptAirport);
		System.out.println("Departure terminal of flight " + (i + 1) + " is: " + activeFlight.deptTerminal);
		System.out.println("Arrival airport of flight " + (i + 1) + " is: " + activeFlight.arAirport);
	}
}

public static void  printFlightDetails(ArrayList<Flight> ArrayFlight, String number)
{
	int count = 0;
	for(int i = 0; i < ArrayFlight.size(); i++)
	{
		Flight activeFlight = ArrayFlight.get(i);
		if (number.equals(activeFlight.number))
		{
			System.out.println("Details of flight " + activeFlight.number + " are: ");
			System.out.println("Departure airport: " + activeFlight.deptAirport + " from terminal number " + activeFlight.deptTerminal);
			System.out.println("Arrival airport: " + activeFlight.arAirport);
			System.out.println("Time of departure: " + activeFlight.deptTime);
			System.out.println("Time of arrival: " + activeFlight.arTime);
			count++;
		}
		if (count == 0)
		{
			System.out.println("Flight number wasn't found in the system.");
		}
	}
} 
}





