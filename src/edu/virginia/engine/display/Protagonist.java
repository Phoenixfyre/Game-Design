package edu.virginia.engine.display;

public class Protagonist extends PhysicsSprite {
	private boolean canJump;
	private boolean canJetPack;
	private Sprite firebal;
	private int coinTotal;
	public Protagonist(String id, String imageFileName, double rotation, int x, int y, double px, double py, int scX,
			int scY) {
		super(id, imageFileName, rotation, x, y, px, py, scX, scY);
		canJump=false;
		canJetPack=false;
		coinTotal=500;
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
	
	public void fireball(){
		
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
