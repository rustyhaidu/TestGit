package shapeCalculator;

public class Circle extends Shape {
	private int radius;
	private double pi = Math.PI;
	public int getRadius() {
		return radius;
	}
	public Circle(int radius) {
		this.radius = radius;
	}
	@Override
	public double getPerimeter() {
		return 2 * pi * radius;
	}
	@Override
	public double getSurface() {
		return pi * radius * radius;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + radius;
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
		Circle other = (Circle) obj;
		if (radius != other.radius)
			return false;
		return true;
	}
	

}
