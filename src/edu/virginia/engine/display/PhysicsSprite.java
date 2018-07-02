package edu.virginia.engine.display;

public class PhysicsSprite extends AnimatedSprite {
	double accelx = 0;
	double accely = 0;
	double velx = 0;
	double vely = 0;
	boolean jump;
	boolean rest;
	int maxJump;
	double jumps;
	//each sprite will have its own mass, speed, acceleration, and gravity to it
	public PhysicsSprite(String id) {
		super(id);
		this.accelx=0;
		this.accely=0;
		this.velx=0;
		this.vely=0;
		this.maxJump=100;
	
	}
	public PhysicsSprite(String id, String imageFileName, double rotation, int x, int y, double px, double py, int scX, int scY){
		super(id,imageFileName,rotation,x,y,px,py,scX,scY);
		this.accelx=0;
		this.accely=0;
		this.velx=0;
		this.vely=0;
		this.maxJump=25;
		
		
	}
	public void updatePhys(){
		this.setYpos(this.getPosition().getY()+vely);
		
	}
	
	public double getVelocityX(){
		return velx;
	}
	public double getVelocityY(){
		return vely;
	}
	public double getAccelX(){
		return accelx;
	}
	public double getAccelY(){
		return accely;
	}
	
	
	public void setAcceleration(double x, double y){
		this.accelx=x;
		this.accely=y;
	}
	public void setAccelY(double y){
		this.accely=y;
	}
	public void setVelocity(double x, double y){
		this.velx=x;
		this.vely=y;
	}
	public void setVelY(double y){
		this.vely=y;
	}
	public void setVelX(double x){
		this.velx=x;
	}
	public void jumps(){
		
		
	}
	public boolean isJumping(){
		return jump;
	}
	public void setJump( boolean b){
		this.jump=b;
	}
	public int getJumpHeight(){
		return this.maxJump;
	}
}
