package edu.virginia.engine.display;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JPanel;

public class Menu extends DisplayObjectContainer{
	
	HashMap<String, Integer> menu;
	public Menu(String id) {
		super(id);
		menu=new HashMap<String,Integer>();
		
		
		// TODO Auto-generated constructor stub
	}
	public void addItem(String b, int price){
		menu.put(b, price);
	
	}
	public int getPrice(String b){
		return menu.get(b);
	}
	

}
