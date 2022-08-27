import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class TicketBook {

	static int availLb = 21;
	static int availMb = 21;
	static int availUb = 21;
	static int availRac = 9;
	static int availWl = 10;

	static List<Integer> lBp = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	static List<Integer> mBp = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	static List<Integer> uBp = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	static List<Integer> rAc = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
	static List<Integer> wL = new ArrayList<Integer>(Arrays.asList(1, 2));

	static Queue<Integer> wList = new LinkedList<Integer>();
	static Queue<Integer> racList = new LinkedList<Integer>();
	static List<Integer> bookedTicketsList = new ArrayList<Integer>();
	static Map<Integer, Passenger> passenger_stored_data = new HashMap<Integer, Passenger>();
	
	
	public void bookTicket(Passenger p, int sNumber, String allotedBerth) {
		p.number = sNumber;
		p.alloted = allotedBerth;
		passenger_stored_data.put(p.passengerId, p);
		bookedTicketsList.add(p.passengerId);
		
		System.out.println("Passenger Name "+p.name);
		System.out.println("Passenger Age "+p.age);
		System.out.println("Passenger Gender "+p.gender);
		System.out.println("Alloted berth "+sNumber+allotedBerth);
		System.out.println("============= Ticket Booked successfully===========");
		
	}
	
	public void cancelTicket(int passengerId) {
		Passenger p = passenger_stored_data.get(passengerId);
		passenger_stored_data.remove(passengerId);
		
		bookedTicketsList.remove(passengerId);		
	}
	
	public void addToRac(Passenger p, int racInfo, String allotedToRac) {
		p.number = racInfo;
		p.alloted = allotedToRac;
		passenger_stored_data.put(p.passengerId,p);
		racList.add(p.passengerId);
		//decrementing the available tickets once it is occupied
		availRac--;
		rAc.remove(0);
		System.out.println("Added to RAC Successfully..!!");
	}
	public void addToWaitingList(Passenger p, int wListInfo, String allotedToWl ) {
		p.number = wListInfo;
		p.alloted = allotedToWl;
		passenger_stored_data.put(p.passengerId, p);
		wList.add(p.passengerId);
		
		availWl--;
		wL.remove(0);
		System.out.println("Added to Waiting List Successfully..!!");
	}
	
	 public void printAvailable()
	    {
	        System.out.println("Available Lower Berths "  + availLb);
	        System.out.println("Available Middle Berths "  + availMb);
	        System.out.println("Available Upper Berths "  + availUb);
	        System.out.println("Availabel RACs " + availRac);
	        System.out.println("Available Waiting List " + availWl);
	        System.out.println("--------------------------");
	    }
	
}
