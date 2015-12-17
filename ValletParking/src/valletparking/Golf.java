package valletparking;

public class Golf extends VW {

	private String MODEL = "Golf";
	private int TANK_CAPACITY = 55;
	private int NUMBER_OF_GEARS = 6;
	private String FUEL_TYPE = "DIESEL";

	public Golf(String chassisNumber, int initialFuel) {

		setChassisNumber(chassisNumber);
		setNumberOfGears(NUMBER_OF_GEARS);
		setAvailableFuel((double) initialFuel);
		setInitialFuel((double) initialFuel);
		setTankCapacity(TANK_CAPACITY);
		setModel(MODEL);
		setFuelType(FUEL_TYPE);

		fuelOverLoadException();
		setConsumptionLevels(0, 4.6, 5.4, 6.5, 8.0, 8.7, 9.3);
		setPollutionLevels(0, 0.15, 0.22, 0.34, 0.58, 0.8, 0.85);
	}
}
