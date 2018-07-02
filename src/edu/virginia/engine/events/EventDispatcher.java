package edu.virginia.engine.events;

import java.util.ArrayList;
import java.util.HashMap;

public class EventDispatcher implements IEventDispatcher{
	 private HashMap<String, ArrayList<IEventListener>> events;
	public EventDispatcher() {
		this.setEvents(new HashMap<String, ArrayList<IEventListener>>());
	}

	public HashMap<String, ArrayList<IEventListener>> getEvents() {
		return events;
	}

	public void setEvents(HashMap<String, ArrayList<IEventListener>> events) {
		this.events = events;
	}

	@Override
	public void addEventListener(IEventListener listener, String eventType) {
		 if(this.events.containsKey(eventType)){
			 this.events.get(eventType).add(listener);
		 }
		 else{
			 this.events.put(eventType, new ArrayList<IEventListener>());
			 this.events.get(eventType).add(listener);
				 
		 }
	}

	@Override
	public void removeEventListener(IEventListener listener, String eventType) {
		this.events.get(eventType).remove(listener);
		
	}

	@Override
	public void dispatchEvent(Event event) {
		 for (IEventListener listen : this.events.get(event.getEventType())){
			 	//System.out.println(this.events.get(event.getEventType()));
	            listen.handleEvent(event);
	           // System.out.println("handled");
	        }
		
	}

	@Override
	public boolean hasEventListener(IEventListener listener, String eventType) {
		if(events.containsKey(eventType)){
			if(events.get(eventType).contains(listener)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}

	

}
