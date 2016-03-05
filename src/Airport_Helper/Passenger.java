package Airport_Helper;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {

	public static int dataFields = 6;
	protected String username;
	protected String password;
	protected String firstName;
	protected String surName;
	protected String safetyQuestion;
	protected String answer;
	protected String food;
	protected String flight;
	protected String airport; //departure airport
	protected String date;   // departure date

	public static String fileName = "databasePassengers.txt";
	public static String fileFavAirport = "favoriteAirport.txt";
	static Scanner userInput = new Scanner(System.in);

	Passenger(String passengerUsername, String passengerPassword, String passengerFirstName, String passengerSurName, String passengerSafetyQuestion, String passengerAnswer, String prefFood, String passengerFLight, String passengerAirport, String passengerDate)
	{
		username = passengerUsername;
		password = passengerPassword;
		firstName = passengerFirstName;
		surName = passengerSurName;
		safetyQuestion = passengerSafetyQuestion;
		answer = passengerAnswer;
		food = prefFood; 
		flight = passengerFLight;
		airport = passengerAirport;
		date = passengerDate; 

	}

	Passenger()
	{
		
	}
	
	public static void printWelcomeMessage()
	{
		System.out.println("Welcome to the Airport Helper�.");
		System.out.println("This unique tool will help you with finding what you need on the airport.");
		System.out.println("This program has several functionalities:");
		System.out.println("");

	}

	public String beforeLoginMenu() // ** change this shit edited by max. "This is not the best way to move through a menu" - saso. Methods in menu directly.

	{
		String choice = null;
		while(choice == null)
		{                              
			System.out.println("");
			System.out.println("Login menu");
			System.out.println("1. Login.");
			System.out.println("2. Retrieve your password.");
			System.out.println("3. Create a new account.");
			System.out.println("Press 0 to exit Airport Helper.");
			choice = userInput.nextLine();					

			switch(choice)
			{
			case "0":
				systemExit();
			case "1":
				System.out.println("Proceeding to login");
				break;
			case "2":
				System.out.println("Password Retrieval menu");
				break;
			case "3":
				System.out.println("Creating an account");
				break;
			default:
				System.out.println("Input mismatch. Please choose 1, 2 or 3.");
			}
		}
		return choice;
	}

	public Passenger loginMenu() // ** all the nulls are a bit weird. Eclipse wants this otherwise its not happening. 

	{
		String username = null;
		String password = null;
		String firstName = null;
		String surName = null;
		String safetyQuestion = null;
		String answer = null;
		String food = null;
		String flight = null; 
		String airport = null;
		String date = null; 
		Passenger user = new Passenger(username, password, firstName, surName, safetyQuestion, answer, food, flight, airport, date);

		System.out.println("Welcome to the login menu.");

		do
		{

			System.out.println("Please enter your username.");
			username = userInput.nextLine();
			System.out.println("Please enter your password.");
			password = userInput.nextLine();

			try 
			{

				String sCurrentLine;				        					
				String[] uCurrent =  new String[dataFields];
				int count = 0;
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);


				while((sCurrentLine = bufferedReader.readLine()) != null) 		
				{
					uCurrent = sCurrentLine.split(",");							

					if (username.equals(uCurrent[0]) && password.equals(uCurrent[1]))	
					{
						count++;
						username = (uCurrent[0]);
						password = (uCurrent[1]);									
						firstName = (uCurrent[2]);
						surName = (uCurrent[3]);
						safetyQuestion = (uCurrent[4]);
						answer = (uCurrent[5]);

						user = new Passenger(username, password, firstName, surName, safetyQuestion, answer, food, flight, airport, date);		 
					}
				}   

				bufferedReader.close(); 
				if (count > 0)
				{
					break;
				}
				else
				{
					System.out.println("The username/password combination is not correct.");
				}
			}

			catch(FileNotFoundException ex) 								//Exception handling
			{
				System.out.println("Unable to open file '" + fileName + "'");
				System.out.println("This is normal if the file hasn't been created yet.");
				System.out.println("Otherwise, '" + fileName + "' is in the wrong place.");

			}
			catch(IOException ex) 
			{
				System.out.println("The program was unable to read '" + fileName + "'. Please contact the developer.");                  
			}
		}
		while(true);

		return user;
	}

	public Passenger createAccount()
	{						
		String passengerUserName = setUsername();												
		String passengerPassword = setPassword();									
		String passengerFirstName = setFirstName();
		String passengerSurName = setSurName();
		String passengerSafetyQuestion = setSafetyQuestion();
		String passengerAnswer = setAnswer(passengerSafetyQuestion);
		String passengerPrefFood = null; 
		String passengerFlight = null; 
		String passengerAirport = null; 
		String passengerDate = null; 

		Passenger user = new Passenger(passengerUserName, passengerPassword, passengerFirstName, passengerSurName, passengerSafetyQuestion, passengerAnswer,  passengerPrefFood, 
		passengerFlight, passengerAirport, passengerDate);		
		addNewPassenger(user);

		System.out.println("Account created.");
		return user;
	}

	public String setUsername()
	{
		System.out.println("What do you want your username to be?");
		String newUsername = userInput.nextLine();

		try {

			String sCurrentLine;				        					
			String[] uCurrent =  new String[dataFields];
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);


			while((sCurrentLine = bufferedReader.readLine()) != null) 		
			{
				uCurrent = sCurrentLine.split(",");							

				if (newUsername.equals(uCurrent[0]))	
				{
					System.out.println("The username '" + newUsername + "' is already taken. Please enter a different username.");
					newUsername = userInput.nextLine();
				}

			}   

			bufferedReader.close(); 

		}

		catch(FileNotFoundException ex) 								//Exception handling
		{
			System.out.println("Unable to open file '" + fileName + "'");
			System.out.println("This is normal if the file hasn't been created yet.");
			System.out.println("Otherwise, '" + fileName + "' is in the wrong place.");

		}
		catch(IOException ex) 
		{
			System.out.println("The program was unable to read '" + fileName + "'. Please contact the developer.");                  
		}

		return newUsername;
	}

	/* we could set a maximum of password words here (e.g. 6 words). code: 
	 * int length = String.valueOf(newPassword).length();
	 * while (length !=6)  
		{ 
			System.out.println("False input. Please enter a six character password: ");
			newPassword = userInput.nextLine();
			length = String.valueOf(newPassword).length();

			if (length == 4) 
			{ 
				break;
			}
		}
		return Password; 
	 */
	public static String setPassword()
	{
		System.out.println("What do you want your password to be?"); 
		String newPassword = userInput.nextLine();
		System.out.println("Enter your password again.");
		String newPasswordCheck = userInput.nextLine();

		if (!newPassword.equals(newPasswordCheck))
		{
			System.out.println("The first password you entered does not match the second password.");
			System.out.println("Please try again.");
			setPassword();
		}

		return newPassword;
	}

	public String setFirstName() //edited by max - while loop if a number is inserted in the name area. 

	{
		System.out.println("What is your first name?");
		while (!userInput.hasNext("[A-Za-z]+"))
		{
			System.out.println("Input failure. Please Enter a valid  name: ");
			userInput.nextLine();  //or just next();
		}
		String newFirstName = userInput.nextLine();
		return newFirstName;
	}

	public String setSurName() //edited by max - while loop if a number is inserted in the name area

	{
		System.out.println("What is your surname?");
		while (!userInput.hasNext("[A-Za-z]+"))
		{
			System.out.println("Imput failure. Please Enter a valid name: ");
			userInput.nextLine();  //or just next();
		}
		String newSurName = userInput.nextLine();
		return newSurName;
	}

	public String setSafetyQuestion()
	{
		String newSafetyQuestion = null;
		String userChoice = null; 

		while(userChoice == null)
		{
			System.out.println("What do you want your safety question to be?");
			System.out.println("1. What is the name of your first pet?");
			System.out.println("2. What is your favourite food?");
			System.out.println("3. What is the name of your favorite professor?");
			System.out.println("Press 1, 2 or 3 to pick a default safety question.");
			System.out.println("Press 0 to enter your own safety question.");
			userChoice = userInput.nextLine();

			switch(userChoice)
			{
			case "0":
				System.out.println("Please enter your own safety question.");
				newSafetyQuestion = userInput.nextLine();
				break;
			case "1":
				newSafetyQuestion = "What is the name of your first pet?";
				break;
			case "2":
				newSafetyQuestion = "What is your favourite food?";
				break;
			case "3":
				newSafetyQuestion = "What is the name of your favorite professor?";
				break;
			default:
				System.out.println("Input mismatch. Please make a selection");
				userChoice = null;
				break;
			}
		}
		return newSafetyQuestion;
	}

	public String setAnswer(String newSafetyQuestion) // this can include numbers so I will not touch it. 
	{
		System.out.println("Please answer your new safety question.");
		System.out.println("You will need this answer if you forget your username or password.");
		System.out.println("Your safety question: " + newSafetyQuestion);
		String newAnswer = userInput.nextLine();
		System.out.println("Your answer is : '" + newAnswer + "'. Make sure to hold on to your new answer.");
		return newAnswer;
	}

	public void addNewPassenger(Passenger passengerUsername)
	{
		try
		{		
			PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true))); 	
			pr.print(passengerUsername.username);
			pr.print(",");
			pr.print(passengerUsername.password);
			pr.print(",");
			pr.print(passengerUsername.firstName);
			pr.print(",");
			pr.print(passengerUsername.surName);
			pr.print(",");
			pr.print(passengerUsername.safetyQuestion);
			pr.print(",");
			pr.print(passengerUsername.answer);
			pr.println("");
			pr.close();
		}
		catch (IOException e)				//If the file doesn't exist, this message prompts.
		{
			System.out.println("The file doesn't exist");
		}
	}

	public void failedLoginMenu() // edited by max. // while loop not present yet - should we? or return to another menu? 

	{
		String userChoice = null; 
		System.out.println("The username/password combination is not correct.");
		System.out.println("What do you want to do next?");
		System.out.println("1. Create a new account");
		System.out.println("2. I forgot my password");
		System.out.println("Press 0 to exit Airport Helper.");
		
		while (userChoice.equals(null))
		{
		userChoice = userInput.nextLine();

		switch(userChoice)
		{

		case "0":
			System.out.println("Press 0 to exit Airport Helper.");
			systemExit();
			break;
		case "1":
			createAccount();
			break;
		case "2":
			passwordRetrieval(); 
			break;

		default:
			System.out.println("Input mismatch. Please pick one the next choices");
			userChoice = null;
		}
		}
	}

	public static void passwordRetrieval()
	{
		String personalUsername;
		String personalPassword;
		String personalSafetyQuestion;
		String personalAnswer;
		System.out.println("Please enter your username.");
		String username = userInput.nextLine();

		try 
		{
			String sCurrentLine;				        					
			String[] uCurrent =  new String[dataFields];
			int count = 0;
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);


			while((sCurrentLine = bufferedReader.readLine()) != null) 		
			{
				uCurrent = sCurrentLine.split(",");							

				if (username.equals(uCurrent[0]))	
				{    				
					count++;
					System.out.println("Username found.");
					System.out.println("Your safety question is: " + uCurrent[4]);
					personalUsername = uCurrent[0];
					personalPassword = uCurrent[1];
					personalSafetyQuestion = uCurrent[4];
					personalAnswer = uCurrent[5];
					answerSafetyQuestion(personalUsername, personalPassword, personalSafetyQuestion, personalAnswer);
				}
			}   

			bufferedReader.close(); 
			if (count == 0)
			{
				System.out.println("Username not found.");
			}
		}

		catch(FileNotFoundException ex) 								//Exception handling
		{
			System.out.println("Unable to open file '" + fileName + "'");
			System.out.println("This is normal if the file hasn't been created yet.");
			System.out.println("Otherwise, '" + fileName + "' is in the wrong place.");

		}
		catch(IOException ex) 
		{
			System.out.println("The program was unable to read '" + fileName + "'. Please contact the developer.");                  
		}
	}

	public static void answerSafetyQuestion(String personalUsername, String personalPassword, String personalSafetyQuestion, String personalAnswer)
	{
		System.out.println("Please answer your safety question : " + personalSafetyQuestion);
		String tempAnswer = userInput.nextLine();

		if (tempAnswer.equals(personalAnswer))
		{
			System.out.println("That is the right answer!");
			System.out.println("Username: " + personalUsername);
			System.out.println("Password: " + personalPassword);
		}
		else
		{
			System.out.println("That is not the right answer!");
			System.out.println("Please try again.");
		}
	}

	public void afterLoginMenu(Passenger activeUser, ArrayList<Flight> ArrayFlight, ArrayList<Restaurant> ArrayRestaurant, ArrayList<DutyFreeStore> ArrayStore)
	{
		String userChoice = "";

			System.out.println("");
			System.out.println("You have succesfully logged in!");	

			do
			{
				System.out.println("What do you want to do next?");	
				System.out.println("1. Set preferences for food, flight, airport and date of departure");
				System.out.println("2. Retrieve information regarding flights, airports and available facilities.");	
				System.out.println("Press 0 to exit Airport Helper.");
				userChoice = userInput.nextLine();
				switch(userChoice)
				{
				case "0":
					systemExit();
					break;
				case "1":
					activeUser.setPreferences(activeUser, ArrayFlight);
					break;
				case "2":
					activeUser.retrieveInformation(activeUser, ArrayFlight, ArrayRestaurant, ArrayStore); 
					break;
				default:
					System.out.println("Input mismatch. Please pick one of the next choices.");
				}
			userChoice = "";
			}
			while(true);
	}
	
	public void setPreferences(Passenger activeUser, ArrayList<Flight> ArrayFlight) // @ raphael: ik maak het weer string want anders risico op program crash if != number
	
	{
		String userChoice = "";

		while(userChoice.equals(""))
		{
			System.out.println("What preferences do you want to change");	
			System.out.println("1. Change flight number");	
			System.out.println("2. Change date of departure");
			System.out.println("3. Change food preferences");
			System.out.println("Press 0 to exit Airport Helper.");
			userChoice = userInput.nextLine();
	
			switch(userChoice)
			{
			case "0":
				systemExit();
				break;
			case "1":
				activeUser.setFlightNumber(activeUser, ArrayFlight);
				break;
			case "2":
				activeUser.setDeptDate(activeUser, ArrayFlight);
				break;
			case "3":
				activeUser.setFood(activeUser);
				userChoice = "";
				break;
			default:
				System.out.println("Input mismatch. Please pick one of the next choices.");
				userChoice = "";
			}
		break;
		}
	}
	
	public void setFlightNumber(Passenger activeUser, ArrayList<Flight> ArrayFlight) // updates the flight preference
	{
		String flight = null;  // whether this works needs to be verified. 
		System.out.println("Please enter your flight in the format of the airlinecode and flight code as on your booking and boarding card.");
		System.out.println("Example: KLM 1821 = KL1821.");
		flight = userInput.nextLine();
		flight = flight.toUpperCase();
		
		for(int i = 0; i < ArrayFlight.size(); i++)  // to check whether flight exists 
		{
			Flight activeFlight = ArrayFlight.get(i);
			if (flight.equals(activeFlight.number))
			{
				System.out.println("The flight " + activeFlight.number + " has been found");
				activeUser.flight = flight;  // now the flight is connected to the user. 
				checkDuplicatesFavAirportFile(activeUser, activeFlight); //writes down the airport for the user
				return; // exit procedure 
			}
		}
		System.out.println("Flight not found. Please check your boardingpass if information was inserted correctly");
		// insert code to return to menu
	}
	
	public void checkDuplicatesFavAirportFile(Passenger activeUser, Flight activeFlight)
	{
		String line;
        String[] wordsInFile =  new String[4];
		int count = 0;	
		try
		{
	        FileReader fileReader = new FileReader(fileFavAirport);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null)
			{
				wordsInFile = line.split(",");
				
				if ((wordsInFile[0] + wordsInFile[1]).equals(activeUser.username + activeFlight.number))
				{
					count++;
				}
				
			}
            bufferedReader.close(); 
		
		}
		catch (IOException ex)
		{
			System.out.println("The file does not exist");
		}
		if (count == 0)
		{
			writeToFavAirportFile(activeUser, activeFlight);
		}

	}
	
	public void writeToFavAirportFile(Passenger activeUser, Flight activeFlight)
	{
		
		try
		{		
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(fileFavAirport, true))); 	//Appends the file with new entries because of 'true'
		pr.print(activeUser.username);
		pr.print(",");
		pr.print(activeUser.flight);
		pr.print(",");
		pr.print(activeFlight.deptAirport);
		pr.print(",");
		pr.print(activeFlight.airlineCode);
		pr.println("");
		pr.close();
		System.out.println("Succesfully added new entry to " + fileFavAirport);
		}

		catch (IOException e)				
		{
			System.out.println("The file doesn't exist");
		}
		
	}
	
