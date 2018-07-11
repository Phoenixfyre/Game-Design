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
	boolean gamestart=false;
	public Protagonist mario = new Protagonist("Mario", "Sonic_standby1.png",0,0,0,0,0,1,1);
	AnimatedSprite rupee1= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee2= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee3= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee4= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee5= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee6= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee7= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee8= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee9= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee10= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee11= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee12= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee13= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee14= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee15= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee16= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee17= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee18= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee19= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee20= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee21= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee22= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee23= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee24= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee26= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee25= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee28= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee27= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee29= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee30= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	
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
	Boolean up=true;
	boolean side1=true;
	boolean side2=true;
	boolean diag1=true;
	boolean diag2 = true;
	boolean side3=true;
	boolean diag3=true;
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
	
	Sprite platform15= new Sprite("platform9","platform.png",0,0,0,0,0,1,1);
	Sprite platform16= new Sprite("platform10","platform.png",0,0,0,0,0,1,1);
	Sprite platform17= new Sprite("platform11","platform.png",0,0,0,0,0,1,1);
	Sprite platform18= new Sprite("platform12","platform.png",0,0,0,0,0,1,1);
	Sprite platform19= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform20= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	
	Sprite platform21= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform22= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform23= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform24= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform25= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform26= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform27= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform28= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform29= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform30= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	
	
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
	Sprite background= new Sprite("Background", "background1.png",0,0,0,0,0,1,1);
	public Beta() {
		super("Beta", 800, 800);
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
		door2.setScaleX(.1);
		door2.setScaleY(.1);
		door3.setScaleX(.1);
		door3.setScaleY(.1);
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
		super.addChild(rupee2);
		super.addChild(rupee3);
		super.addChild(rupee4);
		super.addChild(rupee5);
		super.addChild(rupee6);
		super.addChild(rupee7);
		super.addChild(rupee8);
		super.addChild(rupee9);
		super.addChild(rupee10);
		super.addChild(rupee12);
		super.addChild(rupee11);
		super.addChild(rupee13);
		super.addChild(rupee14);
		super.addChild(rupee15);
		super.addChild(rupee16);
		super.addChild(rupee17);
		super.addChild(rupee18);
		super.addChild(rupee19);
		super.addChild(rupee20);
		super.addChild(rupee21);
		super.addChild(rupee22);
		super.addChild(rupee23);
		super.addChild(rupee24);
		super.addChild(rupee25);
		super.addChild(rupee26);
		super.addChild(rupee27);
		super.addChild(rupee28);
		super.addChild(rupee29);
		super.addChild(rupee30);
		
		background.setScaleX(8);
		background.setScaleY(5);
		background.setPosition(-2000,-900);
		
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
		
		rupee2.getFrames().add("rupee1.png");
		rupee2.getFrames().add("rupee2.png");
		rupee2.getFrames().add("rupee6.png");
		rupee2.getFrames().add("rupee3.png");
		rupee2.getFrames().add("rupee4.png");
		rupee2.getFrames().add("rupee5.png");
		rupee2.setScaleX(.2);
		rupee2.setScaleY(.2);
		
		rupee3.getFrames().add("rupee1.png");
		rupee3.getFrames().add("rupee2.png");
		rupee3.getFrames().add("rupee6.png");
		rupee3.getFrames().add("rupee3.png");
		rupee3.getFrames().add("rupee4.png");
		rupee3.getFrames().add("rupee5.png");
		rupee3.setScaleX(.2);
		rupee3.setScaleY(.2);
		
		rupee4.getFrames().add("rupee1.png");
		rupee4.getFrames().add("rupee2.png");
		rupee4.getFrames().add("rupee6.png");
		rupee4.getFrames().add("rupee3.png");
		rupee4.getFrames().add("rupee4.png");
		rupee4.getFrames().add("rupee5.png");
		rupee4.setScaleX(.2);
		rupee4.setScaleY(.2);
		
		rupee5.getFrames().add("rupee1.png");
		rupee5.getFrames().add("rupee2.png");
		rupee5.getFrames().add("rupee6.png");
		rupee5.getFrames().add("rupee3.png");
		rupee5.getFrames().add("rupee4.png");
		rupee5.getFrames().add("rupee5.png");
		rupee5.setScaleX(.2);
		rupee5.setScaleY(.2);
		
		rupee6.getFrames().add("rupee1.png");
		rupee6.getFrames().add("rupee2.png");
		rupee6.getFrames().add("rupee6.png");
		rupee6.getFrames().add("rupee3.png");
		rupee6.getFrames().add("rupee4.png");
		rupee6.getFrames().add("rupee5.png");
		rupee6.setScaleX(.2);
		rupee6.setScaleY(.2);
		
		rupee7.getFrames().add("rupee1.png");
		rupee7.getFrames().add("rupee2.png");
		rupee7.getFrames().add("rupee6.png");
		rupee7.getFrames().add("rupee3.png");
		rupee7.getFrames().add("rupee4.png");
		rupee7.getFrames().add("rupee5.png");
		rupee7.setScaleX(.2);
		rupee7.setScaleY(.2);
		
		rupee8.getFrames().add("rupee1.png");
		rupee8.getFrames().add("rupee2.png");
		rupee8.getFrames().add("rupee6.png");
		rupee8.getFrames().add("rupee3.png");
		rupee8.getFrames().add("rupee4.png");
		rupee8.getFrames().add("rupee5.png");
		rupee8.setScaleX(.2);
		rupee8.setScaleY(.2);
		
		rupee9.getFrames().add("rupee1.png");
		rupee9.getFrames().add("rupee2.png");
		rupee9.getFrames().add("rupee6.png");
		rupee9.getFrames().add("rupee3.png");
		rupee9.getFrames().add("rupee4.png");
		rupee9.getFrames().add("rupee5.png");
		rupee9.setScaleX(.2);
		rupee9.setScaleY(.2);
		
		rupee10.getFrames().add("rupee1.png");
		rupee10.getFrames().add("rupee2.png");
		rupee10.getFrames().add("rupee6.png");
		rupee10.getFrames().add("rupee3.png");
		rupee10.getFrames().add("rupee4.png");
		rupee10.getFrames().add("rupee5.png");
		rupee10.setScaleX(.2);
		rupee10.setScaleY(.2);
		
		rupee11.getFrames().add("rupee1.png");
		rupee11.getFrames().add("rupee2.png");
		rupee11.getFrames().add("rupee6.png");
		rupee11.getFrames().add("rupee3.png");
		rupee11.getFrames().add("rupee4.png");
		rupee11.getFrames().add("rupee5.png");
		rupee11.setScaleX(.2);
		rupee11.setScaleY(.2);
		
		rupee12.getFrames().add("rupee1.png");
		rupee12.getFrames().add("rupee2.png");
		rupee12.getFrames().add("rupee6.png");
		rupee12.getFrames().add("rupee3.png");
		rupee12.getFrames().add("rupee4.png");
		rupee12.getFrames().add("rupee5.png");
		rupee12.setScaleX(.2);
		rupee12.setScaleY(.2);
		
		rupee13.getFrames().add("rupee1.png");
		rupee13.getFrames().add("rupee2.png");
		rupee13.getFrames().add("rupee6.png");
		rupee13.getFrames().add("rupee3.png");
		rupee13.getFrames().add("rupee4.png");
		rupee13.getFrames().add("rupee5.png");
		rupee13.setScaleX(.2);
		rupee13.setScaleY(.2);
		
		rupee14.getFrames().add("rupee1.png");
		rupee14.getFrames().add("rupee2.png");
		rupee14.getFrames().add("rupee6.png");
		rupee14.getFrames().add("rupee3.png");
		rupee14.getFrames().add("rupee4.png");
		rupee14.getFrames().add("rupee5.png");
		rupee14.setScaleX(.2);
		rupee14.setScaleY(.2);
		
		rupee15.getFrames().add("rupee1.png");
		rupee15.getFrames().add("rupee2.png");
		rupee15.getFrames().add("rupee6.png");
		rupee15.getFrames().add("rupee3.png");
		rupee15.getFrames().add("rupee4.png");
		rupee15.getFrames().add("rupee5.png");
		rupee15.setScaleX(.2);
		rupee15.setScaleY(.2);
		
		rupee16.getFrames().add("rupee1.png");
		rupee16.getFrames().add("rupee2.png");
		rupee16.getFrames().add("rupee6.png");
		rupee16.getFrames().add("rupee3.png");
		rupee16.getFrames().add("rupee4.png");
		rupee16.getFrames().add("rupee5.png");
		rupee16.setScaleX(.2);
		rupee16.setScaleY(.2);
		
		rupee17.getFrames().add("rupee1.png");
		rupee17.getFrames().add("rupee2.png");
		rupee17.getFrames().add("rupee6.png");
		rupee17.getFrames().add("rupee3.png");
		rupee17.getFrames().add("rupee4.png");
		rupee17.getFrames().add("rupee5.png");
		rupee17.setScaleX(.2);
		rupee17.setScaleY(.2);
		
		rupee18.getFrames().add("rupee1.png");
		rupee18.getFrames().add("rupee2.png");
		rupee18.getFrames().add("rupee6.png");
		rupee18.getFrames().add("rupee3.png");
		rupee18.getFrames().add("rupee4.png");
		rupee18.getFrames().add("rupee5.png");
		rupee18.setScaleX(.2);
		rupee18.setScaleY(.2);
		
		rupee19.getFrames().add("rupee1.png");
		rupee19.getFrames().add("rupee2.png");
		rupee19.getFrames().add("rupee6.png");
		rupee19.getFrames().add("rupee3.png");
		rupee19.getFrames().add("rupee4.png");
		rupee19.getFrames().add("rupee5.png");
		rupee19.setScaleX(.2);
		rupee19.setScaleY(.2);
		
		rupee20.getFrames().add("rupee1.png");
		rupee20.getFrames().add("rupee2.png");
		rupee20.getFrames().add("rupee6.png");
		rupee20.getFrames().add("rupee3.png");
		rupee20.getFrames().add("rupee4.png");
		rupee20.getFrames().add("rupee5.png");
		rupee20.setScaleX(.2);
		rupee20.setScaleY(.2);
		
		rupee21.getFrames().add("rupee1.png");
		rupee21.getFrames().add("rupee2.png");
		rupee21.getFrames().add("rupee6.png");
		rupee21.getFrames().add("rupee3.png");
		rupee21.getFrames().add("rupee4.png");
		rupee21.getFrames().add("rupee5.png");
		rupee21.setScaleX(.2);
		rupee21.setScaleY(.2);
		
		rupee22.getFrames().add("rupee1.png");
		rupee22.getFrames().add("rupee2.png");
		rupee22.getFrames().add("rupee6.png");
		rupee22.getFrames().add("rupee3.png");
		rupee22.getFrames().add("rupee4.png");
		rupee22.getFrames().add("rupee5.png");
		rupee22.setScaleX(.2);
		rupee22.setScaleY(.2);
		
		rupee23.getFrames().add("rupee1.png");
		rupee23.getFrames().add("rupee2.png");
		rupee23.getFrames().add("rupee6.png");
		rupee23.getFrames().add("rupee3.png");
		rupee23.getFrames().add("rupee4.png");
		rupee23.getFrames().add("rupee5.png");
		rupee23.setScaleX(.2);
		rupee23.setScaleY(.2);
		
		rupee24.getFrames().add("rupee1.png");
		rupee24.getFrames().add("rupee2.png");
		rupee24.getFrames().add("rupee6.png");
		rupee24.getFrames().add("rupee3.png");
		rupee24.getFrames().add("rupee4.png");
		rupee24.getFrames().add("rupee5.png");
		rupee24.setScaleX(.2);
		rupee24.setScaleY(.2);
		
		rupee25.getFrames().add("rupee1.png");
		rupee25.getFrames().add("rupee2.png");
		rupee25.getFrames().add("rupee6.png");
		rupee25.getFrames().add("rupee3.png");
		rupee25.getFrames().add("rupee4.png");
		rupee25.getFrames().add("rupee5.png");
		rupee25.setScaleX(.2);
		rupee25.setScaleY(.2);
		
		rupee26.getFrames().add("rupee1.png");
		rupee26.getFrames().add("rupee2.png");
		rupee26.getFrames().add("rupee6.png");
		rupee26.getFrames().add("rupee3.png");
		rupee26.getFrames().add("rupee4.png");
		rupee26.getFrames().add("rupee5.png");
		rupee26.setScaleX(.2);
		rupee26.setScaleY(.2);
		
		rupee27.getFrames().add("rupee1.png");
		rupee27.getFrames().add("rupee2.png");
		rupee27.getFrames().add("rupee6.png");
		rupee27.getFrames().add("rupee3.png");
		rupee27.getFrames().add("rupee4.png");
		rupee27.getFrames().add("rupee5.png");
		rupee27.setScaleX(.2);
		rupee27.setScaleY(.2);
		
		rupee28.getFrames().add("rupee1.png");
		rupee28.getFrames().add("rupee2.png");
		rupee28.getFrames().add("rupee6.png");
		rupee28.getFrames().add("rupee3.png");
		rupee28.getFrames().add("rupee4.png");
		rupee28.getFrames().add("rupee5.png");
		rupee28.setScaleX(.2);
		rupee28.setScaleY(.2);
		rupee29.getFrames().add("rupee1.png");
		rupee29.getFrames().add("rupee2.png");
		rupee29.getFrames().add("rupee6.png");
		rupee29.getFrames().add("rupee3.png");
		rupee29.getFrames().add("rupee4.png");
		rupee29.getFrames().add("rupee5.png");
		rupee29.setScaleX(.2);
		rupee29.setScaleY(.2);
		rupee30.getFrames().add("rupee1.png");
		rupee30.getFrames().add("rupee2.png");
		rupee30.getFrames().add("rupee6.png");
		rupee30.getFrames().add("rupee3.png");
		rupee30.getFrames().add("rupee4.png");
		rupee30.getFrames().add("rupee5.png");
		rupee30.setScaleX(.2);
		rupee30.setScaleY(.2);
		rock1.setScaleX(.2);
		rock1.setScaleY(.2);
		
		rock2.setScaleX(.2);
		rock2.setScaleY(.2);
		super.addChild(mario);
		
		super.addChild(platform1);
		
		//super.addChild(offswitch);
		//super.addChild(onswitch);
		onswitch.setVisible(false);
		
		
		
		super.addChild(platform2);
		super.addChild(platform3);
	
		super.addChild(platform4);
		super.addChild(platform5);
		super.addChild(platform6);
		super.addChild(platform7);
		super.addChild(platform8);
		super.addChild(platform9);
		super.addChild(platform10);
		super.addChild(platform11);
		super.addChild(platform12);
		super.addChild(platform13);
		super.addChild(platform14);
		super.addChild(platform15);
		super.addChild(platform16);
		super.addChild(platform17);
		super.addChild(platform18);
		super.addChild(platform19);
		super.addChild(platform20);
		super.addChild(platform21);
		super.addChild(platform22);

		
		
		
		
		onswitch.setScaleX(.2);
		onswitch.setScaleY(.2);
		offswitch.setScaleX(.2);
		offswitch.setScaleY(.2);
		onswitch1.setScaleX(.2);
		onswitch1.setScaleY(.2);
		offswitch1.setScaleX(.2);
		offswitch1.setScaleY(.2);
		onswitch2.setScaleX(.2);
		onswitch2.setScaleY(.2);
		offswitch2.setScaleX(.2);
		offswitch2.setScaleY(.2);
		snd.loadMusic("loop", "8-bit Detective.wav");
		snd.playMusic("loop");
		//mario.setMass(2);
		//snd.LoadSoundEffect("jump", "jump.wav");
		offswitch.setPosition(520, 629);
		onswitch.setPosition(420,629);
		
		super.addChild(fireball);
		fireball.setVisible(false);
		//Level 1 Platforms, Switches, Levers, doors
		mario.setPosition(position1);
		platform1.setPosition(100, 676);
		platform2.setPosition(-100, 676);
		platform2.setAlpha(0);
		platform3.setPosition(-700, 296);
		platform4.setPosition(-250,266);
		platform4.setScaleX(.7);
		platform4.setScaleY(.2);
		rock1.setPosition(150,656);
		door.setPosition(-230,180);
		door.setVisible(true);
		platform1.setScaleX(2);
		platform1.setScaleY(.5);
		platform2.setScaleX(.5);
		platform2.setScaleY(.5);
		rupee2.setPosition(200,600);
		rupee3.setPosition(300,600);
		rupee4.setPosition(400,600);
		rupee1.setPosition(500,600);
		
		//Level 2 Platforms...
		platform5.setPosition(2500, 100);
		platform6.setPosition(3000,200);
		platform7.setPosition(3050,500);
		platform8.setPosition(2550,90);
		platform8.setScaleX(.2);
		platform8.setScaleY(.2);
		rock2.setPosition(3020,200);
		door1.setPosition(3050, 430);
		super.addChild(rock2);
		super.addChild(door1);
		
		//Level 3 Platforms...
		rupee10.setPosition(6700,250);
		rupee11.setPosition(6800,250);
		rupee12.setPosition(6900,250);
		rupee13.setPosition(7000,250);
		rupee14.setPosition(6000,650);
		rupee15.setPosition(5700,650);
		rupee16.setPosition(5800,650);
		rupee17.setPosition(5900,650);
		rupee18.setPosition(5100,150);
		rupee19.setPosition(5000,150);
		rupee20.setPosition(5200,150);

		rupee30.setPosition(6700,200);
		platform9.setPosition(5000,200);
		
		platform12.setPosition(5600,300);
		platform13.setPosition(5700,700);
		//platform14 moving left to right
		platform14.setPosition(5300,500);
		platform15.setPosition(6000,300);
		platform16.setPosition(6000,750);
		platform17.setPosition(6700,300);
		platform17.setScaleX(1.5);
		platform15.setScaleX(.5);
		platform15.setScaleY(.5);
		platform16.setScaleX(.5);
		platform16.setScaleY(.5);
		door2.setPosition(5350,420);
		platform14.setScaleY(.3);
		super.addChild(door2);
		super.addChild(door3);
		
		super.addChild(offswitch2);
		super.addChild(onswitch2);
		onswitch2.setPosition(6800,250);
		onswitch2.setScaleX(.2);
		offswitch2.setPosition(7000,250);
		onswitch2.setVisible(false);
		
		//level 4 platforms
		rupee21.setPosition(10000,350);
		rupee22.setPosition(10100,350);
		rupee23.setPosition(10200,350);
		rupee24.setPosition(10300,350);
		rupee25.setPosition(10400,150);
		rupee26.setPosition(10500,150);
		rupee27.setPosition(10800,100);
		rupee28.setPosition(10600,150);
		rupee29.setPosition(10700,150);
		rupee30.setPosition(10000,250);
		platform18.setPosition(10000, 400);
		platform19.setScaleY(.5);
		platform22.setScaleY(.5);
		platform19.setPosition(10600,200);
		platform20.setPosition(10800,700);
		platform21.setPosition(11000,250);
		platform22.setPosition(10300,310);
		door3.setPosition(11110,0);
		door3.setScaleY(.3);
		door3.setScaleX(.3);
	}
	@Override
	public void draw(Graphics g){
		//g.drawString("Health Left:", 670, 30);
		if(gamestart==false){
		g.drawString("Press H to start game", 500, 500);
		}
		if(gamestart==true){
	
		Graphics2D g2d = (Graphics2D)g;
		
		cam.draw(g);
		super.draw(g);
		g2d.draw(q);;
		g2d.draw(a);
	
		g2d.draw(d);
		g2d.draw(j);
		
		g.drawString("total coins ="+ mario.getTotalCoins(), (int)mario.getPosition().getX()-200, (int)mario.getPosition().getY()-200);
		g.drawString("Jump=5coins",(int)q.getCenterX()-40, (int)q.getCenterY());
		g.drawString("JetPack=5coins",(int)a.getCenterX()-40, (int)a.getCenterY());
		g.drawString("Interact=5coins",(int)j.getCenterX()-40, (int)j.getCenterY());
		g.drawString("EndDisapear=5coins",(int)d.getCenterX()-40, (int)d.getCenterY());
		if(onswitch.isVisible()){
			onswitch.draw(g);
			platform2.setAlpha(1);
		}
		if(offswitch.isVisible()){
			offswitch.draw(g);
		}
		
		if(rock1.isVisible()){
		rock1.draw(g);}
		
		if(rupee1.isVisible()){
		rupee1.draw(g);
		}
		}
		
		
		//g.drawString("You can buy abilities through using the m key", 400, 200);

		//g2d.draw(mario.getGlobalHitbox());
		//g2d.draw(rupee1.getGlobalHitbox());
		
		
		
		
	}
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		if(pressedKeys.contains(KeyEvent.VK_H)){
			gamestart=true;
		}
		
		if(pressedKeys.contains(KeyEvent.VK_I)){
			mario.setPosition(5000,200);
		}
		if(pressedKeys.contains(KeyEvent.VK_P)){
			mario.setPosition(10000,200);
		}
		if(platform2.getPosition().getY()>400 &&up==true){
			platform2.setPosition(platform2.getPosition().getX()-2,platform2.getPosition().getY()-2);
			if(mario.collidesWith(platform2)){
				mario.setPosition(mario.getPosition().getX()-2,mario.getPosition().getY()-2);
			}
		}
		else{
			up=false;
		}
		if(up==false){
			platform2.setPosition(platform2.getPosition().getX()+2,platform2.getPosition().getY()+2);
			if(mario.collidesWith(platform2)){
				mario.setPosition(mario.getPosition().getX()+2,mario.getPosition().getY()+2);
			}
		}
		if(platform2.getPosition().getY()>700){
			up=true;
		}
		
		
		if(platform16.getPosition().getY()>200 &&diag1==true){
			platform16.setPosition(platform16.getPosition().getX()+2,platform16.getPosition().getY()-2);
			if(mario.collidesWith(platform16)){
				mario.setPosition(mario.getPosition().getX()+2,mario.getPosition().getY()-2);
			}
		}
		else{
			diag1=false;
		}
		if(diag1==false){
			platform16.setPosition(platform16.getPosition().getX()-2,platform16.getPosition().getY()+2);
			if(mario.collidesWith(platform16)){
				mario.setPosition(mario.getPosition().getX()-2,mario.getPosition().getY()+2);
			}
		}
		if(platform16.getPosition().getY()>700){
			diag1=true;
		}
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
		if(rupee2.isVisible()){
			rupee2.play("standby");
			rupee2.update(pressedKeys);
		}
		if(rupee3.isVisible()){
			rupee3.play("standby");
			rupee3.update(pressedKeys);
		}
		if(rupee4.isVisible()){
			rupee4.play("standby");
			rupee4.update(pressedKeys);
		}
		if(rupee5.isVisible()){
			rupee5.play("standby");
			rupee5.update(pressedKeys);
		}
		if(rupee6.isVisible()){
			rupee6.play("standby");
			rupee6.update(pressedKeys);
		}
		if(rupee7.isVisible()){
			rupee7.play("standby");
			rupee7.update(pressedKeys);
		}
		if(rupee8.isVisible()){
			rupee8.play("standby");
			rupee8.update(pressedKeys);
		}
		if(rupee9.isVisible()){
			rupee9.play("standby");
			rupee9.update(pressedKeys);
		}
		if(rupee10.isVisible()){
			rupee10.play("standby");
			rupee10.update(pressedKeys);
		}
		if(rupee11.isVisible()){
			rupee11.play("standby");
			rupee11.update(pressedKeys);
		}
		if(rupee12.isVisible()){
			rupee12.play("standby");
			rupee12.update(pressedKeys);
		}
		if(rupee13.isVisible()){
			rupee13.play("standby");
			rupee13.update(pressedKeys);
		}
		if(rupee14.isVisible()){
			rupee14.play("standby");
			rupee14.update(pressedKeys);
		}
		if(rupee15.isVisible()){
			rupee15.play("standby");
			rupee15.update(pressedKeys);
		}
		if(rupee16.isVisible()){
			rupee16.play("standby");
			rupee16.update(pressedKeys);
		}
		if(rupee17.isVisible()){
			rupee17.play("standby");
			rupee17.update(pressedKeys);

		}
		if(rupee18.isVisible()){
			rupee18.play("standby");
			rupee18.update(pressedKeys);

		}
		if(rupee19.isVisible()){
			rupee19.play("standby");
			rupee19.update(pressedKeys);

		}
		if(rupee20.isVisible()){
			rupee20.play("standby");
			rupee20.update(pressedKeys);

		}
		if(rupee21.isVisible()){
			rupee21.play("standby");
			rupee21.update(pressedKeys);

		}
		if(rupee22.isVisible()){
			rupee22.play("standby");
			rupee22.update(pressedKeys);

		}
		if(rupee23.isVisible()){
			rupee23.play("standby");
			rupee23.update(pressedKeys);

		}
		if(rupee24.isVisible()){
			rupee24.play("standby");
			rupee24.update(pressedKeys);

		}
		if(rupee25.isVisible()){
			rupee25.play("standby");
			rupee25.update(pressedKeys);

		}
		if(rupee26.isVisible()){
			rupee26.play("standby");
			rupee26.update(pressedKeys);

		}
		if(rupee27.isVisible()){
			rupee27.play("standby");
			rupee27.update(pressedKeys);

		}
		if(rupee28.isVisible()){
			rupee28.play("standby");
			rupee28.update(pressedKeys);

		}
		if(rupee29.isVisible()){
			rupee29.play("standby");
			rupee29.update(pressedKeys);

		}
		if(rupee30.isVisible()){
			rupee30.play("standby");
			rupee30.update(pressedKeys);

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
		if(mario.collidesWith(platform8) &&platform8.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform9) &&platform9.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform10) &&platform10.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform11) &&platform11.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		
		if(mario.collidesWith(platform12) &&platform12.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform13) &&platform13.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform14) &&platform14.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform15) &&platform15.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		if(mario.collidesWith(platform16) &&platform16.getAlpha()>0){
			isfalling=false;
			numJumps=1;
		}
		
		if(mario.collidesWith(rupee1)&&rupee1.isVisible()){
			rupee1.setVisible(false);
			//rupee1.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee2)&&rupee2.isVisible()){
			rupee2.setVisible(false);
			//rupee2.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee3)&&rupee3.isVisible()){
			rupee3.setVisible(false);
			//rupee3.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee4)&&rupee4.isVisible()){
			rupee4.setVisible(false);
			//rupee4.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee5)&&rupee5.isVisible()){
			rupee5.setVisible(false);
			//rupee5.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee6)&&rupee6.isVisible()){
			rupee6.setVisible(false);
			//rupee6.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee7)&&rupee7.isVisible()){
			rupee7.setVisible(false);
			//rupee7.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee8)&&rupee8.isVisible()){
			rupee8.setVisible(false);
			//rupee8.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee9)&&rupee9.isVisible()){
			rupee9.setVisible(false);
			//rupee9.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee10)&&rupee10.isVisible()){
			rupee10.setVisible(false);
			//rupee10.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee11)&&rupee11.isVisible()){
			rupee11.setVisible(false);
			//rupee11.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee12)&&rupee12.isVisible()){
			rupee12.setVisible(false);
			rupee12.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee13)&&rupee13.isVisible()){
			rupee13.setVisible(false);
			//rupee13.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee15)&&rupee15.isVisible()){
			rupee14.setVisible(false);
			//rupee14.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee14)&&rupee14.isVisible()){
			rupee15.setVisible(false);
			//rupee15.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee16)&&rupee16.isVisible()){
			rupee16.setVisible(false);
			//rupee16.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee17)&&rupee17.isVisible()){
			rupee17.setVisible(false);
			//rupee17.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee18)&&rupee18.isVisible()){
			rupee18.setVisible(false);
			//rupee18.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee19)&&rupee19.isVisible()){
			rupee19.setVisible(false);
			//rupee19.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee20)&&rupee20.isVisible()){
			rupee20.setVisible(false);
			//rupee20.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee21)&&rupee21.isVisible()){
			rupee21.setVisible(false);
			//rupee21.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee22)&&rupee22.isVisible()){
			rupee22.setVisible(false);
			//rupee22.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee23)&&rupee23.isVisible()){
			rupee23.setVisible(false);
			//rupee23.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee24)&&rupee24.isVisible()){
			rupee24.setVisible(false);
			//rupee24.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee25)&&rupee25.isVisible()){
			rupee25.setVisible(false);
			//rupee25.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee26)&&rupee26.isVisible()){
			rupee26.setVisible(false);
			//rupee26.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee27)&&rupee27.isVisible()){
			rupee27.setVisible(false);
			//rupee27.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee28)&&rupee28.isVisible()){
			rupee28.setVisible(false);
			//rupee28.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee29)&&rupee29.isVisible()){
			rupee29.setVisible(false);
			//rupee29.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee30) &&rupee30.isVisible()){
			rupee30.setVisible(false);
			//rupee30.setPosition(1, 200);
			mario.addCoin();
			
		}
		
		
		if(numJumps==1){
			//mario.setVelY(0);
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
				mario.setPosition(platform1.getPosition().getX(),platform1.getPosition().getY()-60);
				level=0;
			} else if(level == 2){
				mario.setPosition(position2);
				level=0;
			} else if(level == 3){
				mario.setPosition(position3);
				level=0;
			} else if(level == 4){
				mario.setPosition(position4);
				level=0;
			}

		
		}
		if(pressedKeys.contains(KeyEvent.VK_UP)){
			mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()-8);
		}
		
		if(pressedKeys.contains(KeyEvent.VK_RIGHT)){
			mario.setPosition(mario.getPosition().getX()+8,mario.getPosition().getY());
		}
		if(pressedKeys.contains(KeyEvent.VK_LEFT)){
			mario.setPosition(mario.getPosition().getX()-8,mario.getPosition().getY());
		}
		if(pressedKeys.contains(KeyEvent.VK_DOWN)){
			mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()+8);
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
			mario.minusTotalCoins(1);
			
		}	
		
		if(mx>a.getX() && mx<a.getX()+100 ){
			System.out.println("hit");
			mario.setJetpack(true);
			mario.minusTotalCoins(7);
			
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