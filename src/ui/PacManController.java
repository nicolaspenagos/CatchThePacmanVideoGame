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
   
    	PacMan pCx=new PacMan(100,300, pane, PacMan.SIZE2);
    	PacManModel pMx = new PacManModel(100, 200, PacManModel.HORIZONTAL, PacManModel.RIGHT);
    	PacManThread t = new PacManThread(50, this, pMx, pCx);
    	t.start();
    	
    	PacMan pCx1=new PacMan(100,350, pane, PacMan.SIZE2);
    	PacManModel pMx1 = new PacManModel(100, 350, PacManModel.HORIZONTAL, PacManModel.LEFT);
    	PacManThread t1 = new PacManThread(30, this, pMx1, pCx1);
    	t1.start();
    
    	PacMan pCx2=new PacMan(100,350, pane, PacMan.SIZE2);
    	PacManModel pMx2 = new PacManModel(100, 350, PacManModel.VERTICAL, PacManModel.UP);
    	PacManThread t2 = new PacManThread(30, this, pMx2, pCx2);
    	t2.start();
       
       
    }
    
    public void update(PacManModel pMx, PacMan uiPacMan) {
    	
    	double x = pMx.getxCoordenate();
    	double y = pMx.getyCoordenate(); 
    	
    	uiPacMan.move(x, y);
    	
    }

}

