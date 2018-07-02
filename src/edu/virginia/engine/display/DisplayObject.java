package edu.virginia.engine.display;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import edu.virginia.engine.events.EventDispatcher;

/**
 * A very basic display object for a java based gaming engine
 * 
 * */
public class DisplayObject extends EventDispatcher {

	/* All DisplayObject have a unique id */
	private String id;
	private boolean visible;
	private Point position;
	private Point pivotPoint;
	private double scaleX;
	private double scaleY;
	private double rotation;
	private double alpha;
	private DisplayObject parent; 	
	
	/* The image that is displayed by this object */
	private BufferedImage displayImage;

	/**
	 * Constructors: can pass in the id OR the id and image's file path and
	 * position OR the id and a buffered image and position
	 */
	public DisplayObject(String id) {
		this.setId(id);
		this.visible=true;
		this.scaleX=1;
		this.scaleY=1;
		this.position= new Point();
		this.position.setLocation(0, 0);
		this.pivotPoint=new Point();
		this.pivotPoint.setLocation(0, 0);
		this.alpha=1;
		this.rotation=0;
	}

	public DisplayObject(String id, String fileName, double rotation, int x, int y, double px, double py, double scX, double scY) {
		this.setId(id);
		this.setImage(fileName);
		this.visible=true;
		this.scaleX=scX;
		this.scaleY=scY;
		this.position= new Point();
		this.position.setLocation(x, y);
		this.pivotPoint=new Point();
		this.pivotPoint.setLocation(px, py);
		this.alpha=1;
		this.rotation=rotation;
		
		
		
		
	}
	
	public void setXpos(double x){
		this.setPosition(x, this.getPosition().getY());
	}
	public void setYpos(double x){
		this.setPosition(this.getPosition().getX(), x);
	}
	public boolean collidesWith(DisplayObject other){
		Area a = new Area(getGlobalHitbox());
		a.intersect(new Area(other.getGlobalHitbox()));
		return !a.isEmpty();
	}
	public Shape getGlobalHitbox(){
		return getGlobalTransform().createTransformedShape(new Rectangle(0, 0, getUnscaledWidth(), getUnscaledHeight()));
	}
		
	public Shape getLocalHitbox(){
		return getLocalTransform().createTransformedShape(new Rectangle(0, 0, getUnscaledWidth(), getUnscaledHeight()));
	}
	
	protected AffineTransform getGlobalTransform(){
		AffineTransform at;
		if(this.parent == null) at = new AffineTransform();
		else at = this.getParent().getGlobalTransform();
		
		at.concatenate(getLocalTransform());
		return at;
	}
		
	private AffineTransform getLocalTransform(){
		AffineTransform at = new AffineTransform();
		at.translate(this.position.x, this.position.y);
		at.rotate((this.rotation));
		at.scale(this.scaleX, this.scaleY);
		at.translate(-this.pivotPoint.x, -this.pivotPoint.y);
		return at;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	

	/**
	 * Returns the unscaled width and height of this display object
	 * */
	public int getUnscaledWidth() {
		if(displayImage == null) return 0;
		return displayImage.getWidth();
	}
	public void setPosition(double d, double e){
		this.getPosition().setLocation(d, e);
	}

	public int getUnscaledHeight() {
		if(displayImage == null) return 0;
		return displayImage.getHeight();
	}

	public BufferedImage getDisplayImage() {
		return this.displayImage;
	}

	protected void setImage(String imageName) {
		if (imageName == null) {
			return;
		}
		displayImage = readImage(imageName);
		if (displayImage == null) {
			System.err.println("[DisplayObject.setImage] ERROR: " + imageName + " does not exist!");
		}
	}


	/**
	 * Helper function that simply reads an image from the given image name
	 * (looks in resources\\) and returns the bufferedimage for that filename
	 * */
	public BufferedImage readImage(String imageName) {
		BufferedImage image = null;
		try {
			String file = ("resources" + File.separator + imageName);
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			System.out.println("[Error in DisplayObject.java:readImage] Could not read image " + imageName);
			e.printStackTrace();
		}
		return image;
	}

	public void setImage(BufferedImage image) {
		if(image == null) return;
		displayImage = image;
	}


	/**
	 * Invoked on every frame before drawing. Used to update this display
	 * objects state before the draw occurs. Should be overridden if necessary
	 * to update objects appropriately.
	 * */
	protected void update(ArrayList<Integer> pressedKeys) {
		
	}

	/**
	 * Draws this image. This should be overloaded if a display object should
	 * draw to the screen differently. This method is automatically invoked on
	 * every frame.
	 * */
	public void draw(Graphics g) {
		
		if (displayImage != null) {
						/*
			 * Get the graphics and apply this objects transformations
			 * (rotation, etc.)
			 */
			Graphics2D g2d = (Graphics2D) g;
			applyTransformations(g2d);

			/* Actually draw the image, perform the pivot point translation here */
			g2d.drawImage(displayImage,(int)pivotPoint.getX()*-1, (int)pivotPoint.getY()*-1,
					(int) (getUnscaledWidth()),
					(int) (getUnscaledHeight()), null);
			
			/*
			 * undo the transformations so this doesn't affect other display
			 * objects
			 */
			reverseTransformations(g2d);
		}
	}
	public Point setPivotPoint(double x, double y){
		this.pivotPoint.setLocation(x, y);
		return this.pivotPoint;
		
	}
	public void setCenter(){
		this.getPivotPoint().setLocation(this.getUnscaledWidth()/2, this.getUnscaledHeight()/2);
		
	}
	/**
	 * Applies transformations for this display object to the given graphics
	 * object
	 * */
	protected void applyTransformations(Graphics2D g2d) {
		g2d.translate(this.position.getX(), this.position.getY());
		
		g2d.rotate(this.rotation);
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) alpha));
		
		g2d.scale(this.scaleX, this.scaleY);
		
	
	}
	
	/**
	 * Reverses transformations for this display object to the given graphics
	 * object
	 * */
	protected void reverseTransformations(Graphics2D g2d) {
		g2d.scale(1/scaleX, 1/scaleY);
		
		g2d.rotate(rotation*-1);
		
		
		
		g2d.translate(position.getX()*-1, position.getY()*-1);
	}



	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setPosition(Point position1){
		position=position1;
	}
	
	public Point getPosition(){
		return position;
	}
	public double getScaleX() {
		return scaleX;
	}

	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}

	public double getScaleY() {
		return scaleY;
	}

	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public Point getPivotPoint() {
		return pivotPoint;
	}

	public void setPivotPoint(Point pivotPoint) {
		this.pivotPoint = pivotPoint;
	}

	public DisplayObject getParent() {
		return parent;
	}

	public void setParent(DisplayObject parent) {
		this.parent = parent;
	}

}
