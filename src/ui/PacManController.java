package ui;
import ui.PacMan;

import customsThread.PacManThread;
import model.PacManModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PacManController {
	
	public final static double MIN_WIDTH = 21.0;
	public final static double MAX_WIDTH = 580.0;
	public final static double MIN_HEIGHT = 83.0;
	public final static double MAX_HEIGTH = 380.0; 
	
	
    @FXML
    private Pane pane;
    
    
    
    @FXML
    public void initialize() {
   
    	PacMan pCx=new PacMan(100,300, pane);
    	PacManModel pMx = new PacManModel(100, 200, PacManModel.HORIZONTAL, PacManModel.RIGHT);
    	PacManThread t = new PacManThread(30, this, pMx, pCx);
    	t.start();
    	
    	PacMan pCx1=new PacMan(100,350, pane);
    	PacManModel pMx1 = new PacManModel(100, 350, PacManModel.HORIZONTAL, PacManModel.LEFT);
    	PacManThread t1 = new PacManThread(50, this, pMx1, pCx1);
    	t1.start();
       
    }
    
    public void update(PacManModel pMx, PacMan uiPacMan) {
    	
    	double x = pMx.getxCoordenate();
    	double y = pMx.getyCoordenate(); 
    	
    	uiPacMan.move(x, y);
    	
    }

}

