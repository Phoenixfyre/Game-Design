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
import edu.virginia.engine.tweening.Tween;
import edu.virginia.engine.tweening.TweenEvent;
import edu.virginia.engine.tweening.TweenJuggler;
import edu.virginia.engine.tweening.TweenableParam;
import edu.virginia.engine.util.GameClock;
import edu.virginia.engine.util.SoundManager;
public class Lab6Game extends Game implements MouseListener{
	PhysicsSprite mario = new PhysicsSprite("Mario", "Sonic_standby1.png",0,0,0,0,0,1,1);
	AnimatedSprite rupee1= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	Tween marios=new Tween(mario);
	TweenJuggler jugg=new TweenJuggler();
	Tween rupee= new Tween(rupee1);
	TweenEvent alph1 = new TweenEvent("alph1", this);
	TweenEvent alph2 = new TweenEvent("alph2",this);
	TweenEvent size= new TweenEvent("size",this);
	Sprite platform1= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform2= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform3= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform4= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform5= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	double tdelta=0;
	double tstart=0;
	double tend=0;
	int jumpcounter;
	int numJumps= 1;
	int x1=1;
	GameClock time= new GameClock();
	SoundManager snd= new SoundManager();
	public Lab6Game() {
		super("Lab 6", 800, 800);
		super.getMainFrame().addMouseListener(this);
		//mario.setPosition(200, 500);
		mario.setScaleX(0.6);
		mario.setScaleY(0.6);
		mario.setAlpha(.11);
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
		
		
		
		marios.animate(TweenableParam.ALPHA, 0, 1, 5000);
		
		jugg.add(marios);
		rupee1.getFrames().add("rupee1.png");
		rupee1.getFrames().add("rupee2.png");
		rupee1.getFrames().add("rupee6.png");
		rupee1.getFrames().add("rupee3.png");
		rupee1.getFrames().add("rupee4.png");
		rupee1.getFrames().add("rupee5.png");
		rupee1.setScaleX(.2);
		rupee1.setScaleY(.2);
		super.addChild(mario);
		super.addChild(rupee1);
		super.addChild(platform1);
		rupee1.setPosition(300,120);
		mario.setPosition(200, 600);
		platform1.setPosition(100, 676);
		super.addChild(platform2);
		super.addChild(platform3);
		super.addChild(platform4);
		super.addChild(platform5);
		platform3.setScaleY(.5);
		platform4.setScaleY(.5);
		platform5.setScaleY(.5);
		platform2.setPosition(500, 576);
		platform3.setPosition(70, 496);
		platform4.setPosition(500, 396);
		platform5.setPosition(40, 296);
		
		
		
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
		
		g2d.draw(mario.getGlobalHitbox());
		g2d.draw(rupee1.getGlobalHitbox());
		//if(mario.isVisible()){
			//mario.draw(g);
		//}
		
		
	}
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		//tend=time.getElapsedTime();
		
		if(mario.collidesWith(platform1)){
			
			numJumps=1;
		}
		
		if(mario.collidesWith(platform2)){
					
			numJumps=1;
			
					
		}
				
		if(mario.collidesWith(platform3)){
			
			numJumps=1;
		}
		
		if(mario.collidesWith(platform4)){
			
			numJumps=1;
		}

		if(mario.collidesWith(platform5)){
			
			numJumps=1;
		}
		if(numJumps==1){
			mario.setVelY(0);
		}
		
		//mario.setForceY(0);
		mario.updatePhys();
		/* Make sure mario is not null. Sometimes Swing can auto cause an extra frame to go before everything is initialized */
		/*		if(mario.collidesWith(platform2)){
			if(mario.getPosition().getY()>platform2.getPosition().getY()+30){
			mario.setPosition(mario.getPosition().getX(), platform2.getPosition().getY()+50);
			mario.setForceY(2);
		}
			}
		*/
		
		
		if(mario != null){
			mario.play("standby");
			mario.update(pressedKeys);
			
		}
		mario.play("standby");
		
