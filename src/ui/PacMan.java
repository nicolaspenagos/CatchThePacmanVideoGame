package ui;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import model.PacManModel;



public class PacMan{
	
	//-------------------------------------
	// CONSTANTS 
	//-------------------------------------
	public static final double SIZE1 = 15.0;
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
	private char orientation;
	private int counter;
	private boolean open;
	


	
	//-------------------------------------
	// CONSTRUCTOR
	//-------------------------------------
	public PacMan(double x, double y, Pane px, double sx, char o){
		
		xCoordinate = x; 
		yCoordinate = y;
		pane = px;
		size = sx; 
		orientation = o;
		counter = 0;
		boolean open = true;
		int xEyeC=0;
		int yEyeC=0;
		
		body = new Arc();
    	eye = new Circle(3.0); 
    
        body.setCenterX(x);
        body.setCenterY(y);
        body.setRadiusX(size);
        body.setRadiusY(size);
        if(orientation == PacManModel.LEFT)
        	body.setStartAngle(200.0);
        if(orientation == PacManModel.RIGHT)
        	body.setStartAngle(30.0);
        body.setLength(300);
        body.setFill(Color.YELLOW);
        body.setType(ArcType.ROUND);
       
	    xEyeC=2;
	    yEyeC=8;
        
	    if(orientation == PacManModel.UP||orientation == PacManModel.DOWN)
	    	 xEyeC=-2;
        
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
	
	public void move(double x, double y, char o) {
		
		char actualO = o;
		if(actualO == PacManModel.LEFT) 
			body.setStartAngle(200.0);
		
	    if(actualO == PacManModel.RIGHT)
	    	body.setStartAngle(30.0);
	    
	    if(actualO == PacManModel.UP) 
			body.setStartAngle(100);
		
	    if(actualO == PacManModel.DOWN)
	    	body.setStartAngle(290);
	    
	    if(counter%15==0) 
	    	open = !open; 
	     	
	    
	    if(open) {
	    	body.setLength(360);
	    }else {
	    	body.setLength(300);
	    }
			
		body.setLayoutX(x-xCoordinate);
    	body.setLayoutY(y-yCoordinate);
    	int xx=2;
    	int yy=8;
    	if(orientation == PacManModel.UP||orientation == PacManModel.DOWN) {
	    	 xx=-5;
	    	 yy=6;
    	}
    	
    	eye.setLayoutX(x+xx);
        eye.setLayoutY(y-yy);
        counter++;
        
	}
}
