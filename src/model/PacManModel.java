package model;

import ui.PacManController;

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
	//-------------------------------------
	
	private double xCoordenate;
	private double yCoordenate;
	private char movement;
	private char orientation; 
	private double radius; 
	private long sleep; 
	private int bouncings; 
	private boolean caught; 
	private Game game;
	
	//-------------------------------------
	// CONTRUCTOR 
	//-------------------------------------

	public PacManModel(double radiusx, double xX, double yY, long sleepx, char movementX, char orientationX, int bouncingsX, boolean caughtX, String idx, Game gx) {
		
		radius      = radiusx;
		xCoordenate = xX;
		yCoordenate = yY;
		sleep       = sleepx;
		movement    = movementX;
		orientation = orientationX; 
		bouncings   = bouncingsX; 
		caught      = caughtX; 
		game = gx;
		
	
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
	
	
	public long getSleep() {
		return sleep;
		}

		public void setSleep(long sleep) {
			this.sleep = sleep;
		}

		public double getRadius() {
			return radius;
		}
		
		public Game getGame() {
			return game; 
		}

		public void setRadius(double radius) {
			this.radius = radius;
		}

		public Boolean getCaught() {
			return caught;
		}

		public void setCaught(Boolean caught) {
			this.caught = caught;
		}

		public int getBouncings() {
			return bouncings;
		}

		public void setBouncings(int bouncings) {
			this.bouncings = bouncings;
		}
	
	//-------------------------------------
	// METHODS 
	//-------------------------------------
	
	public void move() {
		
		if(!caught) {
			if(xCoordenate >= PacManController.MAX_WIDTH-10) {
				orientation = LEFT;
				bouncings++;
				
			}else if(xCoordenate <=  PacManController.MIN_WIDTH+10) {	
				orientation = RIGHT;	
				bouncings++;
			}
			
			if(yCoordenate >= PacManController.MAX_HEIGTH-10) {
				orientation = UP;
				bouncings++;
			}else if(yCoordenate <=  PacManController.MIN_HEIGHT+10) {
				orientation = DOWN; 
				bouncings++;
			}
			
			
			
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
	
	public void colision() {
		double  movement = 20; 
		if(orientation == UP) {
			orientation = DOWN;
			yCoordenate = yCoordenate + movement;
		}else if(orientation == DOWN) {
			orientation = UP;
			yCoordenate = yCoordenate - movement;
		}else if(orientation == RIGHT) {
			orientation = LEFT;
			xCoordenate = xCoordenate + movement;
		}else if(orientation == LEFT) {
			orientation = RIGHT;
			xCoordenate = xCoordenate - movement;
		}
	}
	
	

}