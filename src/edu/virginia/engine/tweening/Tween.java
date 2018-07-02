package edu.virginia.engine.tweening;

import java.util.ArrayList;
import java.util.List;

import edu.virginia.engine.display.DisplayObject;
import edu.virginia.engine.events.EventDispatcher;

public class Tween extends EventDispatcher {
	//private boolean complete;
	private List <TweenParam> params;
	private DisplayObject sprite;
	private TweenTransition trans;
	
	public Tween(DisplayObject object) {
		this.sprite=object;
		this.params=new ArrayList<TweenParam>();
		// TODO Auto-generated constructor stub
		
	}
	public Tween(DisplayObject object, TweenTransition transition){
		this.sprite=object;
		this.trans=transition;
	}
	
	public void animate(TweenableParam fieldToAnimate, double startVall, double endVall, double time){
		TweenParam b= new TweenParam(fieldToAnimate,startVall,endVall,time, this.sprite);
		params.add(b);
	}
	
	public void update(){
		List<TweenParam> rem= new ArrayList<TweenParam>();
		for(TweenParam t: params){
			t.update();
			if(t.isComplete()){
				rem.add(t);
				
			}
		}
		params.removeAll(rem);
	}
	
	public boolean isComplete(){
		boolean check=true;
		for(TweenParam x : params){
			if(!x.isComplete()){
				check=false;
			}
		}
		return check;
	}
	public void setValue(TweenableParam param, double value){
		
	}

}
