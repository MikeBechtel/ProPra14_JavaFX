package model;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class SpriteBullet extends Sprite
{
	
	public SpriteBullet(double posX, double posY, double size)
	{
		super(posX, posY, posX, posY + size, posX + size, posY + size, posX + size, posY);
		super.fillSprite(Color.GRAY);
		
		super.speedX = 3;
		super.speedY = 3;
	}
	
	public SpriteBullet(double posX, double posY, double size, double speedX, double speedY)
	{
		super(posX, posY, posX, posY + size, posX + size, posY + size, posX + size, posY);
		super.fillSprite(Color.GRAY);
		
		super.speedX = speedX;
		super.speedY = speedY;
	}

	@Override
	public void setImage(ImagePattern imagePattern) 
	{
		
	}
}
