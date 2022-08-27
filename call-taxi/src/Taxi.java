import java.util.*;

public class Taxi {
	static int taxiCount = 0;
	int id;
	int totalEarnings;
	int freeTime;
	char currentSpot;
	List<String> trips;
	boolean booked;

	public Taxi() {
		id = 0;
		int toatalEarnings = 0;
		freeTime = 6; // FreeTime at 6 AM
		currentSpot = 'A'; // Starting point
		trips = new ArrayList<String>();// Adding the Trip details of Taxi into a Array
		booked = true;
		taxiCount = taxiCount + 1; // Every time a taxi is created the Id will be incremented
		id = taxiCount;
	}

	public void setDetails(boolean booked, int freeTime, char currentSpot, int totalEarnings, String tripDetails) {
		this.booked = booked;
		this.freeTime = freeTime;
		this.currentSpot = currentSpot;
		this.totalEarnings = totalEarnings;
		this.trips.add(tripDetails);

	}

	public void printDetails() {
		System.out.println("Taxi No" + this.id + " TotalEarings " + this.totalEarnings);
		System.out.println(
				"BookingId	"+ "CustomerId	"+ "From	"+"To	"+"PickUp Time	"+"DropTime	"+"Earnings	");
		for (String trip : trips) {
			System.out.println(id + "       " + trip);
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

}
