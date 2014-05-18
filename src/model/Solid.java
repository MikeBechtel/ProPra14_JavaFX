package model;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

import com.sun.javafx.geom.Vec2d;

public abstract class Solid extends Polygon 
{
	private double midX, midY;
	
	public Solid(double... points)
	{
		super(points);
		
		midX = 0.5 * (super.getBoundsInParent().getMaxX() + super.getBoundsInParent().getMinX());
		midY = 0.5 * (super.getBoundsInParent().getMaxY() + super.getBoundsInParent().getMinY());
	}
	
	public Vec2d getPos()
	{
		return new Vec2d(midX, midY);
	}

	public abstract void setImage(ImagePattern imagePattern);
}
