package myPackage;


import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.net.*;
//import javax.swing.*;

public class SnakeGame extends Applet implements Runnable {

	private int width, height, mainx, mainy, x, y;
	private Boolean stopped, newfood;
	
	private Image dbImage;
	private Graphics dbGraphics;
	Font myfont = new Font ("Serif", Font.BOLD, 20);
	Image backbuffer;
	Graphics background;
	
	AudioClip turnnoise;
	AudioClip eatnoise;
	AudioClip outnoise;
	
	Thread myThread;
	
	private Snake snake;
	private Player player;
	
	Random generator = new Random();
	private int boardSize = 300;
	Food food;
	boolean printfood = true;
	
	
	public void init(){
		
		//GridBagLayout gridbag = new GridBagLayout();
		setLayout(new GridLayout());
		setSize(boardSize, boardSize);
		
		//GridBagConstraints c = new GridBagConstraints();
		setBackground(Color.gray);
		setFont (myfont);
		//window.setMinimumSize(600, 600);
		width=getSize().width;
		height=getSize().height;
		
		addKeyListener(new Eavesdropper());
		
		//button.setBounds(100, 100, 15, 15);
		
		mainx = width/2;
		mainy = height/2;
		
		backbuffer = createImage(width, height);
		background = backbuffer.getGraphics();
		
		
		
		//set audio clips
		// turnnoise = getAudioClip (getCodeBase(), "gun.au");
		
		// initialize board objects
		player = new Player();
		// food
		snake = new Snake();
		
		//addKeyListener(KeyEvent e);
	
		setFocusable(true);
		requestFocus();
	}
	
	public void start(){
		myThread = new Thread (this);
		myThread.start();
	}
	
	public void stop(){
		myThread.stop();
	}
	
	public void new_food(){
		x = ( Math.abs(generator.nextInt()) )%(boardSize-50) + 25;
		y = ( Math.abs(generator.nextInt()) )%(boardSize-50) + 25;
		
		food = new Food(x, y);
		printfood = true;
	}
	
	public void check_food(){
		
		if ( Math.abs(snake.get_head_pos_x() - food.get_pos_x())<10 && Math.abs(snake.get_head_pos_y() - food.get_pos_y())<10){
			new_food();
			snake.grow();
		}
	}
	
	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		new_food();
		
		while (true){
			snake.move(boardSize);
			snake.update_list();
			//System.out.print("pos:" + snake.head.get_pos_x() + " prev:"+snake.head.prev_pos.getX()+ "\n");
			repaint();
			try {
				Thread.sleep(100/player.level());
			} catch (InterruptedException e) {
				
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}
	
	public void update(Graphics myBoard){
		//g.setColor(Color.gray);
		//System.out.print("out");
		//g.drawImage(backbuffer, 0, 0, this);
		
		if (dbImage == null){
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbGraphics = dbImage.getGraphics();
		}
		
		dbGraphics.setColor(getBackground());
		dbGraphics.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		dbGraphics.setColor(getForeground());
		paint(dbGraphics);
		
		myBoard.drawImage(dbImage, 0, 0, this);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.blue);
		snake.drawSnake(g);
		check_food();
		if(printfood = true){
			food.drawFood(g);
			printfood = false;
		}
	}
	
	
	class Eavesdropper implements KeyListener {
		
		public Eavesdropper(){
			
		}
		public void keyPressed(KeyEvent e){
			int event = e.getKeyCode();
			
			switch(event){
			case 38:
				if(snake.get_dir() != 3) snake.set_dir(1);
				break;
			case 39:
				if(snake.get_dir() != 4) snake.set_dir(2);
				break;
			case 40:
				if(snake.get_dir() != 1) snake.set_dir(3);
				break;
			case 37:
				if(snake.get_dir() != 2) snake.set_dir(4);
				break;
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
}
	
}

