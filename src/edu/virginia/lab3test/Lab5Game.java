package edu.virginia.lab3test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

//import javax.swing.Timer;

import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.PhysicsSprite;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.events.Event;
import edu.virginia.engine.events.EventDispatcher;
import edu.virginia.engine.events.IEventListener;
import edu.virginia.engine.events.QuestManager;
import edu.virginia.engine.util.GameClock;
import edu.virginia.engine.util.SoundManager;
public class Lab5Game extends Game implements MouseListener{
	PhysicsSprite mario = new PhysicsSprite("Mario", "Sonic_standby1.png",0,0,0,0,0,1,1);
	AnimatedSprite rupee1= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	Sprite platform1= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform2= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform3= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform4= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform5= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	double tdelta=0;
	double tstart=0;
	double tend=0;
	GameClock time= new GameClock();
	SoundManager snd= new SoundManager();
	public Lab5Game() {
		super("Lab 5", 800, 800);
		super.getMainFrame().addMouseListener(this);
		mario.setScaleX(0.6);
		mario.setScaleY(0.6);
		time = new GameClock();
		mario.getFrames().add("Sonic_standby1.png");
		mario.getFrames().add("Sonic_standby2.png");
		mario.getFrames().add("Sonic_standby3.png");
		mario.getFrames().add("Sonic_standby4.png");
		mario.getFrames().add("Sonic_standby5.png");
		mario.getFrames().add("Sonic_standby6.png");
		mario.getFrames().add("Sonic_run1.png");
		mario.getFrames().add("Sonic_run2.png");
		mario.getFrames().add("Sonic_run4.png");
		mario.getFrames().add("Sonic_run5.png");
		mario.getFrames().add("Sonic_run1.png");
		
		rupee1.getFrames().add("rupee1.png");
		rupee1.getFrames().add("rupee2.png");
		rupee1.getFrames().add("rupee6.png");
		rupee1.getFrames().add("rupee3.png");
		rupee1.getFrames().add("rupee4.png");
		rupee1.getFrames().add("rupee5.png");
		rupee1.setScaleX(.5);
		rupee1.setScaleY(.5);
		super.addChild(mario);
		super.addChild(rupee1);
		super.addChild(platform1);
		//super.addChild(platform2);
		/*super.addChild(platform3);
		super.addChild(platform4);
		super.addChild(platform5);
		platform3.setScaleY(.5);
		platform4.setScaleY(.5);
		platform5.setScaleY(.5);
		platform2.setPosition(500, 576);
		platform3.setPosition(70, 496);
		platform4.setPosition(500, 396);
		platform5.setPosition(40, 296);*/
		platform1.setPosition(100, 676);
		rupee1.setPosition(400,100);
		mario.setPosition(200, 600);
		
		snd.loadMusic("loop", "MoodyLoop.wav");
		snd.playMusic("loop");
		//mario.setMass(2);
		snd.LoadSoundEffect("jump", "jump.wav");
		
	}
	@Override
	public void draw(Graphics g){
		//g.drawString("Health Left:", 670, 30);
		
		
		
		
		super.draw(g);
		
		
		
		Graphics2D g2d = (Graphics2D)g;
		
		//g2d.draw(mario.getGlobalHitbox());
		g2d.draw(rupee1.getGlobalHitbox());
		//if(mario.isVisible()){
			//mario.draw(g);
		//}
		
		
	}
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		//tend=time.getElapsedTime();
		
		
		
		//mario.setForceY(0);
		mario.updatePhys();
		/* Make sure mario is not null. Sometimes Swing can auto cause an extra frame to go before everything is initialized */
		if(mario.collidesWith(platform1)){
			if(!mario.isJumping()){
			//mario.setPosition(mario.getPosition().getX(), 600);
			mario.setVelY(0);
			mario.setAccelY(0);
			}
		}
/*		if(mario.collidesWith(platform2)){
			if(mario.getPosition().getY()>platform2.getPosition().getY()+30){
			mario.setPosition(mario.getPosition().getX(), platform2.getPosition().getY()+50);
			mario.setForceY(2);
		}
			}
		if(mario.collidesWith(platform3)){
			if(mario.getPosition().getY()>platform3.getPosition().getY()){
			mario.setPosition(mario.getPosition().getX(), platform3.getPosition().getY()+50);
			mario.setForceY(2);
		}}
		if(mario.collidesWith(platform4)){
			if(mario.getPosition().getY()>platform4.getPosition().getY()){
			mario.setPosition(mario.getPosition().getX(), platform4.getPosition().getY()+50);
			mario.setForceY(2);
			}else{
			if(mario.getPosition().getY()<platform4.getPosition().getY()){
				mario.setPosition(mario.getPosition().getX(), platform4.getPosition().getY()-50);
				mario.setForceY(2);
				}
			}
		}*/
		if(mario.isJumping()){
			mario.jumps();
		}
		
		if(mario != null){
			mario.play("standby");
			mario.update(pressedKeys);
			
		}
		mario.play("standby");
		if(!pressedKeys.contains(KeyEvent.VK_SPACE)){
			mario.setJump(false);
			
		}
		if(rupee1 != null){
			rupee1.play("standby");
			rupee1.update(pressedKeys);
			
		}
		if(mario.getPosition().getY()>=750){
		mario.setPosition(200,600);
		}
		if(pressedKeys.contains(KeyEvent.VK_D)){
			
			mario.update(pressedKeys);
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getX()<711){
					mario.getPosition().setLocation(mario.getPosition().getX()+5,mario.getPosition().getY());

				}
			}
			//xcount+=5;
		}
		else{
			mario.setVelX(0);
		}
		
		if(pressedKeys.contains(KeyEvent.VK_A)){
			
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getX()>-20){
					//System.out.println(mario.getPosition().getX());
					
					mario.getPosition().setLocation(mario.getPosition().getX()-5,mario.getPosition().getY());
			}
			}
			//xcount-=5;
		}

		if(pressedKeys.contains(KeyEvent.VK_SPACE)){
			
			if(rupee1.isVisible()){
				snd.PlaySoundEffect("jump");
				mario.play("run");
				if(mario.getPosition().getY()>0){
					mario.setJump(true);
					
					mario.jumps();
				}
			}

			//ycount-=5;
		}
		
		
	}
	
	public static void main(String[] args) {
		Lab5Game game = new Lab5Game();
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
