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
import edu.virginia.engine.display.Menu;
import edu.virginia.engine.display.PhysicsSprite;
import edu.virginia.engine.display.Protagonist;
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
public class Prototype extends Game implements MouseListener{
	Protagonist mario = new Protagonist("Mario", "Sonic_standby1.png",0,0,0,0,0,1,1);
	AnimatedSprite rupee1= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	Tween marios=new Tween(mario);
	TweenJuggler jugg=new TweenJuggler();
	int y2=0;
	Tween rupee= new Tween(rupee1);
	Sprite onswitch= new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite offswitch= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	TweenEvent alph1 = new TweenEvent("alph1", this);
	TweenEvent alph2 = new TweenEvent("alph2",this);
	TweenEvent size= new TweenEvent("size",this);
	Sprite platform1= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform2= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite platform3= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	//Sprite platform4= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	//Sprite platform5= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite rock1= new Sprite("rock1", "rock.png",0,0,0,0,0,1,1);
	double tdelta=0;
	double tstart=0;
	double tend=0;
	int jumpcounter;
	int numJumps= 1;
	int x1=1;
	int y1=1;
	GameClock time= new GameClock();
	SoundManager snd= new SoundManager();
	boolean on=false;
	boolean off=true;
	boolean menuon=false;
	Menu buymenu=new Menu();
	Sprite door= new Sprite("door","door.png",0,0,0,0,0,1,1);

	public Prototype() {
		super("Prototype", 800, 800);
		super.getMainFrame().addMouseListener(this);
		super.getMainFrame().add(buymenu);
		//mario.setPosition(200, 500);
		mario.setScaleX(0.6);
		mario.setScaleY(0.6);
		//mario.setAlpha(.11);
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
		super.addChild(door);
		
		
	//	marios.animate(TweenableParam.ALPHA, 0, 1, 5000);
		jugg.add(marios);
		rupee1.getFrames().add("rupee1.png");
		rupee1.getFrames().add("rupee2.png");
		rupee1.getFrames().add("rupee6.png");
		rupee1.getFrames().add("rupee3.png");
		rupee1.getFrames().add("rupee4.png");
		rupee1.getFrames().add("rupee5.png");
		rupee1.setScaleX(.2);
		rupee1.setScaleY(.2);
		
		rock1.setPosition(150,656);
		rock1.setScaleX(.2);
		rock1.setScaleY(.2);
		super.addChild(mario);
		
		super.addChild(platform1);
		//super.addChild(offswitch);
		//super.addChild(onswitch);
		onswitch.setVisible(false);
		rupee1.setPosition(600,680);
		mario.setPosition(200, 600);
		platform1.setPosition(100, 676);
		super.addChild(platform2);
		super.addChild(platform3);
		platform1.setScaleX(.5);
		//super.addChild(platform4);
		//super.addChild(platform5);
		platform3.setScaleY(.5);
		////platform4.setScaleY(.5);
		//platform5.setScaleY(.5);
		platform2.setScaleX(.5);
		platform2.setPosition(400, 676);
		platform3.setPosition(600, 696);
		//platform4.setPosition(500, 396);
		//platform5.setPosition(40, 296);
		
		onswitch.setScaleX(.2);
		onswitch.setScaleY(.2);
		offswitch.setScaleX(.2);
		offswitch.setScaleY(.2);
		//snd.loadMusic("loop", "MoodyLoop.wav");
		//snd.playMusic("loop");
		//mario.setMass(2);
		//snd.LoadSoundEffect("jump", "jump.wav");
		offswitch.setPosition(520, 629);
		onswitch.setPosition(420,629);
		platform3.setAlpha(.3);
	}
	@Override
	public void draw(Graphics g){
		//g.drawString("Health Left:", 670, 30);
		g.drawString("total coins ="+ mario.getTotalCoins(), 20, 20);
		
		if(menuon){
			super.removeAllChildren();
		}
		else{
			super.addChild(mario);
			super.addChild(platform1);
			super.addChild(platform2);
			super.addChild(platform3);
		}
			
		
		
		
		super.draw(g);
		
		if(onswitch.isVisible()){
			onswitch.draw(g);
		}
		if(offswitch.isVisible()){
			offswitch.draw(g);
		}
		if(rock1.isVisible()){
		rock1.draw(g);}
		if(rupee1.isVisible()){
		rupee1.draw(g);
		}
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.draw(mario.getGlobalHitbox());
		//g2d.draw(rupee1.getGlobalHitbox());
		
		
		
		
	}
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		//tend=time.getElapsedTime();
		
		if(mario.collidesWith(platform1) &&platform1.getAlpha()>0){
			
			numJumps=1;
		}
		
		if(mario.collidesWith(platform2) && platform2.getAlpha()>0){
					
			numJumps=1;
			
					
		}
				
		if(mario.collidesWith(platform3) && platform3.getAlpha()==1){
			
			numJumps=1;
		}
		if(mario.collidesWith(rupee1)){
			rupee1.setVisible(false);
			rupee1.setPosition(1, 200);
			mario.addCoin();
			
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
			//xcount+=5;
		}
		else{
			mario.setVelX(0);
		}
		if(pressedKeys.contains(KeyEvent.VK_M)){
			menuon=true;
		}
		
		}
		if(pressedKeys.contains(KeyEvent.VK_A)){
			//if(mario.getAlpha()==1 && x1==1){
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
		
		else{
			mario.setVelX(0);
		}

		if(pressedKeys.contains(KeyEvent.VK_SPACE)){
			//if(mario.getAlpha()==1 && x1==1){
			if(mario.isJumping()|| mario.isJetpacking()){
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
							if(mario.isJetpacking()){
							mario.setVelY(2);
							}
							else{
								mario.setVelY(5);
							}
						}
					}
					}
				}
			}
			}
			//ycount-=5;
		
		if(!pressedKeys.contains(KeyEvent.VK_SPACE)){
			mario.setVelY(5);
			numJumps=0;
		}
		if(!pressedKeys.contains(KeyEvent.VK_F)){
			x1=1;
			
			//if(rock1.getParent().getId()==mario.getId()){
				//rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+50);
			//}
			
			if(y2==1){
			rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+60);
			y2=0;
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_F)){
			if(x1==1){
				if(mario.collidesWith(offswitch)){
					platform3.setAlpha(1);
					off=false;
					on=true;
					offswitch.setVisible(false);
					onswitch.setVisible(true);
					x1=0;
					
				}
			}
			if(x1==1){
				if(mario.collidesWith(onswitch)){
					platform3.setAlpha(.5);
					on=false;
					off=true;
					offswitch.setVisible(true);
					onswitch.setVisible(false);
					x1=0;
				}
			}
			if(y1==1){
				if(mario.collidesWith(rock1)){
					
					rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()-20);
					y2=1;
				}
			}
		}}
	
	
	public static void main(String[] args) {
		Prototype game = new Prototype();
		
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
