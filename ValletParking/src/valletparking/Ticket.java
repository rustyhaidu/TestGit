package valletparking;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private int ticketNumber;

	static List<Integer> ticketList = new ArrayList<>();

	/* TODO CODE REVIEW: If a ticket has a number and it is used to identify tickets,
	 * The value should be created / managed by the Ticket class. NOT passed in by someone else.
	 * Consider generating a unique UUID (java has a standard library for this).
	 */
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
