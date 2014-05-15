package adapters;

import java.util.ArrayList;

import model.*;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

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

		SpriteBullet b = new SpriteBullet(40, 40, 30);
		b.setSpeedX(5);
		b.setSpeedY(7);
		b.setFill(Color.BLUEVIOLET);
		SpriteBullet c = new SpriteBullet(400, 40, 30);
		c.setSpeedX(-4);
		c.setSpeedY(7);
		c.setFill(Color.BROWN);

		sprites.add(b);
		sprites.add(c);

		terrain.add(new TerrainGras(0, 500, 0, 600, 800, 600, 800, 500));
		terrain.add(new TerrainGras(0, 500, 0, 0, 10, 0, 10, 500));
		terrain.add(new TerrainGras(10, 0, 10, 10, 800, 10, 800, 0));
		terrain.add(new TerrainGras(800, 10, 790, 10, 790, 500, 800, 500));
		terrain.add(new TerrainGras(790, 100, 790, 300, 700, 300));
		terrain.add(new TerrainGras(10, 100, 10, 300, 100, 300, 200, 150));
		
		parentPane.getChildren().addAll(sprites);
		parentPane.getChildren().addAll(terrain);
//		parentPane.requestFocus();
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
