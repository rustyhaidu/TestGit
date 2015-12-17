package valletparking;

import static org.junit.Assert.*;

import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import valletparking.BMW;
import valletparking.Car;
import valletparking.Logan;
import valletparking.Ticket;
import valletparking.ValletParking;

public class CarValletTests {

	private ValletParking<Car> valletParking;
	private Car logan;
	private Car bmw;
	private Car bmw2;

	@Before
	public void setup() {
		valletParking = new ValletParking<Car>(5);
		logan = new Logan("g3etgwef", 23);
		bmw = new BMW("fafaqw21", 20);
		bmw2 = new BMW("fafaqw22", 21);

	}

	@Test
	public void testSpotsGenerator() {
		for (Entry<Integer, Ticket> entry : valletParking.getParkingSpotsMap().entrySet()) {
			assertNull(entry.getValue());
		}
	}

	@Test
	public void testFindEmptySpot() {
		int actual = valletParking.findEmptySpot();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDistanceToSpotForEvenSpotNumber() {
		double actual = valletParking.getDistanceToSpot(6);
		double expected = 0.5;
		assertEquals(expected, actual, 0.0);
	}

	@Test
	public void testGetDistanceToSpotForOddSpotNumber() {
		double actual = valletParking.getDistanceToSpot(5);
		double expected = 0.5;
		assertEquals(expected, actual, 0.0);
	}

	@Test
	public void testFindNextParkingSpot() {
		valletParking.parkVehicle(logan, new Ticket(logan.hashCode() - 3));
		int actual = valletParking.findEmptySpot();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void testParkedCar() {
		Ticket testTicket = new Ticket(logan.hashCode() - 1);
		valletParking.parkVehicle(logan, testTicket);

		if (valletParking.getParkedVehicles().get(testTicket).equals(logan)) {
			assertTrue(true);
		}

	}

	@Test
	public void testAdvancedParking() {
		valletParking.generateParkingSpots(5);
		Ticket loganTicket = new Ticket(logan.hashCode() - 2);
		Ticket bmwTicket = new Ticket(bmw.hashCode());
		Ticket bmw2Ticket = new Ticket(bmw2.hashCode());
		valletParking.parkVehicle(logan, loganTicket);
		valletParking.parkVehicle(bmw, bmwTicket);
		valletParking.parkVehicle(bmw2, bmw2Ticket);
		valletParking.retrieveVehicle(bmwTicket);
		int actual = valletParking.findEmptySpot();

		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testFullParking() {
		class ValletParkingSubClass extends ValletParking<Car> {

			public ValletParkingSubClass(int numberOfSpots) {
				super(numberOfSpots);
			}

			@Override
			public boolean isParkingIsFull() {
				return true;
			}
		}
		ValletParkingSubClass valletParkingSubClass = new ValletParkingSubClass(5);
		valletParkingSubClass.findEmptySpot();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParkTheSameCar() {
		Ticket loganTicket1 = new Ticket(logan.hashCode() + 1);
		Ticket loganTicket2 = new Ticket(logan.hashCode() + 2);
		valletParking.parkVehicle(logan, loganTicket1);
		valletParking.parkVehicle(logan, loganTicket2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSameTicketcreation() {
		new Ticket(logan.hashCode());
		new Ticket(logan.hashCode());
	}
}
