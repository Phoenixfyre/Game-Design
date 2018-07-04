package edu.virginia.engine.display;

import edu.virginia.engine.util.GameClock;

public class Protagonist extends PhysicsSprite {
	private boolean canJump;
	private boolean canJetPack;
	private Sprite firebal;
	private int coinTotal;
	private GameClock c= new GameClock();
	public Protagonist(String id, String imageFileName, double rotation, int x, int y, double px, double py, int scX,
			int scY) {
		super(id, imageFileName, rotation, x, y, px, py, scX, scY);
		canJump=false;
		canJetPack=true;
		coinTotal=500;
		firebal= new Sprite("fireball", "fireball.png", 0,0,0,0,0,1,1);
		c=new GameClock();
		// TODO Auto-generated constructor stub
	}

	public void jetpack(){
		if(canJetPack==true){
			this.setVelY(-1);
		}
	}
	public void jump(){
		if(canJump==true){
			this.setVelY(-2);
		}
	}
	public int getTotalCoins(){
		return coinTotal;
	}
	public void addCoin(){
		this.coinTotal+=1;
	}
	public void sword(){
		
	}
	
	
	
	public void interact(){
		
	}
	public boolean isJumping(){
		return this.canJump;
	}
	public void setJump(boolean b){
		this.canJump=b;
	}
	public boolean isJetpacking(){
		return this.canJetPack;
	}
	public void setJetpack(boolean b){
		this.canJump=false;
		this.canJetPack=b;
	}

}
