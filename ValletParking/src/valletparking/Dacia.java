package valletparking;

abstract class Dacia extends Car {
	private String brand = "Dacia";

	@Override
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
