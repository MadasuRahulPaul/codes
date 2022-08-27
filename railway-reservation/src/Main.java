import java.util.Scanner;

public class Main {

	public static void bookTicket(Passenger p) {

		TicketBook booker = new TicketBook();
		// If Waiting list becomes Zero, which means all tickets are filled..
		if (booker.availWl == 0) {
			System.out.println("No tickets Available..!!");
			return;
		}

		if ((p.berthPreferance.equals("L") && booker.availLb > 0)
				|| (p.berthPreferance.equals("M") && booker.availMb > 0)
				|| (p.berthPreferance.equals("U") && booker.availUb > 0)) {
			System.out.println("Prefered Bert Availbale..!!");

			if (p.berthPreferance.equals("L")) {

				System.out.println("Lower Berth given..!!");
				// Assigning the passenger details into Lower berth position list position (0).
				booker.bookTicket(p, (TicketBook.lBp.get(0)), "L");
				TicketBook.lBp.remove(0);
				TicketBook.availLb--;

			} else if (p.berthPreferance.equals("M")) {
				System.out.println("Middle berth given..!!");

				booker.bookTicket(p, (TicketBook.mBp.get(0)), "M");
				TicketBook.uBp.remove(0);
				TicketBook.availMb--;
			} else if (p.berthPreferance.equals("U")) {
				System.out.println("Upper berth given..!!");

				booker.bookTicket(p, (TicketBook.uBp.get(0)), "U");
				TicketBook.uBp.remove(0);
				TicketBook.availUb--;
			}
		} else if (TicketBook.availLb > 0) {
			System.out.println("Waste berth given..!!");
			booker.bookTicket(p, TicketBook.lBp.get(0), "L");
			TicketBook.lBp.remove(0);
			TicketBook.availLb--;

		} else if (TicketBook.availMb > 0) {
			System.out.println("middle berth given");
			booker.bookTicket(p, TicketBook.mBp.get(0), "M");
			TicketBook.mBp.remove(0);
			TicketBook.availMb--;
		} else if (TicketBook.availUb > 0) {
			System.out.println("Upper berth Given..!!");
			booker.bookTicket(p, TicketBook.uBp.get(0), "U");
			TicketBook.uBp.remove(0);
			TicketBook.availUb--;
		} else if (TicketBook.availRac > 0) {
			System.out.println(" RAC Tickets available..!!");
			booker.addToRac(p, TicketBook.rAc.get(0), "RAC");
		} else if (TicketBook.availWl > 0) {
			System.out.println("Added to Waiting list..!!");
			booker.addToRac(p, TicketBook.wL.get(0), "WL");
		}
	}

	public static void cancelTicket(int id) {
		TicketBook booker = new TicketBook();

		if (!booker.passenger_stored_data.containsKey(id)) {
			System.out.println("Invalid Passenger details..!!");
		} else {
			booker.cancelTicket(id);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			System.out.println("1.Book \n2.Cancel \n3.Available Tickets \n4.Booked Tickets \n5.Exit");
			System.out.println("please select an option:");
			int choice = input.nextInt();
			switch (choice) {
			// booking
			case 1: {
				System.out.println("Enter Passenger Name:");
				String name = input.next();
				System.out.println("Enter the Age of passenger:");
				int age = input.nextInt();
				System.out.println("Please select the Gender - M / F / O");
				String gender = input.next();
				System.out.println("Please select Berth preferance - U / M / L");
				String berthPreferance = input.next();

				Passenger p = new Passenger(name, age, gender, berthPreferance);
				bookTicket(p);

			}
				break;
			// cancel
			case 2: {
				System.out.println("Enetr the Id to cancel the ticket.");
				int id = input.nextInt();
				cancelTicket(id);
			}
			case 3: {
				TicketBook booker = new TicketBook();
				booker.printAvailable();
			}

			case 5: {
				loop = false;
				System.out.println("Invalid Reservation...!!");
				break;

			}
			default: {
				System.out.println("Please select the listed option");
			}
			}
		}

	}

}
