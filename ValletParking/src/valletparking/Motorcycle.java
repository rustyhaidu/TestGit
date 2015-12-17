package valletparking;

import java.util.HashMap;
import java.util.Map;

public abstract class Motorcycle implements Vehicle {

	public abstract String getBrand();

	private boolean isEngineStarted;
	private int gear;
	private int numberOfGears;
	private int tankCapacity;
	private boolean okToDrive;

	private double averageEstimatedConumption = 0;

	private double availableFuel;
	private double consumptionFuel;
	private double pollution = 0;

	private double totalKm;
	private double initialFuel;

	private String chassisNumber;
	private String model;
	private String fuelType;

	public boolean isOkToDrive() {
		return okToDrive;
	}

	public void setConsumptionFuel(double consumptionFuel) {
		this.consumptionFuel = consumptionFuel;
	}

	public double getConsumptionFuel() {
		return consumptionFuel;
	}

	private Map<Integer, Double> consumptionHashMap = new HashMap<Integer, Double>();
	private Map<Integer, Double> pollutionHashMap = new HashMap<Integer, Double>();

	public double getAverageEstimatedConsumption() {
		for (int i = 0; i < getNumberOfGears() + 1; i++) {
			averageEstimatedConumption = averageEstimatedConumption + consumptionHashMap.get(i);
		}
		return averageEstimatedConumption / getNumberOfGears();
	}

	public void addToConsumptionHashMap(int gear, double consumption) {
		consumptionHashMap.put(gear, consumption);
	}

	public void addToPollutionHashMap(int gear, double consumption) {
		pollutionHashMap.put(gear, consumption);
	}

	public void setConsumptionLevels(double gear0, double gear1, double gear2, double gear3, double gear4,
			double gear5) {
		addToConsumptionHashMap(0, gear0);
		addToConsumptionHashMap(1, gear1);
		addToConsumptionHashMap(2, gear2);
		addToConsumptionHashMap(3, gear3);
		addToConsumptionHashMap(4, gear4);
		addToConsumptionHashMap(5, gear5);
	}

	public void setPollutionLevels(double gear0, double gear1, double gear2, double gear3, double gear4, double gear5) {
		addToPollutionHashMap(0, gear0);
		addToPollutionHashMap(1, gear1);
		addToPollutionHashMap(2, gear2);
		addToPollutionHashMap(3, gear3);
		addToPollutionHashMap(4, gear4);
		addToPollutionHashMap(5, gear5);
	}

	public void setConsumptionLevels(double gear0, double gear1, double gear2, double gear3, double gear4, double gear5,
			double gear6) {
		addToConsumptionHashMap(0, gear0);
		addToConsumptionHashMap(1, gear1);
		addToConsumptionHashMap(2, gear2);
		addToConsumptionHashMap(3, gear3);
		addToConsumptionHashMap(4, gear4);
		addToConsumptionHashMap(5, gear5);
		addToConsumptionHashMap(6, gear6);
	}

	public void setPollutionLevels(double gear0, double gear1, double gear2, double gear3, double gear4, double gear5,
			double gear6) {
		addToPollutionHashMap(0, gear0);
		addToPollutionHashMap(1, gear1);
		addToPollutionHashMap(2, gear2);
		addToPollutionHashMap(3, gear3);
		addToPollutionHashMap(4, gear4);
		addToPollutionHashMap(5, gear5);
		addToPollutionHashMap(6, gear6);
	}

	public double getAverageConsumption(double initialFuel, double totalKm) {
		return (100 * initialFuel) / totalKm;
	}

	public double getTotalKm() {
		return totalKm;
	}

	public void setInitialFuel(double initialFuel) {
		this.initialFuel = initialFuel;
	}

	public double getInitialFuel() {
		return initialFuel;
	}

	public void setTotalKm(double totalKm) {
		this.totalKm = totalKm;
	}

	@Override
	public void drive(double kilometers) {
		if (okToDrive) {
			// setValues();

			setConsumptionFuel(kilometers * getConsumptionValuePerGear(getGear()) / 100);
			setPollution(getPollution() + (kilometers * getPollutionValuePerGear(getGear())) / 100);

			if (availableFuel - consumptionFuel < 0) {
				double kilometersToBeMade = (availableFuel * 100) / getConsumptionValuePerGear(getGear());
				availableFuel = 0;
				totalKm = totalKm + kilometersToBeMade;

				stop();
			} else {
				availableFuel = availableFuel - consumptionFuel;

				totalKm = totalKm + kilometers;
			}
		} else {
			System.out.println("Start Car First!");
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorcycle other = (Motorcycle) obj;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		return true;
	}

	public int getGear() {
		return gear;
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void start() {
		isEngineStarted = true;
		shiftGear(1);
	}

	public void setTankCapacity(int liters) {
		tankCapacity = liters;
	}

	public int getTankCapacity() {
		return tankCapacity;
	}

	public final void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public void stop() {
		isEngineStarted = false;
		okToDrive = false;
		gear = 0;
	}

	public boolean getStatusEngine() {
		return isEngineStarted;
	}

	public int getShiftedGear() {
		return gear;
	}

	public void shiftGear(int gear) {
		if (isEngineStarted && (this.gear == 1 || gear == 1)) {
			okToDrive = true;
			this.gear = gear;
		}
		if (okToDrive) {
			if (gear < 0 || gear > numberOfGears) {
				this.gear = 0;
			}
			this.gear = gear;
		} else if (!isEngineStarted) {
			if (getAvailableFuel() > 0) {
				System.out.println("Shift to 1st Gear first!");
			} else {
				System.out.println("Tank Empty, No use to change Gear!");
			}

		}
	}

	public double getConsumptionValuePerGear(int gear) {
		return consumptionHashMap.get(gear);
	}

	public double getPollutionValuePerGear(int gear) {
		return pollutionHashMap.get(gear);
	}

	public double getPollution() {
		return pollution;
	}

	public void setPollution(double pollution) {
		this.pollution = pollution;
	}

	public double getAvailableFuel() {
		return availableFuel;
	}

	public void setAvailableFuel(double availableFuel) {
		this.availableFuel = availableFuel;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void fuelOverLoadException() {
		if (availableFuel > tankCapacity) {
			throw new IllegalArgumentException("Car tank Overloaded!");
		}
	}

}
