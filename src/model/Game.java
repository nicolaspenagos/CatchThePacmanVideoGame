package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	//------------------------------------- 
	// CONSTANTS 
	//------------------------------------- 
	
	public static final String LOAD_PATH_LEVEL1 = "data/loadLevel1.txt";
	public static final String LOAD_PATH_LEVEL2 = "data/loadLevel2.txt";
	public static final String LOAD_PATH_LEVEL3 = "data/loadLevel3.txt";
	public static final String SAVE_PATH1 = "data/save1.txt";
	public static final String SAVE_PATH2 = "data/save2.txt";
	public static final String SAVE_PATH3 = "data/save3.txt";
	
	//------------------------------------- 
	// ASSOCIATIONS 
	//-------------------------------------
	private List<PacManModel> pacmans;
	
	//------------------------------------- 
	// ATRIBUTTES 
	//-------------------------------------
	private int level; 
	private String playerName;
	private int counter;
	private int savingsCounter;
	private boolean win;
	private int totalBouncings;
	
	//-------------------------------------
	// CONTRUCTOR 
	//-------------------------------------

	public Game(int levelx) throws IOException {
		level = levelx;
		pacmans = new ArrayList<>();
		totalBouncings = 0; 
		playerName = "";
		counter = 0;
		savingsCounter = 1;
		win=false;
	}
	
	//-------------------------------------
	// GETTERS AND SETTERS  
	//-------------------------------------
	public List<PacManModel> getPacMans(){
		return pacmans; 
	}
	
	public boolean getWin() {
		return win;
	}
	
	//-------------------------------------
	// METHODS  
	//-------------------------------------
	public int totalBouncings(){
		int total = 0;
		for (int i = 0; i < pacmans.size(); i++) {
			total+=pacmans.get(i).getBouncings();
		}
		return total;
	}
	public void loadNewGameFile(String sepx, int x) throws IOException {
		String sep = sepx;
		int option = x;
		boolean firstTime = true;
		String path=LOAD_PATH_LEVEL1;
	
		if(option == 2) {
		
			path=LOAD_PATH_LEVEL2;;
		}else if(option == 3){
			path=LOAD_PATH_LEVEL3;
		}else if(option == 4) {
			path=SAVE_PATH1;
		}else if(option == 5) {
			path=SAVE_PATH2;
		}else if(option == 6) {
			path=SAVE_PATH3;
		}
		
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
	
		String line = br.readLine();
		while(line!=null) {
		
			if(!(line.charAt(0)=='#')&&!(line.equals(" "))) {

				String[] parts = line.split(sep); 
				if(firstTime) {
					firstTime = false; 
				}else if(!firstTime){
					char movement = ' '; 
					char orientation = ' ';
					double radius    = Double.parseDouble(parts[0]);
					double xPos      = Double.parseDouble(parts[1]);
					double yPos      = Double.parseDouble(parts[2]);
					long sleep       = Long.parseLong(parts[3]);
					String movementX  = parts[4];
					String orientationX = parts[5];
					int bouncings    = Integer.parseInt(parts[6]);
					boolean caught   = Boolean.parseBoolean(parts[7]);
					
					if(movementX.equalsIgnoreCase("horizontal")) {
						movement=PacManModel.HORIZONTAL; 
					}else if(movementX.equalsIgnoreCase("vertical")) {
						movement=PacManModel.VERTICAL; 
					}
					
					if(orientationX.equalsIgnoreCase("right")) {
						orientation=PacManModel.RIGHT; 
					}else if(orientationX.equalsIgnoreCase("left")) {
						orientation=PacManModel.LEFT; 
					}
					
					if(orientationX.equalsIgnoreCase("up")) {
						orientation=PacManModel.UP; 
					}else if(orientationX.equalsIgnoreCase("down")) {
						orientation=PacManModel.DOWN; 
					}
					
					
					PacManModel pMMx = new PacManModel(radius, xPos, yPos, sleep, movement, orientation, bouncings, caught, String.valueOf(counter), this);
					counter++;
					pacmans.add(pMMx);
				}
			}
			line = br.readLine(); 
				
		}	
	}
	
	public void saveGame(int x) throws IOException {
		String path = "";
		int slot = x;
		if(slot==0) {
			if(savingsCounter == 1) {
				path = SAVE_PATH1;
			}else if(savingsCounter == 2) {
				path = SAVE_PATH2;
			}else {
				path = SAVE_PATH3;
			}
		}else {
			if(slot == 1) {
				path = SAVE_PATH1;
			}else if(slot == 2) {
				path = SAVE_PATH2;
			}else {
				path = SAVE_PATH3;
			}
		}
			
		PrintWriter pw = new PrintWriter(new File(path));
		String msg = saveMsg();
		pw.print(msg);
		pw.close();
		savingsCounter++;
	}
	
	public void colision(PacManModel pMx) {
		
		double rx  = pMx.getRadius();
		double xPx = pMx.getxCoordenate();
		double yPx = pMx.getyCoordenate();
		
		for (int i = 0; i < pacmans.size(); i++) {
			PacManModel current = pacmans.get(i);
			double rc = current.getRadius();
			double xPc = current.getxCoordenate();
			double yPc = current.getyCoordenate();
			
			double distance = Math.sqrt((xPc-xPx)*(xPc-xPx) + (yPc-yPx)*(yPc-yPx));
			
			if(distance < rx + rc) {
				current.colision();
				pMx.colision();	
			}
		}
		
	}
	
	public void stop(double x, double y) {
		for (int i = 0; i < pacmans.size(); i++) {
			PacManModel current = pacmans.get(i);
			double xCurrent = current.getxCoordenate();
			double yCurrent = current.getyCoordenate();
			double currentR = current.getRadius();
			
			if(x>(xCurrent-currentR)&&x<(xCurrent+currentR)&&y>(yCurrent-currentR)&&y<(yCurrent+currentR)) {
				current.setCaught(true);
			}
		}
	}
	
	public String saveMsg() {
		String msg = "#level\n0\n#radio  posX	posY	sleep	movement	direction       bouncings	caught\n";
		for (int i = 0; i < pacmans.size(); i++) {
			PacManModel current = pacmans.get(i);
			String mov="";
			String ori=""; 
			if(current.getMovement()=='V') {
				mov="vertical";
			}else if(current.getMovement()=='H') {
				mov="horizontal";
			}
			
			if(current.getOrientation()=='R') {
				ori = "right";
			}else if(current.getOrientation()=='L') {
				ori = "left";
			}else if(current.getOrientation()=='U') {
				ori = "up";
			}if(current.getOrientation()=='D') {
				ori = "down";
			}
			
			msg+=current.getRadius()+"\t"+current.getxCoordenate()+"\t"+current.getyCoordenate()+"\t"+current.getSleep()+"\t"+mov+"\t"+ori+"\t"+current.getBouncings()+"\t"+current.getCaught()+"\n";
		}
		
		return msg;
	}
	
	public void win() {
		
		int caught=0;
		for (int i = 0; i < pacmans.size(); i++) {
			PacManModel current = pacmans.get(i);
			if(current.getCaught()) {
				caught++; 
			}
		}
		if(caught==pacmans.size())
			win=true; 
	}
}

