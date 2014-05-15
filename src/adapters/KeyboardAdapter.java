package adapters;

import javafx.event.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardAdapter implements EventHandler<KeyEvent>
{
	public KeyboardAdapter() { }

	public void handle(KeyEvent event) 
	{
		if(event.getCode() == KeyCode.A)
		{
			System.out.println("A clicked!");
			
//			event.consume();
		}
	}
}
