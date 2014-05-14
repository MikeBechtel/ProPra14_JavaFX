package adapters;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.*;

public class CollisionAdapter 
{
	private AnchorPane parentPane;
	
	public CollisionAdapter(AnchorPane parentPane)
	{
		this.parentPane = parentPane;
	}
	
	public void handleCollision()
	{
		for(Sprite sprite : GameLoop.sprites)
		{
	        double xMin = sprite.getBoundsInParent().getMinX();
	        double yMin = sprite.getBoundsInParent().getMinY();
	        double xMax = sprite.getBoundsInParent().getMaxX();
	        double yMax = sprite.getBoundsInParent().getMaxY();
	
	        if (xMin < 0 || xMax > parentPane.getWidth()) {
		        sprite.setSpeedX(sprite.getSpeedX() * (-1));
	        }
	        if (yMin < 0 || yMax > parentPane.getHeight()) {
		        sprite.setSpeedY(sprite.getSpeedY() * (-1));
	        }
	        
	        for(Terrain terrain : GameLoop.terrain)
	        {
	        	Shape s = Shape.intersect(sprite, terrain);
	        	if(s.getBoundsInLocal().getWidth() != -1)
	        	{
	        		if(terrain.getBoundsInParent().getMinX() < sprite.getBoundsInParent().getMinX())
	    		        sprite.setSpeedX(sprite.getSpeedX() * (-1));
	        		sprite.fillSprite(Color.GREEN);
			        sprite.setSpeedY(sprite.getSpeedY() * (-1));
	        	}
	        	else
	        		sprite.fillSprite(Color.GRAY);
	        	System.out.println(0.5 * (terrain.getBoundsInParent().getMaxX()-terrain.getBoundsInParent().getMinX()));
	        }
	        		
	        sprite.setTranslateX(sprite.getTranslateX() + sprite.getSpeedX());
	        sprite.setTranslateY(sprite.getTranslateY() + sprite.getSpeedY());
		}
	}
}
