package modelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.PacManModel;

class PacManModelTest {

	private PacManModel pMm; 
	public void setUpScenary1() {
		
	}
	
	@Test
	void pacManTest() {
		setUpScenary1();
		PacManModel pMm = new PacManModel(15, 120, 180, 100, 'a','b', 0, false, " ", null); 
		assertNotNull("The new pacMan object is null", pMm);
	}

}