/*	Niet langer nodig om airport te setten, want alle info staat in flight
	public void setAirport(Passenger activeUser, ArrayList<Flight> ArrayFlight) // updates the airport preference
	{
		String airport = null;  // whether this works needs to be verified. 
		System.out.println("Please enter the airport you will fly from with its airport code.");
		System.out.println("For example: AMS for Schiphol, Amsterdam");
		airport = userInput.nextLine();
		airport = airport.toUpperCase();
		
		for(int i = 0; i < ArrayFlight.size(); i++)  // to check whether flight exists 
		{
			Flight activeFlight = ArrayFlight.get(i);
			if (airport.equals(activeFlight.deptAirport))
			{
				System.out.println("The airport " + activeFlight.deptAirport + " has been found");
				activeUser.airport = airport;  // now the airport is connected to the user. 
				return; 
			}
			System.out.println("Departure Airport not found");
			// code to return to menu
		}
	}
*/

	public void setDeptDate(Passenger activeUser, ArrayList<Flight> ArrayFlight)  // can someone check this who worked with dates. // updates the date preference
	{
		String day = null;
		String month = null;
		String date = null;  // whether this works needs to be verified. 
		int count = 0;
		System.out.println("Please enter the date you will fly.");
		day = setFlightDay();
		month = setFlightMonth();
		
		date = day + "-" + month;
	
		for(int i = 0; i < ArrayFlight.size(); i++)  // to check whether flight exists 
		{
			Flight activeFlight = ArrayFlight.get(i);
			for(int j = 0; j < activeFlight.date.length; j++)
			{
				if (date.equals(activeFlight.date[j]))
			
				{					
					activeUser.date = activeFlight.date[j];  // now the airport is connected to the user. 
					count++;
				}
			}
		}
		if (count == 0)
		{
			System.out.println("Departure date is not in the system.");
		}
		else if (count > 0)
		{
			System.out.println("The date " + activeUser.date + " has been updated as your departure date.");
		}
		
		
	}

	public String setFlightDay()
	{
		int userChoice = 0;
		String day = null;
		while (true)
		{

			System.out.println("Day: ");
			userChoice = Integer.parseInt(userInput.nextLine());
			

			if (userChoice <= 31 && userChoice > 0) // Check of de value voor "dag" goed is (tussen 1 en 31)
			{
				break;
			}
			else
			{
				System.out.println("Invalid input. Please try again.");
			}

		}
		day = String.valueOf(userChoice);
		return day;

	}
	
	public String setFlightMonth()
	{
		int userChoice = 0;
		String month = null;
		while (true)
		{

			System.out.println("Month: ");
			userChoice = Integer.parseInt(userInput.nextLine());

			if (userChoice <= 12 && userChoice > 0) // Check of de value voor "dag" goed is (tussen 1 en 31)
			{
				break;
			}
			else
			{
				System.out.println("Invalid input. Please try again.");
			}

		}
		month = String.valueOf(userChoice);
		return month;

	}
	
	public void setFood(Passenger activeUser)   // updates the food preference ** updated 15:02 march 3 - max
	
	{
		String typeFood = ""; 

		System.out.println("To make your wait more plesant, please enter your favorite type of restaurant");
		System.out.println("|1| for American, type in American");
		System.out.println("|2| Italian, type in Italian");
		System.out.println("|3| Asian, type in Asian");
		System.out.println("|4| French, type in French");
		while(typeFood.equals(""))
		{
			typeFood = userInput.nextLine();
			typeFood = typeFood.toUpperCase();
	
			switch(typeFood)
			{
			case "AMERICAN":
				System.out.println("You have chosen cuisine: American");
				activeUser.food = typeFood; 
				break;
			case "ITALIAN":
				System.out.println("You have chosen cuisine: Italian");
				activeUser.food = typeFood;
				break;
			case "ASIAN":
				System.out.println("You have chosen cuisine: Asian");
				activeUser.food = typeFood;
				break;
			case "FRENCH":
				System.out.println("You have chosen cuisine: French");
				activeUser.food = typeFood;
				break;
			default:
				System.out.println("Input mismatch. Please make a selection between: American, Italian, Asian or French");
				food = "";
			}
		}
		
	}

	public void retrieveInformation(Passenger activeUser, ArrayList<Flight> ArrayFlight, ArrayList<Restaurant> ArrayRestaurant, ArrayList<DutyFreeStore> ArrayStore) //** 
	{
		String userChoice = "";

			System.out.println("What information do you want to view?");
			
			System.out.println("1. View all flights");
			System.out.println("2. View specific flight information including flight updates");				
			System.out.println("3. Find restaurants at your terminal");
			System.out.println("4. Find duty-free stores in the airport you are flying from");
			System.out.println("5. View your favorite airports");
			System.out.println("6. View the airlines you flew most with");
			System.out.println("Press 0 to exit Airport Helper.");

			while(userChoice.equals(""))
			{
				userChoice = userInput.nextLine();
				switch(userChoice)
				{
				case "0":
					systemExit();
					break;
				case "1":
					activeUser.getAllFlights(ArrayFlight);
					break;
				case "2":
					activeUser.getFlightInformation(activeUser, ArrayFlight);
					break;
				case "3":
					activeUser.getRestaurant(activeUser, ArrayFlight, ArrayRestaurant);
					break;
				case "4":
					activeUser.getDutyFreeStore(activeUser, ArrayFlight, ArrayStore);
					break;
				case "5":
					activeUser.getFavoriteAirport(activeUser);
					break;
				case "6":
					activeUser.getFavoriteAirline(activeUser);
					break;
				
				default:
					System.out.println("Input mismatch. Please pick one of the next choices.");
					userChoice = null;
					break;
				}
			break;
			}
	}

	public void getAllFlights(ArrayList<Flight> ArrayFlight)
    {
    	System.out.println("All flights that are currently accessible through Airport Helper:");
	    for(int i = 0; i < ArrayFlight.size(); i++)
	    {
		    Flight activeFlight = ArrayFlight.get(i);
		    System.out.println("Flight " + (i + 1) + " is '" + activeFlight.number + "' which flies from '" + activeFlight.deptAirport + "' and arrives at '" + activeFlight.arAirport +"'.");
	    }
    }

	public void getFlightInformation(Passenger activeUser,ArrayList<Flight> ArrayFlight) // ** this might give an equal problem
	{
		if (activeUser.flight == null && activeUser.date == null)
		{
	    	System.out.println("You haven't set your flight number and flight date yet.");
	    	System.out.println("Please do this first in the 'Set preferences menu'.");
	    	return;
		}
		else if (activeUser.flight == null)
		{
	    	System.out.println("You haven't set your flight number yet.");
	    	System.out.println("Please do this first in the 'Set preferences menu'.");
	    	return;
	    }
		else if (activeUser.date == null)
		{
	    	System.out.println("You haven't set your flight date yet.");
	    	System.out.println("Please do this first in the 'Set preferences menu'.");
	    	return;
		}
		else
		{
			int i = checkFlightNumber(activeUser, ArrayFlight);
			int j = checkFlightDate(activeUser, ArrayFlight, i);
			if(j != -1)
			{
				printFlightDetails(activeUser, ArrayFlight,i, j);
			}

		}
	}	
	
	public int checkFlightNumber(Passenger activeUser, ArrayList<Flight> ArrayFlight)
	{
		int count = 0;
		int i;
		for(i = 0; i < ArrayFlight.size(); i++)  // to check whether flight exists
		{
		    Flight activeFlight = ArrayFlight.get(i);

		    if (activeUser.flight.equals(activeFlight.number))
		    {
		    	System.out.println("The flight number has been found.");
		    	count++;
		    	return i;
		    }
		}
		if (count == 0)
		{
			System.out.println("The flight number you entered wasn't found in the system.");
			System.out.println("Please check whether you have inserted the correct information.");
			System.out.println("You can always change your preferences in the previous menu.");
			i = -1;
		}
		return i;
	}
	
	public int checkFlightDate(Passenger activeUser, ArrayList<Flight> ArrayFlight, int i)
	{
		Flight activeFlight = ArrayFlight.get(i);
		int count = 0;
		int j;
		for(j = 0; j < activeFlight.date.length; j++)  // to check whether flight exists
		{
		    if (activeUser.date.equals(activeFlight.date[j]))
		    {
		    	System.out.println("The flight date has been found for this flight.");
		    	count++;
		    	return j;
		    }
		}

		if (count == 0)
		{
			System.out.println("The combination of flightnumber and date wasn't found in the system.");
			System.out.println("Please check whether you have inserted the correct information.");
			System.out.println("You can always change your preferences in the previous menu.");
			j = -1;
		}
		return j;
	}
	
	public void printFlightDetails(Passenger activeUser, ArrayList<Flight> ArrayFlight,int i, int j)
	{	
		Flight activeFlight = ArrayFlight.get(i);
		if (flight.equals(activeFlight.number) && (date.equals(activeFlight.date[j])))
	    {
			if (activeFlight.update[j] == 0)
			{
		        System.out.println("***************************************");
		        System.out.println("Flight Number:      | " + activeFlight.number);
		        System.out.println("Departure Airport:  | " + activeFlight.deptAirport);
		        System.out.println("Departure Terminal: | " + activeFlight.deptTerminal);
		        System.out.println("Departure date:     | " + activeFlight.date[j]);
		        System.out.println("Departure time:     | " + activeFlight.deptTime);
		        System.out.println("Arrival time:       | " + activeFlight.arTime);
		        System.out.println("Arrival airport:    | " + activeFlight.arAirport);
		        System.out.println("Your flight is currently on time.");
		        System.out.println("***************************************");
		        System.out.println("");
			}
			else
			{
		        System.out.println("***************************************");
		        System.out.println("Flight Number:      | " + activeFlight.number);
		        System.out.println("Departure Airport:  | " + activeFlight.deptAirport);
		        System.out.println("Departure Terminal: | " + activeFlight.deptTerminal);
		        System.out.println("Departure date:     | " + activeFlight.date[j]);
		        System.out.println("Departure time:     | " + activeFlight.deptTime);
		        System.out.println("Arrival time:       | " + activeFlight.arTime);
		        System.out.println("Arrival airport:    | " + activeFlight.arAirport);
		        System.out.println("Your flight is delayed by " + activeFlight.update[j] + " minutes");
		        System.out.println("***************************************");
		        System.out.println("");
			}
	    }
	}

	public void getRestaurant(Passenger activeUser, ArrayList<Flight> ArrayFlight, ArrayList<Restaurant> ArrayRestaurant)
	{
		if (activeUser.flight == null && activeUser.food == null)
		{
	    	System.out.println("You haven't set your flight number and food preference yet.");
	    	System.out.println("We need your flight number to read your departure terminal.");
	    	System.out.println("Please do this first in the 'Set preferences menu'.");
	    	return;
		}
		else if (activeUser.flight == null)
		{
	    	System.out.println("You haven't set your flight number yet.");
	    	System.out.println("We need your flight number to read your departure terminal.");
	    	System.out.println("Please do this first in the 'Set preferences menu'.");
	    	return;
	    }
		else if (activeUser.food == null)
		{
	    	System.out.println("You haven't set your food preference yet.");
	    	System.out.println("Please do this first in the 'Set preferences menu'.");
	    	return;
		}
		else
		{
			int i = checkFlightNumber(activeUser, ArrayFlight);
			if(i != -1)
			{
				printRestaurant(activeUser, ArrayFlight, ArrayRestaurant, i);
			}

		}
	}
	
	public void printRestaurant(Passenger activeUser, ArrayList<Flight> ArrayFlight, ArrayList<Restaurant> ArrayRestaurant, int i)  // no back to menu loop yet **
    {
        int count = 0;
       
        Flight activeFlight = ArrayFlight.get(i);
        
        for(int j = 0; j < ArrayRestaurant.size(); j++)  // connects food to cuisine - terminal to terminal number stated as e.g. AMS1.
        {
            Restaurant activeRestaurant = ArrayRestaurant.get(j);
            if(activeFlight.deptAirport.equals(activeRestaurant.shortcut)&& activeFlight.deptTerminal.equals(activeRestaurant.terminalNumber) && activeUser.food.equals(activeRestaurant.cuisine))
            {
	        	count++;
	            System.out.println("A restaurant that serves '" + activeUser.food + "' in your terminal is " + activeRestaurant.name);
            }                                              

        }
        if (count == 0)
        {
        	System.out.println("There was no restaurant found with your preferences.");
        	System.out.println("If you want to find restaurants which serve different cuisine than " + activeUser.food + ", then please update your preferences.");
        }
    }
	
	public void getDutyFreeStore(Passenger activeUser,ArrayList<Flight> ArrayFlight, ArrayList<DutyFreeStore> ArrayStore)
	{

		if (activeUser.flight == null)
		{
	    	System.out.println("You haven't set your flight number yet.");
	    	System.out.println("We need your flight number to read your departure airport.");
	    	System.out.println("Please do this first in the 'Set preferences menu'.");
	    	return;
	    }
		else
		{
			int i = checkFlightNumber(activeUser, ArrayFlight);
			if(i != -1)
			{
				printDutyFreeStore(activeUser, ArrayFlight, ArrayStore, i);
			}
		}
	}
	
	public void printDutyFreeStore(Passenger activeUser, ArrayList<Flight> ArrayFlight, ArrayList<DutyFreeStore> ArrayStore, int i)  
    {
        int count = 0;
       
        Flight activeFlight = ArrayFlight.get(i);
        System.out.println("Stores that are located on your departure airport");
        for(int j = 0; j < ArrayStore.size(); j++)  
        {
            DutyFreeStore activeStore = ArrayStore.get(j);
            if(activeFlight.deptAirport.equals(activeStore.shortcut))
            {
	        	count++;
            	if(activeStore.discount != 0)
            	{
		            System.out.println(activeStore.name + " has a discount of " + activeStore.discount + "%");
            	}
            	else
            	{
		            System.out.println(activeStore.name + " doesn't have any discount at this moment.");
            	}
            }                                              

        }
        if (count == 0)
        {
        	System.out.println("There was no store found on your departure airport.");
        	System.out.println("If you want to find stores on different airports, please update your preferences.");
        }
    }
			
	
		
    		
	
    public void getFavoriteAirport(Passenger activeUser)
	{
		String line;
        String[] wordsInFile =  new String[4];
		int countAMS = 0;
		int countTXL = 0;
		int countFCO = 0;
		int countBCN = 0;
		int countCDG = 0;
						        					
		try
		{
	        FileReader fileReader = new FileReader(fileFavAirport);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null)
			{
				wordsInFile = line.split(",");
				
				if (wordsInFile[0].equals(username))
				{
					if (wordsInFile[2].equals("AMS"))
					{
						countAMS++;
					}
					else if (wordsInFile[2].equals("TXL"))
					{
						countTXL++;
					}
					else if (wordsInFile[2].equals("FCO"))
					{
						countFCO++;
					}
					else if (wordsInFile[2].equals("BCN"))
					{
						countBCN++;
					}
					else if (wordsInFile[2].equals("CDG"))
					{
						countCDG++;
					}
				}
				
			}
            bufferedReader.close(); 
            
			System.out.println("How often you fly from the following airports:");
			System.out.println("Schiphol, Amsterdam: " + countAMS);
			System.out.println("Tegel, Berlin: " + countTXL);
			System.out.println("Fiumicino, Rome: " + countFCO);
			System.out.println("El Prat, Barcelona: " + countBCN);
			System.out.println("Charles de Gaulle, Paris: " + countCDG);

		}
		catch (IOException ex)
		{
			System.out.println("The file does not exist");
		}
	}
	
	
	public void getFavoriteAirline(Passenger activeUser)
	{
		String line;
        String[] wordsInFile =  new String[4];
		int countKLM = 0;
		int countLufthansa = 0;
		int countVirgin = 0;
		int countAirFrance = 0;
		int countEmirates = 0;
						        					
		try
		{
	        FileReader fileReader = new FileReader(fileFavAirport);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null)
			{
				wordsInFile = line.split(",");
				
				if (wordsInFile[0].equals(username))
				{
					if (wordsInFile[3].equals("KLM"))
					{
						countKLM++;
					}
					else if (wordsInFile[3].equals("Lufthansa"))
					{
						countLufthansa++;
					}
					else if (wordsInFile[3].equals("Virgin"))
					{
						countVirgin++;
					}
					else if (wordsInFile[3].equals("AirFrance"))
					{
						countAirFrance++;
					}
					else if (wordsInFile[3].equals("Emirates"))
					{
						countEmirates++;
					}
				}
				
			}
            bufferedReader.close(); 
			System.out.println("How often you fly with the following airlines:");
			System.out.println("KLM Dutch Royal Airlines: " + countKLM);
			System.out.println("Lufthansa: " + countLufthansa);
			System.out.println("Virgin Atlantic: " + countVirgin);
			System.out.println("Air France: " + countAirFrance);
			System.out.println("Emirates: " + countEmirates);

		}
		catch (IOException ex)
		{
			System.out.println("The file does not exist");
		}
	}
	
	
	public static void systemExit()
	{
		System.out.println("Do you want to exit or continue?");
		System.out.println("Press 0 to exit the program.");
		System.out.println("Press 1 to continue.");
		
		while(true)
		{
			try
			{
				
				int userChoice = Integer.parseInt(userInput.nextLine());
				
				if (userChoice == 0)
				{
					System.exit(0);
				}
				else if (userChoice == 1)
				{
					System.out.println("Continue program.");
					break;
				}		
				else
				{
					System.out.println("Please enter value 0 or 1");
				}
			}
			catch (NumberFormatException e)																//If the user input can't be parsed, this method will call itself again until the user enters an integer
			{
				System.out.println("That is not a valid input. Please enter an integer.");										
			}
		}

	}

}










