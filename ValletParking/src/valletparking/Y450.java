package valletparking;

public class Y450 extends Yamaha {
	private final String MODEL = "Kellet";
	private final int TANK_CAPACITY = 150;
	private final int NUMBER_OF_GEARS = 3;
	private final String FUEL_TYPE = "PETROL";

	public Y450(String chassisNumber, int initialFuel) {

		setChassisNumber(chassisNumber);
		setNumberOfGears(NUMBER_OF_GEARS);
		setAvailableFuel((double) initialFuel);
		setInitialFuel((double) initialFuel);
		setTankCapacity(TANK_CAPACITY);
		setModel(MODEL);
		setFuelType(FUEL_TYPE);

		fuelOverLoadException();
		setConsumptionLevels(0, 3.7, 4.2, 5.8, 7.2, 6.7);
		setPollutionLevels(0, 0.15, 0.21, 0.32, 0.53, 0.81);
	}

}
