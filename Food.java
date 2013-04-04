package myPackage;
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.net.*;

public class Food {
	private int pos_x;
	private int pos_y;
	private int diam;
	
	
	public Food(int x, int y){
		pos_x = x;
		pos_y = y;
		diam = 10;
		
	}

	public int get_pos_x(){
		return pos_x;
	}
	
	public int get_pos_y(){
		return pos_y;
	}
	
	public Graphics drawFood (Graphics g){
		g.setColor(Color.green);
		g.fillOval(pos_x, pos_y, diam, diam);
		g.drawOval(pos_x, pos_y, diam, diam);
		//System.out.print();
		
		return g;
	}
	
}
