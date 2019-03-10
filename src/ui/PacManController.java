package ui;
import ui.PacMan;

import java.util.List;
import model.PacManModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;



public class PacManController {
	
	public final static double MIN_WIDTH = 21.0;
	public final static double MAX_WIDTH = 580.0;
	public final static double MIN_HEIGHT = 83.0;
	public final static double MAX_HEIGTH = 380.0; 
	
	private List<PacMan> pacmans; 
	
	
    @FXML
    private Pane pane;
    
    
    
    @FXML
    public void initialize() {
    	
    	PacMan pMx=new PacMan(100,200);
    	pane.getChildren().add(pMx);
    	
    	/*
    	//Coordenadas X y Y
    	double x = 50.0;
    	double y = 200.0;
    	
    	//Arco y circulo para formar el cuerpo de Pac-Man
    	Arc body = new Arc();
    	Circle eye = new Circle(3.0); 
    
        body.setCenterX(x);
        body.setCenterY(y);
        body.setRadiusX(15.0);
        body.setRadiusY(15.0);
        body.setStartAngle(30.0);
        body.setLength(300.0);
        body.setFill(Color.YELLOW);
        body.setType(ArcType.ROUND);
      
        eye.setLayoutX(x+2);
        eye.setLayoutY(y-8);
        eye.setFill(Color.BLACK);
        
        
        pane.getChildren().add(body);
        pane.getChildren().add(eye);
        */
       
       
    }

}

