package valletparking;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private int ticketNumber;

	static List<Integer> ticketList = new ArrayList<>();

	public Ticket(int ticketNumber) {
		this.ticketNumber = Math.abs(ticketNumber);
		if (ticketList.contains(ticketNumber)) {
			throw new IllegalArgumentException("Ticket Number already exists!");
		} else {
			ticketList.add(ticketNumber);
		}

	}

	public int getTicketNumber() {
		return ticketNumber;
	}
}
