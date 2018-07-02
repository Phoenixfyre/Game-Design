package edu.virginia.engine.tweening;

import java.util.ArrayList;
import java.util.List;

import edu.virginia.engine.events.Event;
import edu.virginia.engine.events.IEventListener;

public class TweenJuggler implements IEventListener{
	static List<Tween> tweens;
	public TweenJuggler() {
		// TODO Auto-generated constructor stub
		tweens=new ArrayList<Tween>();
	}
	
	public static void add(Tween tween){
		tweens.add(tween);
	}
	public void update(){
		for(Tween t : tweens){
			t.update();
		}
	}

	@Override
	public void handleEvent(Event event) {
		if(event.getEventType()=="alph1"){
			this.update();
		}
		
	}
	
	
}
