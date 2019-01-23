import java.util.ArrayList;

class Passenger {
	private String firstName, lastName, address, phone;
	private ArrayList<Ticket> myTickets;
	
	public Passenger(String first, String last) {
		firstName = first;
		lastName = last;
		address = "Not set yet";
		phone = "Not set yet";
		myTickets = new ArrayList<>();
	}
	
	public void cancel(Ticket t) { 
		if(myTickets.contains(t)) myTickets.remove(t);
	}
	
	public ArrayList<Flight> findFlights(Airline a, String date, String time, String from){
		ArrayList<Flight> find = new ArrayList<>();
		ArrayList<Flight> compare =	a.getFlights();
		for(int i = 0; i < compare.size(); i++) {
				double convert = Double.parseDouble(time);
				Flight tocompare = compare.get(i);
				double conv = Double.parseDouble(tocompare.getDepartureTime());
				if(date.equals(tocompare.getDate())) {
					if(from.equals(tocompare.getOriginAirport())) {
						if(((conv - 4) < convert && convert < (conv + 4)) || convert == conv)
							find.add(tocompare);
					}
				}
		}
		return find;
	}
	
	public Ticket bookFlight(Flight f) {
		Ticket book = new Ticket(f.getAirline(), this, f);
		myTickets.add(book);
		return book;
	}
	
	boolean holdsTicket(Ticket t) {
		return myTickets.contains(t);
	}
	
	public void setAddress(String address1) {
		address = address1;
	}
	
	public void setPhone(String phone1) {
		phone = phone1;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public ArrayList<Ticket> getMyTickets(){
		return myTickets;
	}

	public String toString() {
		return "Passenger name: " + firstName + " " + lastName + " " + "\nAddress: " + address 
				+ "\nPhone number: " + phone + "\nBooked tickets: " + myTickets;
	}
}