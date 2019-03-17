package customsThread;
import model.PacManModel;
import ui.PacMan;
import ui.PacManController;

public class PacManThread extends Thread{
	
	private long sleep;
	private PacManModel pacMan; 
	private PacManController pacManController; 
	private PacMan uiPacMan;
	
	public PacManThread(long i, PacManController pacManController2, PacManModel pMx, PacMan pCx) {
	
		sleep = i;
		pacMan = pMx;
		pacManController= pacManController2; 
		uiPacMan = pCx; 
		
	}


	@Override
	public void run() {
		
		for(int i=0; i<500; i++) {
			pacMan.move();
			pacManController.update(pacMan, uiPacMan);
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}
