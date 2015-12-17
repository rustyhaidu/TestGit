package valletparking;

abstract class Yamaha extends Motorcycle {

	private String brand = "Yamaha";

	@Override
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
