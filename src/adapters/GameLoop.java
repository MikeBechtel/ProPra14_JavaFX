package adapters;

import java.util.ArrayList;

import model.*;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

public class GameLoop
{
	private int fps;
	private Duration oneFrameDur = Duration.millis(1000/60);
	
	AnchorPane parentPane;
	Timeline loop;
	
	static ArrayList<Sprite> sprites;
	static ArrayList<Terrain> terrain;
	
	CollisionAdapter collAdapter;
	
	public GameLoop(AnchorPane parentPane)
	{
		fps = 60;
		
		this.parentPane = parentPane;
		
		collAdapter = new CollisionAdapter(parentPane);
		
		loop = new Timeline();
		loop.setCycleCount(Animation.INDEFINITE);
		
		init();
	}
	
	public void start()
	{
		KeyFrame oneFrame = new KeyFrame(oneFrameDur, 
				new EventHandler<ActionEvent> ()
				{
			
					public void handle(ActionEvent event)
						{
							collAdapter.handleCollision();
						}
				});
		
		loop.getKeyFrames().add(oneFrame);
		loop.play();
	}
	
	private void init()
	{
		sprites = new ArrayList<Sprite>();
		terrain = new ArrayList<Terrain>();

		sprites.add(new SpriteBullet(100, 100));
		sprites.add(new SpriteBullet(500, 100));
		sprites.add(new SpriteBullet(500, 300));

		terrain.add(new TerrainGras(0, 500, 0, 600, 800, 600, 800, 500));
		terrain.add(new TerrainGras(0, 100, 0, 300, 100, 300));
		
		parentPane.getChildren().addAll(sprites);
		parentPane.getChildren().addAll(terrain);
	}
	
	public void setFPS(int fps)
	{
		this.fps = fps;
		oneFrameDur = Duration.millis(1000/fps);
	}
	
	public int getFPS()
	{
		return fps;
	}
}
