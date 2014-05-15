package adapters;

import com.sun.javafx.geom.Vec2d;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.*;

public class CollisionAdapter 
{
	private AnchorPane parentPane;
	private final double lookAhead = 0.5;
	
	public CollisionAdapter(AnchorPane parentPane)
	{
		this.parentPane = parentPane;
	}
	
	/**
	 * Main method for handling the collisions of all game objects.
	 * Loops through all Sprites, Terrain, etc. Objects to evaluate
	 * whether a collision occurred or not.
	 */
	public void handleCollision()
	{
		Shape s = null;

		for(Sprite sprite : GameLoop.sprites)
		{
	        if (sprite.getBoundsInParent().getMinX() < 0 || sprite.getBoundsInParent().getMaxX() > parentPane.getWidth()) {
		        sprite.setSpeedX(sprite.getSpeedX() * (-1));
	        }
	        if (sprite.getBoundsInParent().getMinY() < 0 || sprite.getBoundsInParent().getMaxY() > parentPane.getHeight()) {
		        sprite.setSpeedY(sprite.getSpeedY() * (-1));
	        }
	        
	        /*
	         * Collision Detection works with a look-ahead of one
	         * transition
	         */
	        double zwX = sprite.getTranslateX();
	        double zwY = sprite.getTranslateY();
	        
	        sprite.setTranslateX(sprite.getTranslateX() + lookAhead*sprite.getSpeedX());
	        sprite.setTranslateY(sprite.getTranslateY() + lookAhead*sprite.getSpeedY());

	        for(Terrain terrain : GameLoop.terrain)
	        {
	        	s = Shape.intersect(sprite, terrain);
	        	s.setFill(Color.CYAN);
	        	
	        	if(!s.getBoundsInLocal().isEmpty())
	        	{
	    	        sprite.setTranslateX(zwX);
	    	        sprite.setTranslateY(zwY);
	    	        
	    		    sprite.setSpeed(evalCollLine(sprite, s));
	        	}
	        }
	        for(Sprite sprite2 : GameLoop.sprites)
	        {
	        	if(sprite != sprite2)
	        	{
	        	s = Shape.intersect(sprite, sprite2);
	        	s.setFill(Color.CYAN);
	        	
	        	if(!s.getBoundsInLocal().isEmpty())
	        	{
	    	        sprite.setTranslateX(zwX);
	    	        sprite.setTranslateY(zwY);
	    	        
	    		    sprite.setSpeed(evalCollLine(sprite, s));
	        	}
	        	}
	        }
	        		
	        sprite.setTranslateX(zwX + sprite.getSpeedX());
	        sprite.setTranslateY(zwY + sprite.getSpeedY());
		}
	}
	
	/**
	 * Method that evaluates the angle of reflection. 
	 * Uses easy functions from Linear Algebra
	 * 
	 * @param sprite - The sprite that needs to be reflected
	 * @param shape - The shape from which the sprite reflects
	 * @return <b>Vec2d</b> - A new Vec2d containing the new velocity for the given sprite
	 */
	private Vec2d evalCollLine(Sprite sprite, Shape shape)
	{
        sprite.setTranslateX(sprite.getTranslateX() + lookAhead*sprite.getSpeedX());
        sprite.setTranslateY(sprite.getTranslateY() + lookAhead*sprite.getSpeedY());

        double lx = getMidX(sprite)-getMidX(shape);
		double ly = getMidY(sprite)-getMidY(shape);
		
		/*
		 * functions from Linear Algebra
		 */
		Vec2d v = new Vec2d(lx, ly);
		Vec2d normV = new Vec2d(v.x * 1/Math.sqrt(v.x * v.x + v.y * v.y), v.y * 1/Math.sqrt(v.x * v.x + v.y * v.y));
		double vOrth = ((sprite.getSpeedX() * normV.x) + (sprite.getSpeedY() * normV.y));
		
		Vec2d vNeu = new Vec2d(sprite.getSpeedX()-2*vOrth*normV.x, sprite.getSpeedY()-2*vOrth*normV.y);

		return vNeu;
	}
	
	/**
	 * Returns the Center x-coordinate for the given shape
	 * @param shape - The shape 
	 * @return <b>double</b> The center x-coordinate
	 */
	private double getMidX(Shape shape)
	{
		return 0.5 * (shape.getBoundsInParent().getMaxX() + shape.getBoundsInParent().getMinX());
	}
	
	/**
	 * Returns the Center y-coordinate for the given shape
	 * @param shape - The shape 
	 * @return <b>double</b> The center y-coordinate
	 */
	private double getMidY(Shape shape)
	{
		return 0.5 * (shape.getBoundsInParent().getMaxY() + shape.getBoundsInParent().getMinY());
	}
}
