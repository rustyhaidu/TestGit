package shapeCalculator;


public class Main {
	
	public static void main(String... args){
		
		ShapeCatalog shapeCatalog = new ShapeCatalog();
		
		Square square = new Square(5);		
		Circle circle = new Circle(6);
		Triangle triangle = new Triangle(3,4,5); //dreptunghic
		Rectangle rectangle = new Rectangle(3,4);
		
		
		shapeCatalog.addShape(square);
		System.out.println(shapeCatalog.getAllPerimetersSummed());
		System.out.println(shapeCatalog.getAllPerimetersSummed());
		
		shapeCatalog.addShape(rectangle);
		System.out.println(shapeCatalog.getAllPerimetersSummed());		
		
		System.out.println(shapeCatalog.getAllPerimetersSummed());
		System.out.println(shapeCatalog.getAllSurfacesSummed());		
	}

}
