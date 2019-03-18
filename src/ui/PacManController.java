package ui;
import ui.PacMan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import customsThread.GUIUpdateControllThread;
import customsThread.PacManThread;
import model.Game;
import model.PacManModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PacManController {
	
	public final static double MIN_WIDTH = 21.0;
	public final static double MAX_WIDTH = 580.0;
	public final static double MIN_HEIGHT = 103.0;
	public final static double MAX_HEIGTH = 380.0; 
	
	private Game game;
 	private List<PacMan> pacmans; 
 	private List<PacManModel> pacmansM; 
	
	
    @FXML
    private Pane pane;
   
    @FXML
    public void initialize() {
    	pacmans = new ArrayList<>();
    	pacmansM = new ArrayList<>();
    	GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this); 
    	guiThread.setDaemon(true);
    	guiThread.start();
    	
    }
    
    @FXML
    void load(ActionEvent event) {
    	
    }
    
    @FXML
    void newEasyGame(ActionEvent event) {
    	
		try {
			game = new Game(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	pacmansM = game.getPacMans();
    	for(int i=0; i<pacmansM.size(); i++) {
    		
    		PacManModel current = pacmansM.get(i);
    		
    		long sleep       = current.getSleep(); 
    		double xPos      = current.getxCoordenate();
    		double yPos      = current.getyCoordenate(); 
    		double radius    = current.getRadius();
    		char orientation = current.getOrientation();
    	
    		PacMan pMCx  = new PacMan(xPos, yPos, pane, radius, orientation); 
    		pacmans.add(pMCx);
    		PacManThread tx = new PacManThread(sleep, this, current, pMCx);
    		tx.start();
    		
    	}
    	
    }
    
    public void update() {
    	for(int i=0; i<pacmans.size(); i++) {
    		pacmans.get(i).move(pacmansM.get(i).getxCoordenate(), pacmansM.get(i).getyCoordenate(), pacmansM.get(i).getOrientation());
    	}
    }
    
    public void startThread() {
    	
    }

}

