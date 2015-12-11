package shapeCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class shapeCalculatorTests {

	Square square;
	Circle circle;
	Triangle triangle;
	Rectangle rectangle;	
	ShapeCatalog shapeCatalog;
	Square square2;
	Triangle triangle2;
		
	@Before
	public void setup() {	
		square = new Square(5);
		circle = new Circle(6);
		triangle = new Triangle(3,4,5); //dreptunghic
		rectangle = new Rectangle(8,9);
		shapeCatalog = new ShapeCatalog();	
		square2 = new Square(5);
		triangle2 = new Triangle(5,4,3);
		
		shapeCatalog.addShape(square);
		shapeCatalog.addShape(circle);
		shapeCatalog.addShape(triangle);
		shapeCatalog.addShape(rectangle);	
	}
	@Test
	public void testSquarePerimeter() {
		double actual = square.getPerimeter();
		double expected = 20;
		assertEquals(expected, actual,0.0);
	}
	@Test
	public void testSquareSurface() {
		double actual = square.getSurface();
		double expected = 25;
		assertEquals(expected, actual,0.0);
	}
	@Test
	public void testRectangleSurface() {
		double actual = rectangle.getSurface();		
		double expected = 72;
		assertEquals(expected, actual,0.0);
	}
	@Test
	public void testRectanglePerimeter() {
		double actual = rectangle.getPerimeter();		
		double expected = 34;
		assertEquals(expected, actual,0.0);
	}
	@Test
	public void testTrianglePerimeter() {
		double actual = triangle.getPerimeter();		
		double expected = 12;
		assertEquals(expected, actual,0.0);
	}
	@Test
	public void testTriangleSurface() {
		double actual = triangle.getSurface();		
		double expected = 6;
		assertEquals(expected, actual,0.0);
	}
	@Test
	public void testCircleSurface() {
		double actual = circle.getSurface();		
		double expected = 113;
		assertEquals(expected, actual,0.1);
	}
	@Test
	public void testCirclePerimeter() {
		double actual = circle.getPerimeter();		
		double expected = 37.68;
		assertEquals(expected, actual,0.1);
	}
	@Test
	public void testAllPerimeterSummed() {
		double actual = shapeCatalog.getAllPerimetersSummed();		
		double expected = 103.69;
		assertEquals(expected, actual,0.1);
	}
	@Test
	public void testAllSurfaceSummed() {
		double actual = shapeCatalog.getAllSurfacesSummed();		
		double expected = 216.097;
		assertEquals(expected, actual,0.1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddTheSameShape() {
		
		shapeCatalog.addShape(square2);
	}
	@Test
	public void testAddTheSameShapeWithTryCatch() {
		try {			
			shapeCatalog.addShape(square);
			fail("You cannot add the same Shape");
		} catch (IllegalArgumentException ex) {
			System.out.println("Cannot add the Same shape");
		}
	}
}
