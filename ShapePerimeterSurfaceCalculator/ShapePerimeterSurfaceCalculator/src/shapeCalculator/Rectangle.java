package shapeCalculator;

public class Rectangle extends Shape {
	private int width;
	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	private int length;

	public Rectangle(int width, int length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double getPerimeter() {
		return (width + length) * 2;
	}

	@Override
	public double getSurface() {
		return width * length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + width;
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
		Rectangle other = (Rectangle) obj;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	

}