package model;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

public abstract class Terrain extends Polygon
{
	public Terrain(double... points)
	{
		super(points);
	}
	
	protected void setImage(ImagePattern imagePattern)
	{
		super.setFill(imagePattern);
	}
}
