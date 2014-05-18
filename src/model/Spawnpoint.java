package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import com.sun.javafx.geom.Vec2d;

public class Spawnpoint extends Circle
{
	private double posX, posY;
	
	public Spawnpoint(double posX, double posY)
	{
		super(posX, posY, 3);
		super.setFill(Color.RED);
		this.posX = posX;
		this.posY = posY;
	}
	
	public double getSpawnX()
	{
		return posX;
	}
	
	public double getSpawnY()
	{
		return posY;
	}
	
	public Vec2d getSpawn()
	{
		return new Vec2d(posX, posY);
	}
}
