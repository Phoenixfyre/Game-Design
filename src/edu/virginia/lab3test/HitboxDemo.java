package edu.virginia.lab3test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

//import edu.virginia.engine.controller.GamePad;
import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.Sprite;


public class HitboxDemo extends Game{

	private Sprite mario = new Sprite("Mario", "Mario.png",0,300,100,0,0,0,0);
	private Sprite mario2 = new Sprite("Mario", "Mario.png",0,500,300,0,0,0,0);
	
	public HitboxDemo(String gameId, int width, int height) {
		super(gameId, width, height);
		// TODO Auto-generated constructor stub
		mario2.setPosition(500, 500);
		mario.setPosition(100, 100);
		mario.setScaleX(0.6);
		mario.setScaleY(0.6);
		mario2.setScaleX(0.8);
		mario2.setScaleY(0.8);
		
		this.addChild(mario);
		mario.addChild(mario2);
		mario.setCenter();
		mario2.setCenter();
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		
		if(pressedKeys.contains(KeyEvent.VK_D)){		
			mario.getPosition().setLocation(mario.getPosition().getX()+5, mario.getPosition().getY());
			}
		
		if(pressedKeys.contains(KeyEvent.VK_A)) 	mario.getPosition().setLocation(mario.getPosition().getX()-5,getPosition().getY());
		if(pressedKeys.contains(KeyEvent.VK_W)) 	mario.getPosition().setLocation(mario.getPosition().getX(),getPosition().getY()-5);
		if(pressedKeys.contains(KeyEvent.VK_S)) 	mario.getPosition().setLocation(mario.getPosition().getX(),getPosition().getY()+5);
		
		if(pressedKeys.contains(KeyEvent.VK_A)){
			
				
			mario.setScaleY(mario.getScaleY()-0.01);
			mario.setScaleX(mario.getScaleX()-0.01);
			
			
		}
		
		if(pressedKeys.contains(KeyEvent.VK_C))		mario.setRotation(mario.getRotation()-.05);
		if(pressedKeys.contains(KeyEvent.VK_X)) 	mario.setRotation(getRotation()-.2);
		
		
		if(pressedKeys.contains(KeyEvent.VK_RIGHT))	mario2.getPosition().setLocation(mario2.getPosition().getX()+5,getPosition().getY());
		if(pressedKeys.contains(KeyEvent.VK_LEFT)) 	mario2.getPosition().setLocation(mario2.getPosition().getX()-5,getPosition().getY());
		if(pressedKeys.contains(KeyEvent.VK_UP)) 	mario2.getPosition().setLocation(mario2.getPosition().getX(),getPosition().getY()-5);
		if(pressedKeys.contains(KeyEvent.VK_DOWN)) 	mario2.getPosition().setLocation(mario2.getPosition().getX(),getPosition().getY()+5);
		
		if(pressedKeys.contains(KeyEvent.VK_M))		mario2.setRotation(mario.getRotation()-.05);
		if(pressedKeys.contains(KeyEvent.VK_N)) 	mario2.setRotation(mario.getRotation()+.05);
		
		/*Print if they are colliding to test collision*/
		if(mario.collidesWith(mario2)) System.out.println("Colliding!");;
		
	}
	
	@Override
	public void draw(Graphics g){
		super.draw(g);
		
		Graphics2D g2d = (Graphics2D)g;
		//draw mario's hitboxes to test
		g2d.draw(mario.getGlobalHitbox());
		g2d.draw(mario2.getGlobalHitbox());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HitboxDemo demo = new HitboxDemo("Hitbox Demo", 800,600);
		demo.start();
	}

}
