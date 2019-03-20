package model;

import java.io.Serializable;

public class Score implements Serializable{
	private Game[] bestGames;
	
	public Score() {
		bestGames = new Game[10];
	}
	
	public void isBest() {
		
	}
}
