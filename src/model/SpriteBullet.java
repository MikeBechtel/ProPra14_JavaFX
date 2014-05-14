package model;

import javafx.scene.paint.Color;

public class SpriteBullet extends Sprite
{
	public SpriteBullet(int posX, int posY)
	{
		super(posX, posY, posX, posY + 20, posX + 20, posY + 20, posX + 20, posY);
		super.fillSprite(Color.GRAY);
		
		speedX = 5;
		speedY = 5;
	}
	
	public SpriteBullet(int posX, int posY, int speedX, int speedY)
	{
		super(1,1,1,2,2,2,2,1);
		super.fillSprite(Color.GRAY);
		
		super.speedX = speedX;
		super.speedY = speedY;
	}
}
