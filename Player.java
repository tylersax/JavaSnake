package myPackage;
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.net.*;

public class Player {
	private int score = 0;
	private int lives = 3;
	private boolean haswon = false;
	private int level = 1;
	
	public boolean haswon(){
		if (haswon == true)
			return true;
		else return false;
	}
	
	public int lives(){
		return lives;
	}
	
	public int level(){
		return level;
	}
	
	public int score(){
		return score;
	}

	public void increaseScore(){
		score++;
	}
	
	public void updateLives(){
		lives--;
	}


}
