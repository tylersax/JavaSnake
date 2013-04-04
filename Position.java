package myPackage;



public class Position {
	private int pos_x = 0;
	private int pos_y = 0;
	
	public Position(int x, int y){
		pos_x = x;
		pos_y = y;
	}
	
	public int getX(){
		return pos_x;
	}
	
	public int getY(){
		return pos_y;
	}
	
	public void setX(int x){
		pos_x = x;
	}
	
	public void setY(int y){
		pos_y = y;
	}
}
