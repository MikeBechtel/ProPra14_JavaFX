package model;

import java.util.ArrayList;

/**
 * Saves the game map and all its defining terrain, sprites, etc.
 * 
 * @author Bellum
 *
 */
public class Map 
{
	/*
	 * name - Saves the mapname
	 * terrain - ArrayList for saving the Terrain-Polygons
	 * sprites - ArrayList for saving the Sprite-Polygons
	 */
	private String name;
	private ArrayList<Terrain> terrain;
	private ArrayList<Solid> solids;
	private ArrayList<Sprite> sprites;
	private ArrayList<Spawnpoint> spawnpoints;
	
	/**
	 * Creates a new map with the name 'NoName'
	 */
	public Map()
	{
		name = "NoName";
		terrain = new ArrayList<Terrain>();
		solids = new ArrayList<Solid>();
		sprites = new ArrayList<Sprite>();
		spawnpoints = new ArrayList<Spawnpoint>();
	}
	
	/**
	 * Create a new map with the given name
	 * @param name - name of the new map
	 */
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
	
	public void addSolid(Solid solid)
	{
		this.solids.add(solid);
	}
	
	public void addSprite(Sprite sprite)
	{
		this.sprites.add(sprite);
	}
	
	public void addSpawn(Spawnpoint spawn)
	{
		this.spawnpoints.add(spawn);
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Terrain> getTerrain()
	{
		return terrain;
	}
	
	public ArrayList<Solid> getSolids()
	{
		return solids;
	}
	
	public ArrayList<Sprite> getSprites()
	{
		return sprites;
	}
	
	public ArrayList<Spawnpoint> getSpawnpoints()
	{
		return spawnpoints;
	}
}
