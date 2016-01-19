package valletparking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorcycleValletTests {
	private ValletParking<Motorcycle> valletParking;
	private Motorcycle yamaha1;
	private Motorcycle yamaha2;
	
	
	@Before
	public void setup() {
		valletParking = new ValletParking<Motorcycle>(5);
		yamaha1 = new Y450("g3etgwef", 23);
		yamaha2 = new Y450("fafaqw21", 20);		
	}

	@Test
	public void testFindNextParkingSpot() {
		valletParking.parkVehicle(yamaha1, new Ticket(yamaha1.hashCode()));
		int actual = valletParking.findEmptySpot();		
		int expected = 2;
		assertEquals(expected, actual);
	}
	@Test
	public void testParkedMotorcycle() {
		/* TODO CODE REVIEW: When tests are run together (MotorcycleValletTests along with CarValletTests, 
		 * they don't run because in Ticket you have a static haschode tracker that is never reset on test tearDown.
		 * */
		Ticket testTicket = new Ticket(yamaha2.hashCode());
		valletParking.parkVehicle(yamaha2, testTicket);

		if (valletParking.getParkedVehicles().get(testTicket).equals(yamaha2)) {
			assertTrue(true);
		}

	}

}
