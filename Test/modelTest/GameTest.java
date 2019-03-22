package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Game;
import model.PacManModel;

class GameTest {
	private Game game; 
	
	public void setUpScenary1() {
		
	}
	
	public void setUpScenary2() {
		try {
			game  = new Game(1);
			ArrayList<PacManModel> px = new ArrayList<PacManModel>();
			for(int i=0; i<5; i++) {
				PacManModel pxx=new PacManModel(0,0,0,5,'a','b',2,true,"sjdsk",game);
				px.add(pxx);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testGame() {
		int level = 1;
		String playerName = "Nicolas";
		int counter = 3;
		int savingsCounter = 4; 
		boolean win = false;
		int totalBocunings = 0; 
		
		try {
			Game gx = new Game(level);
			assertNotNull("The new MagicSquare is null", gx);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
	@Test
	void totalBouncingsTest() {
		setUpScenary2();
		int t=game.totalBouncings();	
		assertTrue("Total boucings are correct", t==0);
	}

}
