package shapeCalculator;

import java.util.ArrayList;
import java.util.List;

public class ShapeCatalog {
	
	List<Shape> shapeList = new ArrayList<>();
	
	
	private double allPerimetersSummed = 0.0;
	private double allSurfacesSummed = 0.0;
	private boolean okToAdd=true;
	
	public double getAllPerimetersSummed() {
		for (Shape s : shapeList){			
			allPerimetersSummed = allPerimetersSummed + s.getPerimeter();					
		}
		return allPerimetersSummed;
	}

	public double getAllSurfacesSummed() {
		for (Shape s : shapeList){							
			allSurfacesSummed = allSurfacesSummed +s.getSurface();
		}
		return allSurfacesSummed;
	}	
	
	public void addShape(Shape s){		
		for (Shape shape : shapeList){	
			if (shape.equals(s)){
				okToAdd=false;				
				break;
			}else{
				okToAdd = true;
			}
		}
		if (okToAdd){
			shapeList.add(s);
		}else{
			 throw new IllegalArgumentException("Shape already exists!!!");      
		}
	}
}
