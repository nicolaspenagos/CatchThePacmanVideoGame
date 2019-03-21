package model;

import java.io.Serializable;

public class Score implements Serializable{
	
	private String[] bestEasy;
	private String[] bestMedium;
	private String[] bestHard;
	public final static String PATH ="data/info.dat";
	
	
	public Score() {
		bestEasy = new String[10];
		bestMedium = new String[10];
		bestHard = new String[10];
	}
	
	public void isBest(int pacmansNumber, int bx, int cx, String playerName) {
		String level = "";
		String[] array = null;
		int moreB = 0;
		int pMoreB = 999;
		boolean finish = false;
		
		if(pacmansNumber == 3) {
			level = "Easy"; 
			array = bestEasy; 
		}else if(pacmansNumber == 5) {
			level = "Medium"; 
			array = bestMedium;
		}else if(pacmansNumber == 7) {
			level = "Hard"; 
			array = bestHard; 
		}
		for (int i = 0; i < array.length; i++) {
			
			if(array[i] == null||array[i].equals("")) {
				array[i] = "\t"+playerName+"\t"+bx+"\t"+level;
				finish=true;
				
			}
			
		}
		
		for (int i = 0; i < array.length&&!finish; i++) {
			String current = array[i];
		
			if(current!=null) {
				String[] parts = current.split("\t");
				if(Integer.parseInt(parts[2])>moreB) {
					moreB = Integer.parseInt(parts[2]);
					pMoreB = i;
				}
			}
		}
		
		for (int i = 0; i < array.length&&!finish; i++) {
			if(bx<moreB) {
				array[pMoreB]="\t"+playerName+"\t"+bx+"\t"+level;
				finish = true;
			}
		}
		if(level.equals("Easy")) {
			bestEasy=order(array);
		}
		if(level.equals("Medium")) {
			bestMedium=order(array);
		}
		if(level.equals("Hard")) {
			bestHard=order(array);
		}
		
	
	}
	
	public String[] order(String[] array) {
		String[] array2 = array;
		for (int i = array2.length; i < 0; i--) {
			for (int j = 0; j < i-1; j++) {
				String[] parts = array2[j].split("\t");
				String[] parts1 = array2[j+1].split("\t");
				int x = Integer.parseInt(parts[2]);
				int y = Integer.parseInt(parts1[2]);
				if(x>y) {
					String temp = array2[j];
					array2[j]=array2[j+1];
					array2[j+1]=temp;
				}
			}
		}
		return array2; 
	}
	
	public String getScores() {
		String msg="----- BEST SCORES -----\nPOS\tNAME\tBOUNCIGS\tLEVEL\n";
		for (int i = 0; i < bestEasy.length; i++) {
			if(bestEasy[i]!=null)
			msg+=(i+1)+bestEasy[i]+"\n";
		}
		msg+="\n-----------------------\n";
		for (int i = 0; i < bestMedium.length; i++) {
			if(bestMedium[i]!=null)
			msg+=(i+1)+bestMedium[i]+"\n";
		}
		msg+="\n-----------------------\n";
		for (int i = 0; i < bestHard.length; i++) {
			if(bestHard[i]!=null)
			msg+=(i+1)+bestHard[i]+"\n";
		}
		return msg;
	}
}
