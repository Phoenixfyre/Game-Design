package edu.virginia.engine.display;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu extends DisplayObjectContainer implements ActionListener{
	
	private boolean isBought;
	private boolean canBuy;
	private boolean isOpen;
	private Sprite sprite;
	private JMenuBar menuBar;
	private JMenu mainMenu;
	private JMenuItem item;
	private JFrame F;
	JTextArea output;
	JScrollPane scrollPane;
	
	HashMap<String, Integer> menu;
	
	public Menu(String id) {
		super(id);
		openMenu();
		
		menu=new HashMap<String,Integer>();
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void openMenu(){
		F = new JFrame("Game Menu");
		menuBar = new JMenuBar();
		mainMenu = new JMenu("File");
		

		F.setJMenuBar(menuBar);
		F.setSize(300, 100);
		F.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent f){
		if(f.getSource() == item){
			JFileChooser F = new JFileChooser(",");
			F.showOpenDialog(null);
		}
	}
	
	public void addItem(String b, int price){
		menu.put(b, price);
		//item = new JMenuItem("Price: " + price, new ImageIcon("resources/"+imageName+".png"));
		item.setText(b);
		mainMenu.add(item);
		item.addActionListener(this);
	
	}
	public int getPrice(String b){
		return menu.get(b);
	}
	

}
