package model;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class SolidStone extends Solid
{
	public SolidStone(double... points)
	{
		super(points);
		super.setFill(Color.GREY);
	}

	@Override
	public void setImage(ImagePattern imagePattern) 
	{
		
	}
}
