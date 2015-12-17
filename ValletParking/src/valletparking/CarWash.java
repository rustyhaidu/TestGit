package valletparking;

/**
 * CarWash Class :  contains two Lists for the Todays Clients and Postponed Clients
 * Has getters for the first and last Element of the List (getLastElement used)
 * Methods for open and close shop (sets boolean isShopOpen)
 * standInLine method adds Cars to the postponed list and after they are washed, they are removed one by one
 * washCar method adds to the todaysClients list the next Car in Line to be washed
 */

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class CarWash {
	private boolean isShopOpen = false;

	private LinkedHashSet<Car> postPonedClients = new LinkedHashSet<Car>();
	private LinkedHashSet<Car> todaysClients = new LinkedHashSet<Car>();

	public void CarWashStandinLine(Car car) {

	}

	public Car getLastElement(final Collection<Car> c) {
		final java.util.Iterator<Car> itr = c.iterator();
		Object lastElement = itr.next();
		while (itr.hasNext()) {
			lastElement = itr.next();
		}
		return (Car) lastElement;
	}

	public Car getFirstElement(final Collection<Car> c) {
		final java.util.Iterator<Car> itr = c.iterator();
		Object lastElement = itr.next();
		return (Car) lastElement;
	}

	public void standInLine(Car car) {
		if (isShopOpen) {
			postPonedClients.add(car);
		} else {
			System.out.println("Shop is Closed!");
		}
	}

	public void washCar() {
		if (isShopOpen) {
			todaysClients.add(getFirstElement(postPonedClients));
			postPonedClients.remove(getFirstElement(postPonedClients));
		} else {
			System.out.println("Shop is Closed!");
		}
	}

	public void openShop() {
		isShopOpen = true;
	}

	public void closeShop() {
		isShopOpen = false;
	}

	public HashSet<Car> getTodaysClients() {

		return todaysClients;
	}

	public HashSet<Car> getPostponedClients() {

		return postPonedClients;
	}

}
