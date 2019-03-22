package ui;
import ui.PacMan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import customsThread.GUIUpdateControllThread;
import customsThread.PacManThread;
import model.Game;
import model.PacManModel;
import model.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
 	private Score scores; 
 	private int clicksC;

 	
    @FXML
    private TextArea textA;
 	
    @FXML
    private Label won;
    
    @FXML
    private Button bname;
    
    @FXML
    private TextField name;

    @FXML
    private Label congrats;
	
    @FXML
    private Pane pane;
    
    @FXML
    private Label clicks;

    @FXML
    private Label bouncings;
   
    @FXML
    public void initialize() {
    	
    	textA.setVisible(false);
    	load();
    	name.setVisible(false);
    	bname.setVisible(false);
    	clicksC = 0;
    	bouncings.setText("0");
    	pacmans = new ArrayList<>();
    	pacmansM = new ArrayList<>();
    	GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this); 
    	guiThread.setDaemon(true);
    	guiThread.start();
    	congrats.setVisible(false);
    	won.setVisible(false);
    }
    
    
    @FXML
    void newEasyGame(ActionEvent event) {
    	congrats.setVisible(false);
		won.setVisible(false);
		bname.setVisible(false);
		name.setVisible(false);
		textA.setVisible(false);
    	clear();
		try {
			game = new Game(0);
			game.getPacMans().clear();
			game.loadNewGameFile("\t", 1);
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
    

    @FXML
    void newHardGame(ActionEvent event) {
    	congrats.setVisible(false);
    	won.setVisible(false);
    	bname.setVisible(false);
		name.setVisible(false);
		textA.setVisible(false);

    	clear();
    	try {
			game = new Game(0);
			game.getPacMans().clear();
			game.loadNewGameFile("\t", 3);
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

    @FXML
    void newMediumGame(ActionEvent event) {
      	congrats.setVisible(false);
    	won.setVisible(false);
    	bname.setVisible(false);
		name.setVisible(false);
		textA.setVisible(false);
    	clear();
    	try {
			game = new Game(0);
			game.getPacMans().clear();
			game.loadNewGameFile("\t", 2);
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
    		game.win();
	    	if(game.getWin()) {
	    		name.setVisible(true);
	    		congrats.setVisible(true);
	    		bname.setVisible(true);
	    		won.setVisible(true);
	    		
	    		
	    	}
    	
    	
    		bouncings.setText(""+game.totalBouncings());
    	}catch (NullPointerException e){
    	
    	}
    	for(int i=0; i<pacmans.size(); i++) {
    		pacmans.get(i).move(pacmansM.get(i).getxCoordenate(), pacmansM.get(i).getyCoordenate(), pacmansM.get(i).getOrientation(), pacmansM.get(i).getCaught());
    	}
    }
    
    @FXML
    void saveName(ActionEvent event) {
    	String nx = name.getText();
		int bx=game.totalBouncings();
		int cx =Integer.parseInt(clicks.getText());
		int pN = pacmans.size();
		scores.isBest(pN, bx, cx, nx);
		
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
    		game.saveGame(0);
    	}catch (NullPointerException e) {
    		
    	}catch (IOException e) {
    		
    	}
    }
    
    @FXML
    void saveSlot1(ActionEvent event) {
    	try {
    		game.saveGame(1);
    	}catch (NullPointerException e) {
    		
    	}catch (IOException e) {
    		
    	}
    }

    @FXML
    void saveSlot2(ActionEvent event) {
    	try {
    		game.saveGame(2);
    	}catch (NullPointerException e) {
    		
    	}catch (IOException e) {
    		
    	}

    }

    @FXML
    void saveSlot3(ActionEvent event) {
    	try {
    		game.saveGame(3);
    	}catch (NullPointerException e) {
    		
    	}catch (IOException e) {
    		
    	}
    }
    
    @FXML
    void loadSlot1(ActionEvent event) {
      	congrats.setVisible(false);
    	won.setVisible(false);
    	bname.setVisible(false);
		name.setVisible(false);
		textA.setVisible(false);
    	clear();
		try {
			game = new Game(0);
			game.getPacMans().clear();
			game.loadNewGameFile("\t", 4);
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

    @FXML
    void loadSlot2(ActionEvent event) {
    	congrats.setVisible(false);
    	won.setVisible(false);
    	bname.setVisible(false);
		name.setVisible(false);
		textA.setVisible(false);
    	clear();
		try {
			game = new Game(0);
			game.getPacMans().clear();
			game.loadNewGameFile("\t", 5);
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

    @FXML
    void loadSlot3(ActionEvent event) {
    	congrats.setVisible(false);
    	won.setVisible(false);
    	bname.setVisible(false);
		name.setVisible(false);
		textA.setVisible(false);
    	clear();
		try {
			game = new Game(0);
			game.getPacMans().clear();
			game.loadNewGameFile("\t", 6);
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
    
   public void clear() {
	   for (int i = 0; i < pacmans.size(); i++) {
			pacmans.get(i).turnOf();
		}
   	pacmans.clear();
   	pacmansM.clear();
   }
   
   @FXML
   void showBS(ActionEvent event) {
	   
	   System.out.println("Hola");
	   textA.setVisible(true);
	   congrats.setVisible(false);
	   won.setVisible(false);
	   bname.setVisible(false);
	   name.setVisible(false);
	   textA.setText(scores.getScores());
	   save();
   }
   
   public void load() {
	   File f = new File(Score.PATH);
	   if(f.exists()) {
		   try {
			ObjectInputStream io=new  ObjectInputStream(new FileInputStream(f));
			scores=(Score) io.readObject();
			io.close();
		   } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	   }else {
		   scores=new Score();
	   }
   }
   
   public void save() {
	   File f = new File(Score.PATH);
	   try {
		ObjectOutputStream io = new ObjectOutputStream(new FileOutputStream(f));
		io.writeObject(scores);
		io.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   

}

