package model;

import com.sun.javafx.geom.Vec2d;

import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;;

public abstract class Sprite extends Polygon
{
	protected double speedX, speedY;
	private double midX, midY;
	
	public Sprite(double...points)
	{
		super(points);
		
		midX = 0.5 * (super.getBoundsInParent().getMaxX() + super.getBoundsInParent().getMinX());
		midY = 0.5 * (super.getBoundsInParent().getMaxY() + super.getBoundsInParent().getMinY());
	}
	public void setSpeedX(double speedX)
	{
		this.speedX = speedX;
	}
	
	public void setSpeedY(double speedY)
	{
		this.speedY = speedY;
	}
	
	public void setSpeed(Vec2d speed)
	{
		this.speedX = speed.x;
		this.speedY = speed.y;
	}
	
	public double getSpeedX()
	{
		return speedX;
	}
	
	public double getSpeedY()
	{
		return speedY;
	}
	
	public Vec2d getPos()
	{
		return new Vec2d(midX, midY);
	}
	
	public Vec2d getSpeed()
	{
		return new Vec2d(speedX, speedY);
	}
	
	public void fillSprite(Paint paint)
	{
		super.setFill(paint);
	}
	
	public abstract void setImage(ImagePattern imagePattern);
}
