package model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;;

public abstract class Sprite extends Polygon
{
	protected int speedX, speedY;
	
	public Sprite(double...points)
	{
		super(points);
	}
	public void setSpeedX(int speedX)
	{
		this.speedX = speedX;
	}
	
	public void setSpeedY(int speedY)
	{
		this.speedY = speedY;
	}
	
	public int getSpeedX()
	{
		return speedX;
	}
	
	public int getSpeedY()
	{
		return speedY;
	}
	
	public void fillSprite(Paint paint)
	{
		super.setFill(paint);
	}
}
