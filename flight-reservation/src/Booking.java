import java.util.*;

public class Booking {

	public static void book(Flight currentFlight, int noOfTickets, int passengerId) {

		String passengerDetails = "";

		passengerDetails = "PassengerID = " + passengerId + "No of Tickets Booked = " + noOfTickets + "Total Cost = "
				+ noOfTickets * currentFlight.price;

		currentFlight.addPassengerDetails(passengerId, noOfTickets, passengerDetails);
		currentFlight.flightSummary();
	}

	public static void cancelticket(int pId, Flight currentFlight) {
		currentFlight.cancel(pId);
		currentFlight.flightSummary();
	}

	public static void print(Flight flight) {
		flight.printDetails();
	}

	public static void main(String[] args) {

		// create flights
		ArrayList<Flight> flights = new ArrayList<Flight>();
		for (int i = 0; i < 2; i++) {
			flights.add(new Flight());
		}

		int passengerId = 1;

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("Please select your Option.!!");
			System.out.println("1.Book -- 2.Cancel -- 3.Flight Details");
			int choice = input.nextInt();
			switch (choice) {
			// Booking
			case 1: {
				// checking the if the flight Id is valid or not
				System.out.println("Enter Flight Id: ");
				int flightId = input.nextInt();
				if (flightId > flights.size()) {
					System.out.println("Invalid Flight Id..!!");
					break;
				}
				// Checking of the flight Id is available in the list or not
				Flight currentFlight = null;
				for (Flight f : flights) {
					if (flightId == f.flightId) {
						currentFlight = f;
						f.flightSummary();
						break;
					}
				}

				System.out.println("Enter No of tickets to Book.!!");
				// checking if noOfTickets are available in the currentFlight
				int noOfTickets = input.nextInt();
				if (noOfTickets > currentFlight.tickets) {
					System.out.println("Not enought tickets.!!");
				}
				// Calling the ook ticket function
				book(currentFlight, noOfTickets, passengerId);
				// incrementing the passengerID value to get the new passengerId
				passengerId = passengerId + 1;
				break;
			}
			case 2: {

				System.out.println("Enter FlightId and PassengerID for cancelling the ticket");
				int fId = input.nextInt();
				if (fId > flights.size()) {
					System.out.println("Invalid FlightId..!!");
				}
				Flight currentFlight = null;
				for (Flight flight : flights) {
					if (fId == flight.flightId) {
						currentFlight = flight;
						break;
					}
				}
				System.out.println("Enter the passengerId");
				int pId = input.nextInt();
				cancelticket(pId, currentFlight);
				break;

			}
			case 3: {
				for (Flight flight : flights) {
					if (flight.passengerDetails.size() == 0) {
						System.out.println("No Passenger details available..!!");
					} else {
						print(flight);
					}
				}
				break;
			}
			default: {
				System.out.println(" Please select below listed options..!!");
				break;
			}
			}

		}
	}

}
