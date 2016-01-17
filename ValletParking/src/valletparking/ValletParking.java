package valletparking;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ValletParking<T extends Vehicle> {

	private T t;

	private Map<Integer, Ticket> parkingSpotsMap = new HashMap<>();
	private Map<Ticket, T> parkedVehicles = new HashMap<>();

	public boolean equals(Object other) {
		if (other instanceof ValletParking<?>) {
			if (((ValletParking<?>) other).t.equals(t)) {
				return true;
			}
		}
		return false;
	}

	public Map<Integer, Ticket> getParkingSpotsMap() {
		return parkingSpotsMap;
	}

	// TODO CODE REVIEW: you should either return true&false, or just validate an throw an exception. You are doing both in this method.
	public boolean vehicleAlreadyExists(T t) {
		for (Entry<Ticket, T> entry : parkedVehicles.entrySet()) {
			if (entry.getValue().equals(t)) {
				throw new IllegalArgumentException("Car was already parked!");
			}
		}
		return false;
	}

	// TODO CODE REVIEW: The name sounds bad -> usParkingIsFull?! doesn't isParkingFull sound better?
	public boolean isParkingIsFull() {
		for (Entry<Integer, Ticket> entry : parkingSpotsMap.entrySet()) {
			if (entry.getValue() == null) {
				return false;
			}
		}
		return true;
	}

	public Map<Ticket, T> getParkedVehicles() {
		return parkedVehicles;
	}

	public ValletParking(int numberOfSpots) {
		generateParkingSpots(numberOfSpots);
	}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public int findEmptySpot() {
		if (isParkingIsFull()) {
			/* TODO CODE REVIEW: You should use your own exception for this scenario. 
			 * RuntimeException (IndexOutOfBoundsException is part of them) should be used 
			 * for programming errors only.
			 */
			throw new IndexOutOfBoundsException("Parking Spots taken!");
		}
		for (Entry<Integer, Ticket> entry : parkingSpotsMap.entrySet()) {
			if (entry.getValue() == null) {
				return entry.getKey();
			}
		}

		return 0;
	}

	public double getDistanceToSpot(int spot) {
		double distance = (double) spot;
		if (spot < 1) {
			throw new IllegalArgumentException("Enter positive value!");
		}
		if (spot % 2 == 0 && spot > 0) {
			return (distance - 1) / 10;
		} else {
			return distance / 10;
		}
	}

	public void parkVehicle(T t, Ticket ticket) {
		vehicleAlreadyExists(t);
		int spot = findEmptySpot();
		double distanceToDrive = getDistanceToSpot(spot);
		t.start();
		t.drive(distanceToDrive);
		parkingSpotsMap.put(spot, ticket);
		parkedVehicles.put(ticket, t);
		t.stop();
	}

	public T retrieveVehicle(Ticket ticket) {
		T vehicle = null;
		int spot = 0;
		for (Entry<Integer, Ticket> entry : parkingSpotsMap.entrySet()) {
			if (entry.getValue() == ticket) {
				spot = entry.getKey();
			}
		}
		for (Entry<Ticket, T> entry : parkedVehicles.entrySet()) {
			if (entry.getKey() == ticket) {
				vehicle = entry.getValue();
				parkingSpotsMap.put(spot, null);
			}
		}
		parkingSpotsMap.put(spot, null);
		vehicle.start();
		vehicle.drive(getDistanceToSpot(spot));
		vehicle.stop();
		return vehicle;
	}

	final void generateParkingSpots(int NumberOfSpots) {
		for (int i = 1; i <= NumberOfSpots; i++) {
			parkingSpotsMap.put(i, null);
		}
	}
}
