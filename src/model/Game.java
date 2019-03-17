package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	//------------------------------------- 
	// CONSTANTS 
	//------------------------------------- 
	
	public static final String LOAD_PATH_LEVEL1 = "data/loadLevel1.txt";
	public static final String LOAD_PATH_LEVEL2 = "data/loadLevel2.txt";
	public static final String LOAD_PATH_LEVEL3 = "data/loadLevel3.txt";
	
	//------------------------------------- 
	// ASSOCIATIONS 
	//-------------------------------------
	private List<PacManModel> pacmans;
	private int totalBouncings;
	
	//------------------------------------- 
	// ATRIBUTTES 
	//-------------------------------------
	private int level; 
	
	//-------------------------------------
	// CONTRUCTOR 
	//-------------------------------------

	public Game(int levelx) throws IOException {
		level = levelx;
		pacmans = new ArrayList<>();
		totalBouncings = 0; 
		loadNewGameFile("\t"); 
	}
	
	//-------------------------------------
	// GETTERS AND SETTERS  
	//-------------------------------------
	public List<PacManModel> getPacMans(){
		return pacmans; 
	}
	
	//-------------------------------------
	// METHODS  
	//-------------------------------------
	public void loadNewGameFile(String sepx) throws IOException {
		String sep = sepx;
		boolean firstTime = true;
		
		File f = new File(LOAD_PATH_LEVEL1);
		if(level == 2) {
			f = new File(LOAD_PATH_LEVEL2);
		}else if(level == 3){
			f = new File(LOAD_PATH_LEVEL3);
		}
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
	
		String line = br.readLine();
		while(line!=null) {
		
			if(!(line.charAt(0)=='#')&&!(line.equals(" "))) {

				String[] parts = line.split(sep); 
				if(firstTime) {
					firstTime = false; 
				}else if(!firstTime){
					System.out.println("ENTRO");
					char movement = ' '; 
					char orientation = ' ';
					double radius    = Double.parseDouble(parts[0]);
					double xPos      = Double.parseDouble(parts[1]);
					System.out.println(parts[2]);
					double yPos      = Double.parseDouble(parts[2]);
					System.out.println(parts[3]);
					long sleep       = Long.parseLong(parts[3]);
					System.out.println(parts[4]);
					String movementX  = parts[4];
					System.out.println(parts[5]);
					String orientationX = parts[5];
					System.out.println(parts[6]);
					int bouncings    = Integer.parseInt(parts[6]);
					System.out.println(parts[7]);
					boolean caught   = Boolean.parseBoolean(parts[7]);
					
					if(movementX.equalsIgnoreCase("horizontal")) {
						movement=PacManModel.HORIZONTAL; 
					}else if(movementX.equalsIgnoreCase("vertical")) {
						movement=PacManModel.VERTICAL; 
					}
					
					if(orientationX.equalsIgnoreCase("right")) {
						orientation=PacManModel.RIGHT; 
					}else if(movementX.equalsIgnoreCase("left")) {
						orientation=PacManModel.LEFT; 
					}
					
					if(orientationX.equalsIgnoreCase("up")) {
						orientation=PacManModel.UP; 
					}else if(movementX.equalsIgnoreCase("donw")) {
						orientation=PacManModel.DOWN; 
					}
					
					
					PacManModel pMMx = new PacManModel(radius, xPos, yPos, sleep, movement, orientation, bouncings, caught);
					pacmans.add(pMMx);
				}
			}
			line = br.readLine(); 
				
		}
		
	}
	
}

