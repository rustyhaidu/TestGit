package valletparking;

abstract class VW extends Car {
	private String brand = "VolfWagen";

	@Override
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}