package edu.virginia.lab3test;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;



//import javax.swing.Timer;

import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.util.GameClock;
import edu.virginia.lab1test.LabOneGame;

/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class LabThreeGame extends Game implements MouseListener {
	

	

	/* Create a sprite object for our game. We'll use mario */
	Sprite sun1= new Sprite("sun","Sun.png", 0,0,0,0,0,.5,.5);
	
	Sprite child1=new Sprite("placeholder");
	Sprite child2= new Sprite("placeholder2");
	Sprite child3= new Sprite("placeholder3");
	Sprite p1= new Sprite("e1","earth.png",0,0,0,0,0,1,1);
	Sprite p2= new Sprite("ring3","Moon1.png",0,20,20,0,0,1,1);
	Sprite p3= new Sprite("ring3","Mercury.png",0,20,20,0,0,1,1);
	Sprite p4= new Sprite("ring3","Moon2.png",0,20,20,0,0,1,1);
	Sprite p5= new Sprite("ring3","Venus.png",0,20,20,0,0,1,1);
	Sprite p6= new Sprite("ring3","Moon3.png",0,20,20,0,0,1,1);
	int dx=0;
	int dy=0;
	/*Sprite p3 = new Sprite("Ring.png");
	Sprite m1= new Sprite("Ring.png");
	Sprite m2 = new Sprite("Ring.png");
	Sprite m3=  new Sprite ("Ring.png");
	*/
	/**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public LabThreeGame() {
		super("Lab Three Test Game", 1400, 1000);
		super.getMainFrame().addMouseListener(this);
		this.getScenePanel().setBackground(Color.BLACK);
		
		this.addChild(sun1);
		sun1.addChild(child1);
		sun1.addChild(child2);
		sun1.addChild(child3);
		sun1.setPosition(750-sun1.getUnscaledWidth()/2, 500-sun1.getUnscaledHeight()/2);
		sun1.setCenter();
		child1.addChild(p1);
		child1.setCenter();
		child2.setCenter();
		child3.setCenter();
		child2.addChild(p3);
		child3.addChild(p5);
		p5.addChild(p6);
		p5.setCenter();
		p5.setCenter();
		p3.setCenter();
		p3.setPosition(450, 100);
		p3.addChild(p4);
		p4.setCenter();
		p1.setPosition(200, 0);
		p2.setCenter();
		p1.setCenter();
		p2.setPosition(100,0);
		p1.addChild(p2);
		p2.setPivotPoint(p1.getUnscaledWidth()/2, p1.getUnscaledHeight()/2);
		//p2.setPosition(300, 0);
		//p1.addChild(p2);
		/*sun1.setScaleX(.5);
		sun1.setScaleY(.5);
		p1.setScaleX(.5);
		p1.setScaleY(.5);
		p2.setScaleX(.3);
		p2.setScaleY(.3);
		p3.setScaleX(.5);
		p3.setScaleY(.5);
		p4.setScaleX(.4);
		p4.setScaleY(.4);*/
		p4.setPosition(100,0);
		//p5.setScaleX(.3);
	//	p5.setScaleY(.3);
		p5.setPosition(750, 0);
		p6.setPosition(120, 0);
		//p6.setScaleX(.4);
		//p6.setScaleY(.4);
		//sun1.addChild(p1);
		
		
		
		
		
		//sun1.addChild(child2);
		//sun1.addChild(child3);
		/*child1.setPivotPoint(sun1.getPivotPoint());
		child1.setPosition(sun1.getPosition());
		child2.setPivotPoint(sun1.getPivotPoint());
		child2.setPosition(sun1.getPosition());
		child3.setPivotPoint(sun1.getPivotPoint());
		child3.setPosition(sun1.getPosition());
		child1.addChild(p1);
		p1.setPosition(700, 500);
		p1.setPivotPoint(child1.getPivotPoint());
		*/
		}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
			if(pressedKeys.contains(KeyEvent.VK_A)){
				child1.setRotation(child1.getRotation()-.2);
				child2.setRotation(child2.getRotation()-.1);
				child3.setRotation(child3.getRotation()-.1);
			}
			if(pressedKeys.contains(KeyEvent.VK_S)){
				child1.setRotation(child1.getRotation()-.2);
				child2.setRotation(child2.getRotation()-.1);
				child3.setRotation(child3.getRotation()-.1);
				
			}
			if(pressedKeys.contains(KeyEvent.VK_UP)){
				sun1.setPosition(sun1.getPosition().getX(), sun1.getPosition().getY()-10);
			}			
			if(pressedKeys.contains(KeyEvent.VK_RIGHT)){
				sun1.setPosition(sun1.getPosition().getX()+10, sun1.getPosition().getY());
			}
			
			if(pressedKeys.contains(KeyEvent.VK_LEFT)){
				sun1.setPosition(sun1.getPosition().getX()-10, sun1.getPosition().getY());
				
			}
			if(pressedKeys.contains(KeyEvent.VK_DOWN)){
				sun1.setPosition(sun1.getPosition().getX(), sun1.getPosition().getY()+10);
			}
			if(pressedKeys.contains(KeyEvent.VK_Q)){
				sun1.setScaleX(sun1.getScaleX()-.01);
				sun1.setScaleY(sun1.getScaleY()-.01);
			}
			if(pressedKeys.contains(KeyEvent.VK_W)){
				sun1.setScaleX(sun1.getScaleX()+.01);
				sun1.setScaleY(sun1.getScaleY()+.01);
			}
			child1.setPosition((((Math.cos(child1.getRotation()))+1)/2)*400+-150, child1.getPosition().getY());
			child2.setPosition((((Math.cos(child2.getRotation()))+1)/2)*400+-150, child2.getPosition().getY());
			child3.setPosition((((Math.cos(child3.getRotation()))+1)/2)*400+-150, child3.getPosition().getY());
			
		if(!pressedKeys.contains(KeyEvent.VK_A) || !pressedKeys.contains(KeyEvent.VK_S)){
			child1.setRotation(child1.getRotation()+.1);
			//System.out.println("rotate");
			p1.setRotation(p1.getRotation()+.2);
			child2.setRotation(child2.getRotation()+.05);
			p3.setRotation(p3.getRotation()+.02);
			child3.setRotation(child3.getRotation()+.08);
			p5.setRotation(p5.getRotation()+.1);
		
			}
	}
	
	@Override
	public void draw(Graphics g){
		//g.drawString("Welcome to Our Miniature Solar System:", 400, 30);
		
		super.draw(g);
		//System.out.println("drawing");		
		//sun1.draw(g);
		
	}
	public static void main(String[] args) {
		LabThreeGame game = new LabThreeGame();
		game.start();

	}

	
	
	
	
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}