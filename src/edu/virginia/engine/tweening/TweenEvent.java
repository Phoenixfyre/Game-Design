package edu.virginia.engine.tweening;

import edu.virginia.engine.events.Event;
import edu.virginia.engine.events.IEventDispatcher;

public class TweenEvent extends Event {
	
	private Tween t;
	public final static String TWEEN_IS_COMPLETE= "Tween has performed";
	public TweenEvent(String eventType, IEventDispatcher tween) {
		super(eventType,tween);
	
	}
	public Tween getTween(){
		return this.t;
	}
}
