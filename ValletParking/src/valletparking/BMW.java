package valletparking;



public class BMW extends VW{

	private String MODEL="BMW";
	private int TANK_CAPACITY=55;		
	private int NUMBER_OF_GEARS=6;	
	private String FUEL_TYPE = "DIESEL";
	
	public BMW(String chassisNumber, int initialFuel){
		
		setChassisNumber(chassisNumber);		
		setNumberOfGears(NUMBER_OF_GEARS);
		setAvailableFuel((double)initialFuel);
		setInitialFuel((double)initialFuel);
		setTankCapacity(TANK_CAPACITY);		
		setModel(MODEL);
		setFuelType(FUEL_TYPE);
		
		fuelOverLoadException();
		setConsumptionLevels(0,5.7,5.2,6.8,8.2,7.7,8.3);
		setPollutionLevels(0,0.11,0.21,0.32,0.4,0.6,0.66);
	}
}