// Project 2
// Name: Tyler Sax	
// E-mail: tps32@georgetown.edu
// Instructor: Singh
// COSC 150
//
// In accordance with the class policies and Georgetown's Honor Code,
// I certify that, with the exceptions of the lecture notes and those
// items noted below, I have neither given nor received any assistance
// on this project.
//


package myPackage;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Game extends Applet implements Runnable, AppletStub{
	
	Thread myThread;
	Button b = new Button("Start Game");
	Frame f = new Frame();
	
	public void init(){
		//setLayout(new FlowLayout());
		setSize(300, 300);
		
		//GridBagConstraints c = new GridBagConstraints();
		//setBackground(Color.black);
	
		add(b);
		b.addActionListener(new Eavesdropper());
	}
	
	public void run() {
		 
		//launch();
		 
	}
	 
	public void launch(){
		b.setVisible(false);
		Color c = new Color(0, 0, 0, 1);
		setBackground(c);
		
		try {
				
			    Class gameboard = Class.forName("myPackage.SnakeGame");
			    Applet appletToLoad = (Applet)gameboard.newInstance();
			    appletToLoad.setStub(this);
			    setLayout( null);
			    //setSize(600,600);
			    add(appletToLoad);
			    appletToLoad.init();
			    appletToLoad.start();
		 
			  }catch (Exception e) {
			    System.out.println(e);
			  }
		 
			    validate();
	}
		
	public void start(){
		 myThread = new Thread(this);
		 myThread.start();
	}
	 
	public void stop() {
		//myThread.stop();
		myThread = null;
	}
	public void appletResize( int width, int height ){
		resize( width, height );
	}
class Eavesdropper implements ActionListener {
		
		public Eavesdropper(){
			
		}
		public void actionPerformed(ActionEvent e){
			
			launch();
			
		}
		
	}


}
