package controller;

import java.util.ArrayList;

import adapters.CollisionAdapter;
import adapters.RoundAdapter;
import util.MapReader;
import model.*;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * The main game loop. Initializes the maps
 * and adding the corresponding Objects
 * to the AnchorPane.
 * 
 * @author Bellum
 *
 */
public class GameLoop
{
	public Duration oneFrameDur = Duration.millis(1000/60);
	
	public ControllerGame parentController;
	private Timeline loop;
	
	private int currLevel = 1;
	
	public static ArrayList<Terrain> terrain;
	public static ArrayList<Solid> solids;
	public static ArrayList<Sprite> sprites;
	public static ArrayList<Spawnpoint> spawn;
	
	public static ArrayList<Player> players;
	
	private MapReader mapReader;
	private Map currMap;
	
	private CollisionAdapter collAdapter;
	private RoundAdapter roundAdapter;
	
	public Player currPlayer;
	
	/**
	 * Creates a new GameLoop Object.
	 * It gets the parent AnchorPane, on which the
	 * game will be painted.
	 * 
	 * @param parentPane - The parent AnchorPane where the game will be set
	 */
	public GameLoop(ControllerGame parentController)
	{
		this.parentController = parentController;
		
		players = new ArrayList<Player>();
		
		collAdapter = new CollisionAdapter(parentController.gamePane);
		roundAdapter = new RoundAdapter(this);
		
		loop = new Timeline();
		loop.setCycleCount(Animation.INDEFINITE);
		
		mapReader = new MapReader();
		
		initMap("maps/map1.txt");
	}
	
	/**
	 * Starts the game loop.
	 * This is where all logical functions will be called.
	 */
	public void start()
	{
		KeyFrame oneFrame = new KeyFrame(oneFrameDur, 
				new EventHandler<ActionEvent> ()
				{
			
					public void handle(ActionEvent event)
						{
							collAdapter.handleCollision();
							roundAdapter.handleRound();
						}
				});
		
		loop.getKeyFrames().add(oneFrame);
		loop.play();
	}
	
	/**
	 * Reads the initial map and adds the corresponding 
	 * Objects to the parent AnchorPane
	 */
	public void initMap(String mapFile)
	{
		parentController.gamePane.getChildren().clear();
		
		currMap = mapReader.readMap(mapFile);
		
		terrain = currMap.getTerrain();
		solids = currMap.getSolids();
		sprites = currMap.getSprites();
		spawn = currMap.getSpawnpoints();
		
		players.add(new Player("Mike"));
		players.add(new Player("Oscar"));
		
		currPlayer = players.get(0);
		
		parentController.gamePane.getChildren().add(parentController.roundStats);
		
		parentController.gamePane.getChildren().addAll(terrain);
		parentController.gamePane.getChildren().addAll(solids);
		parentController.gamePane.getChildren().addAll(sprites);
		parentController.gamePane.getChildren().addAll(spawn);
	}
	
	public void nextMap()
	{
		if(currLevel == 3)
			currLevel = 1;
		else
			currLevel++;
		
		roundAdapter.reset();
		initMap("maps/map" + currLevel + ".txt");
	}
	
	public void prevMap()
	{
		if(currLevel == 1)
			currLevel = 3;
		else
			currLevel--;

		roundAdapter.reset();
		initMap("maps/map" + currLevel + ".txt");
	}
	
	public RoundAdapter getRoundAdapter()
	{
		return this.roundAdapter;
	}
}
