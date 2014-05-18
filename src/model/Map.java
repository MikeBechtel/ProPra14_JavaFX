package model;

import java.util.ArrayList;

public class Map 
{
	private String name;
	private ArrayList<Terrain> terrain;
	private ArrayList<Sprite> sprites;
	
	public Map()
	{
		name = "NoName";
		terrain = new ArrayList<Terrain>();
		sprites = new ArrayList<Sprite>();
	}
	
	public Map(String name)
	{
		this.name = name;
		terrain = new ArrayList<Terrain>();
		sprites = new ArrayList<Sprite>();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addTerrain(Terrain terrain)
	{
		this.terrain.add(terrain);
	}
	
	public void addSprite(Sprite sprite)
	{
		this.sprites.add(sprite);
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Terrain> getTerrain()
	{
		return terrain;
	}
	
	public ArrayList<Sprite> getSprites()
	{
		return sprites;
	}
}
