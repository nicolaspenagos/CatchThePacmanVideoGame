package ui;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;



public class PacMan{
	
	//-------------------------------------
	// CONSTANTS 
	//-------------------------------------
	public static final double SIZE1 = 10.0;
	public static final double SIZE2 = 15.0;
	public static final double SIZE3 = 20.0;
	
	//-------------------------------------
	// ATRIBUTTES 
	//-------------------------------------
	
	private double xCoordinate;
	private double yCoordinate; 
	private Arc body; 
	private Circle eye; 
	private Pane pane; 
	private double size; 


	
	//-------------------------------------
	// CONSTRUCTOR
	//-------------------------------------
	public PacMan(double x, double y, Pane px, double sx){
		
		xCoordinate = x; 
		yCoordinate = y;
		pane = px;
		size = sx; 
		int xEyeC=0;
		int yEyeC=0;
		
		body = new Arc();
    	eye = new Circle(3.0); 
    
        body.setCenterX(x);
        body.setCenterY(y);
        body.setRadiusX(size);
        body.setRadiusY(size);
        body.setStartAngle(30.0);
        body.setLength(300.0);
        body.setFill(Color.YELLOW);
        body.setType(ArcType.ROUND);
        if(size==SIZE1) {
	       xEyeC=2;
	       yEyeC=8;
        }
        
        eye.setLayoutX(x+xEyeC);
        eye.setLayoutY(y-yEyeC);
        eye.setFill(Color.BLACK);
        
        pane.getChildren().add(body);
        pane.getChildren().add(eye);
        
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
	
	public void move(double x, double y) {
		body.setLayoutX(x-xCoordinate);
    	body.setLayoutY(y-yCoordinate);
    	
    	eye.setLayoutX(x+2);
        eye.setLayoutY(y-8);
	}
}
