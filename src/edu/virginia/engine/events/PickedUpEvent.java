package edu.virginia.engine.events;

public class PickedUpEvent extends Event{

	public PickedUpEvent() {
		super();
	}
	public String Coin_Picked_Up(){
		String s = "Quest Complete! You got the Coin";
		return s;
	}
}
