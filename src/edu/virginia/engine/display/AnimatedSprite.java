package edu.virginia.engine.display;

import java.util.ArrayList;
import java.util.List;

import edu.virginia.engine.util.GameClock;

public class AnimatedSprite extends Sprite {
	
	private int startFrame;
	private int endFrame;
	private List <String> frames;
	//private List<String> locations;
	private GameClock clock;
	private boolean playing;
	private int currentFrame;
	private double animationSpeed;
	private int b;
	private int xx;
	
	public AnimatedSprite(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public AnimatedSprite(String id, String imageFileName, double rotation, int x, int y, double px, double py, int scX, int scY ){
		super(id, imageFileName, py, scY, scY, py, py, scY, scY);
		this.frames=new ArrayList <String>();
		this.startFrame=0;
		this.endFrame=0;
		this.playing=false;
		this.currentFrame=0;
		this.animationSpeed=1;
		this.clock= new GameClock();
		//this.locations= new ArrayList<String>();
		this.xx=0;
		this.b=0;
	}
	
	public void play(String n){
		this.playing=true;
		 
		if(n=="standby"){
			if(this.xx==0){
				this.currentFrame=1;
				this.startFrame=0;
				this.endFrame=5;
				this.animationSpeed=80;
				this.xx+=1;
			}
		}
		
		if(n=="run"){
			if(this.b==0){
			this.currentFrame=6;
			this.startFrame=6;
			this.endFrame=10;
			this.animationSpeed=80;
			this.b+=1;
			}
			//update();
		}
		
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys){
	    if(playing){
	        if(clock.getElapsedTime() >= animationSpeed){
	        	clock.resetGameClock();
	        	//System.out.println("change frame");
	            if(currentFrame<endFrame){
	            currentFrame++; 
	            //need currentFrame to wrap, so this is buggy
	            super.setImage(frames.get(currentFrame));
	            }
	            else{
	            	currentFrame=startFrame;
	            	super.setImage(frames.get(currentFrame));
	            	this.b=0;
	            	this.xx=0;
	            	}
	            }
	    	}
	      }
	    

	public boolean isPlaying() {
		return playing;
	}


	public void setPlaying(boolean playing) {
		this.playing = playing;
	}


	public double getAnimationSpeed() {
		return animationSpeed;
	}


	public void setAnimationSpeed(double animationSpeed) {
		this.animationSpeed = animationSpeed;
	}


	public int getCurrentFrame() {
		return currentFrame;
	}


	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}


	public int getEndFrame() {
		return endFrame;
	}


	public void setEndFrame(int endFrame) {
		this.endFrame = endFrame;
	}


	public int getStartFrame() {
		return startFrame;
	}


	public void setStartFrame(int startFrame) {
		this.startFrame = startFrame;
	}


	public List <String> getFrames() {
		return frames;
	}


	public void setFrames(List <String> frames) {
		this.frames = frames;
	}
	
	
}
