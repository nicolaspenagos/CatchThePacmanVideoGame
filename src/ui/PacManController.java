package ui;
import ui.PacMan;

import java.io.IOException;
import java.util.List;

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
	
	
    @FXML
    private Pane pane;
   
    @FXML
    public void initialize() {
    	
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
		
    	List<PacManModel> pacmans = game.getPacMans();
    	for(int i=0; i<pacmans.size(); i++) {
    		
    		PacManModel current = pacmans.get(i);
    		
    		long sleep  = current.getSleep(); 
    		double xPos = current.getxCoordenate();
    		double yPos = current.getyCoordenate(); 
    		double radius = current.getRadius();
    	
    		PacMan pMCx  = new PacMan(xPos, yPos, pane, radius); 
    		PacManThread tx = new PacManThread(sleep, this, current, pMCx);
    		tx.start();
    		
    	}
    	
    }
    
    public void update(PacManModel pMx, PacMan uiPacMan) {
    	
    	double x = pMx.getxCoordenate();
    	double y = pMx.getyCoordenate(); 
    	
    	uiPacMan.move(x, y);
    	
    }
    
    public void startThread() {
    	
    }

}

