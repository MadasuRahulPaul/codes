import java.util.*;

public class Booking {

	public static void bookTaxi(int id, char pickupPoint, char dropPoint, int pickupTime, List<Taxi> freeTaxi) {
		int min = 999;
		int distanceBetweenPickAndDrop = 0;
		int earnings = 0;
		int nextFreeTime = 0;
		char nextSpot = 'Z';
		String tripDetails = "";
		Taxi bookedTaxi = null;

		for (Taxi t : freeTaxi) {
			int distanceBetweenCustomerAndTaxi = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;
			if (distanceBetweenCustomerAndTaxi < min) {
				bookedTaxi = t;
				distanceBetweenPickAndDrop = Math.abs((pickupPoint - '0') - (t.currentSpot - '0')) * 15;

				earnings = (distanceBetweenPickAndDrop-5)*10 +100;
				
				int dropTime = pickupTime + distanceBetweenPickAndDrop/15;
				nextFreeTime = dropTime;
				
				nextSpot = dropPoint;
				tripDetails = id +"		"+ id +"	 	"+ pickupPoint +"		"+ dropPoint +"		"+ pickupTime+"		"+dropTime +"		"+ earnings;
				min = distanceBetweenCustomerAndTaxi;
			}
		}
		  bookedTaxi.setDetails(true, nextFreeTime, nextSpot, bookedTaxi.totalEarnings+earnings, tripDetails);
	        
	        System.out.println("Taxi No" + bookedTaxi.id + " booked");

	}

	public static List<Taxi> createTaxi(int n) {
		// create an empty taxi list for adding the taxis.
		List<Taxi> taxis = new ArrayList<Taxi>();
		// create taxis
		for (int i = 0; i < n; i++) {
			Taxi t = new Taxi();
			taxis.add(t);
		}
		return taxis;
	}

	public static List<Taxi> getFreeTaxi(List<Taxi> taxis, int pickupTime, char pickupPoint) {
		List<Taxi> freeTaxi = new ArrayList<Taxi>();

		for (Taxi taxi : taxis) {
			// Taxi should be free
			// Taxi should have enough Time to reach the customer before pickup time
			if ((taxi.freeTime <= pickupTime)
					&& (Math.abs(taxi.currentSpot - '0') - (pickupPoint - '0') <= pickupTime - taxi.freeTime)) {
				freeTaxi.add(taxi);
			}
		}
		return freeTaxi;
	}

	public static void main(String[] args) {
		// create 4 Taxi's
		List<Taxi> taxis = createTaxi(4);

		Scanner input = new Scanner(System.in);
		int id = 1;
		while (true) {
			System.out.println("1 -- Book Taxi");
			System.out.println("2 -- Print Details");
			int choice = input.nextInt();
			switch (choice) 
			{
			case 1:
			{
				// get the derails from customer
				int customerId = id;
				System.out.println("Enter Pick up point");
				char pickupPoint = input.next().charAt(0);
				System.out.println("Enter Drop point");
				char dropPoint = input.next().charAt(0);
				System.out.println("Enter Pick up Time");
				int pickupTime = input.nextInt();

				// check if Pick and Drop point are valid or not
				if (pickupPoint < 'A' || dropPoint > 'F' || dropPoint < 'A' || pickupPoint > 'F')
				{
					System.out.println("Valid points are A, B, C, D, E, F");
					System.out.println("Exitting the Booking..!!");
					return;
				}
				List<Taxi> freeTaxi = getFreeTaxi(taxis, pickupTime, pickupPoint);
				if (freeTaxi.size() == 0)
				{
					System.out.println("Sorry No Taxi Available at the moment.!!");
					return;
				}
				bookTaxi(id, pickupPoint, dropPoint, pickupTime, freeTaxi);
				id++;
				break;

			}
			case 2:
	        {
	            //two functions to print details
	             for(Taxi t : taxis)
	                t.printDetails();
	            break;
	        }
	        default:
	            return;
	        }
			}
		}
	}


