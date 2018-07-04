package edu.virginia.engine.display;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
//import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DisplayObjectContainer extends DisplayObject {
	private List <DisplayObjectContainer> children;
	private boolean hasChildren;
	public DisplayObjectContainer(String id) {
		super(id);
		children=new ArrayList<DisplayObjectContainer>();
		hasChildren=false;
		
		// TODO Auto-generated constructor stub
	}
	public DisplayObjectContainer(String id, String fileName, double rotation, int x, int y, double px, double py, double scX, double scY){
	 super(id,fileName,rotation,x,y,px,py,scX,scY);
	 children= new ArrayList<DisplayObjectContainer>();
	 hasChildren=false;
	 
	 
	}
	
	
	/*public DisplayObject getChild() {
		return child;
	}
	*/
	public void addChild(DisplayObjectContainer child){
		if(this.hasChildren==false){
			this.setHasChildren(true);
			child.setParent(this);
			this.children.add(child);
		}
		else{
			child.setParent(this);
			this.children.add(child);
		}
		
	}
	public void removeChild(DisplayObjectContainer child){
		child.setParent(null);
		this.children.remove(child);
		if(children.size()==0){
			this.setHasChildren(false);
		}
	}
	public List <DisplayObjectContainer> getChildren() {
		return children;
	}
	public void removeAllChildren(){
		for(int x= 0; x<this.children.size(); x++){
			children.get(x).setParent(null);
			children.remove(x);
		}
		this.setHasChildren(false);
	}
	public void setChildren(List <DisplayObjectContainer> children) {
		this.children = children;
	}
	public boolean isHasChildren() {
		if(this.children.isEmpty()){
			hasChildren=false;
		}
		else{
			hasChildren=true;
		}
		return hasChildren;
	}
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	@Override
	public void draw(Graphics g) {
		super.draw(g);		//Draw myself!
		this.applyTransformations((Graphics2D) g);
		//Apply MY transformations to my children
		for(DisplayObjectContainer child: children){
			if(child!=null){
				if(child.isVisible()){
				child.draw(g);}
			}
		}
		/*for(child in children)		//Draw each of my children  
			child.draw(g);
		 */
		reverseTransformations((Graphics2D) g);	//Reverse those transformations
	
	}

	
}


