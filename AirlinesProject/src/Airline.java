import java.util.ArrayList;

class Airline {
	private String name;
	private ArrayList<Flight> flights;
	
	public Airline(String airlineName){
		name = airlineName;
		flights = new ArrayList<>();
	}
	
	void cancel(Ticket t) { 
		t = null;
	}
	
	void issueRefund(Ticket t) {
		double refund = t.getPrices();
		Passenger pass = t.getMyPassenger();
		System.out.println("Airline " + name + " refunds $" + refund + " to " + pass.getName());
	}
	
	public ArrayList<Flight> findFlights(String adate, double time, String origin) {
		ArrayList<Flight> flightFind = new ArrayList<>();
		int i = 0;
		while(i < flights.size()) {
			for(int j = -4; j < 5; j++) {
				double theTime = time + j;
				Flight possible = flights.get(i);
				if(possible.matches(adate, theTime, origin))
					flightFind.add(possible);
			}	
			i++;
		}
		return flightFind;
	}
	
	public void book(Passenger p, Flight f) {
		Ticket booked = new Ticket(this, p, f);
		ArrayList<Ticket> myt = p.getMyTickets();
		myt.add(booked);
		f.addTicket(booked);
	}
	
	public double cost(Flight f) {
		double base = 150.0;
		double cost = base;
		int add = 10;
		ArrayList<Ticket> ftickets = f.getTickets();
		int filled = ftickets.size();
		if(f.hasSpace() == false)
			System.out.println("No more seats.");
		else cost = base + (add*filled);
		return cost;
	}
	
	public void createFlight(String time, int numSeats, String from, String to) {
		Flight airFlight = new Flight();
		airFlight.setAirline(this);
		airFlight.setDepartureTime(time);
		airFlight.setSeats(numSeats);
		airFlight.setOriginAirport(from);
		airFlight.setDestination(to);
		flights.add(airFlight);
	}
	
	public String getAirline() {
		return name;
	}
	
	public ArrayList<Flight> getFlights(){
		return flights;
	}
	
	public String toString() {
		return "Airline: " + name;
	}
}