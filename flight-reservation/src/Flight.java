import java.lang.reflect.Array;
import java.util.ArrayList;

public class Flight {
	// id for flight which is alloted and a new id will be alloted
	static int id = 0;
	int flightId;
	// price of each ticket
	int price;
	// total no of tickets available for flight
	int tickets;
	// for adding passenger details
	ArrayList<String> passengerDetails;
	// for adding passenger id
	ArrayList<Integer> passengerIds;
	// for addding the total number of tickets booked by the passenger
	ArrayList<Integer> bookedTicketesPerPassenger;

	ArrayList<Integer> PassengerCost;

	// constructor to set the values.
	public Flight() {
		tickets = 50;
		id = id + 1;
		flightId = id;
		price = 5000;
		passengerDetails = new ArrayList<String>();
		passengerIds = new ArrayList<Integer>();
		bookedTicketesPerPassenger = new ArrayList<Integer>();
		PassengerCost = new ArrayList<Integer>();

	}

	public void addPassengerDetails(int passengerId, int noOfTickets, String PassengerDetails) {

		passengerDetails.add(PassengerDetails);
		passengerIds.add(passengerId);
		PassengerCost.add(noOfTickets * price);
		// increasing the ticket price after every successful booking
		price += 200 * noOfTickets;
		// decreasing the tickets after booking the no of tickets
		tickets -= noOfTickets;
		bookedTicketesPerPassenger.add(noOfTickets);
		System.out.println("BOOKED Successfully..!!");

	}
	
	
	public void cancel(int pId) {
		int indexToRemove = passengerIds.remove(pId);
		if(indexToRemove<0) {
			System.out.println("PassengerId not found..!!");
		}
		
		int ticketsToCancel = bookedTicketesPerPassenger.get(indexToRemove);
		tickets+=ticketsToCancel;
		price-= 200*ticketsToCancel;
		
		System.out.println("Refund After Cancellation: "+ PassengerCost.get(indexToRemove));
		passengerDetails.remove(indexToRemove);
		PassengerCost.remove(indexToRemove);
		bookedTicketesPerPassenger.remove(indexToRemove);
		passengerIds.remove(Integer.valueOf(pId));
		
		System.out.println("Cancellation Successful..!!");
	}
	
	public void printDetails() {
		System.out.println(" FlightId "+ flightId);
		for(String detail: passengerDetails) {
			System.out.println(detail);
		}
	}

	// to print flight details
	public void flightSummary() {
		System.out.println("FlightId: " + flightId +","+ " Tickets Available: " +","+ tickets + " Ticket Price: " +","+ price);
	}

}
