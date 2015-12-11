package shapeCalculator;

public class Square extends Shape{
	private int side;	
	public int getSide() {
		return side;
	}
	public Square(int side){
		this.side = side;
	}	
	@Override
	public double getPerimeter() {
		return side*4;		
	}
	@Override
	public double getSurface() {
		return 	 side*side;		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + side;
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
		Square other = (Square) obj;
		if (side != other.side)
			return false;
		return true;
	}	
}
