package model;

import javafx.scene.paint.Color;

public class TerrainGras extends Terrain
{
	public TerrainGras(double... points)
	{
		super(points);
		super.setFill(Color.GREEN);
	}
}
