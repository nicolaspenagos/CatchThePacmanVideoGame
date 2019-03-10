package ui;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;


public class PacMan extends Shape{
	
	//-------------------------------------
	// ATRIBUTTES 
	//-------------------------------------
	
	private double xCoordinate;
	private double yCoordinate; 
	private Arc body; 
	private Circle eye; 

	
	//-------------------------------------
	// CONSTRUCTOR
	//-------------------------------------
	public PacMan(double x, double y){
		
		xCoordinate = x; 
		yCoordinate = y; 
		
		Arc body = new Arc();
    	Circle eye = new Circle(3.0); 
    
        body.setCenterX(x);
        body.setCenterY(y);
        body.setRadiusX(15.0);
        body.setRadiusY(15.0);
        body.setStartAngle(30.0);
        body.setLength(300.0);
        body.setFill(Color.YELLOW);
        body.setType(ArcType.ROUND);
      
        eye.setLayoutX(x+2);
        eye.setLayoutY(y-8);
        eye.setFill(Color.BLACK);
	}
	
	//-------------------------------------
	// GETTERS AND SETTERS
	//-------------------------------------
	
	public double getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	@Override
	public com.sun.javafx.geom.Shape impl_configShape() {
		// TODO Auto-generated method stub
		return null;
	}
}
