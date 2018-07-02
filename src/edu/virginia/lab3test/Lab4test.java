package edu.virginia.lab3test;

import java.awt.Graphics;
import java.util.ArrayList;

//import javax.swing.Timer;

import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import edu.virginia.engine.display.AnimatedSprite;
import edu.virginia.engine.display.Game;
import edu.virginia.engine.display.Sprite;
import edu.virginia.engine.events.Event;
import edu.virginia.engine.events.EventDispatcher;
import edu.virginia.engine.events.IEventListener;
import edu.virginia.engine.events.QuestManager;
import edu.virginia.engine.util.GameClock;


/**
 * Example game that utilizes our engine. We can create a simple prototype game with just a couple lines of code
 * although, for now, it won't be a very fun game :)
 * */
public class Lab4test extends Game implements MouseListener {
	
	private int hp;
	private GameClock time;
	private long endtime;
	private int speed;
	private double scale;
	

	/* Create a sprite object for our game. We'll use mario */
	AnimatedSprite mario = new AnimatedSprite("Mario", "Sonic_standby1.png",0,0,0,0,0,1,1);
	Sprite rupee1= new Sprite("rupee1", "rupee_2.png",0,0,0,0,0,1,1 );
	//Sprite rupee2= new Sprite("Rupee2", "rupee_4.png",0,0,0,0,0,1,1 );
	//Sprite rupee3= new Sprite("Rupee3", "pur_rupee1.png",0,0,0,0,0,1,1 );
	Event coin= new Event("coinPickedUp",this);
	QuestManager quests= new QuestManager();
	/**
	 * Constructor. See constructor in Game.java for details on the parameters given
	 * */
	public Lab4test() {
		super("Get the Rupee", 800, 800);
		super.getMainFrame().addMouseListener(this);
		hp=15;
		time = new GameClock();
		endtime=0;
		speed=5;
		
		//rupee1.getPosition().setLocation(300, 600);
		//rupee2.getPosition().setLocation(500, 250);
		//rupee3.getPosition().setLocation(100, 400);
		rupee1.setPosition(500, 500); 	
		mario.setPosition(100, 100);
		mario.setCenter();
		mario.getFrames().add("Sonic_standby0.png");
		mario.getFrames().add("Sonic_standby2.png");
		mario.getFrames().add("Sonic_standby4.png");
		mario.getFrames().add("Sonic_standby5.png");
		mario.getFrames().add("Sonic_standby6.png");
		mario.getFrames().add("Sonic_standby7.png");
		mario.getFrames().add("Sonic_standby1.png");
		mario.getFrames().add("Sonic_run0.png");
		mario.getFrames().add("Sonic_run1.png");
		mario.getFrames().add("Sonic_run2.png");
		mario.getFrames().add("Sonic_run4.png");
		mario.getFrames().add("Sonic_run5.png");
		mario.getFrames().add("Sonic_run6.png");
		mario.getFrames().add("Sonic_run7.png");
		mario.getFrames().add("Sonic_run8.png");
		mario.getFrames().add("Sonic_run9.png");
		this.addEventListener(rupee1, "coinPickedUp");
		this.addEventListener(quests, "coinPickedUp");
		
	}
	
