package valletparking;

public class Main {

	public static void main(String[] args) {

		Car logan = new Logan("oiqe0934hkkadsn", 27);
		Car bmw = new BMW("oiye0434h124gdsn", 30);

		Motorcycle y450 = new Y450("oizesa4h124gdsn", 15);

		ValletParking<Car> carPark = new ValletParking<Car>(100);
		Ticket ticketLogan = new Ticket(logan.hashCode());

		System.out.println(logan.getAvailableFuel());
		carPark.parkVehicle(logan, ticketLogan);
		System.out.println(logan.getAvailableFuel());
		carPark.retrieveVehicle(ticketLogan);
		System.out.println(logan.getAvailableFuel());
		System.out.println(ticketLogan.getTicketNumber());
		System.out.println();

		Ticket ticketBMW = new Ticket(bmw.hashCode());

		System.out.println(bmw.getAvailableFuel());
		carPark.parkVehicle(bmw, ticketBMW);
		System.out.println(bmw.getAvailableFuel());
		carPark.retrieveVehicle(ticketBMW);
		System.out.println(bmw.getAvailableFuel());
		System.out.println(ticketBMW.getTicketNumber());
		System.out.println();

		ValletParking<Motorcycle> motorcyclePark = new ValletParking<Motorcycle>(100);
		Ticket ticketYamaha = new Ticket(y450.hashCode());
		System.out.println(y450.getAvailableFuel());
		motorcyclePark.parkVehicle(y450, ticketYamaha);
		System.out.println(y450.getAvailableFuel());
		motorcyclePark.retrieveVehicle(ticketYamaha);
		System.out.println(y450.getAvailableFuel());
		System.out.println(ticketYamaha.getTicketNumber());
	}
}
