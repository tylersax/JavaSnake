package myPackage;
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.net.*;

public class Snake {

	private int head_pos_x;
	private int head_pos_y;
	private int head_dir = 2; //1,2,3, or 4
	private int length;
	private int list_size;
	public Segment head;
	Segment tail;
	boolean on_food;
	boolean out;
	Position head_pos = new Position(50,50);
	
	ArrayList<Segment> list;
	
	// List pos_list; **find a good list type 
	
	public Snake(){
		list = new ArrayList();
		head = new Segment(head_pos);
		list.add(head);
	}
	
	public Graphics drawSnake (Graphics g){
		
		for (int x = 0; x<list.size(); x++){
			list.get(x).drawSeg(g);
		}
		return g;
	}
	
	public void update_list(){
		for (int x = 2; x<list.size(); x++){
			//System.out.print(x + " posx: "+ list.get(x).get_pos_x() + "prevposx: " +list.get(x).prev_pos.getX() + "\n");
			list.get(x).update_pos();
			list.get(x).set_pos_x(list.get(x-1).prev_pos.getX());
			list.get(x).set_pos_y(list.get(x-1).prev_pos.getY());
		}
	}
	public void grow(){
		list_size = list.size();
		tail = list.get(list_size - 1);
		list.add(new Segment(tail.prev_pos));
		//System.out.print(" list size= " + list.size());
		for (int x = 0; x<list.size(); x++){
			System.out.print("x: "+x+" xpos: "+list.get(x).get_pos_x() + "\n");
		}
	}
	
	
	
	public void set_dir(int new_dir){
		head_dir = new_dir;
	}
	
	public int get_dir(){
		return head_dir;
	}
	
	public int get_head_pos_x(){
		return head.get_pos_x();
	}
	
	public int get_head_pos_y(){
		return head.get_pos_y();
	}
	
	public void move(int boardSize){
		head.move(head_dir, boardSize);
		//for (int x = 1; x<list.size(); x++){
		//	list.get(x).move(head_dir, boardSize);
		//}
	}
}
	

