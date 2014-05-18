package adapters;

import controller.GameLoop;
import javafx.event.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class handles all Keyboard Inputs from
 * the User on the Game Field.
 * 
 * @author Bellum
 *
 */
public class KeyboardAdapter implements EventHandler<KeyEvent>
{
	private GameLoop loop;
	
	public KeyboardAdapter(GameLoop loop) 
	{ 
		this.loop = loop;
	}

	/**
	 * Handles all KeyEvents (Yes this is when the
	 * User actually clicked a Keyboard Button).
	 * 
	 * @param event - The KeyEvent that occurs when the User presses a key
	 */
	public void handle(KeyEvent event) 
	{
		if(event.getCode() == KeyCode.A)
		{
			loop.nextMap();
		}
		if(event.getCode() == KeyCode.B)
		{
			loop.prevMap();
		}
		if(event.getCode() == KeyCode.I)
		{
			loop.getRoundAdapter().nextRound();
		}
	}
}
