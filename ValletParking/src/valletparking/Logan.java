package valletparking;

public class Logan extends Dacia {
	private final String MODEL = "Logan";
	private final int TANK_CAPACITY = 50;
	private final int NUMBER_OF_GEARS = 5;
	private final String FUEL_TYPE = "PETROL";

	public Logan(String chassisNumber, int initialFuel) {

		setChassisNumber(chassisNumber);
		setNumberOfGears(NUMBER_OF_GEARS);
		setAvailableFuel((double) initialFuel);
		setInitialFuel((double) initialFuel);
		setTankCapacity(TANK_CAPACITY);
		setModel(MODEL);
		setFuelType(FUEL_TYPE);

		fuelOverLoadException();
		setConsumptionLevels(0, 4.7, 5.2, 6.8, 8.2, 7.7);
		setPollutionLevels(0, 0.1, 0.2, 0.3, 0.5, 0.8);
	}
}