	/**
	 * Engine will automatically call this update method once per frame and pass to us
	 * the set of keys (as strings) that are currently being pressed down
	 * */
	@Override
	public void update(ArrayList<Integer> pressedKeys){
		super.update(pressedKeys);
		
		
		/* Make sure mario is not null. Sometimes Swing can auto cause an extra frame to go before everything is initialized */
		
		if(mario != null){
			mario.play("standby");
			mario.update(pressedKeys);
			
		}
		mario.play("standby");
		/*if(rupee1!=null){
			rupee1.update(pressedKeys);
			
		}
		if(rupee2!=null){
			rupee2.update(pressedKeys);
		}
		if(rupee3!=null){
			rupee3.update(pressedKeys);
		}*/
		
		if(pressedKeys.contains(KeyEvent.VK_RIGHT)){
			
			mario.update(pressedKeys);
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getX()<711){
					mario.getPosition().setLocation(mario.getPosition().getX()+speed, mario.getPosition().getY());
				}
			}
			//xcount+=5;
		}
		/*(pressedKeys.contains(KeyEvent.VK_SHIFT)){
			if(speed<50){
				speed+=1;
			}
		}*/
		if(!pressedKeys.contains(KeyEvent.VK_SHIFT)){
			if(speed>20){
				speed-=1;
			}
			
		}
		if(pressedKeys.contains(KeyEvent.VK_LEFT)){
			
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getX()>-20){
					
			mario.getPosition().setLocation(mario.getPosition().getX()-speed, mario.getPosition().getY());
			}
			}
			//xcount-=5;
		}

		if(pressedKeys.contains(KeyEvent.VK_UP)){
			
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getY()>0)
				mario.getPosition().setLocation(mario.getPosition().getX(), mario.getPosition().getY()-speed);
			}

			//ycount-=5;
		}
		if(pressedKeys.contains(KeyEvent.VK_DOWN)){
			
			if(rupee1.isVisible()){
				mario.play("run");
				if(mario.getPosition().getY()<660)
				mario.getPosition().setLocation(mario.getPosition().getX(), mario.getPosition().getY()+speed);
			}
			//ycount+=5;
		}
		/*if(pressedKeys.contains(KeyEvent.VK_I)){
			if(hp>0 && endtime<61){
				mario.getPivotPoint().setLocation(mario.getPivotPoint().getX(), mario.getPivotPoint().getY()-5);
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_K)){
			if(hp>0 && endtime<61){
				mario.getPivotPoint().setLocation(mario.getPivotPoint().getX(), mario.getPivotPoint().getY()+5);
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_J)){
			if(hp>0 && endtime<61){
				mario.getPivotPoint().setLocation(mario.getPivotPoint().getX()-5, mario.getPivotPoint().getY());
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_K)){
			if(hp>0 && endtime<61){
				mario.getPivotPoint().setLocation(mario.getPivotPoint().getX()+5, mario.getPivotPoint().getY());
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_V)){
			if(hp>0  && endtime<61){
				if(mario.isVisible()==true){
					mario.setVisible(false);
				}
				else
					mario.setVisible(true);
		}
		}
		if(pressedKeys.contains(KeyEvent.VK_Q)){
			if(hp>0  && endtime<61){
				mario.setRotation(mario.getRotation()-.05);
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_W)){
			if(hp>0  && endtime<61){
				mario.setRotation(mario.getRotation()+.05);

			}
		}
		if(pressedKeys.contains(KeyEvent.VK_Z)){
			if(hp>0  && endtime<61){
				if(mario.getAlpha()<0){
					mario.setAlpha(0);
				}
				if(mario.getAlpha()>0.000000000000000000000001)
					mario.setAlpha(mario.getAlpha()-0.01);
				//System.out.println(mario.getAlpha());
			}
		}
		
		if(pressedKeys.contains(KeyEvent.VK_X)){
			if(hp>0  && endtime<61){
				if(mario.getAlpha()<1){
			mario.setAlpha(mario.getAlpha()+0.01);
			}
			}
		}
		if(pressedKeys.contains(KeyEvent.VK_A)){
			if(hp>0  && endtime<61){
				
			mario.setScaleY(mario.getScaleY()-0.01);
			mario.setScaleX(mario.getScaleX()-0.01);
			speed+=5;
				}
			
		}
){
			if(hp>0  && endtime<61){
			mario.setScaleY(mario.getScaleY()+0.01);
			mario.setScaleX(mario.getScaleX()+0.01);
			speed-=.05;
		}
		}
		*/
		  if(rupee1 != null && mario.getPosition().getX()>rupee1.getPosition().getX()-10 && mario.getPosition().getX()-40<rupee1.getPosition().getX() 
				  && mario.getPosition().getY()+30>rupee1.getPosition().getY() && mario.getPosition().getY()-50<rupee1.getPosition().getY()  ){
			  //System.out.println(mario.getPosition().getX());
              this.dispatchEvent(coin);
             
              this.removeEventListener(rupee1, "coinPickedUp");
              this.removeEventListener(quests, "coinPickedUp");
              this.removeEventListener(quests, "coinPickedUp");
             // System.out.println("Success");
              
          }
		
	}
	
	/**
	 * Engine automatically invokes draw() every frame as well. If we want to make sure mario gets drawn to
	 * the screen, we need to make sure to override this method and call mario's draw method.
	 * */
	@Override
	public void draw(Graphics g){
		//g.drawString("Health Left:", 670, 30);
		
		g.drawString("Get The Rupee", 330, 30);
		g.drawString("Move with Arrow Keys!", 300, 50);
		//g.drawString(Integer.toString(hp), 750, 30);
		/*g.drawString("Hold down Shift to speed up", 550, 670);
		if(hp<0){
			hp=0;
		}
		*/
		/*if(endtime!=61 && hp>0){
		//g.drawString("Time Left For Survival:", 600,70);
		//g.drawString(Long.toString(61-Math.round(time.getElapsedTime()/1000)), 750, 70);
		//endtime=Math.round(time.getElapsedTime()/1000);
		}
		if(endtime==61){
			if(hp>0){
				g.drawString("Player 1 Wins", 700, 70);
			}
		}
		if(hp==0){
			g.drawString("Player 2 Wins", 700, 70);
		}
		*/
		super.draw(g);
		
	
		/* Same, just check for null in case a frame gets thrown in before Mario is initialized */
		if(mario != null){
			if(mario.isVisible()==true){
				mario.draw(g);
			}
		}
		if(rupee1 !=null){
			if (rupee1.isVisible()==true){
				rupee1.draw(g);
			}
			else{
				g.drawString("YOU GOT THE COIN", 300, 70);
			}
		}
		
		//if(mario.isVisible()){
			//mario.draw(g);
		//}
		
		
	}

	/**
	 * Quick main class that simply creates an instance of our game and starts the timer
	 * that calls update() and draw() every frame
	 * */
	public static void main(String[] args) {
		Lab4test game = new Lab4test();
		game.start();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx=e.getX();
		int my=e.getY();
		if(hp>0 && endtime<60){
			if(mx>mario.getPosition().getX() && mx<mario.getPosition().getX()+140 && my>mario.getPosition().getY() && my<mario.getPosition().getY()+140){
				hp=hp-1;
			}
		}
		
		
		
		
		System.out.println(mx+" " +my);
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
