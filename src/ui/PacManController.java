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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PacManController {
	
	public final static double MIN_WIDTH = 21.0;
	public final static double MAX_WIDTH = 580.0;
	public final static double MIN_HEIGHT = 103.0;
	public final static double MAX_HEIGTH = 380.0; 
	
	private Game game;
 	private List<PacMan> pacmans; 
 	private List<PacManModel> pacmansM; 
 	private int clicksC;
 	private int bouncingsC;
	
	
    @FXML
    private Pane pane;
    
    @FXML
    private Label clicks;

    @FXML
    private Label bouncings;
   
    @FXML
    public void initialize() {
    	clicksC = 0;
    	bouncingsC = 0;
    	pacmans = new ArrayList<>();
    	pacmansM = new ArrayList<>();
    	GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this); 
    	guiThread.setDaemon(true);
    	guiThread.start();
    	//Score scores = new Score();
    	
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
    	clicks.setText(""+clicksC);
    	try {
    		bouncingsC=game.totalBouncings();
    		bouncings.setText(""+bouncingsC);
    	}catch (NullPointerException e){
    	
    	}
    	for(int i=0; i<pacmans.size(); i++) {
    		pacmans.get(i).move(pacmansM.get(i).getxCoordenate(), pacmansM.get(i).getyCoordenate(), pacmansM.get(i).getOrientation(), pacmansM.get(i).getCaught());
    	}
    }
    
    @FXML
    void stopPacMan(MouseEvent event) {
    	clicksC++;
    	double x=event.getX();
    	double y=event.getY(); 
    	try {
    		game.stop(x, y);
    	}catch(NullPointerException e) {
    		
    	}
    	
    }
    
    @FXML
    void saveGame(ActionEvent event) {
    	try {
    		game.saveGame();
    	}catch (NullPointerException e) {
    		
    	}catch (IOException e) {
    		
    	}
    }
    
   

}

