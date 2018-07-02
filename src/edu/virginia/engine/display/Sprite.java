package edu.virginia.engine.display;

import java.util.ArrayList;

import edu.virginia.engine.events.Event;
import edu.virginia.engine.events.IEventListener;

/**
 * Nothing in this class (yet) because there is nothing specific to a Sprite yet that a DisplayObject
 * doesn't already do. Leaving it here for convenience later. you will see!
 * */
public class Sprite extends DisplayObjectContainer implements IEventListener {

	public Sprite(String id) {
		super(id);
	}

	public Sprite(String id, String imageFileName, double rotation, int x, int y, double px, double py, double scX, double scY) {
		super(id, imageFileName,rotation, x, y , px, py, scY, scY);
	}
	
	@Override
	public void update(ArrayList<Integer> pressedKeys) {
		super.update(pressedKeys);
	}

	@Override
	public void handleEvent(Event event) {
		
		this.setVisible(false);
		//System.out.println("Invisible");
	}
	
}
