package customsThread;

import ui.PacManController;

public class GUIUpdateRunnable implements Runnable{
	private PacManController pacManGUI;
	
	public GUIUpdateRunnable(PacManController pMCx) {
		pacManGUI = pMCx;
	}
	@Override
	public void run() {
		pacManGUI.update();
		
	}

}
