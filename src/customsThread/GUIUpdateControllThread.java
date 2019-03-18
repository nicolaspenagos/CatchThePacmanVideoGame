package customsThread;

import javafx.application.Platform;
import ui.PacManController;

public class GUIUpdateControllThread extends Thread{
	private final static long UPDATE_SLEEP_TIME = 5;
	private PacManController pacmanGUI; 
	
	public GUIUpdateControllThread(PacManController pacManGUIx) {
		pacmanGUI = pacManGUIx;
	}
	
	public void run() {
		while(true) {
			GUIUpdateRunnable gUR = new GUIUpdateRunnable(pacmanGUI);
			Platform.runLater(gUR);
			
			try {
				sleep(UPDATE_SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
