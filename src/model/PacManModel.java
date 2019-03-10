package model;

public class PacManModel {
	
	//------------------------------------- 
	// CONSTANTS 
	//------------------------------------- 
	
	public static final char RIGHT = 'R';
	public static final char LEFT = 'L';
	public static final char UP = 'N';
	public static final char DOWN = 'D';
	public static final char VERTICAL = 'V';
	public static final char HORIZONTAL = 'H';
	
	//------------------------------------- 
	// ATRIBUTTES 
	//--------------------------------------
	
	private double xCoordenate;
	private double yCoordenate;
	private char movement;
	private char orientation; 
	
	//-------------------------------------
	// CONTRUCTOR 
	//-------------------------------------

	public PacManModel(double xX, double yY, char movementX, char orientationX) {
		
		xCoordenate = xX;
		yCoordenate = yY;
		movementX = movement;
		orientation = orientationX; 
	
	}
	
	//-------------------------------------
	// GETTERS AND SETTERS 
	//-------------------------------------

	public double getxCoordenate() {
		return xCoordenate;
	}


	public void setxCoordenate(double xCoordenate) {
		this.xCoordenate = xCoordenate;
	}


	public double getyCoordenate() {
		return yCoordenate;
	}


	public void setyCoordenate(double yCoordenate) {
		this.yCoordenate = yCoordenate;
	}


	public char getMovement() {
		return movement;
	}


	public void setMovement(char movement) {
		this.movement = movement;
	}


	public char getOrientation() {
		return orientation;
	}


	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	
	//-------------------------------------
	// METHODS 
	//-------------------------------------
	
	public void move() {
		
		if(movement == HORIZONTAL) {
			if(orientation == RIGHT ) {
				xCoordenate = xCoordenate + 5; 
			}
			if(orientation == LEFT ) {
				xCoordenate = xCoordenate - 5; 
			}
		}
		
		if(movement == VERTICAL) {
			if(orientation == UP ) {
				yCoordenate = yCoordenate - 5; 
			}
			if(orientation == DOWN ) {
				yCoordenate = yCoordenate + 5; 
			}
		}
		
	}
}