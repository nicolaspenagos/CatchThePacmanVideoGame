package ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class PacManController {

    @FXML
    private Pane pane;
    
    
    
    @FXML
    public void initialize() {
    	Circle cx = new Circle(20); 
    	cx.setFill(javafx.scene.paint.Color.YELLOW);
    	cx.setLayoutX(100);
    	cx.setLayoutY(100);
    	pane.getChildren().add(cx);
    	
    }

}
