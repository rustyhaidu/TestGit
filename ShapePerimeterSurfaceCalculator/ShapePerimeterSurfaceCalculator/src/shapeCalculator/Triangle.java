package shapeCalculator;

public class Triangle extends Shape{
	
private int side1;
public int getSide1() {
	return side1;
}
public int getSide2() {
	return side2;
}
public int getSide3() {
	return side3;
}

private int side2;
private int side3;

public Triangle(int side1, int side2, int side3){
	this.side1 = side1;
	this.side2 = side2;
	this.side3 = side3;		
}	
	@Override
	public double getPerimeter() {
		return side1 + side2 + side3;	
	}

	@Override
	public double getSurface() {
		double s = getPerimeter()/2;
		double x = (s * (s-side1) * (s-side2) * (s-side3));
						
		return Math.sqrt(x);		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + side1;
		result = prime * result + side2;
		result = prime * result + side3;
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
		Triangle other = (Triangle) obj;
		if (side1 != other.side1)
			return false;
		if (side2 != other.side2)
			return false;
		if (side3 != other.side3)
			return false;
		return true;
	}
	
}
