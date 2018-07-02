package edu.virginia.engine.tweening;

import edu.virginia.engine.display.DisplayObject;
import edu.virginia.engine.util.GameClock;

public class TweenParam {
	
	TweenableParam params;
	private double startVal;
	private double endVal;
	private double tweentime;
	private GameClock clock;
	private boolean complete;
	private DisplayObject sprite;
	private double ratio;
	public TweenParam(TweenableParam paramToTween, double startVall, double endVall, double time, DisplayObject sprites) {
		this.params=paramToTween;
		this.startVal=startVall;
		this.endVal=endVall;
		this.tweentime=time;
		this.clock=new GameClock();
		this.sprite=sprites;
		complete=false;
		
	}
	
	public TweenableParam getParam(){
		return this.params;
	}
	//jump only when on a platform
	public void update(){
		switch(params){
		case XPOS:
			//System.out.println(this.sprite.getPosition().getX());
			if(this.sprite.getPosition().getX()!=endVal){
				if(this.sprite.getPosition().getX()<endVal){
				//System.out.println(this.sprite.getPosition().getX());
				this.sprite.setXpos(startVal+endVal*(this.clock.getElapsedTime()/this.tweentime));
				
			}
				else{
					complete=true;
					this.isComplete();
			}
			
			}
			break;
		case YPOS:
			//System.out.println(this.sprite.getPosition().getY());
			if(this.sprite.getPosition().getY()!=endVal){
				if(this.sprite.getPosition().getY()<endVal){
				//System.out.println(this.sprite.getPosition().getY());
				this.sprite.setYpos(startVal+endVal*(this.clock.getElapsedTime()/this.tweentime));
			
				}
				else{
					complete=true;
					this.isComplete();}
		
			}
			break;
		case XSCALE:
			//System.out.println(this.sprite.getScaleX());
			if(this.sprite.getScaleX()!=endVal){
				if(this.sprite.getScaleX()<endVal){
				//System.out.println(this.sprite.getScaleX());
				this.sprite.setScaleX((startVal+endVal*(this.clock.getElapsedTime()/this.tweentime)));
				}
				else{
					complete=true;
					this.isComplete();
			}
			
			}
			break;
		case YSCALE:
			if(this.sprite.getScaleY()!=endVal){
				if(this.sprite.getScaleY()<endVal){
				//System.out.println(this.sprite.getScaleY());
				this.sprite.setScaleY((startVal+endVal*(this.clock.getElapsedTime()/this.tweentime)));
				}
				else{
					complete=true;
					this.isComplete();
			}
			
			}
			break;
		case ALPHA:
			//System.out.println("her2e");
			if(startVal<endVal){
				if(this.sprite.getAlpha()<.99){
				this.sprite.setAlpha((startVal+endVal*(this.clock.getElapsedTime()/this.tweentime)));
			}
				else{
					this.sprite.setAlpha(1);
					this.isComplete();
				}
			}
			else
				if(this.sprite.getAlpha()>endVal){
					if(this.sprite.getAlpha()>0.1){
						//System.out.println(this.sprite.getAlpha());
						this.sprite.setAlpha((startVal-endVal*(this.clock.getElapsedTime()/this.tweentime)));
						//System.out.println("works?");
					}
					else{
						this.sprite.setAlpha(0);
						complete=true;
						this.isComplete();
						
					}
				}
			
			break;
		case ROTATION:
			//System.out.println("rotate x bits");
			break;
		}
		
	}
	
	public boolean isComplete(){
		return this.complete;
	}
	public double getStartVal(){
		return this.startVal;
	}
	public double getEndVal(){
		return this.endVal;
	}
	public double getTweenTime(){
		return this.tweentime;
	}
}
