package myPackage;
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.net.*;

public class Segment {
	Position pos;
	public Position prev_pos = new Position (0,0); //the previous position
	
	private int diam, pos_x, pos_y;
	
	
	public Segment(Position p){
		pos = p;
		//prev_pos = p;
		diam = 10;
	}
	
	public Graphics drawSeg (Graphics g){
		g.fillOval(pos.getX(), pos.getY(), diam, diam);
		g.drawOval(pos.getX(), pos.getY(), diam, diam);
		//prev_pos.setX(pos.getX());
		//prev_pos.setY(pos.getY());
		
		return g;
	}
	
	public void update_pos(){
		
		prev_pos.setX(pos.getX());
		prev_pos.setY(pos.getY());
		//System.out.print(" updating pos " + prev_pos.getX());
	}
	
	public void move(int head_dir, int boardSize){
		update_pos();
		
		if (pos.getX() >= boardSize) pos.setX(1);
		if (pos.getY() >= boardSize) pos.setY(1);
		if (pos.getX() <= 0) pos.setX(boardSize);
		if (pos.getY() <= 0) pos.setY(boardSize);
		
		switch(head_dir){
		case 1: //move north
			pos_y = pos.getY();
			pos.setY(pos_y - 10);
			//isOut();
			break;
		case 2: //move east
			pos_x = pos.getX();
			pos.setX(pos_x + 10);
			//isOut();
			break;
		case 3: //move south
			pos_y = pos.getY();
			pos.setY(pos_y + 10);
			//isOut();
			break;
		case 4: //move west
			pos_x = pos.getX();
			pos.setX(pos_x - 10);
			//isOut();
			break;
		}
		//System.out.print("prev: "+prev_pos.getX()+"pos: "+pos.getX()+ "\n");
	}
	
	public int get_pos_x(){
		return pos.getX();
	}
	
	public int get_pos_y(){
		return pos.getY();
	}
	
	public void set_pos_x(int x){
		pos.setX(x);
	}
	
	public void set_pos_y(int y){
		pos.setY(y);
	}
}

