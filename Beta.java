package edu.virginia.lab3test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

//import javax.swing.Timer;

import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.Camera;
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
public class Beta extends Game implements MouseListener{
	public Protagonist mario = new Protagonist("Mario", "Sonic_standby1.png",0,0,0,0,0,1,1);
	AnimatedSprite rupee1= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	Sprite platform1= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Tween marios=new Tween(mario);
	public Tween plat= new Tween(platform1);
	public TweenJuggler jugg=new TweenJuggler();
	int y2=0;
	Tween rupee= new Tween(rupee1);
	Sprite onswitch= new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite onswitch1= new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite onswitch2= new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite onswitch3= new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite onswitch4 = new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite onswitch5 = new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite offswitch= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch1= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch2= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch3= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch4= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch5= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);

	TweenEvent alph1 = new TweenEvent("alph1", this);
	TweenEvent alph2 = new TweenEvent("alph2",this);
	TweenEvent size= new TweenEvent("size",this);
	
	Camera cam = new Camera();
	Sprite platform2= new Sprite("platform1","platform.png",0,0,0,0,0,1,1);
	Sprite platform3= new Sprite("platform2","platform.png",0,0,0,0,0,1,1);
	Sprite platform4= new Sprite("platform3","platform.png",0,0,0,0,0,1,1);
	Sprite platform5= new Sprite("platform4","platform.png",0,0,0,0,0,1,1);
	Sprite platform6= new Sprite("platform5","platform.png",0,0,0,0,0,1,1);
	Sprite platform7= new Sprite("platform6","platform.png",0,0,0,0,0,1,1);
	Sprite platform8= new Sprite("platform7","platform.png",0,0,0,0,0,1,1);
	Sprite platform9= new Sprite("platform8","platform.png",0,0,0,0,0,1,1);
	Sprite platform10= new Sprite("platform9","platform.png",0,0,0,0,0,1,1);
	Sprite platform11= new Sprite("platform10","platform.png",0,0,0,0,0,1,1);
	Sprite platform12= new Sprite("platform11","platform.png",0,0,0,0,0,1,1);
	Sprite platform13= new Sprite("platform12","platform.png",0,0,0,0,0,1,1);
	Sprite platform14= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	
	boolean isfalling= false;
	//Sprite platform5= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite rock1= new Sprite("rock1", "rock.png",0,0,0,0,0,1,1);
	Sprite rock2= new Sprite("rock2", "rock.png",0,0,0,0,0,1,1);
	Sprite rock3= new Sprite("rock3", "rock.png",0,0,0,0,0,1,1);
	Sprite rock4= new Sprite("rock4", "rock.png",0,0,0,0,0,1,1);
	Sprite rock5= new Sprite("rock5", "rock.png",0,0,0,0,0,1,1);
	Sprite rock6= new Sprite("rock6", "rock.png",0,0,0,0,0,1,1);
	Sprite rock7= new Sprite("rock7", "rock.png",0,0,0,0,0,1,1);
	Sprite fireball=new Sprite("fireball", "fireball.png", 0,0,0,0,0,1,1);
	double tdelta=0;
	public int bb=0;
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
	//Menu buymenu=new Menu();
	Sprite door= new Sprite("door","door.png",0,0,0,0,0,1,1);
	Sprite door1= new Sprite("door1","door.png",0,0,0,0,0,1,1);
	Sprite door2= new Sprite("door2","door.png",0,0,0,0,0,1,1);
	Sprite door3= new Sprite("door3","door.png",0,0,0,0,0,1,1);
	
	boolean fire=true;
	Point position1 = new Point(200,600);
	Point position2 = new Point(2600, 55);
	Point position3 = new Point(2600, 55);
	Point position4 = new Point(2600, 55);
	Rectangle j= new Rectangle();
	Rectangle b= new Rectangle();
	Rectangle q= new Rectangle();
	Rectangle d= new Rectangle();
	Rectangle a= new Rectangle();
	int level=1;
	int start1=0;
	int start2=0;
	int start3=0;
	int start4 =0;
	boolean destroy=false;
	public Beta() {
		super("Beta", 9000, 800);
		super.getMainFrame().addMouseListener(this);
		b.setRect(1000,30, 100, 100);
		q.setRect(800,30,100,100);
		d.setRect(600,30,100,100);
		a.setRect(200,30,100,100);
		j.setRect(400,30,100,100);
		door.setScaleX(.1);
		door.setScaleY(.1);
		door.setVisible(false);
		
		door1.setScaleX(.1);
		door1.setScaleY(.1);
		door1.setVisible(false);
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
		super.addChild(door1);
		
		/*buymenu.addItem("Jump", 1);
		buymenu.addItem("Interact", 2);
		buymenu.addItem("JetPack", 35);
		buymenu.addItem("Sword", 50);
		buymenu.addItem("Fireball", 50);
		*/
		
	//	marios.animate(TweenableParam.ALPHA, 0, 1, 5000);
		//jugg.add(marios);
		
		rupee1.getFrames().add("rupee1.png");
		rupee1.getFrames().add("rupee2.png");
		rupee1.getFrames().add("rupee6.png");
		rupee1.getFrames().add("rupee3.png");
		rupee1.getFrames().add("rupee4.png");
		rupee1.getFrames().add("rupee5.png");
		rupee1.setScaleX(.2);
		rupee1.setScaleY(.2);
		
		
		rock1.setScaleX(.2);
		rock1.setScaleY(.2);
		
		rock2.setScaleX(.2);
		rock2.setScaleY(.2);
		super.addChild(mario);
		
		super.addChild(platform1);
		
		//super.addChild(offswitch);
		//super.addChild(onswitch);
		onswitch.setVisible(false);
		rupee1.setPosition(600,680);
		mario.setPosition(position1);
		
		super.addChild(platform2);
		super.addChild(platform3);
		platform1.setScaleX(.8);
		super.addChild(platform4);
		super.addChild(platform5);
		super.addChild(platform6);
		super.addChild(platform7);
		super.addChild(platform8);
		super.addChild(platform9);
		super.addChild(platform10);
		super.addChild(platform11);
		super.addChild(platform12);
		
		
		platform3.setScaleY(.5);
		platform4.setScaleY(.5);
		platform5.setScaleY(.5);
		platform2.setScaleX(.5);
		
		platform4.setScaleX(.1);
		platform4.setScaleY(.2);
		
		platform8.setScaleX(.1);
		platform8.setScaleY(.2);	
		
		
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
		super.addChild(fireball);
		fireball.setVisible(false);
		//Level 1 Platforms, Switches, Levers, doors
		platform1.setPosition(100, 676);
		platform2.setPosition(400, 676);
		platform3.setPosition(600, 696);
		platform4.setPosition(300,666);
		rock1.setPosition(150,656);
		door.setPosition(400,600);
		
		
		//Level 2 Platforms...
		platform5.setPosition(2500, 100);
		platform6.setPosition(3000,200);
		platform7.setPosition(3050,500);
		platform8.setPosition(2550,90);
		rock2.setPosition(3020,80);
		door1.setPosition(3050, 430);
		//Level 3 Platforms...
	}
	@Override
	public void draw(Graphics g){
		//g.drawString("Health Left:", 670, 30);
		g.drawString("total coins ="+ mario.getTotalCoins(), 20, 20);
		g.drawString("Jump=5coins",(int)q.getCenterX()-40, (int)q.getCenterY());
		g.drawString("JetPack=5coins",(int)a.getCenterX()-40, (int)a.getCenterY());
		g.drawString("Interact=5coins",(int)j.getCenterX()-40, (int)j.getCenterY());
		g.drawString("EndDisapear=5coins",(int)d.getCenterX()-40, (int)d.getCenterY());
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.draw(q);;
		g2d.draw(a);
	
		g2d.draw(d);
		g2d.draw(j);
		
		cam.draw(g);
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
		
		
		//g2d.draw(mario.getGlobalHitbox());
		//g2d.draw(rupee1.getGlobalHitbox());
		
		
		
		
	}
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		cam.setX((int)mario.getPosition().getX()-400);
		cam.setY((int)mario.getPosition().getY()-400);
		//tend=time.getElapsedTime();
		/*if(pressedKeys.contains(KeyEvent.VK_SHIFT)){
			fireball.getPosition().setLocation(mario.getPosition().getX(), mario.getPosition().getY());
			if(fire=true){
				fireball.setVisible(true);
				GameClock c= new GameClock();
				if(c.getElapsedTime()<4000){
					
					fireball.setPosition(fireball.getPosition().getX()+5,fireball.getPosition().getY());
				
				}
				
			}
		}
		*/
		/*if(pressedKeys.contains(KeyEvent.VK_SHIFT)){
			fire=true;
		}
		*/
		if(rock1.collidesWith(platform4)){
			door.setVisible(true);
		}
		if(rock2.collidesWith(platform8)){
			door1.setVisible(true);
		}
		if(mario.collidesWith(platform1) &&platform1.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		
		if(mario.collidesWith(platform2) && platform2.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			
					
		}
				
		if(mario.collidesWith(platform3) && platform3.getAlpha()==1){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform5) && platform5.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform6) && platform6.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform7) && platform7.getAlpha()>0){
			isfalling=false;
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
			if(level==1){
				mario.setPosition(position1);
			} else if(level == 2){
				mario.setPosition(position2);
			} else if(level == 3){
				mario.setPosition(position3);
			} else if(level == 4){
				mario.setPosition(position4);
			}

		cam.setX(0);
		cam.setY(0);
		}
		if(pressedKeys.contains(KeyEvent.VK_D)){
			cam.setX(cam.getX()+5);
			mario.update(pressedKeys);
			
				mario.play("run");
				if(mario.getPosition().getX()<8500){
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
			
					
				
			
			//xcount+=5;
		}
		else{
			mario.setVelX(0);
		}
/*	if(pressedKeys.contains(KeyEvent.VK_M)){
			this.pause();
			this.addChild(buymenu);
			if(buymenu.getOpen() == false){
				buymenu.setOpen(true);
			} else if (buymenu.getOpen() == true){
				buymenu.setOpen(false);
			}
		}*/
		
		}
		if(pressedKeys.contains(KeyEvent.VK_A)){
			//if(mario.getAlpha()==1 && x1==1){
			cam.setX(cam.getX()-5);
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
			
				}
			}
			//xcount-=5;
		
		else{
			mario.setVelX(0);
		}

		if(pressedKeys.contains(KeyEvent.VK_SPACE)){
			//if(mario.getAlpha()==1 && x1==1){
			if(mario.isJumping()|| mario.isJetpacking()){
			
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
							
							isfalling=true;
							}
							else{
								mario.setVelY(5);
								
								isfalling=true;
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
		if(numJumps==0){
			
		}
		if(!pressedKeys.contains(KeyEvent.VK_F)){
			x1=1;
			
			//if(rock1.getParent().getId()==mario.getId()){
				//rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+50);
			//}
			
			if(y2==1){
			rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+50);
			y2=0;
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_F)){
			if(mario.interact()==true){
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
			
			if(mario.collidesWith(door)){
				level=2;
				start2=1;
				
				
			}
			if(start2==1){
				//POSITION OF NEXT LEVEL
				mario.setPosition(position2);
				start2=0;
			}	
		}
			}
		jugg.update();
		}
	
	
	public static void main(String[] args) {
		Beta game = new Beta();
		
		game.start();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx=e.getX();
		int my=e.getY();
	/*	g.drawString("Jump=5coins",(int)q.getCenterX()-40, (int)q.getCenterY());
		g.drawString("JetPack=5coins",(int)a.getCenterX()-40, (int)a.getCenterY());
		g.drawString("Interact=5coins",(int)j.getCenterX()-40, (int)j.getCenterY());
		g.drawString("EndDisapear=5coins",(int)d.getCenterX()-40, (int)d.getCenterY());*/
		if(mx>q.getX() && mx<q.getX()+100 && my>q.getY() &&my<q.getY()+150){
			System.out.println();

			mario.setJump(true);
			mario.minusTotalCoins(5);
			
		}	
		
		if(mx>a.getX() && mx<a.getX()+100 ){
			System.out.println("hit");
			mario.setJetpack(true);
			mario.minusTotalCoins(5);
			
		}		
		if((mx>d.getX() && mx<d.getX()+100 && my>d.getY() &&my<d.getY()+150)){
			if(bb==0){
				plat.animate(TweenableParam.ALPHA, .9, .05, 2000);
				
				jugg.add(plat);
			mario.minusTotalCoins(5);
			bb++;
			}
		}
		if((mx>j.getX() && mx<j.getX()+100 && my>j.getY() &&my<j.getY()+150)){
			mario.setinteract(true);
			mario.minusTotalCoins(5);
			
		}
		
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