import java.util.ArrayList;

class Flight {
	private int flightNumber = counter, seats, filledSeats;
	private double flightLength;
	private String date, originAirport, destination, departureTime;
	private Airline airline;
	private ArrayList<Ticket> tickets;
	static int counter = 100;
	
	public Flight(){
		seats = 0;
		flightLength = 0;
		date = "Not set yet";
		originAirport = "Not set yet";
		destination = "Not set yet";
		departureTime = "Not set yet";
		tickets = new ArrayList<>();
		counter++;
	}
	
	public boolean matches(String d, double t, String from) {
		double depart = Double.parseDouble(this.departureTime);
		if(this.date.equals(d) && depart == t && this.originAirport.equals(from))
					return true;
		return false;
	}
	
	public boolean hasSpace() {
		return seats > filledSeats;
	}
	
	public void addTicket(Ticket t) {
		filledSeats += 1;
		tickets.add(t);
	}
	
	public boolean holdsTicket(Ticket ticket) {
		return (tickets.contains(ticket));
	}
	
	public void remove(Ticket ticket) {
		filledSeats -= 1;
		tickets.remove(ticket);
	}
	
	public double getCost() {
		return airline.cost(this);
	}
	
	public void setFlightNumber(int flightNumber1) {
		flightNumber = flightNumber1;
	}
	
	public void setSeats(int seats1) {
		seats = seats1;
	}
	
	public void setFilledSeats(int filledSeats1) {
		filledSeats = filledSeats1;
	}
	
	public void setFlightLength(double flightLength1) {
		flightLength = flightLength1;
	}
	
	public void setAirline(Airline airline1) { 
		airline = airline1;
	}
	
	public void setDate(String date1) {
		date = date1;
	}
	
	public void setOriginAirport(String originAirport1) {
		originAirport = originAirport1;
	}
	
	public void setDestination(String destination1) {
		destination = destination1;
	}
	
	public void setDepartureTime(String departureTime1) {
		departureTime = departureTime1;
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public int getFilledSeats() {
		return filledSeats;
	}
	
	public double getFlightLength() {
		return flightLength;
	}
	
	public Airline getAirline() {
		return airline;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getOriginAirport() {
		return originAirport;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public String toString() {
		return airline + " " + flightNumber + " " + date + " " + departureTime 
				+ " from " + originAirport + " to " + destination + " ticket cost " + this.getCost(); 
	}
}