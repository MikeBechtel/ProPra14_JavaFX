package adapters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.*;


/**
 * Adapter Class for reading maps from an external format (.txt)
 */
public class MapReader 
{
	public MapReader()
	{
		
	}
	
	/**
	 * Reads the map from a given .txt File.
	 * 
	 * @param file - File location
	 * @return <b>Map</b> - A map object containing the defined terrain, sprites, etc.
	 */
	public Map readMap(String file)
	{
		try
		{
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferRead = new BufferedReader(fileReader);
		
		Map returnMap = null;

		String singleLine;
		ArrayList<String> lines = new ArrayList<String>();
		
		String name = "", type = "";
		double startx = 0, starty = 0, size = 0;
		ArrayList<Double> points = new ArrayList<Double>();
		double[] pointsArray = null;
		
		while((singleLine = bufferRead.readLine()) != null)
			lines.add(singleLine);
		
		returnMap = new Map();
		
		for(String curLine : lines)
		{
			//When a line start with '#' ignore it (comment)
			if(!curLine.startsWith("#"))
			{
				String[] sLine = curLine.split("[ ;<>]");
				
				for(String s : sLine)
				{
					/*
					 * Get the mapname, polygontype, startX and startY (for Sprites) and
					 * the given points for polygons
					 */
					if(s.startsWith("name="))
					{
						name = s.substring(5);
						returnMap.setName(name);
					}
					else if(s.startsWith("type="))
						type = s.substring(5);
					else if(s.startsWith("startx="))
						startx = Double.parseDouble(s.substring(7));
					else if(s.startsWith("starty="))
						starty = Double.parseDouble(s.substring(7));
					else if(s.startsWith("size="))
						size = Double.parseDouble(s.substring(5));
					else if(s.startsWith("points="))
					{
						String[] pointsArr = s.substring(8, s.length() - 1).split("[ (),]");
	
						for(String singleCoord : pointsArr)
							if(!singleCoord.equals(""))
								points.add(Double.parseDouble(singleCoord));
						 /*
						  * Convert the ArrayList to a normal Array (needed for all Terrain-Objects)
						  */
						pointsArray = new double[points.size()];
						for(int i = 0; i < pointsArray.length; i++)
							pointsArray[i] = (double)points.get(i);
					}
				}
	
				//add the new Terrain or Sprite to the Map Object
				if(type.equalsIgnoreCase("gras"))
					returnMap.addTerrain(new TerrainGras(pointsArray));
				else if(type.equalsIgnoreCase("solidstone"))
					returnMap.addSolid(new SolidStone(pointsArray));
				else if(type.equalsIgnoreCase("bullet"))
					returnMap.addSprite(new SpriteBullet(startx, starty, size));
				else if(type.equalsIgnoreCase("spawn"))
					returnMap.addSpawn(new Spawnpoint(startx, starty));

				type = "";
				points.clear();
			}
		}
		
		bufferRead.close();
		
		return returnMap;
		}
		catch(FileNotFoundException fEx)
		{
			System.out.println("Could not load the map file '" + file +"'.");
			fEx.printStackTrace();
			return null;
		}
		catch(IOException ioEx)
		{
			System.out.println("An unexpected error occured while reading the map file '" + file + "'.");
			ioEx.printStackTrace();
			return null;
		}
	}
}
