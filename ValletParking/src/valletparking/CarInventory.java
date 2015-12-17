package valletparking;

/**
 *  CarInventory Class: contains the carInventoryList.
 *  Methods for finding, adding and removing a car.
 *  And getting the averageConsumption car based on its gear based Consumption value
 */

import java.util.ArrayList;
import java.util.List;

public class CarInventory {

	private List<Car> carInventory = new ArrayList<Car>();

	public void addCar(Car car) {
		carInventory.add(car);
	}

	public Car findCar(String chassisNumber) {

		for (Car carElement : carInventory) {
			if (carElement.getChassisNumber() == chassisNumber) {
				return carElement;
			}
		}
		return null;
	}

	public void removeCar(String chassisNumber) {

		for (Car carElement : carInventory) {
			if (carElement.getChassisNumber() == chassisNumber) {
				carInventory.remove(carElement);
				break;
				// System.out.println("Found!");
			}
		}
	}

	public Car getMostFuelEfficientCar() {
		double minAverageConsumption = carInventory.get(0).getAverageEstimatedConsumption();
		Car car = null;
		for (int i = 0; i < carInventory.size(); i++) {
			// System.out.println(carInventory.get(i).getModel());
			if (minAverageConsumption < carInventory.get(i).getAverageEstimatedConsumption()) {
				minAverageConsumption = carInventory.get(i).getAverageEstimatedConsumption();
				car = carInventory.get(i);
			} else {
				car = carInventory.get(0);
			}
		}
		return car;
	}
}
