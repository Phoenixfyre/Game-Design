package edu.virginia.engine.display;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Camera {
	private int x;
	private int y;
	
	public Camera() {
		// TODO Auto-generated constructor stub
		this.x=0;
		this.y=0;
	}
	
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(-this.x, -this.getY());
		
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y){
		this.y=y;
	}
	public int getY(){
		return y;
	}

}
