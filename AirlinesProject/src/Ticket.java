class Ticket {
	private int ticketNumber = counter;
	private Airline myAirline;
	private Passenger myPassenger;
	private Flight myFlight;
	private double prices;
	static int counter = 1;
	boolean valid;
	
	public Ticket(Airline airline, Passenger passenger, Flight flight) {
		myAirline = airline;
		myPassenger = passenger;
		myFlight = flight;
		prices = airline.cost(flight);
		counter++;
		valid = true;
	}
	
	public void cancel() { 
		valid = false;
	}
	
	public void setMyAirline(Airline myAirline1) {
		myAirline = myAirline1;
	}
	
	public void setMyPassenger(Passenger myPassenger1) {
		myPassenger = myPassenger1;
	}
	
	public void setMyFlight(Flight myFlight1) {
		myFlight = myFlight1;
	}
	
	public void setPrices(double prices1) {
		prices = prices1;
	}
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	
	public Airline getMyAirline() {
		return myAirline;
	}
	
	public Passenger getMyPassenger() {
		return myPassenger;
	}
	
	public Flight getMyFlight() {
		return myFlight;
	}
	
	public double getPrices() { 
		return prices;
	}
	
	public String toString() {
		return myPassenger.getName() + " booked on " + myAirline.getAirline() + " " + myFlight.getFlightNumber() 
		+ " " + myFlight.getDate() + " " + myFlight.getDepartureTime() + " from " + myFlight.getOriginAirport() 
		+ " to " + myFlight.getDestination() + " cost " + myFlight.getCost();
	}
}