		if(rupee1 != null){
			rupee1.play("standby");
			rupee1.update(pressedKeys);
			
		}
		if(mario.getPosition().getY()>=750){
		mario.setPosition(200,600);
		}
		if(pressedKeys.contains(KeyEvent.VK_D)){
			if(mario.getAlpha()==1 && x1==1) {
			mario.update(pressedKeys);
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getX()<711){
					mario.setVelX(2);
					mario.getPosition().setLocation(mario.getPosition().getX()+5,mario.getPosition().getY());
					/*
					if(mario.collidesWith(platform2) && mario.getVelocityX()>0){
						mario.getPosition().setLocation(mario.getPosition().getX()-5,mario.getPosition().getY());
					}
					if(mario.collidesWith(platform3)){
						mario.getPosition().setLocation(mario.getPosition().getX()-5,mario.getPosition().getY());
					}
					if(mario.collidesWith(platform4)){
						mario.getPosition().setLocation(mario.getPosition().getX()-5,mario.getPosition().getY());
					}
					if(mario.collidesWith(platform5)){
						mario.getPosition().setLocation(mario.getPosition().getX()-5,mario.getPosition().getY());
					}
					*/
					
				}
			}
			//xcount+=5;
		}
		else{
			mario.setVelX(0);
		}
		}
		if(pressedKeys.contains(KeyEvent.VK_A)){
			if(mario.getAlpha()==1 && x1==1){
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getX()>-20){
					//System.out.println(mario.getPosition().getX());
					mario.setVelX(-2);
					mario.getPosition().setLocation(mario.getPosition().getX()-5,mario.getPosition().getY());
					/*if(mario.getVelocityX()<0){
					if(mario.collidesWith(platform2)){
						
						mario.getPosition().setLocation(mario.getPosition().getX()+5,mario.getPosition().getY());
					}
					if(mario.collidesWith(platform3)){
						mario.getPosition().setLocation(mario.getPosition().getX()+5,mario.getPosition().getY());
					}
					if(mario.collidesWith(platform4)){
						mario.getPosition().setLocation(mario.getPosition().getX()+5,mario.getPosition().getY());
					}
					if(mario.collidesWith(platform5)){
						mario.getPosition().setLocation(mario.getPosition().getX()+5,mario.getPosition().getY());
					}*/
			
				}}
			}
			//xcount-=5;
		}
		else{
			mario.setVelX(0);
		}

		if(pressedKeys.contains(KeyEvent.VK_SPACE)){
			if(mario.getAlpha()==1 && x1==1){
			if(rupee1.isVisible()){
				//snd.PlaySoundEffect("jump");
				mario.play("run");
				if(mario.getPosition().getY()>0){
					if(numJumps>0){
						if(jumpcounter!=mario.getJumpHeight()){
						mario.setPosition(mario.getPosition().getX(), mario.getPosition().getY()-5);
						mario.setVelY(-1);
						jumpcounter+=1;
						}
						else{
							numJumps=0;
							jumpcounter=0;
							mario.setVelY(2);
							
						}
					}
					
				}
			}
			}
			//ycount-=5;
		}
		if(!pressedKeys.contains(KeyEvent.VK_SPACE)){
			mario.setVelY(2);
			numJumps=0;
		}
		if(mario.collidesWith(rupee1)){
			mario.setPosition(200, 600);
			x1=0;
			//System.out.println("coll");	
		}
		if(x1==0){
			rupee.animate(TweenableParam.XPOS, 300, 400, 4000);
			rupee.animate(TweenableParam.YPOS, 120, 500, 4000);
			rupee.animate(TweenableParam.XSCALE, .2,.4, 3500);
			rupee.animate(TweenableParam.YSCALE, .2,.4, 3500);
			
			jugg.add(rupee);
			
			
			x1=2;
		}
		if(x1==2){
			rupee.animate(TweenableParam.ALPHA,.8,.09,500);
			jugg.add(rupee);
		}
		jugg.update();
	}
	
	public static void main(String[] args) {
		Lab6Game game = new Lab6Game();
		
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
