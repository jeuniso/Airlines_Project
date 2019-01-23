import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Airline iairline = new Airline("Air Queens");
		Random rand = new Random();
		
		ArrayList<String> depTime = new ArrayList<>();
		for(int i = 0; i < 16; i++) {
			int j = rand.nextInt(60);
			if(j < 10)
				depTime.add(String.valueOf(i+6) + ".0" + String.valueOf(j));
			else depTime.add(String.valueOf(i+6) + "." + String.valueOf(j));
		}
		
		Collections.shuffle(depTime);
		
		ArrayList<Integer> rseats = new ArrayList<>();
		for(int y = 50; y < 101; y++) {
			rseats.add(y);
		}
		Collections.shuffle(rseats);
		
		ArrayList<Flight> addedFlights = iairline.getFlights();
		
		for(int a = 0; a < 16; a++) {
			iairline.createFlight(depTime.get(a), rseats.get(a), "LaGuardia", "Kennedy");
		}
		
		for(int b = 0; b < 16; b++) {
			Flight iflight = addedFlights.get(b);
			iflight.setFlightLength(2.5);
			iflight.setDate("10.1");
		}
		
		for(int c = 0; c < 30; c++) {
			int size = (c+1) * 16;
			for(int d = size; d < (size+16); d++) {
				String thedate = "10." + String.valueOf(c + 2);
				Flight iiflight = addedFlights.get(d - size);
				Flight iiiflight = new Flight();
				Airline iiairline = iiflight.getAirline();
				double iilength = iiflight.getFlightLength();
				String iiorigin = iiflight.getOriginAirport();
				String iidest = iiflight.getDestination();
				String iidep = iiflight.getDepartureTime();
				int iinum = iiflight.getFlightNumber();
				int iiseats = iiflight.getSeats();
				iiiflight.setAirline(iiairline);
				iiiflight.setFlightLength(iilength);
				iiiflight.setOriginAirport(iiorigin);
				iiiflight.setDestination(iidest);
				iiiflight.setDepartureTime(iidep);
				iiiflight.setFlightNumber(iinum);
				iiiflight.setSeats(iiseats);
				iiiflight.setDate(thedate);
				addedFlights.add(iiiflight);
			}
		}
		
		Collections.shuffle(depTime);
		Collections.shuffle(rseats);
		
		ArrayList<Flight> addedFlights1 = iairline.getFlights();
		
		for(int w = 0; w < 16; w++) {
			iairline.createFlight(depTime.get(w), rseats.get(w), "Kennedy", "LaGuardia");
		}
		
		for(int x = 0; x < 16; x++) {
			int n = 16 * 31;
			Flight iflight = addedFlights1.get(n+x);
			iflight.setFlightLength(2.5);
			iflight.setDate("10.1");
		}
		
		for(int y = 0; y < 30; y++) {
			int size = (y+1) * 496;
			for(int z = size; z < (size+16); z++) {
				String thedate = "10." + String.valueOf(y + 2);
				Flight iiflight = addedFlights1.get(z - size + 496);
				Flight iiiflight = new Flight();
				Airline iiairline = iiflight.getAirline();
				double iilength = iiflight.getFlightLength();
				String iiorigin = iiflight.getOriginAirport();
				String iidest = iiflight.getDestination();
				String iidep = iiflight.getDepartureTime();
				int iinum = iiflight.getFlightNumber();
				int iiseats = iiflight.getSeats();
				iiiflight.setAirline(iiairline);
				iiiflight.setFlightLength(iilength);
				iiiflight.setOriginAirport(iiorigin);
				iiiflight.setDestination(iidest);
				iiiflight.setDepartureTime(iidep);
				iiiflight.setFlightNumber(iinum);
				iiiflight.setSeats(iiseats);
				iiiflight.setDate(thedate);
				addedFlights.add(iiiflight);
			}
		}
		
		for(int c = 0; c < 10000; c++) {
			String y = String.valueOf(c+1);
			String z = String.valueOf(c+10);
			Passenger pass = new Passenger(y, z);
			ArrayList<Flight> booking = iairline.getFlights();
			int randm = rand.nextInt(booking.size());
			Flight books = booking.get(randm);
			iairline.book(pass, books);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Ready to book your flights. Enter your first name, hit enter, then enter your last name please:");
		String firstName = input.nextLine();
		String lastName = input.nextLine();
		Passenger ipassenger = new Passenger(firstName, lastName);
		System.out.println("Type your address on one line please:");
		String theaddress = input.nextLine();
		ipassenger.setAddress(theaddress);
		System.out.println("Type your phone number on one line please:");
		String thephone = input.nextLine();
		ipassenger.setPhone(thephone);
		System.out.println("Ready to book your flights between Kennedy and LaGuardia for October 2017.");
		System.out.println("Do you want to book or cancel a flight? Answer Yes or No:");
		while(input.next().equalsIgnoreCase("Yes")) {
			System.out.println("Enter C to cancel, K for a flight from Kennedy, or L for a flight from LaGuardia:");
			String look = input.next();
			if(look.equalsIgnoreCase("K")) {
				String Origin = "Kennedy";
				System.out.println("Enter the day in October that you want to fly:");
				int intdate = input.nextInt();
				String Date = "10." + String.valueOf(intdate);
				System.out.println("Enter the hour you would like to fly (6 - 21)");
				double hour = input.nextDouble();
				while((hour < 6) || (21 < hour)) {
					System.out.println("Please enter a correct hour: ");
					hour = input.nextDouble();
				}	
				String Time = String.valueOf(hour);
				ArrayList<Flight> foundFlights = ipassenger.findFlights(iairline, Date, Time, Origin);
				System.out.println("Here are available flights:");
				for(int i = 0; i < foundFlights.size(); i++) {
					Flight found = foundFlights.get(i);
					System.out.println(found.toString());
				}	
				System.out.println("Type the flight number you wish to book:");
				int num = input.nextInt();
				for(int j = 0; j < foundFlights.size(); j++) {
					Flight check = foundFlights.get(j);
					if(num == check.getFlightNumber()) {
						ipassenger.bookFlight(check);
						System.out.println("Successfully booked ticket.");
					}
				}	
			}
			else if(look.equalsIgnoreCase("L")) {
				String Origin = "LaGuardia";
				System.out.println("Enter the day in October that you want to fly:");
				int intdate = input.nextInt();
				String Date = "10." + String.valueOf(intdate);
				System.out.println("Enter the hour you would like to fly (6 - 21)");
				double hour = input.nextDouble();
				while((hour < 6) || (21 < hour)) {
					System.out.println("Please enter a correct hour: ");
					hour = input.nextDouble();
				}	
				String Time = String.valueOf(hour);
				ArrayList<Flight> foundFlights = ipassenger.findFlights(iairline, Date, Time, Origin);
				System.out.println("Here are available flights:");
				for(int i = 0; i < foundFlights.size(); i++) {
					Flight found = foundFlights.get(i);
					System.out.println(found.toString());
				}	
				System.out.println("Type the flight number you wish to book:");
				int num = input.nextInt();
				for(int j = 0; j < foundFlights.size(); j++) {
					Flight check = foundFlights.get(j);
					if(num == check.getFlightNumber()) {
						ipassenger.bookFlight(check);
						System.out.println("Successfully booked ticket.");
					}	
				}
			}	
			else if(look.equalsIgnoreCase("C")) {
				System.out.println("Here are the tickets you have booked:");
				ArrayList<Ticket> bookedTickets = ipassenger.getMyTickets();
				int n = bookedTickets.size();
				for(int x = 0; x < n; x++) {
					Ticket bookedTicket = bookedTickets.get(x);
					int y = x+1;
					System.out.println(String.valueOf(y) + " " + bookedTicket.toString());
				}
				System.out.println("Type the number of the ticket you wish to cancel");
				int num = input.nextInt();
				Ticket cancel = bookedTickets.get(num-1);
				iairline.issueRefund(cancel);
				ipassenger.cancel(cancel);
			}
			else System.out.println("Your input did not match any of the available options.");
			System.out.println("Do you want to book or cancel a flight? Answer Yes or No");
		}
		System.out.println("Thank you for booking with Air Queens");
		System.out.println("Here is a list of your bookings:");
		ArrayList<Ticket> bookedTickets = ipassenger.getMyTickets();
		int n = bookedTickets.size();
		for(int y = 0; y < n; y++) {
			Ticket bookedTicket = bookedTickets.get(y);
			System.out.println(bookedTicket.toString());
		}
		input.close();
	}
}