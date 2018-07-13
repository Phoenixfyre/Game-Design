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
	int frames=0;
	boolean reset=false;
	public Protagonist mario = new Protagonist("Mario", "Sonic_standby1.png",0,0,0,0,0,1,1);
	Point startPosition=mario.getPosition();
	int y3=0;
	boolean endgame=false;
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
	AnimatedSprite rupee31= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee32= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee33= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee34= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	AnimatedSprite rupee35= new AnimatedSprite("coin", "rupee1.png", 0,300,300,0,0,1,1);
	
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
	Sprite onswitch6 = new Sprite("On", "switch-lever-on.png",0,0,0,0,0,1,1);
	Sprite offswitch= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch1= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch2= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch3= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch4= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch5= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);
	Sprite offswitch6= new Sprite("off", "switch-level-off.png",0,0,0,0,0,1,1);

	TweenEvent alph1 = new TweenEvent("alph1", this);
	TweenEvent alph2 = new TweenEvent("alph2",this);
	TweenEvent size= new TweenEvent("size",this);
	boolean up=true;
	boolean up1=true;
	boolean up2=true;
	boolean up3=true;
	boolean up4=true;
	boolean side1=true;
	boolean side2=true;
	boolean side3=true;
	boolean side4=true;
	boolean side5=true;
	boolean diag1=true;
	boolean diag2 = true;
	boolean diag3=true;
	
	boolean mov1=true;
	boolean mov2=true;
	boolean mov3=true;
	boolean mov4=true;
	boolean mov5=true;
	boolean mov6=true;
	boolean mov7=true;
	int qb=1;
	Camera cam = new Camera();
	Sprite platform2= new Sprite("platform1","platform.png",0,0,0,0,0,1,1);
	Sprite platform3= new Sprite("platform2","platform.png",0,0,0,0,0,1,1);
	Sprite platform4= new Sprite("platform3","doorplatform.png",0,0,0,0,0,1,1);
	
	Sprite platform5= new Sprite("platform4","platform.png",0,0,0,0,0,1,1);
	Sprite platform6= new Sprite("platform5","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform7= new Sprite("platform6","platform.png",0,0,0,0,0,1,1);
	Sprite platform8= new Sprite("platform7","doorplatform.png",0,0,0,0,0,1,1);
	
	Sprite platform9= new Sprite("platform8","platform.png",0,0,0,0,0,1,1);
	Sprite platform10= new Sprite("platform9","platform.png",0,0,0,0,0,1,1);
	Sprite platform11= new Sprite("platform10","platform.png",0,0,0,0,0,1,1);
	Sprite platform12= new Sprite("platform11","platform.png",0,0,0,0,0,1,1);
	Sprite platform13= new Sprite("platform12","platform.png",0,0,0,0,0,1,1);
	Sprite platform14= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	
	Sprite platform15= new Sprite("platform14","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform16= new Sprite("platform15","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform17= new Sprite("platform16","platform.png",0,0,0,0,0,1,1);
	Sprite platform18= new Sprite("platform17","platform.png",0,0,0,0,0,1,1);
	Sprite platform19= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform20= new Sprite("platform14","movplatform.png",0,0,0,0,0,1,1);
	
	Sprite platform21= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform22= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform23= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform24= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform25= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform26= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform27= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite platform28= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform29= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform30= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	
	Sprite platform31= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform32= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform33= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform34= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform35= new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	Sprite platform38=new Sprite("platform13","platform.png",0,0,0,0,0,1,1);
	//level 4 platforms
	Sprite movplat1= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite movplat2= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite movplat3= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite movplat4= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite movplatup= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite movplat5= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite movplat6= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	Sprite movplat7= new Sprite("platform13","movplatform.png",0,0,0,0,0,1,1);
	
	Sprite pressure1= new Sprite("platform13","platform3.png",0,0,0,0,0,1,1);
	Sprite pressure2= new Sprite("platform13","platform3.png",0,0,0,0,0,1,1);

	Sprite dplatform6= new Sprite("platform13","Disappearplatform.png",0,0,0,0,0,1,1);
	Sprite dplatform5= new Sprite("platform13","Disappearplatform.png",0,0,0,0,0,1,1);
	Sprite dplatform4= new Sprite("platform13","Disappearplatform.png",0,0,0,0,0,1,1);
	Sprite dplatform3= new Sprite("platform13","Disappearplatform.png",0,0,0,0,0,1,1);
	Sprite dplatform1= new Sprite("platform13","Disappearplatform.png",0,0,0,0,0,1,1);
	Sprite dplatform2= new Sprite("platform13","Disappearplatform.png",0,0,0,0,0,1,1);
	int jumper=1;
	boolean isfalling= false;
	//Sprite platform5= new Sprite("platform","platform.png",0,0,0,0,0,1,1);
	Sprite rock1= new Sprite("rock1", "rock.png",0,0,0,0,0,1,1);
	// level1 puzzle
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
	Point position3 = new Point(5000,200);
	Point position4 = new Point(10000,700);
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
	boolean gameRestart=false;
	boolean dead=true;
	
	boolean disappear1=false;
	int d1=0;
	int d2=0;
	int d3=0;
	int d4=0;
	int d5=0;
	int d6=0;
	boolean disappear2=false;
	boolean disappear3=false;
	boolean disappear4=false;
	boolean disappear5=false;
	boolean disappear6=false;
	Tween dp1= new Tween(dplatform1);
	Tween dp2= new Tween(dplatform2);
	Tween dp3= new Tween(dplatform3);
	Tween dp4= new Tween(dplatform4);
	Tween dp5= new Tween(dplatform5);
	Tween dp6= new Tween(dplatform6);


	
	
	
	
	public Beta() {
		super("Beta", 800, 800);
		super.getMainFrame().addMouseListener(this);
		
		b.setRect(1000,30, 100, 100);
		q.setRect(800,30,100,100);
		d.setRect(600,30,100,100);
		a.setRect(200,30,100,100);
		j.setRect(400,30,100,100);
		super.addChild(background);
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
		mario.setScaleX(3);
		mario.setScaleY(3);
		//mario.setAlpha(.11);
		
		time = new GameClock();
		mario.getFrames().add("Sonic_standby1.png");
		mario.getFrames().add("Sonic_standby2.png");
		mario.getFrames().add("Sonic_standby3.png");
		mario.getFrames().add("Sonic_standby4.png");
		mario.getFrames().add("Sonic_standby5.png");
		mario.getFrames().add("Sonic_standby6.png");
		mario.getFrames().add("linkst.png");
		mario.getFrames().add("linkst1.png");
		mario.getFrames().add("link1.png");
		mario.getFrames().add("link2.png");
		mario.getFrames().add("link3.png");
		mario.getFrames().add("link4.png");
		mario.getFrames().add("linkc1.png");
		mario.getFrames().add("linkc2.png");
		mario.getFrames().add("linkc3.png");
		mario.getFrames().add("linkc4.png");
		mario.getFrames().add("linkj1.png");
		mario.getFrames().add("linkj2.png");
		mario.getFrames().add("linkj3.png");


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
		super.addChild(rupee31);
		super.addChild(rupee32);
		super.addChild(rupee33);
		super.addChild(rupee34);
		super.addChild(rupee35);
		
		super.addChild(pressure1);
		super.addChild(pressure2);
		pressure1.setScaleX(.5);
		pressure2.setScaleX(.5);
		background.setScaleX(8);
		background.setScaleY(5);
		background.setPosition(-2000,-900);
		
		/*buymenu.addItem("Jump", 1);
		buymenu.addItem("Interact", 2);
		buymenu.addItem("JetPack", 35);
		buymenu.addItem("Sword", 50);
		buymenu.addItem("Fireball", 50);
		*/
		
	//marios.animate(TweenableParam.ALPHA, 0, 1, 5000);
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
		
		rupee31.getFrames().add("rupee1.png");
		rupee31.getFrames().add("rupee2.png");
		rupee31.getFrames().add("rupee6.png");
		rupee31.getFrames().add("rupee3.png");
		rupee31.getFrames().add("rupee4.png");
		rupee31.getFrames().add("rupee5.png");
		rupee31.setScaleX(.2);
		rupee31.setScaleY(.2);
		
		rupee32.getFrames().add("rupee1.png");
		rupee32.getFrames().add("rupee2.png");
		rupee32.getFrames().add("rupee6.png");
		rupee32.getFrames().add("rupee3.png");
		rupee32.getFrames().add("rupee4.png");
		rupee32.getFrames().add("rupee5.png");
		rupee32.setScaleX(.2);
		rupee32.setScaleY(.2);
		
		rupee33.getFrames().add("rupee1.png");
		rupee33.getFrames().add("rupee2.png");
		rupee33.getFrames().add("rupee6.png");
		rupee33.getFrames().add("rupee3.png");
		rupee33.getFrames().add("rupee4.png");
		rupee33.getFrames().add("rupee5.png");
		rupee33.setScaleX(.2);
		rupee33.setScaleY(.2);
		
		rupee34.getFrames().add("rupee1.png");
		rupee34.getFrames().add("rupee2.png");
		rupee34.getFrames().add("rupee6.png");
		rupee34.getFrames().add("rupee3.png");
		rupee34.getFrames().add("rupee4.png");
		rupee34.getFrames().add("rupee5.png");
		rupee34.setScaleX(.2);
		rupee34.setScaleY(.2);
		
		rupee35.getFrames().add("rupee1.png");
		rupee35.getFrames().add("rupee2.png");
		rupee35.getFrames().add("rupee6.png");
		rupee35.getFrames().add("rupee3.png");
		rupee35.getFrames().add("rupee4.png");
		rupee35.getFrames().add("rupee5.png");
		rupee35.setScaleX(.2);
		rupee35.setScaleY(.2);
		
		rock1.setScaleX(.2);
		rock1.setScaleY(.2);
		
		rock2.setScaleX(.2);
		rock2.setScaleY(.2);
		rock2.setVisible(true);
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
		super.addChild(platform23);
		super.addChild(platform24);
		super.addChild(platform25);
		super.addChild(platform26);
		super.addChild(platform27);
		super.addChild(platform28);
		super.addChild(platform29);
		super.addChild(platform30);
		super.addChild(platform31);
		super.addChild(platform32);
		super.addChild(platform33);
		super.addChild(platform34);
		super.addChild(platform35);
		super.addChild(movplat1);
		super.addChild(movplat2);
		super.addChild(movplat3);
		super.addChild(movplat4);
		super.addChild(movplat5);
		super.addChild(movplat6);
		super.addChild(movplat7);


		qb=1;
		
		
		
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
		onswitch3.setScaleX(.2);
		onswitch3.setScaleY(.2);
		offswitch3.setScaleX(.2);
		offswitch3.setScaleY(.2);
		onswitch4.setScaleX(.2);
		onswitch4.setScaleY(.2);
		offswitch4.setScaleX(.2);
		offswitch4.setScaleY(.2);
		onswitch5.setScaleX(.2);
		onswitch5.setScaleY(.2);
		offswitch5.setScaleX(.2);
		offswitch5.setScaleY(.2);
		onswitch5.setVisible(false);
		onswitch6.setScaleX(.2);
		onswitch6.setScaleY(.2);
		offswitch6.setScaleX(.2);
		offswitch6.setScaleY(.2);
		snd.loadMusic("loop", "8-bit Detective.wav");
		snd.playMusic("loop");
		//mario.setMass(2);
		snd.LoadSoundEffect("jump", "jumped.wav");
		snd.LoadSoundEffect("coin", "coinget.wav");
		snd.LoadSoundEffect("door", "door.wav");
		snd.LoadSoundEffect("switch", "switch.wav");
		offswitch.setPosition(520, 629);
		onswitch.setPosition(420,629);
		platform2.setVisible(false);
		//Level 1 Platforms, Switches, Levers, doors
		mario.setPosition(position1);
		pressure1.setPosition(-700,290);
		pressure1.setScaleX(.2);
		pressure1.setScaleY(.5);
		platform1.setPosition(100, 676);
		platform2.setPosition(-100, 676);
		platform3.setPosition(-700, 296);
		platform4.setPosition(-220,266);
		dplatform1.setPosition(100,900);
		platform4.setScaleX(.4);
		platform4.setScaleY(.7);
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
		// move platform 6
		dplatform2.setPosition(3100,400);
		dplatform2.setScaleX(3);
		dplatform2.setScaleY(1.5);
		platform6.setPosition(2900,50);
		dplatform1.setPosition(3450,350);
		platform6.setScaleY(.8);
		platform7.setScaleX(.7);
		platform7.setScaleY(.5);
		platform7.setPosition(3700,250);
		platform24.setScaleX(.8);
		platform24.setScaleY(.5);
		platform24.setPosition(4100,800);
		platform25.setPosition(4200,-300);
		
		platform25.setScaleY(.5);
		platform26.setPosition(4200,800);
		platform8.setPosition(2550,800);
		//door1.setVisible(true);
		
		rupee5.setPosition(3750, 200);
		rupee6.setPosition(3060, 350);
		rupee7.setPosition(3000, 350);
		rupee8.setPosition(3105, 350);
		rupee9.setPosition(3500, 750);
		
		offswitch6.setPosition(4300,-345);
		onswitch6.setPosition(4400, -345);
		door1.setPosition(2550, 710);
		
		super.addChild(offswitch6);
		super.addChild(onswitch6);
		onswitch6.setVisible(false);
		
		
		super.addChild(door1);
		
		//Level 3 Platforms...
		rupee10.setPosition(5000,250);
		rupee11.setPosition(5700,650);
		rupee12.setPosition(6000,370);
		rupee13.setPosition(6100,370);
		rupee14.setPosition(6000,650);
		rupee15.setPosition(5700,650);
		rupee16.setPosition(5800,650);
		rupee17.setPosition(5900,650);
		rupee18.setPosition(5100,150);
		rupee19.setPosition(5000,150);
		rupee20.setPosition(5200,150);

		rupee30.setPosition(6700,200);
		
		super.addChild(platform38);
		platform9.setPosition(5000,300);
		
		platform12.setPosition(5800,300);
		platform12.setScaleY(.5);
		
		platform13.setPosition(5700,700);
		platform14.setPosition(5300,500);
		platform15.setPosition(6000,390);
		platform16.setPosition(6000,750);
		platform17.setPosition(6700,450);
		platform17.setScaleX(1.5);
		platform15.setScaleX(1.5);
		platform16.setScaleX(1.5);
		door2.setPosition(5350,420);
		platform14.setScaleY(.3);
		
		super.addChild(door2);
		super.addChild(door3);
		door2.setVisible(false);
		super.addChild(offswitch2);
		super.addChild(onswitch2);
		super.addChild(onswitch3);
		super.addChild(offswitch3);
		super.addChild(dplatform1);
		super.addChild(dplatform2);
		super.addChild(dplatform3);
		super.addChild(dplatform4);
		super.addChild(dplatform5);
		super.addChild(dplatform6);
		onswitch2.setPosition(6800,400);
		onswitch2.setScaleX(.2);
		offswitch2.setPosition(7000,400);
		onswitch2.setVisible(false);
		onswitch3.setPosition(7300,960);
		onswitch3.setVisible(false);
		offswitch3.setPosition(7500,960);
		dplatform3.setPosition(7200,980);
		dplatform4.setPosition(7200,850);
		dplatform5.setPosition(7200,720);
		dplatform6.setPosition(7200,600);
		platform38.setPosition(7300,1000);
		platform38.setVisible(false);
		//level 4 platforms
		rupee21.setPosition(10000,350);
		rupee22.setPosition(10100,350);
		rupee23.setPosition(10200,350);
		rupee24.setPosition(10300,350);
		rupee25.setPosition(10400,-250);
		rupee26.setPosition(10500,-250);
		rupee27.setPosition(10800,-280);
		rupee28.setPosition(10600,-250);
		rupee29.setPosition(11000,650);
		rupee30.setPosition(10000,250);
		
		
		platform18.setPosition(10000, 800);
		//platform19 moves 500 spaces left and right
		movplat1.setPosition(10400,800);
		
		movplat2.setPosition(10200,450);
		movplat3.setPosition(10600,450);
		movplat4.setPosition(10000, -300);
		platform22.setPosition(11300,800);
		platform22.setScaleX(2);
		platform27.setPosition(9400,-200);
		platform29.setPosition(10900,200);
		platform29.setScaleY(.5);
		platform28.setPosition(10000,-200);
		offswitch5.setPosition(10200,-240);
		onswitch5.setPosition(10000,-240);
		rock3.setPosition(10950,180);
		pressure2.setPosition(10050,790);
		pressure2.setScaleX(.2);
		pressure2.setScaleY(.5);
		super.addChild(rock3);
		super.addChild(onswitch5);
		super.addChild(offswitch5);
		rock3.setScaleX(.3);
		rock3.setScaleY(.3);
		rock3.setVisible(false);
		door3.setVisible(false);
		platform30.setPosition(11600,900);
		/*platform31.setPosition(position1);
		platform32.setPosition(position1);
		platform33.setPosition(position1);
		*/
		movplat5.setPosition(9600,-200);
		
		movplat6.setPosition(9800,-200);
		super.addChild(movplat6);
		door3.setPosition(11700,650);
		door3.setScaleY(.3);
		door3.setScaleX(.3);
		
		//Secret Areas will be place above the map from X 100 - 3000 and y -1000 2 secret areas in each level, 5 coins each

	}
	@Override
	public void draw(Graphics g){
		//g.drawString("Health Left:", 670, 30);
		if(gamestart==false && endgame!=true){
		g.drawString("Press H to start game", 400, 400);
		}
		if(gamestart==true){
	
		Graphics2D g2d = (Graphics2D)g;
		
		cam.draw(g);
		super.draw(g);
		g.drawString("Press Space to Jump",(int)platform1.getPosition().getX()+100, (int)platform1.getPosition().getY()-150);
		g.drawString("Press F to interact with objects",(int)platform1.getPosition().getX()+200, (int)platform1.getPosition().getY()-100);

		g.drawString("Press M to buy abilities",(int)platform1.getPosition().getX(), (int)platform1.getPosition().getY()-100);
		g.drawString("total coins ="+ mario.getTotalCoins(), (int)mario.getPosition().getX()-20, (int)mario.getPosition().getY()-20);
		/*
		g2d.draw(q);;
		g2d.draw(a);
	
		g2d.draw(d);
		g2d.draw(j);
		
		g.drawString("total coins ="+ mario.getTotalCoins(), (int)mario.getPosition().getX()-200, (int)mario.getPosition().getY()-200);
		g.drawString("Jump=5coins",(int)q.getCenterX()-40, (int)q.getCenterY());
		g.drawString("JetPack=5coins",(int)a.getCenterX()-40, (int)a.getCenterY());
		g.drawString("Interact=5coins",(int)j.getCenterX()-40, (int)j.getCenterY());
		g.drawString("EndDisapear=5coins",(int)d.getCenterX()-40, (int)d.getCenterY());
		*/
		if(onswitch.isVisible()){
			onswitch.draw(g);
			
		}
		if(offswitch.isVisible()){
			offswitch.draw(g);
		}
		
		if(onswitch6.isVisible()){
			onswitch6.draw(g);
			door1.setVisible(true);
		}
		if(offswitch6.isVisible()){
			offswitch6.draw(g);
		}
		
		
		
		if(rupee1.isVisible()){
		rupee1.draw(g);
		}
		}
		if(endgame==true){
			mario.setPosition(400,300);
			g.drawString("YOU WIN", 400, 300);
			gamestart=false;
			super.removeAllChildren();
			
		}
		
		//g.drawString("You can buy abilities through using the m key", 400, 200);

		//g2d.draw(mario.getGlobalHitbox());
		//g2d.draw(rupee1.getGlobalHitbox());
		
		
		
		
	}
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		 startPosition=mario.getPosition();
		 if(reset==true){
			 rupee1.setVisible(true);
			 rupee2.setVisible(true);
			 rupee3.setVisible(true);
			 rupee4.setVisible(true);
			 rupee5.setVisible(true);
			 rupee6.setVisible(true);
			 rupee7.setVisible(true);
			 rupee8.setVisible(true);
			 rupee9.setVisible(true);
			 rupee10.setVisible(true);
			 rupee11.setVisible(true);
			 rupee12.setVisible(true);
			 rupee14.setVisible(true);
			 rupee13.setVisible(true);
			 rupee15.setVisible(true);
			 rupee16.setVisible(true);
			 rupee17.setVisible(true);
			 rupee18.setVisible(true);
			 rupee19.setVisible(true);
			 rupee20.setVisible(true);
			 rupee21.setVisible(true);
			 rupee22.setVisible(true);
			 rupee23.setVisible(true);
			 rupee24.setVisible(true);
			 rupee25.setVisible(true);
			 rupee26.setVisible(true);
			 rupee27.setVisible(true);
			 rupee28.setVisible(true);
			 rupee29.setVisible(true);
			 rupee30.setVisible(true);
			 reset=false;
		 }
		 if(mario.collidesWith(dplatform1) &&dplatform1.getAlpha()>.1){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
			 disappear1=true;
			 //System.out.println("k");
			 if(disappear1=true&& d1==1){
				 dp1.animate(TweenableParam.ALPHA, 1, .2, 1000);
				 jugg.add(dp1);
				 
				 //System.out.println("kk");
				 d1++;
			 } 
		 }
		 

		 if(mario.collidesWith(movplat5)){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
		 }
		 if(mario.collidesWith(movplat6)){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
		 }
		 if(!mario.collidesWith(dplatform1)){
			 
			 dplatform1.setAlpha(1);
			
		 }
		 
		 if(mario.collidesWith(dplatform2) &&dplatform2.getAlpha()>.5){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
			 disappear2=true;
			 //System.out.println("k");
			/* if(disappear2=true&& d2==1){
				 dp2.animate(TweenableParam.ALPHA, 1, .2, 1000);
				 jugg.add(dp2);
				 
				 //System.out.println("kk");
				 d2++;
			 } 
		 }*/
		 }
		 if(!mario.collidesWith(dplatform2)){
			 
			 dplatform2.setAlpha(1);
			 d2=1;
			 
		 } if(mario.collidesWith(dplatform3) &&dplatform3.getAlpha()>.5){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
			 disappear3=true;
			 //System.out.println("k");
			 /* if(disappear3=true&& d3==1){
				 dp3.animate(TweenableParam.ALPHA, 1, .2, 500);
				 jugg.add(dp3);
				 jugg.update();
				 //System.out.println("kk");
				 d3++;
			 } */
		 }
		 
		 if(!mario.collidesWith(dplatform3)){
			
			 dplatform3.setAlpha(1);
			 d3=1;
		 } 
		 if(mario.collidesWith(dplatform4) &&dplatform4.getAlpha()>.5){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
			 disappear4=true;
			 //System.out.println("k");
			/* if(disappear4=true&& d4==1){
				 dp4.animate(TweenableParam.ALPHA, 1, .2, 500);
				 jugg.add(dp4);
				
				 //System.out.println("kk");
				 d4++;
			 } */
		 }
		 
		 if(!mario.collidesWith(dplatform4)){
			
			 dplatform4.setAlpha(1);
			 d4=1;
		 } 
		 if(mario.collidesWith(dplatform5) &&dplatform5.getAlpha()>.1){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
			 disappear1=true;
			 //System.out.println("k");
			/* if(disappear5=true&& d5==1){
				 dp5.animate(TweenableParam.ALPHA, 1, .2, 500);
				 jugg.add(dp5);
				
				 //System.out.println("kk");
				 d5++;
			 } */
		 }
		 
		 if(!mario.collidesWith(dplatform5)){
			 
			 dplatform5.setAlpha(1);
			
		 } 
		 if(mario.collidesWith(dplatform6) &&dplatform6.getAlpha()>.1){
			 numJumps=1;
			 jumpcounter=0;
			 isfalling=false;
			 disappear6=true;
			 //System.out.println("k");
			/* if(disappear6=true&& d6==1){
				 dp6.animate(TweenableParam.ALPHA, 1, .2, 500);
				 jugg.add(dp6);
				 jugg.update();
				 //System.out.println("kk");
				 d6++;
			 } */
		 }
		 
		 if(!mario.collidesWith(dplatform6)){
			 d6=1;
			 dplatform6.setAlpha(1);
		 } 
		 
		 
		/* if(pressedKeys.contains(KeyEvent.VK_U)){
			mario.setPosition(3000,100);
		 }*/
		if(pressedKeys.contains(KeyEvent.VK_H)){
			gamestart=true;
		}
		
		/*if(pressedKeys.contains(KeyEvent.VK_I)){
			mario.setPosition(5000,200);
		}
		if(pressedKeys.contains(KeyEvent.VK_P)){
			mario.setPosition(10000,200);
		}
		*/
		//platform6.setPosition(2900,50);
		//platform24.setPosition(4100,150);
		if(movplat5.getPosition().getY()>-200 &&mov5==true){
			movplat5.setPosition(movplat5.getPosition().getX(),movplat5.getPosition().getY()-5);
			if(mario.collidesWith(movplat5)&& movplat5.isVisible()){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()-5);
			}
		}
		else{
			mov5=false;
		}
		if(mov5==false){
			movplat5.setPosition(movplat5.getPosition().getX(),movplat5.getPosition().getY()+5);
			if(mario.collidesWith(movplat5) &&movplat5.isVisible()){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()+5);
			}
		}
		if(movplat5.getPosition().getY()>500){
			mov5=true;
		}
		
		
		if(movplat1.getPosition().getY()>500 &&mov1==true){
			movplat1.setPosition(movplat1.getPosition().getX(),movplat1.getPosition().getY()-5);
			if(mario.collidesWith(movplat1)&& movplat1.isVisible()){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()-5);
			}
		}
		else{
			mov1=false;
		}
		if(mov1==false){
			movplat1.setPosition(movplat1.getPosition().getX(),movplat1.getPosition().getY()+5);
			if(mario.collidesWith(movplat1) &&movplat1.isVisible()){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()+5);
			}
		}
		if(movplat1.getPosition().getY()>800){
			mov1=true;
		}
		
		if(movplat2.getPosition().getX()>9700 &&mov2==true){
			movplat2.setPosition(movplat2.getPosition().getX()-4,movplat2.getPosition().getY());
			if(mario.collidesWith(movplat2)&& movplat2.isVisible()){
				mario.setPosition(mario.getPosition().getX()-4,mario.getPosition().getY());
			}
		}
		else{
			mov2=false;
		}
		if(mov2==false){
			movplat2.setPosition(movplat2.getPosition().getX()+5,movplat2.getPosition().getY());
			if(mario.collidesWith(movplat2) &&movplat2.isVisible()){
				mario.setPosition(mario.getPosition().getX()+5,mario.getPosition().getY());
			}
		}
		if(movplat2.getPosition().getX()>10300){
			mov2=true;
		}
		
		if(movplat3.getPosition().getY()>200 &&mov3==true){
			movplat3.setPosition(movplat3.getPosition().getX()+1,movplat3.getPosition().getY()-3);
			if(mario.collidesWith(movplat3)&& movplat3.isVisible()){
				mario.setPosition(mario.getPosition().getX()+1,mario.getPosition().getY()-3);
			}
		}
		else{
			mov3=false;
		}
		if(mov3==false){
			movplat3.setPosition(movplat3.getPosition().getX()-1,movplat3.getPosition().getY()+3);
			if(mario.collidesWith(movplat3) &&movplat3.isVisible()){
				mario.setPosition(mario.getPosition().getX()-1,mario.getPosition().getY()+3);
			}
		}
		if(movplat3.getPosition().getY()>500){
			mov3=true;
		}
		
		
		if(platform24.getPosition().getY()>-300 &&up1==true){
			platform24.setPosition(platform24.getPosition().getX(),platform24.getPosition().getY()-3);
			if(mario.collidesWith(platform24)&& platform24.isVisible()){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()-3);
			}
		}
		else{
			up1=false;
		}
		if(up1==false){
			platform24.setPosition(platform24.getPosition().getX(),platform24.getPosition().getY()+3);
			if(mario.collidesWith(platform24) &&platform24.isVisible()){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()+3);
			}
		}
		if(platform24.getPosition().getY()>800){
			up1=true;
		}
		
		
		if(platform2.getPosition().getY()>400 &&up==true){
			platform2.setPosition(platform2.getPosition().getX()-2,platform2.getPosition().getY()-2);
			if(mario.collidesWith(platform2)&& platform2.isVisible()){
				mario.setPosition(mario.getPosition().getX()-2,mario.getPosition().getY()-2);
			}
		}
		else{
			up=false;
		}
		if(up==false){
			platform2.setPosition(platform2.getPosition().getX()+2,platform2.getPosition().getY()+2);
			if(mario.collidesWith(platform2) &&platform2.isVisible()){
				mario.setPosition(mario.getPosition().getX()+2,mario.getPosition().getY()+2);
			}
		}
		if(platform2.getPosition().getY()>700){
			up=true;
		}
		//platform16.setPosition(6000,750);
		if(platform15.getPosition().getX()<6500 &&side1==true){
			platform15.setPosition(platform15.getPosition().getX()+2,platform15.getPosition().getY());
			if(mario.collidesWith(platform15)){
				mario.setPosition(mario.getPosition().getX()+2,mario.getPosition().getY());
			}
		}
		else{
			side1=false;
		}
		if(side1==false){
			platform15.setPosition(platform15.getPosition().getX()-2,platform15.getPosition().getY());
			if(mario.collidesWith(platform15)){
				mario.setPosition(mario.getPosition().getX()-2,mario.getPosition().getY());
			}
		}
		if(platform15.getPosition().getX()<6000){
			side1=true;
		}
		
		if(platform26.getPosition().getX()<4100 &&side3==true){
			platform26.setPosition(platform26.getPosition().getX()+4,platform26.getPosition().getY());
			if(mario.collidesWith(platform26)){
				mario.setPosition(mario.getPosition().getX()+4,mario.getPosition().getY());
			}
			//System.out.println(platform26.getPosition().getX());
		}
		else{
			side3=false;
		}
		if(side3==false){
			platform26.setPosition(platform26.getPosition().getX()-4,platform26.getPosition().getY());
			if(mario.collidesWith(platform26)){
				mario.setPosition(mario.getPosition().getX()-4,mario.getPosition().getY());
			}
			//System.out.println(platform26.getPosition().getX());
		}
		if(platform26.getPosition().getX()<2550){
			
			side3=true;
		}
		
		if(platform6.getPosition().getX()<3500 &&side2==true){
			platform6.setPosition(platform6.getPosition().getX()+2,platform6.getPosition().getY());
			if(mario.collidesWith(platform6)){
				mario.setPosition(mario.getPosition().getX()+2,mario.getPosition().getY());
			}
		}
		else{
			side2=false;
		}
		if(side2==false){
			platform6.setPosition(platform6.getPosition().getX()-2,platform6.getPosition().getY());
			if(mario.collidesWith(platform6)){
				mario.setPosition(mario.getPosition().getX()-2,mario.getPosition().getY());
			}
		}
		if(platform6.getPosition().getX()<2950){
			side2=true;
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
		
		//		platform22.setPosition(11300,200);
		
		if(platform22.getPosition().getY()>-250 &&up4==true){
			platform22.setPosition(platform22.getPosition().getX(),platform22.getPosition().getY()-5);
			if(mario.collidesWith(platform22)){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()-5);
			}
		}
		else{
			up4=false;
		}
		if(up4==false){
			platform22.setPosition(platform22.getPosition().getX(),platform22.getPosition().getY()+5);
			if(mario.collidesWith(platform22)){
				mario.setPosition(mario.getPosition().getX(),mario.getPosition().getY()+5);
			}
		}
		if(platform22.getPosition().getY()>800){
			up4=true;
		}
		
		if(movplat4.getPosition().getX()>10200 &&mov4==true ){
			movplat4.setPosition(movplat4.getPosition().getX()-6,movplat4.getPosition().getY());
			if(mario.collidesWith(movplat4)){
				mario.setPosition(mario.getPosition().getX()-6,mario.getPosition().getY());
			}
		}
		else{
			mov4=false;
		}
		if(mov4==false){
			movplat4.setPosition(movplat4.getPosition().getX()+6,movplat4.getPosition().getY());
			if(mario.collidesWith(movplat4)){
				mario.setPosition(mario.getPosition().getX()+6,mario.getPosition().getY()+3);
			}
		}
		if(movplat4.getPosition().getX()>11400){
			mov4=true;
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
		
		if(rock3.collidesWith(pressure2)){
			door3.setVisible(true);
		}
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
		if(mario.collidesWith(movplat1) &&movplat1.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(movplat2) &&movplat2.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(movplat3) &&movplat3.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(movplat4) &&movplat4.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform1) &&platform1.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform2) && platform2.isVisible()){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
					
		}
			
		if(mario.collidesWith(platform3) && platform3.getAlpha()==1){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform4) && platform4.getAlpha()==1){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform5) && platform5.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform6) && platform6.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform7) && platform7.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform8) &&platform8.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform9) &&platform9.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform10) &&platform10.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform11) &&platform11.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform12) &&platform12.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform13) &&platform13.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform14) &&platform14.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform15) &&platform15.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform16) &&platform16.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform17) &&platform17.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform18) &&platform18.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform19) &&platform19.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform20) &&platform20.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform21) &&platform21.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform22) &&platform22.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform23) &&platform23.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(platform24) &&platform24.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(platform25) &&platform25.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(platform26) &&platform26.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(platform27) &&platform27.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(platform28) &&platform28.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(platform29) &&platform29.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}if(mario.collidesWith(platform30) &&platform30.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(platform31) &&platform31.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform32) &&platform32.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform33) &&platform33.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform34) &&platform34.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		if(mario.collidesWith(platform35) &&platform35.getAlpha()>0){
			isfalling=false;
			numJumps=1;
			jumpcounter=0;
		}
		
		if(mario.collidesWith(rupee1)&&rupee1.isVisible()){
			snd.PlaySoundEffect("coin");
			rupee1.setVisible(false);
			//rupee1.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee2)&&rupee2.isVisible()){
			snd.PlaySoundEffect("coin");
			rupee2.setVisible(false);
			//rupee2.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee3)&&rupee3.isVisible()){
			snd.PlaySoundEffect("coin");
			rupee3.setVisible(false);
			//rupee3.setPosition(1, 200);
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee4)&&rupee4.isVisible()){
			snd.PlaySoundEffect("coin");
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
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee7)&&rupee7.isVisible()){
			rupee7.setVisible(false);
			//rupee7.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee8)&&rupee8.isVisible()){
			rupee8.setVisible(false);
			//rupee8.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee9)&&rupee9.isVisible()){
			rupee9.setVisible(false);
			//rupee9.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee10)&&rupee10.isVisible()){
			rupee10.setVisible(false);
			//rupee10.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee11)&&rupee11.isVisible()){
			rupee11.setVisible(false);
			//rupee11.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee12)&&rupee12.isVisible()){
			rupee12.setVisible(false);
			snd.PlaySoundEffect("coin");
			mario.addCoin();
			
		}
		if(mario.collidesWith(rupee13)&&rupee13.isVisible()){
			rupee13.setVisible(false);
			//rupee13.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee15)&&rupee15.isVisible()){
			rupee15.setVisible(false);
			//rupee14.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee14)&&rupee14.isVisible()){
			rupee14.setVisible(false);
			//rupee15.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee16)&&rupee16.isVisible()){
			rupee16.setVisible(false);
			//rupee16.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee17)&&rupee17.isVisible()){
			rupee17.setVisible(false);
			//rupee17.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee18)&&rupee18.isVisible()){
			rupee18.setVisible(false);
			//rupee18.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee19)&&rupee19.isVisible()){
			rupee19.setVisible(false);
			//rupee19.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee20)&&rupee20.isVisible()){
			rupee20.setVisible(false);
			//rupee20.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee21)&&rupee21.isVisible()){
			rupee21.setVisible(false);
			//rupee21.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee22)&&rupee22.isVisible()){
			rupee22.setVisible(false);
			//rupee22.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee23)&&rupee23.isVisible()){
			rupee23.setVisible(false);
			//rupee23.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee24)&&rupee24.isVisible()){
			rupee24.setVisible(false);
			//rupee24.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee25)&&rupee25.isVisible()){
			rupee25.setVisible(false);
			//rupee25.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee26)&&rupee26.isVisible()){
			rupee26.setVisible(false);
			//rupee26.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee27)&&rupee27.isVisible()){
			rupee27.setVisible(false);
			//rupee27.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee28)&&rupee28.isVisible()){
			rupee28.setVisible(false);
			//rupee28.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee29)&&rupee29.isVisible()){
			rupee29.setVisible(false);
			//rupee29.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		if(mario.collidesWith(rupee30) &&rupee30.isVisible()){
			rupee30.setVisible(false);
			//rupee30.setPosition(1, 200);
			mario.addCoin();
			snd.PlaySoundEffect("coin");
		}
		
		
		if(numJumps==1){
			mario.setVelY(0);
		}
		
		//mario.setForceY(0);
		/* Make sure mario is not null. Sometimes Swing can auto cause an extra frame to go before everything is initialized */
		/*		if(mario.collidesWith(platform2)){
			if(mario.getPosition().getY()>platform2.getPosition().getY()+30){
			mario.setPosition(mario.getPosition().getX(), platform2.getPosition().getY()+50);
			mario.setForceY(2);
		}
			}
		*/
		
		
		if(mario != null){
			mario.play("standby1");
			mario.update(pressedKeys);
			
		}
		mario.play("standby1");
		
		if(rupee1 != null){
			rupee1.play("standby");
			rupee1.update(pressedKeys);
			
		}
		if(mario.getPosition().getY()>=1250){
			if(level==1){
				
				mario.setPosition(platform1.getPosition().getX(),platform1.getPosition().getY()-80);
				mario.removeCoin(1);
			} else if(level == 2){
				mario.setPosition(position2);
				mario.removeCoin(1);
			} else if(level == 3){
				mario.setPosition(position3);
				mario.removeCoin(1);
			} else if(level == 4){
				mario.setPosition(position4);
				mario.removeCoin(1);
			}

		
		}
		/*if(pressedKeys.contains(KeyEvent.VK_UP)){
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
		}*/
		if(pressedKeys.contains(KeyEvent.VK_D)){
			cam.setX(cam.getX()+5);
			mario.update(pressedKeys);
			
			if(mario.isCarrying()){
				mario.play("runcr");
			}
			else{
				mario.play("runr");
			}
				
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
/*	if(pressedKeys.contains(KeyEvent.VK_M)){
			this.pause();
			this.addChild(buymenu);
			if(buymenu.getOpen() == false){
				buymenu.setOpen(true);
			} else if (buymenu.getOpen() == true){
				buymenu.setOpen(false);
			}
		}*/
		
		
		if(pressedKeys.contains(KeyEvent.VK_A)){
			//if(mario.getAlpha()==1 && x1==1){
			cam.setX(cam.getX()-5);
			if(mario.isCarrying()){
				mario.play("runcl");
			}
			else{
				mario.play("runl");
			}
				
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
			
			//xcount-=5;
		

		if(pressedKeys.contains(KeyEvent.VK_SPACE)){
			//if(mario.getAlpha()==1 && x1==1){
			
			if(mario.isJumping()|| mario.isJetpacking()){
				
				if(jumper==1){
					snd.PlaySoundEffect("jump");
					jumper++;
				}
				
				if(numJumps==1){
					if(jumpcounter!=mario.getJumpHeight()){
						
						mario.play("jump");
						
						mario.setVelY(-5);
						jumpcounter--;
						
						//System.out.println(numJumps);
					}
					/*else{
						if(mario.isJetpacking()){
							numJumps=3;
						}
						if(numJumps==3){
							
							frames++;
							if(frames<300){
								mario.setVelY(0);
								
							}
							
						}
						*/
					else{
						numJumps=4;
						
						//System.out.println(numJumps);
					}
					}
				// GET HELP HERE
				if(numJumps==4){
					mario.setVelY(2);
					
					
					
					
					//System.out.println(numJumps);
				}
				}
			
		}
		
			/*if(mario.getPosition().getY()>0){
					if(numJumps>0){
						if(jumpcounter!=mario.getJumpHeight()){
						mario.setPosition(mario.getPosition().getX(), mario.getPosition().getY()-5);
						
						mario.setVelY(-1);
						jumpcounter+=1;
						
						}
						else{
							
							if(mario.isJetpacking()) numJumps = 2;
							else numJumps=0;
							
							jumpcounter=0;
							
							
							if(numJumps == 2)
								mario.setVelY(0);
							
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
			}*/
			//ycount-=5;
		
		if(!pressedKeys.contains(KeyEvent.VK_SPACE)){
			jumper=1;
			if(numJumps==4 || numJumps==3){
				mario.setVelY(2);
			
			frames=0;
			jumpcounter=0;
			
			}
			if(mario.collidesWith(platform1)){
				numJumps=1;
			}
			else{
				numJumps=4;
			}
		}
		
		mario.updatePhys();
		
		if(!pressedKeys.contains(KeyEvent.VK_F)){
			x1=1;
			mario.setCarrying(false);
			//if(rock1.getParent().getId()==mario.getId()){
				//rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+50);
			//}
			
			if(y2==1){
			rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+10);
			y2=0;
			}
			
			if(y3==1){
				rock3.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+10);
				y3=0;
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_F)){
			if(mario.interact()==true){
			mario.setCarrying(true);
				if(mario.collidesWith(offswitch) && offswitch.isVisible()){
					platform2.setVisible(true);
					//System.out.println(platform2.isVisible());
					off=false;
					on=true;
					offswitch.setVisible(false);
					onswitch.setVisible(true);
					x1=0;
					snd.PlaySoundEffect("switch");
					
				}
				if(mario.collidesWith(offswitch6) && offswitch6.isVisible()){
					door1.setVisible(true);
					
					offswitch6.setVisible(false);
					onswitch6.setVisible(true);
					x1=0;
					snd.PlaySoundEffect("switch");

				}
				
				if(mario.collidesWith(offswitch2) && offswitch2.isVisible()){
					onswitch2.setVisible(true);
					snd.PlaySoundEffect("switch");
					offswitch2.setVisible(false);
					platform38.setVisible(true);
					
				}
				
				if(mario.collidesWith(offswitch3) && offswitch3.isVisible()){
					onswitch3.setVisible(true);
					snd.PlaySoundEffect("switch");
					offswitch3.setVisible(false);
					door2.setVisible(true);
					
				}
				
				if(mario.collidesWith(offswitch4) && offswitch4.isVisible()){
					onswitch4.setVisible(true);
					offswitch4.setVisible(false);
					
				}
				
				if(mario.collidesWith(offswitch5) && offswitch5.isVisible()){
					onswitch5.setVisible(true);
					offswitch5.setVisible(false);
					rock3.setVisible(true);
					
				}
				if(mario.collidesWith(onswitch) && onswitch.isVisible()){
					platform2.setVisible(false);
					snd.PlaySoundEffect("switch");

					offswitch.setVisible(true);
					onswitch.setVisible(false);
					x1=0;
				}
				if(mario.collidesWith(onswitch2) && onswitch2.isVisible()){	
					offswitch2.setVisible(true);
					snd.PlaySoundEffect("switch");
					onswitch2.setVisible(false);
					platform38.setVisible(false);
				}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
				if(mario.collidesWith(onswitch3) && onswitch3.isVisible()){	
					offswitch3.setVisible(true);
					snd.PlaySoundEffect("switch");
					onswitch3.setVisible(false);
					door2.setVisible(false);
					
				}
				if(mario.collidesWith(onswitch4) && onswitch4.isVisible()){	
					offswitch4.setVisible(true);
					onswitch4.setVisible(false);
				}
				if(mario.collidesWith(onswitch5) && onswitch5.isVisible()){	
					offswitch5.setVisible(true);
					onswitch5.setVisible(false);
					rock3.setVisible(false);
				}
				
				if(mario.collidesWith(onswitch6) && onswitch6.isVisible()){
					door1.setVisible(false);
					on=false;
					off=true;
					offswitch6.setVisible(true);
					onswitch6.setVisible(false);
					x1=0;
				}
			
			
				if(mario.collidesWith(rock1)){
					
					rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()-10);
					y2=1;
				}
				
				if(mario.collidesWith(rock3)&& rock3.isVisible()){
					rock3.setPosition(mario.getPosition().getX()+5,mario.getPosition().getY()-10);
					y3=1;
				}
			
			
			if(mario.collidesWith(door) &&door.isVisible()){
				level=2;
				start2=1;
				snd.PlaySoundEffect("door");
				
			}
			if(mario.collidesWith(door1) &&door1.isVisible()){
				level=3;
				start3=1;
				snd.PlaySoundEffect("door");
				
			}
			if(mario.collidesWith(door2)&&door2.isVisible()){
				level=4;
				start4=1;
				snd.PlaySoundEffect("door");
			}
			if(mario.collidesWith(door3)&&door3.isVisible()){
				if(mario.getTotalCoins()<20){
					level=1;
					start1=1;
					reset=true;
				}
				else{
					endgame=true;
				}
				snd.PlaySoundEffect("door");
			}
			
			if(start1==1){
				mario.setPosition(position1);
				start1=0;
			}
			if(start2==1){
				//POSITION OF NEXT LEVEL
				mario.setPosition(position2);
				start2=0;
				
			}
			if(start3 == 1){
				mario.setPosition(position3);
				start3=0;
			}
			if(start4==1){
				mario.setPosition(position4);
				start4=0;
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
		mario.updatePhys();

		
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
