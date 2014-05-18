package model;

import javafx.scene.paint.Color;

public class SpriteBullet extends Sprite
{
	
	public SpriteBullet(double posX, double posY, double size)
	{
		super(posX, posY, posX, posY + size, posX + size, posY + size, posX + size, posY);
		super.fillSprite(Color.GRAY);
		
		speedX = 3;
		speedY = 3;
	}
	
	public SpriteBullet(int posX, int posY, int speedX, int speedY)
	{
		super(1,1,1,2,2,2,2,1);
		super.fillSprite(Color.GRAY);
		
		super.speedX = speedX;
		super.speedY = speedY;
	}
}
