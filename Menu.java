package edu.virginia.engine.display;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import edu.virginia.engine.events.Event;
import edu.virginia.engine.events.IEventListener;
import edu.virginia.engine.tweening.TweenableParam;
import edu.virginia.lab3test.Beta;
import edu.virginia.lab3test.Beta.BetaEvents;
//import edu.virginia.lab3test.Beta.QuestManager;

public class Menu extends Sprite{
	
	private boolean jumpBought = false;
	private boolean interBought = false;
	private boolean flyBought = false;
	private boolean jtpkBought = false;
	private boolean canBuy;
	private boolean isOpen = false;
	private Sprite buymenu;
	
	HashMap<String, Integer> menu;
	
	Rectangle jump= new Rectangle();
	Rectangle jtpk= new Rectangle();
	Rectangle interact= new Rectangle();
	Rectangle fly= new Rectangle();
	Rectangle a= new Rectangle();
	
	int selected = 1;
	
	public Menu(String id){
		super(id);
		
		menu=new HashMap<String,Integer>();
		
		jtpk.setRect(700,200,100,100);
		fly.setRect(500,200,100,100);
		jump.setRect(100,200,100,100);
		interact.setRect(300,200,100,100);
		
		// TODO Auto-generated constructor stub
	}
	
	public void addItem(String b, int price){
		menu.put(b, price);
	
	}
	public int getPrice(String b){
		return menu.get(b);
	}
	public void setOpen(boolean b){
		this.isOpen = b;
	}
	public boolean getOpen(){
		return isOpen;
	}
	public void setjmpBght(boolean j){
		this.jumpBought = j;
	}
	public boolean getjmpBght(){
		return jumpBought;
	}
	public void setinterBght(boolean i){
		this.interBought = i;
	}
	public boolean getinterBght(){
		return interBought;
	}
	public void setflyBght(boolean f){
		this.flyBought = f;
	}
	public boolean getflyBght(){
		return flyBought;
	}
	public void setjtpkBght(boolean jt){
		this.jtpkBought = jt;
	}
	public boolean getjtpkBght(){
		return jtpkBought;
	}
	
	public void update(ArrayList<Integer> pressedKeys){
		if(pressedKeys.contains(KeyEvent.VK_Y)){
			selected = (selected+1)%5;
		System.out.println("Selected: " + selected);
		}
		
		if(pressedKeys.contains(KeyEvent.VK_ENTER) && selected == 1){
			Event event = new Event(BetaEvents.JUMP_BOUGHT, this);
			this.dispatchEvent(event);
		} else if(pressedKeys.contains(KeyEvent.VK_ENTER) && selected == 2){
			Event event = new Event(BetaEvents.INTERACT_BOUGHT, this);
			this.dispatchEvent(event);
		} else if(pressedKeys.contains(KeyEvent.VK_ENTER) && selected == 3){
			Event event = new Event(BetaEvents.FLY_BOUGHT, this);
			this.dispatchEvent(event);
		} else if(pressedKeys.contains(KeyEvent.VK_ENTER) && selected == 4){
			Event event = new Event(BetaEvents.INTERACT_BOUGHT, this);
			this.dispatchEvent(event);
		}
	} 
	
	@Override
	public void draw(Graphics g){
		//if(getOpen() == true){
			g.drawRect(50, 100, 900, 400);
			g.fillRect(50, 100, 900, 400);
			g.setColor(Color.CYAN);
		
			g.drawString("Jump=1coins",(int)jump.getCenterX()-40, (int)jump.getCenterY());
			g.drawString("Interact=5coins",(int)interact.getCenterX()-40, (int)interact.getCenterY());
			g.drawString("Fly=5coins",(int)fly.getCenterX()-40, (int)fly.getCenterY());
			g.drawString("Jetpack=5coins", (int)jtpk.getCenterX()-40, (int)jtpk.getCenterY());

			Graphics2D g2d = (Graphics2D)g;
		//g.drawString("total coins ="+ mario.getTotalCoins(), 20, 20);
		if(selected == 1 && !jumpBought){
			g2d.setColor(Color.GREEN);
			g2d.draw(jump);
		}
		if(selected == 2 && !interBought){
			g2d.setColor(Color.GREEN);
			g2d.draw(interact);
		}
		if(selected == 3 && !flyBought){
			g2d.setColor(Color.GREEN);
			g2d.draw(fly);
		}
		if(selected == 4 && !jtpkBought){
			g2d.setColor(Color.GREEN);
			g2d.draw(jtpk);
		}
		
			g2d.setColor(Color.RED);
			g2d.draw(jump);

			g2d.setColor(Color.RED);
			g2d.draw(interact);
			
			g2d.setColor(Color.RED);
			g2d.draw(fly);
			
			g2d.draw(jtpk);
			g2d.setColor(Color.RED);
	}
}